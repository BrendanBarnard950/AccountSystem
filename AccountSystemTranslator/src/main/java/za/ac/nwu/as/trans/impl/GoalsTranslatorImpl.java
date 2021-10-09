package za.ac.nwu.as.trans.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.repo.persistence.GoalsRepo;
import za.ac.nwu.as.domain.dto.GoalsDto;
import za.ac.nwu.as.domain.persistence.Goals;
import za.ac.nwu.as.trans.GoalsTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoalsTranslatorImpl implements GoalsTranslator {

    private final GoalsRepo goalsRepo;

    @Autowired
    public  GoalsTranslatorImpl(GoalsRepo goalsRepo){
        this.goalsRepo = goalsRepo;
    }

    @Override
    public List<GoalsDto> getAllGoals(){

        List<GoalsDto> goalsDtos = new ArrayList<>();
        try {
            for (Goals goals : goalsRepo.findAll()){
                goalsDtos.add(new GoalsDto(goals));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from Database", e);
        }

        return goalsDtos;
    }

    @Override
    public GoalsDto create(GoalsDto goalsDto) {
        try{
            Goals goals = goalsRepo.save(goalsDto.getGoals());
            return new GoalsDto(goals);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }

    @Override
    public GoalsDto getGoalsByName(String name) {
        try{
            Goals goals = goalsRepo.getGoalsByName(name);
            return new GoalsDto(goals);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to Database", e);
        }
    }
}
