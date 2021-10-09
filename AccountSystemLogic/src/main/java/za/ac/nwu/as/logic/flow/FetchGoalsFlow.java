package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.GoalsDto;
import java.util.List;

public interface FetchGoalsFlow {
    List<GoalsDto> getAllGoals();
    GoalsDto getGoalsByName(String name);
}