package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.GoalsDto;
import za.ac.nwu.as.logic.flow.FetchGoalsFlow;
import za.ac.nwu.as.trans.GoalsTranslator;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchGoalsFlowImpl implements FetchGoalsFlow {

    private final GoalsTranslator goalsTranslator;

    @Autowired
    public FetchGoalsFlowImpl(GoalsTranslator goalsTranslator){
        this.goalsTranslator = goalsTranslator;
    }

    @Override
    public List<GoalsDto> getAllGoals() {
        return goalsTranslator.getAllGoals();
    }

    @Override
    public GoalsDto getGoalsByName(String partner) {
        return goalsTranslator.getGoalsByName(partner);
    }

}
