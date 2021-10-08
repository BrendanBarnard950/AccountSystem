package za.ac.nwu.as.repo.persistence;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType, Long> {
}
