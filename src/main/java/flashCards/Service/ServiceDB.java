package flashCards.Service;

import flashCards.Model.BasicEntry;
import flashCards.Model.IEntry;
import flashCards.Repository.IEntryRepository;
import flashCards.Service.Printer.IPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceDB implements  IServiceDB{

    private final IEntryRepository entryRepository;
    private final IPrinter printer;

    @Autowired
    public ServiceDB(IEntryRepository entryRepository, IPrinter printer){
        this.entryRepository = entryRepository;
        this.printer = printer;
    }

    public String addEntry(IEntry entry, boolean override) {
        Optional<BasicEntry> existingEntryDB = entryRepository.findByEnglish(entry.getEnglish());

        final String[] result = new String[1];

        existingEntryDB.ifPresentOrElse(
                existingEntry -> {
                    if (override) {
                        existingEntry.setTranslations(entry.getEnglish(), entry.getGerman(), entry.getPolish());
                        entryRepository.save(existingEntry);
                        result[0] = "Word successfully overridden";
                    } else {
                        result[0] = "Word already exists and was not overridden";
                    }
                },
                () -> {
                    BasicEntry newEntry = new BasicEntry();
                    newEntry.setTranslations(entry.getEnglish(), entry.getGerman(), entry.getPolish());
                    entryRepository.save(newEntry);
                    result[0] = "Word successfully added";
                }
        );

        return result[0];
    }

    public void displayDictionary(){
        List<BasicEntry> entries = entryRepository.findAll();

        if(entries.isEmpty()){
            System.out.println("No entries found");
        }else{
            printer.printDictionary(entries);
        }
    }

    public String deleteEntry(String english){
        if ( entryRepository.deleteByEnglish(english) > 0) {
            return "Entry successfully deleted";
        } else {
            return "No records have been found with English word: " + english;
        }
    }


    public String updateEntry(IEntry newEntry, String beforeModification) {
        Optional<BasicEntry> selectedEntry = entryRepository.findByEnglish(beforeModification);

        if (selectedEntry.isPresent()) {
            BasicEntry entryToUpdate = selectedEntry.get();
            entryToUpdate.setTranslations(newEntry.getEnglish(), newEntry.getGerman(), newEntry.getPolish());

            entryRepository.save(entryToUpdate);
            return "Word successfully updated";
        } else {
            return "Word does not exist";
        }
    }

    public boolean isPresent(String english){
        Optional<BasicEntry> existingEntryDB = entryRepository.findByEnglish(english);
        if(existingEntryDB.isPresent()){
            return true;
        }else
            return false;
    }

    public BasicEntry generateQuiz(){
        return entryRepository.findRandom().orElse(null);
    }
}
