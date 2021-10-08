package za.ac.nwu.as.domain.persistence;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Component
@Table(name="ACCOUNT_TYPE")
public class AccountType implements Serializable {



    @Id
    @SequenceGenerator(name="Generic_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generic_Sequence")
    @Column(name = "ACCOUNT_TYPE_ID")
    private Long accountTypeId;

    @Column(name = "MNEMONIC")
    private String mnemonic;

    @Column(name = "ACCOUNT_TYPE_NAME")
    private String accountTypeName;


    @Column(name = "CREATION_DATE")
    private LocalDate CreationDate;

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public AccountType() {
    }

    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate CreationDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.CreationDate = CreationDate;
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate CreationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.CreationDate = CreationDate;
    }
}
