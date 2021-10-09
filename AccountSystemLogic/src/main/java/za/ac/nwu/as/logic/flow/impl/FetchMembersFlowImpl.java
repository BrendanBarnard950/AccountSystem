package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MembersDto;
import za.ac.nwu.as.logic.flow.FetchMembersFlow;
import za.ac.nwu.as.trans.MembersTranslator;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchMembersFlowImpl implements FetchMembersFlow {

    private final MembersTranslator membersTranslator;

    @Autowired
    public  FetchMembersFlowImpl(MembersTranslator membersTranslator){
        this.membersTranslator = membersTranslator;
    }

    @Override
    public List<MembersDto> getAllMembers() {
        return membersTranslator.getAllMembers();
    }

    @Override
    public MembersDto getMembersByName(String mnemonic) {
        return membersTranslator.getMembersByName(mnemonic);
    }

}
