package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistence.Rewards;

@Repository
public interface RewardsRepo extends JpaRepository<Rewards, Long> {

    @Query(value = "SELECT " +
            " par " +
            " FROM " +
            " Rewards par " +
            " WHERE par.partner = :partner ")
    Rewards getRewardsByPartner(String partner);
}
