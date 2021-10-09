package za.ac.nwu.as.trans.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.repo.persistence.CurrenciesRepo;
import za.ac.nwu.as.domain.dto.CurrenciesDto;
import za.ac.nwu.as.domain.persistence.Currencies;
import za.ac.nwu.as.trans.CurrenciesTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrenciesTranslatorImpl implements CurrenciesTranslator {

    private final CurrenciesRepo currenciesRepo;

    @Autowired
    public CurrenciesTranslatorImpl(CurrenciesRepo currenciesRepo){
        this.currenciesRepo = currenciesRepo;
    }

    @Override
    public List<CurrenciesDto> getAllCurrencies(){

        List<CurrenciesDto> currenciesDtos = new ArrayList<>();
        try {
            for (Currencies members : currenciesRepo.findAll()){
                currenciesDtos.add(new CurrenciesDto(members));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from Database", e);
        }

        return currenciesDtos;
    }

    @Override
    public CurrenciesDto create(CurrenciesDto currenciesDto) {
        try{
            Currencies currencies = currenciesRepo.save(currenciesDto.getCurrencies());
            return new CurrenciesDto(currencies);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }

    @Override
    public CurrenciesDto getCurrenciesByName(String name) {
        try{
            Currencies currencies = currenciesRepo.getCurrenciesByName(name);
            return new CurrenciesDto(currencies);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }

    @Override
    public Long getCurrenciesID(String mnemonic) {
        try {
            Currencies currencies = currenciesRepo.getCurrenciesByName(mnemonic);
            return currencies.getCurrencyID();
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }
}
