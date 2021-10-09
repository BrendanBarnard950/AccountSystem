package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.*;
import za.ac.nwu.as.domain.persistence.Rewards;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@ApiModel(value = "Rewards",
        description = "A DTO that represents the Rewards"
)
public class RewardsDto {

    @Id
    private Long id;
    private String partner;
    private String description;
    private Long cost;

    public RewardsDto() {
    }

    public RewardsDto(Long id, String partner, String description, Long cost) {
        this.partner = partner;
        this.description = description;
        this.cost = cost;
        this.id = id;
    }

    public RewardsDto(Rewards rewards){
        this.setCost(rewards.getCost());
        this.setDescription(rewards.getDescription());
        this.setPartner(rewards.getPartner());
        this.setId(rewards.getRewardID());
    }

    @ApiModelProperty(position = 1,
            value = "Reward ID",
            name = "ID",
            notes = "ID of the Rewards",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getId() {
        return id;
    }

    @ApiModelProperty(position = 2,
            value = "Partner Name",
            name = "Partner",
            notes = "Name of the Partner",
            dataType = "java.lang.String",
            example = "Woolworths",
            required = true)
    public String getPartner() {
        return partner;
    }

    @ApiModelProperty(position = 3,
            value = "Reward Description",
            name = "Description",
            notes = "Description of the reward",
            dataType = "java.lang.String",
            example = "A R50 Woolworths voucher!",
            required = true)
    public String getDescription() {
        return description;
    }

    @ApiModelProperty(position = 4,
            value = "Reward Cost",
            name = "Cost",
            notes = "Cost of the Reward in Miles",
            dataType = "java.lang.Long",
            example = "300",
            required = true)
    public Long getCost() {
        return cost;
    }


    @JsonIgnore
    public Rewards getRewards() {
        return new Rewards(getPartner(), getDescription(), getCost());
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardsDto that = (RewardsDto) o;
        return Objects.equals(partner, that.partner) && Objects.equals(description, that.description) && Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partner, description, cost);
    }

    @Override
    public String toString() {
        return "RewardsDto{" +
                "partner='" + partner + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
