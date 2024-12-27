package hutnyk.tpo_02.Repository;

import hutnyk.tpo_02.Model.IEntry;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IEntryRepository {
    void addEntry(IEntry entry);
    <T extends IEntry> List<T> findAllEntries(Class<T> entityClass);
//    boolean deleteEntryByEnglish(String english);
    Optional<IEntry> findEntryByEnglish(String english);
    void updateEntry(IEntry entry);
    String updateEntry(IEntry entry, String beforeModification);
    int deleteEntry(String englishWord);
    Optional<IEntry> findRandom();
}
