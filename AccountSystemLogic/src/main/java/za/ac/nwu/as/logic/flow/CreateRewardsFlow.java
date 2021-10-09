package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.RewardsDto;

public interface CreateRewardsFlow {
    RewardsDto create(RewardsDto member);
}