// Essa interface será usada como meio de acesso aos dados de tarefas da base de dados Task

package todotasks.repository;

import todotasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// Este repositório será linkado ao modelo pelo controlador, que dá os métodos HTTP para conversa entre BD e web
public interface TaskRepository extends JpaRepository<Task, Long> {};
