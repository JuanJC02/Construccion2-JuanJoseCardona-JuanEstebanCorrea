package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.domain.adapters.input.ConsoleAdapter;

@SpringBootApplication
public class VeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApplication.class, args);
		ConsoleAdapter.showprincipalmenu();
	}

}
