package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.RewardsDto;
import za.ac.nwu.as.logic.flow.FetchRewardsFlow;
import za.ac.nwu.as.trans.RewardsTranslator;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchRewardsFlowImpl implements FetchRewardsFlow {

    private final RewardsTranslator currenciesTranslator;

    @Autowired
    public  FetchRewardsFlowImpl(RewardsTranslator currenciesTranslator){
        this.currenciesTranslator = currenciesTranslator;
    }

    @Override
    public List<RewardsDto> getAllRewards() {
        return currenciesTranslator.getAllRewards();
    }

    @Override
    public RewardsDto getRewardsByPartner(String partner) {
        return currenciesTranslator.getRewardsByPartner(partner);
    }

}
