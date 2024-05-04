package com.BankingApp.Backend.BankingApp.service.impl;

import com.BankingApp.Backend.BankingApp.dto.AccountDto;
import com.BankingApp.Backend.BankingApp.entity.Accounts;
import com.BankingApp.Backend.BankingApp.mapper.AccountMapper;
import com.BankingApp.Backend.BankingApp.repository.AccountRepository;
import com.BankingApp.Backend.BankingApp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
      Accounts accounts = AccountMapper.mapToAccounts(accountDto);///conversion because of saving the details in database
      Accounts savedAccounts = accountRepository.save(accounts);// saving the account in database
        return  AccountMapper.mapToAccountDto(savedAccounts);// returning in dto type

    }

    @Override
    public AccountDto getAccountById(Long id) {
      Accounts accounts = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not exists"));
      return AccountMapper.mapToAccountDto(accounts);
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Accounts accounts = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not exists"));
    double totalAmount = accounts.getBalance()+amount;
     accounts.setBalance(totalAmount);
    Accounts savedAccount  = accountRepository.save(accounts);// saving the new upadted datas into database
    return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {
        Accounts accounts = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not exists"));
        if (accounts.getBalance() < amount)
        {
            throw new RuntimeException("Insufficient balance");
        }
        double total = accounts.getBalance() - amount;
        accounts.setBalance(total);
       Accounts savedAccounts = accountRepository.save(accounts);
       return AccountMapper.mapToAccountDto(savedAccounts);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
      List<Accounts> accounts = accountRepository.findAll();
     return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Accounts accounts = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not exists"));
        accountRepository.deleteById(id);
    }
}
