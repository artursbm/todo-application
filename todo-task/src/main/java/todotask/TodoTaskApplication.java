// Ponto de início da aplicação, onde um Spring boot é criado e configura o serviço como um todo

package todotask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaAuditing
@EnableJpaRepositories
@EnableAutoConfiguration
public class TodoTaskApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TodoTaskApplication.class, args);
	}
}