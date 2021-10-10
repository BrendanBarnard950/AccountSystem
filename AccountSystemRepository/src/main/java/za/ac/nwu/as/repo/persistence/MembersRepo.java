package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistence.Members;

import javax.transaction.Transactional;

@Repository
public interface MembersRepo extends JpaRepository<Members, Long> {

    @Query(value = "SELECT " +
            " mem " +
            " FROM " +
            " Members mem " +
            " WHERE mem.username = :name ")
    Members getMembersByName(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE " +
            " Members mem " +
            " SET mem.balance = (mem.balance + :value) " +
            " WHERE mem.username = :name ")
    void cashGoal(String name, Long value);
}
