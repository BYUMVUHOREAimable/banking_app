package net.javaguides.banking.mapper;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                //The following work with Record Class as DTO
                accountDto.id(),
                accountDto.accountHolderName(),
                accountDto.balance()

                //These work with normal class
                //To use this comment the above and uncomment the below as well as in accountMapper
                //accountDto.getId(),
                //accountDto.getAccountHolderName(),
                //accountDto.getBalance()


        );
    }
public static AccountDto mapToAccountDto(Account account) {
    return new AccountDto(
            account.getId(),
            account.getAccountHolderName(),
            account.getBalance()
    );
}
}
