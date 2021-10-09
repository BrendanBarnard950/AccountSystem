package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.RewardsDto;
import za.ac.nwu.as.logic.flow.CreateRewardsFlow;
import za.ac.nwu.as.trans.RewardsTranslator;
import javax.transaction.Transactional;



@Transactional
@Component
public class CreateRewardsFlowImpl implements CreateRewardsFlow {

    private final RewardsTranslator rewardsTranslator;

    @Autowired
    public  CreateRewardsFlowImpl(RewardsTranslator rewardsTranslator) {
        this.rewardsTranslator = rewardsTranslator;
    }

    @Override
    public RewardsDto create(RewardsDto rewards){
        return rewardsTranslator.create(rewards);
    }
}
