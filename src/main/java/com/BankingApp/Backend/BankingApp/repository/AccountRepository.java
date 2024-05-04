package com.BankingApp.Backend.BankingApp.repository;

import com.BankingApp.Backend.BankingApp.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts,Long>// given entity class name and type of primary key which is here id so here long has been given//
{
}
/// this created to accesss the all medthods on java jpa packgaes whicgh in crud operations
