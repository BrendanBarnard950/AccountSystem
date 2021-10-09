package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.CurrenciesDto;
import java.util.List;

public interface FetchCurrenciesFlow {
    List<CurrenciesDto> getAllCurrencies();
    CurrenciesDto getCurrenciesByName(String name);
}
