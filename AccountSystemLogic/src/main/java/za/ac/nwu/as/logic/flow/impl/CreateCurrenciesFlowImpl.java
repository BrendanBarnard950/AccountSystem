package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.CurrenciesDto;
import za.ac.nwu.as.logic.flow.CreateCurrenciesFlow;
import za.ac.nwu.as.trans.CurrenciesTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;


@Transactional
@Component
public class CreateCurrenciesFlowImpl implements CreateCurrenciesFlow {

    private final CurrenciesTranslator currenciesTranslator;

    @Autowired
    public  CreateCurrenciesFlowImpl(CurrenciesTranslator currenciesTranslator) {
        this.currenciesTranslator = currenciesTranslator;
    }

    @Override
    public CurrenciesDto create(CurrenciesDto currencies){
        if (null == currencies.getCreationDate()) {
            currencies.setCreationDate(LocalDate.now());
        }
        return currenciesTranslator.create(currencies);
    }
}
