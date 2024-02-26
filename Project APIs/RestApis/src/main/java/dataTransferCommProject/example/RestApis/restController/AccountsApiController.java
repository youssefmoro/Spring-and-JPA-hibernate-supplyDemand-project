package dataTransferCommProject.example.RestApis.restController;

import dataTransferCommProject.example.RestApis.models.DTOs.accounts.AccountCreationDTO;
import dataTransferCommProject.example.RestApis.models.DTOs.accounts.AccountsUpdateDTO;
import dataTransferCommProject.example.RestApis.models.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import dataTransferCommProject.example.RestApis.business.*;

import javax.validation.Valid;
import java.util.List;

import static dataTransferCommProject.example.RestApis.utils.ConstantsAndConfig.DONE;

@RestController
@RequestMapping("/accountsApi")
public class AccountsApiController {
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/")
    public String getPage() {
        return "welcome";
    }

    @GetMapping(value = "/allAccounts")
    public List<AccountModel> getAllAccount() {
        return accountService.getAllAccountsInsideRepo();
    }
    @GetMapping(value = "/accountById/{accountId}")
    public AccountModel getAccountById(@PathVariable long accountId) {
        return accountService.getAccountsById(accountId);
    }

    @PostMapping("/saveMyAccount")
    public ResponseEntity<String> createAccount(@RequestBody @Valid AccountCreationDTO accountDTO) {
        if(accountService.saveAccounts(accountDTO)==DONE) {
            return ResponseEntity.ok("saved");
        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("invalid input");
    }

    @PutMapping(value = "/updateAccountById/{accountId}")
    public ResponseEntity<String> updateAccount(@PathVariable long accountId, @RequestBody @Valid  AccountsUpdateDTO account) {
        if (accountService.updateAccounts(account, accountId) == DONE) {
            return ResponseEntity.ok("updatedSuccessfully");

        } else {
          return   ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("updatedFailed");

        }
    }


    @DeleteMapping(value = "/deleteAccountById/{accountId}")
    public String deleteAccount(@PathVariable long accountId) {
        if (accountService.deleteAccounts(accountId) == DONE) {

            return "deleted account with id:" + accountId;
        } else return "deletion failed";

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/deleteAllAccounts")
    public String deleteAllAccounts() {
      accountService.deleteAllAccounts();
            return "All deleted";
    }
    @PostMapping(value = "/saveAllAccounts")
    public String createAccounts(@RequestBody List<AccountCreationDTO> accounts) {
        accountService.addListOfAccounts(accounts);
        return "saved successfully";
    }
}
