package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistence.Goals;

@Repository
public interface GoalsRepo extends JpaRepository<Goals, Long> {

    @Query(value = "SELECT " +
            " gol " +
            " FROM " +
            " Goals gol " +
            " WHERE gol.name = :name ")
    Goals getGoalsByName(String name);

    @Query(value = "SELECT " +
            " gol " +
            " FROM " +
            " Goals gol " +
            " WHERE gol.name = :id ")
    Goals getGoalsByID(String id);




}
