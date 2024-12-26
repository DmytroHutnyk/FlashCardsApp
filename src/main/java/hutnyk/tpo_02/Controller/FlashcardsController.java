package hutnyk.tpo_02.Controller;

import hutnyk.tpo_02.Model.BasicEntry;
import hutnyk.tpo_02.Model.IEntry;
import hutnyk.tpo_02.Model.IEntryFactory;
import hutnyk.tpo_02.Repository.IEntryRepository;
import hutnyk.tpo_02.Service.IServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

@Controller
public class FlashcardsController {

    private final IEntryRepository entryRepository;//TODO remove
    private final IServiceDB serviceDB;
    private final IEntryFactory entryFactory;
    private final ApplicationContext context;

    @Autowired
    public FlashcardsController(IEntryRepository entryRepository, IEntryFactory entryFactory, ApplicationContext context, IServiceDB serviceDB){
        this.entryRepository = entryRepository;
        this.entryFactory = entryFactory;
        this.context = context;
        this.serviceDB = serviceDB;
    }

    public void startApplication(){
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Select an option: \n" +
                    "1. Display whole dictionary \n" +
                    "2. Add new word \n" +
                    "3. Delete a word \n" +
                    "4. Update a word \n" +
                    "5. Sort \n" +
                    "6. Play a quiz \n" +
                    "7. Exit application");

            int option = scanInt();
            Scanner scanner = new Scanner(System.in);

            switch (option){
                case 1:
                    serviceDB.displayDictionary();
                    break;

                case 2:
                    System.out.println("If the word exists, do you want to override it? \n" +
                            "1. Yes \n" +
                            "2. No \n");
                    int override = scanInt();
                        System.out.println("Enter a word in three languages line by line:");

                        System.out.println("English:");
                        String english = scanner.next();

                        System.out.println("German:");
                        String german = scanner.next();

                        System.out.println("Polish:");
                        String polish = scanner.next();
                        String result = serviceDB.addEntry(entryFactory.createEntry(english, german, polish), (override == 1));
                        System.out.println(result);

                    break;
                case 3:
                    System.out.println("Enter a word in english to delete it");
                    String input = scanner.next();
                    System.out.println(serviceDB.deleteEntry(input));
                    break;
                case 4:
                    System.out.println("Enter a word in English you would like to update:");
                    String input1 = scanner.next();
                    if(!serviceDB.isPresent(input1)){
                        System.out.println("Word is not present");
                    }else{
                        System.out.println("Enter a word in three languages line by line:");

                        System.out.println("English:");
                        String english1 = scanner.next();

                        System.out.println("German:");
                        String german1 = scanner.next();

                        System.out.println("Polish:");
                        String polish1 = scanner.next();
                        System.out.println(serviceDB.updateEntry(entryFactory.createEntry(english1, german1, polish1), input1));
                    }

                    break;
//                case 6:
//                    IEntry entry = entryRepository.generateQuiz();
//                    System.out.println("Enter translation of the following word: " + entry.getEnglish());
//                    if(entry.isBasic()){
//                        Map<String, String> values = entry.getTranslations();
//                        System.out.println("german:");
//                        String german = scanner.next();
//
//                        System.out.println("polish:");
//                        String polish = scanner.next();
//
//
//                        if(values.get("german").equalsIgnoreCase(german) && values.get("polish").equalsIgnoreCase(polish)){
//                            System.out.println("Congratulations! Answers are correct");
//                        }else{
//                            System.out.println("Ooops, you made a mistake, correct answers are: \n" +
//                                    "german: " + values.get("german") + " polish: " + values.get("polish"));
//
//                        }
//                    }
//                    break;

                case 7:
                    isRunning = false;
                    System.out.println("Exiting application...");
                    SpringApplication.exit(context, () -> 0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private int scanInt(){
        int result = 0;
        try{
            Scanner scanner = new Scanner(System.in);
            result = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid input\n");
        }
        return result;
    }
}
