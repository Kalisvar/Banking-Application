package com.BankingApp.Backend.BankingApp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // created to know the spring to create an entity
@Table(name = "accounts") // this annotation gives to create a table
@Getter // this help to create a getter and setter for the field variable
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

    @Id///mentioning this as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // the id has to be generated automatically
    private Long id;

    @Column(name = "account_holder_name")// if we want different name
    private String accountHolderName;

    private double balance;
}
