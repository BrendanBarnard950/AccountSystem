package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.RewardsDto;
import java.util.List;

public interface FetchRewardsFlow {
    List<RewardsDto> getAllRewards();
    RewardsDto getRewardsByPartner(String name);
}