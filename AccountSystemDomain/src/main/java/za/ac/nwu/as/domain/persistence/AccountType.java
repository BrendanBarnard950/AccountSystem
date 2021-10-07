package za.ac.nwu.as.domain.persistence;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="DemoType")
public class AccountType implements Serializable {



    @Id
    @SequenceGenerator(name="Generic_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generic_Sequence")
    @Column(name = "accountType_Id")
    private Long accountTypeId;

    @Column(name = "mnemonic")
    private String mnemonic;

    @Column(name = "accountType_Name")
    private String accountTypeName;

    @Column(name = "Member_ID")
    private long memberId;

    @Column(name = "Amount")
    private long amount;

    @Column(name = "Add_Date")
    private LocalDate addDate;

    public AccountType() {
    }

    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, long memberId, long amount, LocalDate addDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.memberId = memberId;
        this.amount = amount;
        this.addDate = addDate;
    }
}
