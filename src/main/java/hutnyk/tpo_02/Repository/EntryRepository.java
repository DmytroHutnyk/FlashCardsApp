package hutnyk.tpo_02.Repository;

import hutnyk.tpo_02.Model.IEntry;
import hutnyk.tpo_02.Service.IReadWriteService;
import hutnyk.tpo_02.Service.Printer.IPrinter;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class EntryRepository implements IEntryRepository {
    private List<IEntry> entries;
    private IPrinter printer;
    private final Random random = new Random();

    @Value("${hutnyk.tpo_02.filename}")
    private String filename;

    private final IReadWriteService service;

    @Autowired
    public EntryRepository(IReadWriteService service, IPrinter printer) {
        this.service = service;
        this.printer = printer;
    }

    @PostConstruct
    public void init() {
        entries = service.readFile(filename);
    }

    public String addWord(IEntry entry, boolean override) throws IllegalArgumentException{
        if (entry.isBasic() != entries.getFirst().isBasic()) {
            return "Number of translations is not equal to the one you are currently working with";
        }

        IEntry existingEntry = findEntryByEnglish(entry.getEnglish());

        if (existingEntry == null) {
            entries.add(entry);
            return "New entry added successfully.";
        } else if (override) {
            replaceEntry(existingEntry, entry);
            return "Existing entry overridden successfully.";
        } else {
            return "Entry with the same English word already exists. Use override option to replace it.";
        }
    }

    private IEntry findEntryByEnglish(String englishWord) {
        return entries.stream()
                .filter(e -> e.getEnglish().equalsIgnoreCase(englishWord))
                .findFirst()
                .orElse(null);
    }

    private void replaceEntry(IEntry oldEntry, IEntry newEntry) {
        int index = entries.indexOf(oldEntry);
        if (index != -1) {
            entries.set(index, newEntry);
        }
    }

    public void displayDictionary(){
        printer.printDictionary(entries);
    }

    // is available only for BasicEntry
    public IEntry generateQuiz() {
        int randomIndex = random.nextInt(entries.size());
        return entries.get(randomIndex);
    }

    public boolean isBasic(){
        return entries.getLast().isBasic();
    }

    public List<IEntry> getEntries() {
        return entries;
    }


}
