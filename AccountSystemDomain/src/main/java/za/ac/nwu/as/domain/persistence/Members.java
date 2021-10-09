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
@Table(name="MEMBERS")
public class Members implements Serializable {



    @Id
    @SequenceGenerator(name="MEMBERS_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBERS_SEQ")
    @Column(name = "MEMBER_ID")
    private Long memberID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PREF_CURRENCY")
    private String prefcurrency;

    @Column(name = "BALANCE")
    private Long balance;

    @Column(name = "CREATION_DATE")
    private LocalDate CreationDate;


    public Members() {
    }

    public Members(Long accountTypeId, String name, String surname, String username, String prefcurrency, Long balance, LocalDate creationDate) {
        this.memberID = accountTypeId;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.prefcurrency = prefcurrency;
        this.balance = balance;
        CreationDate = creationDate;
    }

    public Members(String name, String surname, String username, String prefcurrency, Long balance, LocalDate creationDate) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.prefcurrency = prefcurrency;
        this.balance = balance;
        CreationDate = creationDate;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrefcurrency() {
        return prefcurrency;
    }

    public void setPrefcurrency(String prefcurrency) {
        this.prefcurrency = prefcurrency;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
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
        Members members = (Members) o;
        return Objects.equals(memberID, members.memberID) && Objects.equals(name, members.name) && Objects.equals(surname, members.surname) && Objects.equals(username, members.username) && Objects.equals(prefcurrency, members.prefcurrency) && Objects.equals(balance, members.balance) && Objects.equals(CreationDate, members.CreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, name, surname, username, prefcurrency, balance, CreationDate);
    }

    @Override
    public String toString() {
        return "Members{" +
                "accountTypeId=" + memberID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", prefcurrency=" + prefcurrency +
                ", balance=" + balance +
                ", CreationDate=" + CreationDate +
                '}';
    }
}
