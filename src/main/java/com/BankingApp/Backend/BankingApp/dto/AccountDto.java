package com.BankingApp.Backend.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
/* created to transfer the objects in between the layers */
@Data//Automatically generate constructor and getter and setter
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
