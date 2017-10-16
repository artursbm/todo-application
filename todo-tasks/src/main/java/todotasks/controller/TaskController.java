package todotasks.controller;

import todotasks.model.Task;
import todotasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Descrições
 * @author artursbm
 * As annotations abaixo descrevem:
 * @RestController -> une @Controller e @ResponseBody pelo Spring
 * 		@Controller: seta um servidor REST com esse controller;
 * 		@ResponseBody: o valor de retorno do método é usado como response body to request feito
 * @RequestMapping("/api") -> declara que todas as APIs neste controller serão antecipadas por uma 
 * URL com /api como endpoint de referência 
 */

@RestController
@RequestMapping("/api")
public class TaskController {
	@Autowired
	TaskRepository taskRepository;
	
	// GET todas as tarefas (RequestMapping(value="/tasks", method=RequestMethod.Get) == @GetMapping("/tasks")
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	// POST de novas tasks
	@PostMapping("/tasks")
	public Task createTask(@Valid @RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	// GET uma task apenas
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value="id") Long taskId) {
		Task task = taskRepository.findOne(taskId);
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(task);
	}
	
	// atualizando uma task
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value="id") Long taskId, @Valid @RequestBody Task taskDetails) {
		Task task = taskRepository.findOne(taskId);
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		task.setComplete(true);
		task.setCompletedBy(taskDetails.getCompletedBy());
		task.setGps(taskDetails.getLatitude(), taskDetails.getLongitude());
		
		Task updatedTask = taskRepository.save(task);
		
		return ResponseEntity.ok(updatedTask);
	}
}
