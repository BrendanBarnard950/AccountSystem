package za.ac.nwu.as.trans.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.repo.persistence.RewardsRepo;
import za.ac.nwu.as.domain.dto.RewardsDto;
import za.ac.nwu.as.domain.persistence.Rewards;
import za.ac.nwu.as.trans.RewardsTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class RewardsTranslatorImpl implements RewardsTranslator {

    private final RewardsRepo rewardsRepo;

    @Autowired
    public  RewardsTranslatorImpl(RewardsRepo rewardsRepo){
        this.rewardsRepo = rewardsRepo;
    }

    @Override
    public List<RewardsDto> getAllRewards(){

        List<RewardsDto> rewardsDtos = new ArrayList<>();
        try {
            for (Rewards rewards : rewardsRepo.findAll()){
                rewardsDtos.add(new RewardsDto(rewards));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from Database", e);
        }

        return rewardsDtos;
    }

    @Override
    public RewardsDto create(RewardsDto rewardsDto) {
        try{
            Rewards rewards = rewardsRepo.save(rewardsDto.getRewards());
            return new RewardsDto(rewards);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }

    @Override
    public RewardsDto getRewardsByPartner(String partner) {
        try{
            Rewards rewards = rewardsRepo.getRewardsByPartner(partner);
            return new RewardsDto(rewards);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }
}
