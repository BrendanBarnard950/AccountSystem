package za.ac.nwu.as.domain.persistence;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Component
@Table(name="GOALS")

public class Goals {
    @Id
    @SequenceGenerator(name = "GOALS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOALS_SEQ")
    @Column(name = "GOAL_ID")
    private Long goalID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VALUE_MILES")
    private Long value;

    public Goals() {
    }

    public Goals(Long goalID, String name, String description, Long value) {
        this.goalID = goalID;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public Goals(String name, String description, Long value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getValue() {
        return value;
    }

    public Long getGoalID() {
        return goalID;
    }

    public void setGoalID(Long goalID) {
        this.goalID = goalID;
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
        Goals goals = (Goals) o;
        return Objects.equals(goalID, goals.goalID) && Objects.equals(name, goals.name) && Objects.equals(description, goals.description) && Objects.equals(value, goals.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goalID, name, description, value);
    }

    @Override
    public String toString() {
        return "Goals{" +
                "goalID=" + goalID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}