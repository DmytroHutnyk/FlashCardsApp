package hutnyk.tpo_02;

import hutnyk.tpo_02.Model.IEntry;
import hutnyk.tpo_02.Service.FileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class FlashcardsApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlashcardsApp.class, args);


//        List<IEntry> data = new ArrayList<>();
//        FileService fileService = new FileService();
//
//        data = fileService.readFile("src/main/resources/dictionary.txt");
//        for(IEntry entry : data){
//            System.out.println(entry);
//        }


    }
}
