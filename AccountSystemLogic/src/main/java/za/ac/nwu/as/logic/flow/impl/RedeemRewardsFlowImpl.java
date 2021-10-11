package za.ac.nwu.as.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.ac.nwu.as.logic.flow.CashGoalFlow;
import za.ac.nwu.as.logic.flow.RedeemRewardsFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.trans.MembersTranslator;
import za.ac.nwu.as.trans.RewardsTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class RedeemRewardsFlowImpl implements RedeemRewardsFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedeemRewardsFlowImpl.class);

    private final RewardsTranslator rewardsTranslator;
    private final MembersTranslator membersTranslator;

    @Autowired
    public RedeemRewardsFlowImpl(RewardsTranslator rewardsTranslator, MembersTranslator membersTranslator){
        this.rewardsTranslator = rewardsTranslator;
        this.membersTranslator = membersTranslator;
    }

    @Override
    public String redeemReward(String rewardID, String username){
        LOGGER.info("The rewardID and username is {} and {}", rewardID, username);
        return rewardsTranslator.redeemReward(rewardID, username);
    }

}