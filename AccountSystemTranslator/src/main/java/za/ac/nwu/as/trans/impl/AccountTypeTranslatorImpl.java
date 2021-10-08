package za.ac.nwu.as.trans.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.repo.persistence.AccountTypeRepo;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.trans.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepo accountTypeRepo;

    @Autowired
    public  AccountTypeTranslatorImpl(AccountTypeRepo accountTypeRepo){
        this.accountTypeRepo = accountTypeRepo;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountTypeDto accountType : accountTypeRepo.findAll()){
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from Database", e);
        }

        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try{
            AccountType accountType = accountTypeDto.getAccountType();
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }
}
