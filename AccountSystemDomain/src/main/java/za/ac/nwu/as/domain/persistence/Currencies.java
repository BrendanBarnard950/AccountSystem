package za.ac.nwu.as.domain.persistence;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Component
@Table(name="CURRENCIES")

public class Currencies {
    @Id
    @SequenceGenerator(name="CURRENCIES_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURRENCIES_SEQ")
    @Column(name = "CURRENCY_ID")
    private Long currencyID;

    @Column(name = "MNEMONIC")
    private String mnemonic;

    @Column(name = "CURRENCY_NAME")
    private String currname;

    @Column(name = "EX_RATE_MILES")
    private Long exrate;

    @Column(name = "CREATION_DATE")
    private LocalDate CreationDate;

    public Currencies() {
    }

    public Currencies(Long currencyID, String mnemonic, String currname, Long exrate, LocalDate creationDate) {
        this.currencyID = currencyID;
        this.mnemonic = mnemonic;
        this.currname = currname;
        this.exrate = exrate;
        CreationDate = creationDate;
    }

    public Currencies(String mnemonic, String currname, Long exrate, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.currname = currname;
        this.exrate = exrate;
        CreationDate = creationDate;
    }

    public Long getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Long currencyID) {
        this.currencyID = currencyID;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getCurrname() {
        return currname;
    }

    public void setCurrname(String currname) {
        this.currname = currname;
    }

    public Long getExrate() {
        return exrate;
    }

    public void setExrate(Long exrate) {
        this.exrate = exrate;
    }

    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currencies that = (Currencies) o;
        return Objects.equals(currencyID, that.currencyID) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(currname, that.currname) && Objects.equals(exrate, that.exrate) && Objects.equals(CreationDate, that.CreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyID, mnemonic, currname, exrate, CreationDate);
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "currencyID=" + currencyID +
                ", mnemonic='" + mnemonic + '\'' +
                ", currname='" + currname + '\'' +
                ", exrate=" + exrate +
                ", CreationDate=" + CreationDate +
                '}';
    }
}
