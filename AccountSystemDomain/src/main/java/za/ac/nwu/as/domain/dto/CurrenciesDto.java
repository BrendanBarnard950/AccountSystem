package za.ac.nwu.as.domain.dto;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;
import za.ac.nwu.as.domain.persistence.Currencies;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@ApiModel(value = "Currencies",
        description = "A DTO that represents the Currencies"
)

public class CurrenciesDto {

    @Id

    private String mnemonic;
    private String currname;
    private Long exrate;
    private LocalDate CreationDate;
    private Long currID;

    public CurrenciesDto() {
    }

    public CurrenciesDto(String mnemonic, String currname, Long exrate, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.currname = currname;
        this.exrate = exrate;
        CreationDate = creationDate;
    }

    public CurrenciesDto(Currencies currencies) {
        this.setCurrID(currencies.getCurrencyID());
        this.setCurrname(currencies.getCurrname());
        this.setExrate(currencies.getExrate());
        this.setMnemonic(currencies.getMnemonic());
        this.setCreationDate(currencies.getCreationDate());
    }


    @ApiModelProperty(position = 1,
            value = "Currency Mnemonic",
            name = "Mnemonic",
            notes = "Mnemonic of the Currency",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    @ApiModelProperty(position = 2,
            value = "Currency Name",
            name = "Name",
            notes = "Name of the Currency",
            dataType = "java.lang.String",
            example = "Miles",
            required = true)
    public String getCurrname() {
        return currname;
    }

    @ApiModelProperty(position = 3,
            value = "Currency Exchange Rate",
            name = "Exchange",
            notes = "Exchange Rate of this currency to Miles",
            dataType = "java.lang.Long",
            example = "150",
            required = true)
    public Long getExrate() {
        return exrate;
    }

    @ApiModelProperty(position = 4,
            value = "Currency Creation Date",
            name = "Creation Date",
            notes = "Date currency was added",
            dataType = "java.time.LocalDate",
            example = "2020-01-01",
            required = true)
    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setCurrname(String currname) {
        this.currname = currname;
    }

    public void setExrate(Long exrate) {
        this.exrate = exrate;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrenciesDto that = (CurrenciesDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(currname, that.currname) && Objects.equals(exrate, that.exrate) && Objects.equals(CreationDate, that.CreationDate);
    }

    @JsonIgnore
    public Currencies getCurrencies(){
        return new Currencies(getMnemonic(), getCurrname(), getExrate(), getCreationDate());
    }

    @JsonIgnore
    public Long getCurrID() {
        return currID;
    }

    public void setCurrID(Long currID) {
        this.currID = currID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, currname, exrate, CreationDate);
    }

    @Override
    public String toString() {
        return "CurrenciesDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", currname='" + currname + '\'' +
                ", exrate=" + exrate +
                ", CreationDate=" + CreationDate +
                '}';
    }
}
