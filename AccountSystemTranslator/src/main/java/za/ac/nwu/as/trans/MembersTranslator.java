package za.ac.nwu.as.trans;

import java.util.List;
import za.ac.nwu.as.domain.dto.MembersDto;

public interface MembersTranslator  {
    List<MembersDto> getAllMembers();
    MembersDto create(MembersDto accountType);
    MembersDto getMembersByName(String name);
}
