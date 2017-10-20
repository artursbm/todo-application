package todotask.service;

import todotask.repository.TaskRepository;
import todotask.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements TaskServiceDecl {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> getAllTasks() {
		List<Task> task = taskRepository.findAll();
		return task;
	}

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	public ResponseEntity<Task> getTaskById(Long taskId) {
		Task task = taskRepository.findOne(taskId);
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(task);
	}
	
	public ResponseEntity<Task> updateTask(Long taskId, Task taskDetails) {
		Task task = taskRepository.findOne(taskId);
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		task.setComplete(true);
		task.setGps(taskDetails.getLatitude(), taskDetails.getLongitude());
		
		Task updatedTask = taskRepository.save(task);
		
		return ResponseEntity.ok(updatedTask);
	}
	
	public ResponseEntity<Task> deleteTask(Long taskId) {
		Task task = taskRepository.findOne(taskId);
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		taskRepository.delete(task);
		
		return ResponseEntity.ok().build();
	}

}
