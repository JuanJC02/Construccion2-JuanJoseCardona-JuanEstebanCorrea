package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.adapters.in.input.ConsoleMenu;

@SpringBootApplication
public class VeterinariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeterinariaApplication.class, args);
        
        
        ConsoleMenu menu = new ConsoleMenu();
        menu.start();
    }

}
