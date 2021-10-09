package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.*;
import za.ac.nwu.as.domain.persistence.Goals;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@ApiModel(value = "Goals",
        description = "A DTO that represents the Goals"
)
public class GoalsDto {

    @Id

    private String name;
    private String description;
    private Long value;

    public GoalsDto() {
    }

    public GoalsDto(Goals goals) {
        this.setDescription(goals.getDescription());
        this.setName(goals.getName());
        this.setValue(goals.getValue());
    }

    public GoalsDto(String name, String description, Long value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }



    @ApiModelProperty(position = 1,
            value = "Goal Name",
            name = "Name",
            notes = "Name of the Goal",
            dataType = "java.lang.String",
            example = "10K Run",
            required = true)
    public String getName() {
        return name;
    }

    @ApiModelProperty(position = 2,
            value = "Reward Description",
            name = "Description of the Reward",
            notes = "ID of the Rewards",
            dataType = "java.lang.String",
            example = "Run 10 kilometers",
            required = true)
    public String getDescription() {
        return description;
    }

    @ApiModelProperty(position = 3,
            value = "Reward Value",
            name = "Value",
            notes = "Value of the reward in Miles",
            dataType = "java.lang.Long",
            example = "100",
            required = true)
    public Long getValue() {
        return value;
    }

    @JsonIgnore
    public Goals getGoals() {
        return new Goals(getName(), getDescription(), getValue());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoalsDto goalsDto = (GoalsDto) o;
        return Objects.equals(name, goalsDto.name) && Objects.equals(description, goalsDto.description) && Objects.equals(value, goalsDto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, value);
    }

    @Override
    public String toString() {
        return "GoalsDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
