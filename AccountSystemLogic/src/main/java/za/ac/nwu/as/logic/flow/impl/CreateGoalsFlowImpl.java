package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.GoalsDto;
import za.ac.nwu.as.logic.flow.CreateGoalsFlow;
import za.ac.nwu.as.trans.GoalsTranslator;
import javax.transaction.Transactional;



@Transactional
@Component
public class CreateGoalsFlowImpl implements CreateGoalsFlow {

    private final GoalsTranslator goalsTranslator;

    @Autowired
    public  CreateGoalsFlowImpl(GoalsTranslator goalsTranslator) {
        this.goalsTranslator = goalsTranslator;
    }

    @Override
    public GoalsDto create(GoalsDto goals){
        return goalsTranslator.create(goals);
    }
}
