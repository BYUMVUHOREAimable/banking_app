package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;

import java.util.List;

public interface AcccountService {

    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
