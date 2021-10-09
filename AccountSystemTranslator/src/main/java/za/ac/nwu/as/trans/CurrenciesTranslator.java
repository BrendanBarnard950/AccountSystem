package za.ac.nwu.as.trans;

import java.util.List;
import za.ac.nwu.as.domain.dto.CurrenciesDto;

public interface CurrenciesTranslator  {
    List<CurrenciesDto> getAllCurrencies();
    CurrenciesDto create(CurrenciesDto currencies);
    CurrenciesDto getCurrenciesByName(String name);
    Long getCurrenciesID(String mnemonic);
}
