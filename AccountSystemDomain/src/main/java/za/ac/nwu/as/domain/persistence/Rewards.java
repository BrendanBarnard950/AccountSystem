package za.ac.nwu.as.domain.persistence;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Component
@Table(name="REWARDS")

public class Rewards {
    @Id
    @SequenceGenerator(name="REWARDS_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REWARDS_SEQ")
    @Column(name = "REWARD_ID")
    private Long rewardID;

    @Column(name = "PARTNER")
    private String partner;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COST_MILES")
    private Long cost;

    public Rewards() {
    }

    public Rewards(Long rewardID, String partner, String description, Long cost) {
        this.rewardID = rewardID;
        this.partner = partner;
        this.description = description;
        this.cost = cost;
    }

    public Rewards(String partner, String description, Long cost) {
        this.partner = partner;
        this.description = description;
        this.cost = cost;
    }

    public Long getRewardID() {
        return rewardID;
    }

    public void setRewardID(Long rewardID) {
        this.rewardID = rewardID;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return Objects.equals(rewardID, rewards.rewardID) && Objects.equals(partner, rewards.partner) && Objects.equals(description, rewards.description) && Objects.equals(cost, rewards.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardID, partner, description, cost);
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "rewardID=" + rewardID +
                ", partner='" + partner + '\'' +
                ", description='" + description + '\'' +
                ", balance=" + cost +
                '}';
    }
}
