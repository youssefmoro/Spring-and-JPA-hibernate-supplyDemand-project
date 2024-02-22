package dataTransferCommProject.example.RestApis.Business;

import dataTransferCommProject.example.RestApis.Models.AccountModel;
import dataTransferCommProject.example.RestApis.Models.DTOs.Inventory.InventoryCreationDTO;
import dataTransferCommProject.example.RestApis.Models.DTOs.Inventory.InventoryCreationMapper;
import dataTransferCommProject.example.RestApis.Models.DTOs.Inventory.InventoryUpdateDTO;
import dataTransferCommProject.example.RestApis.Models.DTOs.Inventory.InventoryUpdateMapper;
import dataTransferCommProject.example.RestApis.Models.InventoryModel;
import dataTransferCommProject.example.RestApis.Repo.InventoryRepo;
import dataTransferCommProject.example.RestApis.Validation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static dataTransferCommProject.example.RestApis.Utils.ConstantsAndConfig.*;
import static dataTransferCommProject.example.RestApis.Utils.ConstantsAndConfig.BATCH_ACCOUNTS;
import static dataTransferCommProject.example.RestApis.Validation.accountsListValidator;
import static dataTransferCommProject.example.RestApis.Validation.inventoryListValidator;

@Service
public class InventoryService {
        @Autowired
        private InventoryRepo inventoryRepo;
        @Autowired
        private InventoryCreationMapper inventoryMapper;
        @Autowired
        private InventoryUpdateMapper updateMapper;
        public InventoryModel getInventoryById(long inventoryId)
        {
           InventoryModel inventory= inventoryRepo.findById(inventoryId).get();
            return inventory;
        }
        public List<InventoryModel> getAllInventoryInsideRepo()
        {
            return inventoryRepo.findAll();
        }
        public int saveInventory(InventoryCreationDTO inventoryDTO)
        {
           InventoryModel inventory= inventoryMapper.toEntity(inventoryDTO) ;
            inventoryRepo.save(inventory);
            return DONE;
        }
        public int updateInventory(InventoryUpdateDTO inventoryDTO, long idToBeUpdated)
        {
           InventoryModel inventory=updateMapper.toEntity(inventoryDTO);
            if(Validation.inventoryValidator(inventory)) {
                InventoryModel updatedInventory = inventoryRepo.findById(idToBeUpdated).get();
                updatedInventory.setInventoryQuantity(inventory.getInventoryQuantity());
                updatedInventory.setItemPrice(inventory.getItemPrice());
                updatedInventory.setItemName(inventory.getItemName());
                inventoryRepo.save(updatedInventory);
                return DONE;
            }
            else return FAILED;
            //(security features)TIME OUT CAN BE ADDED TO RETURN FAILED IF PROCESS NOT DONE WITHIN THIS AMOUNT OF TIME
        }
        public int deleteInventoryRecord(long inventoryRecordId)
        {
            inventoryRepo.delete(getInventoryById(inventoryRecordId));
            return DONE;
            //(security features)TIME OUT CAN BE ADDED TO RETURN FAILED IF PROCESS NOT DONE WITHIN THIS AMOUNT OF TIME
        }
        public int deleteAllInventory()
        {
            inventoryRepo.deleteAll();
            return DONE;
            //(security features)TIME OUT CAN BE ADDED TO RETURN FAILED IF PROCESS NOT DONE WITHIN THIS AMOUNT OF TIME
        }
        @Transactional
        public int addListOfInventory(List<InventoryCreationDTO> inventoryDTOs)
        {
            List<InventoryModel> inventory= inventoryMapper.toListOfEntities(inventoryDTOs);

            if (inventory.size()>BATCH_ACCOUNTS) {
                List<List<InventoryModel>> listOfList = breakingDownAllInventoryModelsIntoBatches(inventory);
                for (List<InventoryModel> invBatch : listOfList) {
                    List<InventoryModel> newList=inventoryListValidator(invBatch);
                    if(newList!=null) {
                        inventoryRepo.saveAll(newList);
                    }
                }
                return DONE;
            }
            else
            {
                if(inventoryListValidator(inventory)!=null) {
                    inventoryRepo.saveAll(inventoryListValidator(inventory));
                }
                return DONE;
            }
        }
        public static List<List<InventoryModel>> breakingDownAllInventoryModelsIntoBatches(List<InventoryModel> allInventoryRecords)
        {
            int counter=0;
            List<List<InventoryModel>> listOfLists=new ArrayList<>();
            int numOfListsRequired=allInventoryRecords.size()/BATCH_INVENTORY;
            float diff=(float)((float)allInventoryRecords.size()/(float)BATCH_INVENTORY)-numOfListsRequired;
            numOfListsRequired=(diff==0)?(numOfListsRequired):(numOfListsRequired+1);
            for(int i=0;i<numOfListsRequired;i++)
            {
                List<InventoryModel> innerList = new ArrayList<>();
                for (int j=0;j<BATCH_INVENTORY;j++)
                {
                    if (counter < allInventoryRecords.size()) {
                        innerList.add(allInventoryRecords.get(counter));
                        counter++;
                    } else {
                        break; // Break the loop if all accounts have been processed
                    }
                }
                listOfLists.add(innerList);
            }
            return listOfLists;
        }
    }
