package todotask.service;

import java.util.List;
import org.springframework.http.ResponseEntity;


import todotask.model.Task;

public interface TaskServiceDecl {
	public List<Task> getAllTasks();
	public Task createTask(Task task);
	public ResponseEntity<Task> getTaskById(Long taskId);
	public ResponseEntity<Task> updateTask(Long taskId, Task taskDetails);
	public ResponseEntity<Task> deleteTask(Long taskId);
}
