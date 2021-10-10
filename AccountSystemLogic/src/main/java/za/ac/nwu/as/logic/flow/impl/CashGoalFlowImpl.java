package za.ac.nwu.as.logic.flow.impl;

import za.ac.nwu.as.logic.flow.CashGoalFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.trans.MembersTranslator;
import za.ac.nwu.as.trans.GoalsTranslator;
import javax.transaction.Transactional;

@Transactional
@Component
public class CashGoalFlowImpl implements CashGoalFlow {

    private final GoalsTranslator goalsTranslator;
    private final MembersTranslator membersTranslator;

    @Autowired
    public CashGoalFlowImpl(GoalsTranslator goalsTranslator, MembersTranslator membersTranslator){
        this.goalsTranslator = goalsTranslator;
        this.membersTranslator = membersTranslator;
    }

    @Override
    public String cashGoal(String goalID, String username){
        return goalsTranslator.cashGoal(goalID, username);
    }

}
