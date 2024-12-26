package hutnyk.tpo_02.Repository;

import hutnyk.tpo_02.Model.IEntry;
import hutnyk.tpo_02.Service.IReadWriteService;
import hutnyk.tpo_02.Service.Printer.IPrinter;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        String query = "SELECT e FROM BasicEntry e WHERE e.english = :englishWord"; //TODO maybe we will do as in findAllEntries to have lose coupling
        return  entityManager.createQuery(query, IEntry.class).
                setParameter("englishWord", englishWord).
                getResultStream().findFirst();
    }

    @Transactional
    public <T extends IEntry> List<T> findAllEntries(Class<T> entityClass){
        String query = "Select e FROM " + entityClass.getSimpleName() + " e";
        return entityManager.createQuery(query, entityClass).getResultList();
    }

    @Transactional
    public int deleteEntry(String englishWord){
        String query = "DELETE FROM BasicEntry e WHERE e.english = :englishWord";//TODO maybe we will do as in findAllEntries to have lose coupling
        int rowsAffected =  entityManager.createQuery(query).setParameter("englishWord", englishWord).executeUpdate();
        entityManager.clear();
        return  rowsAffected;
    }
}
