package hutnyk.tpo_02.Model;

import org.springframework.stereotype.Component;

@Component
public class BasicEntryFactory implements IEntryFactory{
    public IEntry createEntry(String english, String german, String polish){
        return new BasicEntry(english, german, polish);
    }
}
