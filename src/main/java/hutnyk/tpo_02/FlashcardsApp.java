package hutnyk.tpo_02;

import hutnyk.tpo_02.Controller.FlashcardsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class FlashcardsApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlashcardsApp.class, args);
        FlashcardsController controller = context.getBean(FlashcardsController.class);
        controller.startApplication();
    }
}