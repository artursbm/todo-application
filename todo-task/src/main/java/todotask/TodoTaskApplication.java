// Ponto de início da aplicação, onde um Spring boot é criado e configura o serviço como um todo

package todotask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import todotask.service.StorageService;
import todotask.StorageProperties;


//@EnableAutoConfiguration

@SpringBootApplication
@ComponentScan
@EnableJpaAuditing
@EnableJpaRepositories
@EnableConfigurationProperties(StorageProperties.class)
public class TodoTaskApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TodoTaskApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll();
            storageService.init();
        };
    }
}