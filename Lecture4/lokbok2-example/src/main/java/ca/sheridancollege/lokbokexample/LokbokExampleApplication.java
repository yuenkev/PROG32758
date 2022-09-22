package ca.sheridancollege.lokbokexample;

import ca.sheridancollege.lokbokexample.beans.School;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class LokbokExampleApplication {

	public static void main(String[] args) {

		log.info("Starting the application {}", LokbokExampleApplication.class);

		ConfigurableApplicationContext context = SpringApplication.run(LokbokExampleApplication.class);

		School school = (School) context.getBean("school");
		System.out.println(school);






	}

}
