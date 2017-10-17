// Essa interface será usada como meio de acesso aos dados de tarefas da base de dados Task

package todotask.repository;

import todotask.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Este repositório será linkado ao modelo pelo controlador, que dá os métodos HTTP para conversa entre BD e web
@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long> {};