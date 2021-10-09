package za.ac.nwu.as.trans;

import java.util.List;
import za.ac.nwu.as.domain.dto.RewardsDto;

public interface RewardsTranslator  {
    List<RewardsDto> getAllRewards();
    RewardsDto create(RewardsDto accountType);
    RewardsDto getRewardsByPartner(String name);
}