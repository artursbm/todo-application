package todotask.controller;

import todotask.model.Task;
import todotask.service.TaskServiceDecl;
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
@RequestMapping("/todo")
public class TaskController {
	@Autowired
	private TaskServiceDecl	taskService;
	
	// GET todas as tarefas (RequestMapping(value="/tasks", method=RequestMethod.Get) == @GetMapping("/tasks")
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	// POST de novas tasks
	@PostMapping("/tasks")
	public Task createTask(@Valid @RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	// GET uma task apenas
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value="id") Long taskId) {
		return taskService.getTaskById(taskId);
	}
	
	// atualizando uma task
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value="id") Long taskId, @Valid @RequestBody Task taskDetails) {
		return taskService.updateTask(taskId, taskDetails);
	}
	
	// deletando uma task
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable(value="id") Long taskId) {
		return taskService.deleteTask(taskId);
	}
}