package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MembersDto;
import za.ac.nwu.as.logic.flow.CreateMembersFlow;
import za.ac.nwu.as.trans.MembersTranslator;
import za.ac.nwu.as.trans.CurrenciesTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;


@Transactional
@Component
public class CreateMembersFlowImpl implements CreateMembersFlow {

    private final MembersTranslator membersTranslator;
    private final CurrenciesTranslator currenciesTranslator;

    @Autowired
    public  CreateMembersFlowImpl(MembersTranslator membersTranslator, CurrenciesTranslator currenciesTranslator) {
        this.membersTranslator = membersTranslator;
        this.currenciesTranslator = currenciesTranslator;
    }

    @Override
    public MembersDto create(MembersDto members){
        if (null == members.getCreationDate()) {
            members.setCreationDate(LocalDate.now());
        }
        String ID = members.getPrefcurrency();
        Long LID = currenciesTranslator.getCurrenciesID(ID);
        members.setPrefcurrency(LID.toString());

        return membersTranslator.create(members);
    }
}
