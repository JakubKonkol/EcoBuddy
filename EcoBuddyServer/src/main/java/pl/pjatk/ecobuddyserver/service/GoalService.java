package pl.pjatk.ecobuddyserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.ecobuddyserver.model.Goal;
import pl.pjatk.ecobuddyserver.repository.GoalRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;

    public Goal save(Goal goal){
        return goalRepository.save(goal);}

    public List<Goal> findAll(){return  goalRepository.findAll();}

    public Goal getGoalById(Long id){
        var optionalGoal = goalRepository.findById(id);
        if(optionalGoal.isEmpty()){
            throw new NoSuchElementException("no goale with such id found");

        }
        return optionalGoal.get();
    }
    public void deleteGoalById(Long goalId){
        var optionalGoal = goalRepository.findById(goalId);
        if(optionalGoal.isEmpty()){
            throw new NoSuchElementException("no goale with such id found");

        }
        goalRepository.delete(optionalGoal.get());
    }

    public Goal updateGoal(Long goalId, Goal updatedGoal){
        var optionalGoal = goalRepository.findById(goalId);
        if(optionalGoal.isEmpty()){
            throw new NoSuchElementException("no goale with such id found");

        }
        Goal goalToUpdate = optionalGoal.get();
        if(updatedGoal.getName() != null){
            goalToUpdate.setName(updatedGoal.getName());
        }
        if(updatedGoal.getType() != null){
            goalToUpdate.setType(updatedGoal.getType());
        }
        if(updatedGoal.getDescription() != null){
            goalToUpdate.setDescription(updatedGoal.getDescription());
        }
        if(updatedGoal.getFoundationName() != null){
            goalToUpdate.setFoundationName(updatedGoal.getFoundationName());
        }
        if(updatedGoal.getMoneyCollected() != 0){
            goalToUpdate.setMoneyCollected(updatedGoal.getMoneyCollected());
        }
        if (updatedGoal.getMoneyNeeded() != 0){
            goalToUpdate.setMoneyNeeded(updatedGoal.getMoneyNeeded());
        }
        if(updatedGoal.getCity() != null){
            goalToUpdate.setCity(updatedGoal.getCity());
        }
        return goalToUpdate;
    }

    public Goal addMoney(Long id) {
        var  optionalGoal = goalRepository.findById(id);

        if (optionalGoal.isEmpty()) {
            throw new IllegalArgumentException("Goal not found with id: " + id);
        }

        double newMoneyCollected = optionalGoal.get().getMoneyCollected() + 0.05;
        optionalGoal.get().setMoneyCollected(newMoneyCollected);

       return goalRepository.save(optionalGoal.get());


    }


}
