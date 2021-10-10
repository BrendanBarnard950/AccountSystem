package za.ac.nwu.as.trans;

import java.util.List;
import za.ac.nwu.as.domain.dto.GoalsDto;

public interface GoalsTranslator  {
    List<GoalsDto> getAllGoals();
    GoalsDto create(GoalsDto goals);
    GoalsDto getGoalsByName(String name);
    String cashGoal(String goalID, String username);
}