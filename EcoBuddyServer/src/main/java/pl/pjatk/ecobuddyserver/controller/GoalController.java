package pl.pjatk.ecobuddyserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.ecobuddyserver.model.Goal;
import pl.pjatk.ecobuddyserver.model.enums.EventType;
import pl.pjatk.ecobuddyserver.service.GoalService;

import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping("/createSingleGoal")
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal createdGoal = goalService.save(goal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoal);
    }
    @PostMapping("/createManyGoals")
    public ResponseEntity<List<Goal>> createManyGoals(@RequestBody List<Goal> goal) {
        List<Goal> createdGoal = goalService.saveGoalList(goal);
        return ResponseEntity.ok(createdGoal);
    }

    @GetMapping("/getAllGoals")
    public ResponseEntity<List<Goal>> getAllGoals() {
        List<Goal> goals = goalService.findAll();
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/getGoalById/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable("id") Long id) {
        Goal goal = goalService.getGoalById(id);
        return ResponseEntity.ok(goal);
    }

    @DeleteMapping("/deleteGoalById/{id}")
    public ResponseEntity<Void> deleteGoalById(@PathVariable("id") Long id) {
        goalService.deleteGoalById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateGoalById/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable("id") Long id, @RequestBody Goal updatedGoal) {
        Goal goal = goalService.updateGoal(id, updatedGoal);
        return ResponseEntity.ok(goal);
    }

    @PatchMapping("/addMoneyToGoal/{id}")
    public ResponseEntity<Goal> addMoneyToGoal(@PathVariable("id") Long id) {
        Goal goal = goalService.addMoney(id);
        return ResponseEntity.ok(goal);
    }
    @GetMapping("/findGoalsByCity/{city}")
    public ResponseEntity<List<Goal>> findGoalsByCity(@PathVariable("city") String city){
        return  ResponseEntity.ok(goalService.findGoalsByCity(city));
    }
    @GetMapping("/findGoalsByType/{type}")
    public ResponseEntity<List<Goal>> findGoalsByType(@RequestParam(name = "type") EventType type){
        return  ResponseEntity.ok(goalService.findGoalsByType(type));
    }
}
