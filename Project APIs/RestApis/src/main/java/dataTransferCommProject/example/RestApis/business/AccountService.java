package dataTransferCommProject.example.RestApis.business;

import dataTransferCommProject.example.RestApis.models.AccountModel;
import dataTransferCommProject.example.RestApis.models.DTOs.accounts.AccountCreationDTO;
import dataTransferCommProject.example.RestApis.models.DTOs.accounts.AccountCreationMapper;
import dataTransferCommProject.example.RestApis.models.DTOs.accounts.AccountsUpdateDTO;
import dataTransferCommProject.example.RestApis.models.DTOs.accounts.AccountUpdateMapper;
import dataTransferCommProject.example.RestApis.repo.AccountRepo;
import dataTransferCommProject.example.RestApis.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static dataTransferCommProject.example.RestApis.utils.ConstantsAndConfig.*;
import static dataTransferCommProject.example.RestApis.utils.ConstantsAndConfig.BATCH_ACCOUNTS;
import static dataTransferCommProject.example.RestApis.Validation.accountsListValidator;

@Service
public class AccountService {
        @Autowired
        private AccountRepo accountsRepo;
        @Autowired
        private AccountCreationMapper accountsCreationMapper;
        @Autowired
        private AccountUpdateMapper updateMapper;
        public AccountModel getAccountsById(long accountsId)
        {
           AccountModel accounts= accountsRepo.findById(accountsId).get();
            return accounts;
        }
        public List<AccountModel> getAllAccountsInsideRepo()
        {
            return accountsRepo.findAll();
        }
        public int saveAccounts(AccountCreationDTO accountsDTO)
        {
           AccountModel accounts= accountsCreationMapper.toEntity(accountsDTO) ;
            accountsRepo.save(accounts);
            return DONE;
        }
        public int updateAccounts(AccountsUpdateDTO accountsDTO, long idToBeUpdated)
        {
           AccountModel accounts=updateMapper.toEntity(accountsDTO);
            if(Validation.accountsValidator(accounts)) {
                AccountModel updatedAccounts = accountsRepo.findById(idToBeUpdated).get();
                updatedAccounts.setCardNumber(accounts.getCardNumber());
                updatedAccounts.setMobileNumber(accounts.getMobileNumber());
                updatedAccounts.setEmail(accounts.getEmail());
                updatedAccounts.setAddress(accounts.getAddress());
                updatedAccounts.setFullName(accounts.getFullName());
                accountsRepo.save(updatedAccounts);
                return DONE;
            }
            else return FAILED;
            //(security features)TIME OUT CAN BE ADDED TO RETURN FAILED IF PROCESS NOT DONE WITHIN THIS AMOUNT OF TIME
        }
        public int deleteAccounts(long accountsId)
        {
            accountsRepo.delete(getAccountsById(accountsId));
            return DONE;
            //(security features)TIME OUT CAN BE ADDED TO RETURN FAILED IF PROCESS NOT DONE WITHIN THIS AMOUNT OF TIME
        }
        public int deleteAllAccounts()
        {
            accountsRepo.deleteAll();
            return DONE;
            //(security features)TIME OUT CAN BE ADDED TO RETURN FAILED IF PROCESS NOT DONE WITHIN THIS AMOUNT OF TIME
        }
        @Transactional
        public int addListOfAccounts(List<AccountCreationDTO> accountsDTOs)
        {
            List<AccountModel> accounts= accountsCreationMapper.toListOfEntities(accountsDTOs);

            if (accounts.size()>BATCH_ACCOUNTS) {
                List<List<AccountModel>> listOfList = breakingDownAllAccountModelsIntoBatches(accounts);
                for (List<AccountModel> invBatch : listOfList) {
                    List<AccountModel> newList=accountsListValidator(invBatch);
                    if(newList!=null) {
                        accountsRepo.saveAll(newList);
                    }
                }
                return DONE;
            }
            else
            {
                if(accountsListValidator(accounts)!=null) {
                    accountsRepo.saveAll(accountsListValidator(accounts));
                }
                return DONE;
            }
        }
        public static List<List<AccountModel>> breakingDownAllAccountModelsIntoBatches(List<AccountModel> allAccounts)
        {
            int counter=0;
            List<List<AccountModel>> listOfLists=new ArrayList<>();
            int numOfListsRequired=allAccounts.size()/BATCH_INVENTORY;
            float diff=(float)((float)allAccounts.size()/(float)BATCH_INVENTORY)-numOfListsRequired;
            numOfListsRequired=(diff==0)?(numOfListsRequired):(numOfListsRequired+1);
            for(int i=0;i<numOfListsRequired;i++)
            {
                List<AccountModel> innerList = new ArrayList<>();
                for (int j=0;j<BATCH_INVENTORY;j++)
                {
                    if (counter < allAccounts.size()) {
                        innerList.add(allAccounts.get(counter));
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
