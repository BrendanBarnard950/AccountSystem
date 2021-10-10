package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistence.Rewards;

import javax.transaction.Transactional;

@Repository
public interface RewardsRepo extends JpaRepository<Rewards, Long> {

    @Query(value = "SELECT " +
            " par " +
            " FROM " +
            " Rewards par " +
            " WHERE par.partner = :partner ")
    Rewards getRewardsByPartner(String partner);

    @Modifying
    @Transactional
    @Query(value = "UPDATE " +
            " Members mem " +
            " SET mem.balance = (mem.balance - :value) " +
            " WHERE mem.username = :name ")
    void redeemReward(String name, Long value);
}
