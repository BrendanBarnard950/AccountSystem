package za.ac.nwu.as.trans.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.repo.persistence.MembersRepo;
import za.ac.nwu.as.domain.dto.MembersDto;
import za.ac.nwu.as.domain.persistence.Members;
import za.ac.nwu.as.trans.MembersTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MembersTranslatorImpl implements MembersTranslator {

    private final MembersRepo membersRepo;

    @Autowired
    public  MembersTranslatorImpl(MembersRepo membersRepo){
        this.membersRepo = membersRepo;
    }

    @Override
    public List<MembersDto> getAllMembers(){

        List<MembersDto> membersDtos = new ArrayList<>();
        try {
            for (Members members : membersRepo.findAll()){
                membersDtos.add(new MembersDto(members));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from Database", e);
        }

        return membersDtos;
    }

    @Override
    public MembersDto create(MembersDto membersDto) {
        try{
            Members members = membersRepo.save(membersDto.getMembers());
            return new MembersDto(members);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }

    @Override
    public MembersDto getMembersByName(String name) {
        try{
            Members member = membersRepo.getMembersByName(name);
            return new MembersDto(member);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }
}
