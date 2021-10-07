package za.ac.nwu.as.trans;

import java.util.List;
import za.ac.nwu.as.domain.dto.AccountTypeDto;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();
}
