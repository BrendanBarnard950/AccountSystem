package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.GoalsDto;

public interface CreateGoalsFlow {
    GoalsDto create(GoalsDto goal);
}