package za.ac.nwu.as.domain.dto;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;
import za.ac.nwu.as.domain.persistence.Members;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@ApiModel(value = "Members",
        description = "A DTO that represents the Members"
)

public class MembersDto implements Serializable {

    @Id

    private String name;
    private String surname;
    private String username;
    private String prefcurrency;
    private Long balance;
    private LocalDate CreationDate;

    public MembersDto() {
    }

    public MembersDto(String name, String surname, String username, String prefcurrency, Long balance, LocalDate creationDate) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.prefcurrency = prefcurrency;
        this.balance = balance;
        CreationDate = creationDate;
    }

    public MembersDto(Members members) {
        this.setName(members.getName());
        this.setSurname(members.getSurname());
        this.setUsername(members.getUsername());
        this.setPrefcurrency(members.getPrefcurrency());
        this.setBalance(members.getBalance());
        this.setCreationDate(members.getCreationDate());
    }


    @ApiModelProperty(position = 1,
            value = "Members Name",
            name = "Name",
            notes = "Name of the Member",
            dataType = "java.lang.String",
            example = "John",
            required = true)
    public String getName() {
        return name;
    }

    @ApiModelProperty(position = 2,
            value = "Members Surname",
            name = "Surname",
            notes = "Surname of the Member",
            dataType = "java.lang.String",
            example = "Smoth",
            required = true)
    public String getSurname() {
        return surname;
    }

    @ApiModelProperty(position = 3,
            value = "Members Username",
            name = "Username",
            notes = "Username of the Member",
            dataType = "java.lang.String",
            example = "JSmoth123",
            required = true)
    public String getUsername() {
        return username;
    }

    @ApiModelProperty(position = 4,
            value = "Members Preffered Currency",
            name = "Prefcurrency",
            notes = "Currency the member preffers",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getPrefcurrency() {
        return prefcurrency;
    }

    @ApiModelProperty(position = 5,
            value = "Members Balance",
            name = "Balance",
            notes = "Balance of the Member",
            dataType = "java.lang.Long",
            example = "1000",
            required = true)
    public Long getBalance() {
        return balance;
    }

    @ApiModelProperty(position = 6,
            value = "Members Creation Date",
            name = "Creation Date",
            notes = "Date on which Member was added",
            dataType = "java.time.LocalDate",
            example = "2020-01-01",
            required = true)
    public LocalDate getCreationDate() {
        return CreationDate;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPrefcurrency(String prefcurrency) {
        this.prefcurrency = prefcurrency;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    @JsonIgnore
    public Members getMembers(){
        return new Members(getName(), getSurname(), getUsername(), getPrefcurrency(), getBalance(), getCreationDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembersDto that = (MembersDto) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(username, that.username) && Objects.equals(prefcurrency, that.prefcurrency) && Objects.equals(balance, that.balance) && Objects.equals(CreationDate, that.CreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, username, prefcurrency, balance, CreationDate);
    }

    @Override
    public String toString() {
        return "MembersDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", prefcurrency=" + prefcurrency +
                ", balance=" + balance +
                ", CreationDate=" + CreationDate +
                '}';
    }
}
