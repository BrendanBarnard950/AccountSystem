package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistence.Currencies;

@Repository
public interface CurrenciesRepo extends JpaRepository<Currencies, Long> {

    @Query(value = "SELECT " +
            " cur " +
            " FROM " +
            " Currencies cur " +
            " WHERE cur.mnemonic = :mnemonic ")
    Currencies getCurrenciesByName(String mnemonic);

 /*   @Query(value = "SELECT " +
            " cur " +
            " FROM " +
            " Currencies cur " +
            " WHERE cur.mnemonic = :id ")
    Currencies getCurrenciesID(Long id);*/
}
