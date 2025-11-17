package app;

import app.adapters.in.input.ConsoleAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VeterinariaApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(VeterinariaApplication.class, args);
        
        
        ConsoleAdapter console = ctx.getBean(ConsoleAdapter.class);
        console.start();
    }

}
