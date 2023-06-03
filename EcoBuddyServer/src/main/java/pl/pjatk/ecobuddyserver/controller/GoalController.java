package pl.pjatk.ecobuddyserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.ecobuddyserver.model.Goal;
import pl.pjatk.ecobuddyserver.service.GoalService;

import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal createdGoal = goalService.save(goal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoal);
    }

    @GetMapping
    public ResponseEntity<List<Goal>> getAllGoals() {
        List<Goal> goals = goalService.findAll();
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable("id") Long id) {
        Goal goal = goalService.getGoalById(id);
        return ResponseEntity.ok(goal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoalById(@PathVariable("id") Long id) {
        goalService.deleteGoalById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable("id") Long id, @RequestBody Goal updatedGoal) {
        Goal goal = goalService.updateGoal(id, updatedGoal);
        return ResponseEntity.ok(goal);
    }

    @PatchMapping("/{id}/add-money")
    public ResponseEntity<Goal> addMoneyToGoal(@PathVariable("id") Long id) {
        Goal goal = goalService.addMoney(id);
        return ResponseEntity.ok(goal);
    }
}
