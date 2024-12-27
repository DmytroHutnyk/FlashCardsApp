package hutnyk.tpo_02.Service;

import hutnyk.tpo_02.Model.BasicEntry;
import hutnyk.tpo_02.Model.IEntry;
import hutnyk.tpo_02.Repository.IEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceDB implements  IServiceDB{

    private final IEntryRepository entryRepository;

    @Autowired
    public ServiceDB(IEntryRepository entryRepository){
        this.entryRepository = entryRepository;
    }

    public String addEntry(IEntry entry, boolean override){
        Optional<IEntry> existingEntryDB = entryRepository.findEntryByEnglish(entry.getEnglish());

        final String[] result = new String[1];

        existingEntryDB.ifPresentOrElse(
                existingEntry -> {
                    if(override){
                        existingEntry.setTranslations(entry.getEnglish(), entry.getGerman(), entry.getPolish());
                        entryRepository.updateEntry(existingEntry);
                        result[0] = "Word successfully overridden";
                    }

                }, () -> {
                    entryRepository.addEntry(entry);
                    result[0] = "Word successfully added";

                }
        );
        return result[0];

    }

    public void displayDictionary(){
        List<BasicEntry> entries = entryRepository.findAllEntries(BasicEntry.class);

        if(entries.isEmpty()){
            System.out.println("No entries found");
        }else{
            entries.forEach(System.out::println);
        }
    }

    public String deleteEntry(String english){
        if ( entryRepository.deleteEntry(english) > 0) {
            return "Entry successfully deleted";
        } else {
            return "No records found with English word: " + english;
        }
    }

    public String updateEntry(IEntry entry, String beforeModification){
        return entryRepository.updateEntry(entry, beforeModification);
    }

    public boolean isPresent(String english){
        Optional<IEntry> existingEntryDB = entryRepository.findEntryByEnglish(english);
        if(existingEntryDB.isPresent()){
            return true;
        }else
            return false;
    }

    public IEntry generateQuiz(){
        return entryRepository.findRandom().orElse(null);
    }
}
