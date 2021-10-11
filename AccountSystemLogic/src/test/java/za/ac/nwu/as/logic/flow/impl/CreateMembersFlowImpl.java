/*package za.ac.nwu.as.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.as.domain.dto.MembersDto;
import za.ac.nwu.as.trans.CurrenciesTranslator;
import za.ac.nwu.as.trans.MembersTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateMembersFlowImpl {

    @Mock
    private MembersTranslator membersTranslator;

    @Mock
    private CurrenciesTranslator currenciesTranslator;

    @InjectMocks
    public  CreateMembersFlowImpl flow;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create(MembersDto members){
        when(membersTranslator.create(any(MembersDto.class))).thenReturn(new MembersDto());
       MembersDto members = flow.create(new MembersDto());
        if (null == members.getCreationDate()) {
            members.setCreationDate(LocalDate.now());
        }
        String ID = members.getPrefcurrency();
        Long LID = currenciesTranslator.getCurrenciesID(ID);
        members.setPrefcurrency(LID.toString());

        assertNotNull(members);
    }
}*/
