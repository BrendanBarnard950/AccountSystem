package za.ac.nwu.as.repo.persistence;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountTypeDto, Long> {
}
