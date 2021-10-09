package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.MembersDto;

public interface CreateMembersFlow {
    MembersDto create(MembersDto member);
}
