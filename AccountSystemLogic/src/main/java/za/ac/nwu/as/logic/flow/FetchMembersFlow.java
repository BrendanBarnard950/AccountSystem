package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.MembersDto;
import java.util.List;

public interface FetchMembersFlow {
    List<MembersDto> getAllMembers();
    MembersDto getMembersByName(String name);
}
