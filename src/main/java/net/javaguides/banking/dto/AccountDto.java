package net.javaguides.banking.dto;


//import lombok.*;
//
//@Data
//@AllArgsConstructor
//public class AccountDto {
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//
//}

//Using Record Class as DTO
public record AccountDto(Long id, String accountHolderName, double balance) {
}