package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.service.AcccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AcccountService acccountService;

    public AccountController(AcccountService acccountService) {
        this.acccountService = acccountService;
    }
    // Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount (@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(acccountService.createAccount(accountDto), HttpStatus.CREATED);

    }
    //Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = acccountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
       AccountDto accountDto = acccountService.deposit(id, amount);
       return ResponseEntity.ok(accountDto);

    }
    //Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = acccountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }
    //Get All Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = acccountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    //Delete Account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        acccountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }


}
