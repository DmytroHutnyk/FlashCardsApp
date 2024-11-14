package hutnyk.tpo_02.Repository;

import hutnyk.tpo_02.Model.IEntry;
import hutnyk.tpo_02.Service.IReadWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EntryRepository implements IEntryRepository{
    private List<IEntry> entries;

    @Value("${hutnyk.tpo_02.filename}")
    private String filename;

    @Autowired
    public EntryRepository(IReadWriteService service){
        entries = service.readFile(filename);
    }


    public List<IEntry> getEntries() {
        return entries;
    }


}
