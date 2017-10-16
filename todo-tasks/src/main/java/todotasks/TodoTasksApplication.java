// Ponto de início da aplicação, onde um Spring boot é criado e configura o serviço como um todo

package todotasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodoTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoTasksApplication.class, args);
	}
}
