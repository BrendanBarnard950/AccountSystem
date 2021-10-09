package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistence.Members;

@Repository
public interface MembersRepo extends JpaRepository<Members, Long> {

    @Query(value = "SELECT " +
            " mem " +
            " FROM " +
            " Members mem " +
            " WHERE mem.username = :name ")
    Members getMembersByName(String name);
}
