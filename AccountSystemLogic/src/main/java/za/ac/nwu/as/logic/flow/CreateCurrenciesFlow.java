package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.CurrenciesDto;

public interface CreateCurrenciesFlow {
    CurrenciesDto create(CurrenciesDto currencies);
}
