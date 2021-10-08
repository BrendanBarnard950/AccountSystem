package za.ac.nwu.as.domain.dto;

import io.swagger.annotations.*;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.persistence.AccountType;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@ApiModel(value = "AccountType",
        description = "A DTO that represents the AccountType"
)

public class AccountTypeDto implements Serializable {

    @Id

    private String accountTypeName;
    private String mnemonic;
    private LocalDate creationDate;

    public AccountTypeDto() {
    }

    public AccountTypeDto(AccountType accountType) {
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setMnemonic(accountType.getMnemonic());
        this.setCreationDate(accountType.getCreationDate());
    }


    @ApiModelProperty(position = 1,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Name",
            name = "Name",
            notes = "Name of Account Type",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    @ApiModelProperty(position = 3,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "Date on which AccountType was created",
            dataType = "java.lang.String",
            example = "2021-08-01",
            allowEmptyValue = true,
            required = false)
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getMnemonic(), getAccountTypeName(), getCreationDate());
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "accountTypeName='" + accountTypeName + "'" +
        ", mnemonic='" + mnemonic + "'" +
        ", creationDate=" + creationDate +
                '}';
    }
}
