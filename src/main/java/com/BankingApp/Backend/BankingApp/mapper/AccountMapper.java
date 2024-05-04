package com.BankingApp.Backend.BankingApp.mapper;

import com.BankingApp.Backend.BankingApp.dto.AccountDto;
import com.BankingApp.Backend.BankingApp.entity.Accounts;
/* created to convert the accountdto type to account type and vice versa*/
public class AccountMapper {
    public static Accounts mapToAccounts (AccountDto accountDto)
    {
        Accounts accounts = new Accounts(accountDto.getId(),accountDto.getAccountHolderName(),accountDto.getBalance());
        return accounts;
    }

    public static AccountDto mapToAccountDto(Accounts accounts)
    {
        AccountDto accountDto = new AccountDto(
                accounts.getId(),
                accounts.getAccountHolderName(),
                accounts.getBalance());
        return accountDto;
    }


}
