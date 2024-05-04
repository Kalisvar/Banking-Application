package com.BankingApp.Backend.BankingApp.controller;


import com.BankingApp.Backend.BankingApp.dto.AccountDto;
import com.BankingApp.Backend.BankingApp.service.AccountService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account" )
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)  // request body contain json whih automatically convert into java dto object
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Account
    @GetMapping   ("/{id}")
    
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
    {
      AccountDto accountDto = accountService.getAccountById(id);
      return ResponseEntity.ok(accountDto);
    }

    // deposit
    @PutMapping("/{id}/deposit")

    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> depositedAmount)
    {
      Double amount = depositedAmount.get("amount");
     AccountDto accountDto =  accountService.deposit(id,amount) ;
     return ResponseEntity.ok(accountDto);
    }
   // withdraw
    @PutMapping("/{id}/withdraw")

    public  ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> withdrawAmount)
    {
     Double amount =  withdrawAmount.get("amount");
    AccountDto accountDto= accountService.withdraw(id,amount);
    return ResponseEntity.ok(accountDto);

    }

    // get all account
    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAllAccount()
    {
      List<AccountDto>  accountsList = accountService.getAllAccounts();
      return ResponseEntity.ok(accountsList);
    }

    //delete account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account  deleted succesfully");
    }

}
