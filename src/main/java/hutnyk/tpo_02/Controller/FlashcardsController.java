package hutnyk.tpo_02.Controller;

import hutnyk.tpo_02.Model.BasicEntry;
import hutnyk.tpo_02.Model.IEntry;
import hutnyk.tpo_02.Model.IEntryFactory;
import hutnyk.tpo_02.Repository.IEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

@Controller
public class FlashcardsController {

    IEntryRepository entryRepository;
    IEntryFactory entryFactory;


    @Autowired
    public FlashcardsController(IEntryRepository entryRepository, IEntryFactory entryFactory){
        this.entryRepository = entryRepository;
        this.entryFactory = entryFactory;
    }

    public void startApplication(){
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Select an option: \n" +
                    "1. Display whole dictionary \n" +
                    "2. Add new word \n" +
                    "3. Play a quiz \n");

            int option = scanInt();
            Scanner scanner = new Scanner(System.in);

            switch (option){
                case 1:
                    entryRepository.displayDictionary();
                    break;
                case 2:
                    System.out.println("If the word exists, do you want to override it? \n" +
                            "1. Yes \n" +
                            "2. No \n");
                    int override = scanInt();
                    if(entryRepository.isBasic()){
                        System.out.println("Enter a word in three languages line by line:");

                        System.out.println("English:");
                        String english = scanner.next();

                        System.out.println("German:");
                        String german = scanner.next();

                        System.out.println("Polish:");
                        String polish = scanner.next();
                        String result = entryRepository.addWord(entryFactory.createEntry(english, german, polish), (override == 1));
                        System.out.println(result);
                    }// add other implementation if needed
                    break;

                case 3:
                    IEntry entry = entryRepository.generateQuiz();
                    System.out.println("Enter translation of the following word: " + entry.getEnglish());
                    if(entry.isBasic()){
                        Map<String, String> values = entry.getTranslations();
                        System.out.println("german:");
                        String german = scanner.next();

                        System.out.println("polish:");
                        String polish = scanner.next();


                        if(values.get("german").equalsIgnoreCase(german) && values.get("polish").equalsIgnoreCase(polish)){
                            System.out.println("Congratulations! Answers are correct");
                        }else{
                            System.out.println("Ooops, you made a mistake, correct answers are: \n" +
                                    "german: " + values.get("german") + " polish: " + values.get("polish"));

                        }
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Exiting application...");
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
