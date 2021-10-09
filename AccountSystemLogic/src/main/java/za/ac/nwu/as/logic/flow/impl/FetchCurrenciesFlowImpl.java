package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.CurrenciesDto;
import za.ac.nwu.as.logic.flow.FetchCurrenciesFlow;
import za.ac.nwu.as.trans.CurrenciesTranslator;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchCurrenciesFlowImpl implements FetchCurrenciesFlow {

    private final CurrenciesTranslator currenciesTranslator;

    @Autowired
    public  FetchCurrenciesFlowImpl(CurrenciesTranslator currenciesTranslator){
        this.currenciesTranslator = currenciesTranslator;
    }

    @Override
    public List<CurrenciesDto> getAllCurrencies() {
        return currenciesTranslator.getAllCurrencies();
    }

    @Override
    public CurrenciesDto getCurrenciesByName(String mnemonic) {
        return currenciesTranslator.getCurrenciesByName(mnemonic);
    }

}
