package stage.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("stage.entities")
@EnableJpaRepositories("stage.dao")
@ComponentScan(basePackages= "stage")


public class StageApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StageApplication.class, args);
	}

}
