package dataTransferCommProject.example.RestApis.restController;

import dataTransferCommProject.example.RestApis.business.InventoryService;
import dataTransferCommProject.example.RestApis.models.DTOs.Inventory.InventoryCreationDTO;
import dataTransferCommProject.example.RestApis.models.DTOs.Inventory.InventoryUpdateDTO;
import dataTransferCommProject.example.RestApis.models.InventoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static dataTransferCommProject.example.RestApis.utils.ConstantsAndConfig.DONE;

@RestController
@RequestMapping("/inventoryApi")
public class InventoryApiController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping(value = "/getAllInventory")
    public List<InventoryModel> getAllInventoryRepo() {
        return inventoryService.getAllInventoryInsideRepo();
    }
    @PostMapping(value = "/saveInventory")
    public ResponseEntity<String> saveMyInventoryRecord(@RequestBody @Valid InventoryCreationDTO inventoryDTO)
    {
        if(inventoryService.saveInventory(inventoryDTO)==DONE) {
            return ResponseEntity.ok("saved");
        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("invalid input");
    }
    @PutMapping(value="/updateInventory/{inventoryId}")
    public ResponseEntity<String> updateInventory(@PathVariable long id, @RequestBody InventoryUpdateDTO inventoryRecordDTO)
    {
        if (inventoryService.updateInventory(inventoryRecordDTO, id) == DONE) {
            return ResponseEntity.ok("updatedSuccessfully");

        } else {
            return   ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("updatedFailed");

        }
    }
    @DeleteMapping(value = "/deleteInventory/{inventoryId}")
    public String deleteInventoryRecord(@PathVariable long invId)
    {
        inventoryService.deleteInventoryRecord(invId);
        return "deleted inventoryrecord number: "+invId;
    }
    @DeleteMapping(value = "/deleteInventory")
    public String deleteInventory()
    {
        inventoryService.deleteAllInventory();
        return "all deleted";
    }
    @PostMapping(value = "/saveAllInventory")
    public String createInventory(@RequestBody List<InventoryCreationDTO> inventory) {
        inventoryService.addListOfInventory(inventory);
        return "saved successfully";
    }
}
