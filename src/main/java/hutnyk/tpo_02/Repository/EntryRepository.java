package hutnyk.tpo_02.Repository;

import hutnyk.tpo_02.Model.IEntry;
import hutnyk.tpo_02.Service.Printer.IPrinter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public  class EntryRepository implements IEntryRepository {

    @PersistenceContext
    private final EntityManager entityManager;
    private IPrinter printer;
    private final Random random = new Random();

    @Autowired
    public EntryRepository(IPrinter printer, EntityManager entityManager) {
        this.printer = printer;
        this.entityManager = entityManager;
    }

    @Transactional
    public void addEntry(IEntry entry){
        entityManager.persist(entry);
    }

    @Transactional
    public void updateEntry(IEntry entry){
        entityManager.merge(entry);
    }

    @Transactional
    public String updateEntry(IEntry newEntry, String beforeModification){
        String query = "SELECT e FROM BasicEntry e WHERE e.english = :englishWord";
        Optional<IEntry> selectedEntry = entityManager.createQuery(query, IEntry.class).
                setParameter("englishWord", beforeModification).
                getResultStream().findFirst();

        if(selectedEntry.isPresent()){
            selectedEntry.get().setTranslations(newEntry.getEnglish(), newEntry.getGerman(), newEntry.getGerman());
            entityManager.merge(selectedEntry.get());
            return "Word successfully updated";
        }else {
            return "Word does not exist";
        }
    }

    @Transactional(readOnly = true)
    public Optional<IEntry> findEntryByEnglish(String englishWord) {
        String query = "SELECT e FROM BasicEntry e WHERE e.english = :englishWord";
        return  entityManager.createQuery(query, IEntry.class).
                setParameter("englishWord", englishWord).
                getResultStream().findFirst();
    }

    @Transactional
    public  List<IEntry> findAllEntries(){
        String query = "Select e FROM BasicEntry e";
        return entityManager.createQuery(query, IEntry.class).getResultStream().toList();
    }

    @Transactional
    public int deleteEntry(String englishWord){
        String query = "DELETE FROM BasicEntry e WHERE e.english = :englishWord";
        int rowsAffected =  entityManager.createQuery(query).setParameter("englishWord", englishWord).executeUpdate();
        entityManager.clear();
        return  rowsAffected;
    }

    @Transactional(readOnly = true)
    public Optional<IEntry> findRandom(){
        Long count = entityManager.createQuery("SELECT COUNT(e) FROM BasicEntry e", Long.class).getSingleResult();

        int random = new Random().nextInt(count.intValue());

        return entityManager.createQuery("SELECT e FROM BasicEntry e", IEntry.class).
                setFirstResult(random).
                setMaxResults(1).
                getResultStream().
                findFirst();
    }
}
