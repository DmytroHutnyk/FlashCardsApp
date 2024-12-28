package hutnyk.tpo_02.Service.Printer;

import hutnyk.tpo_02.Model.BasicEntry;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@Profile("UpperCase")
public class UpperCase implements IPrinter{
    public void printDictionary(List<BasicEntry> entries) {
        for (BasicEntry entry : entries) {
            Map<String, String> map = entry.getTranslations();
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> translation : map.entrySet()) {
                result.append(translation.getKey())
                        .append(": ")
                        .append(translation.getValue().toUpperCase())
                        .append(" ");
            }
            System.out.println(result);
        }
    }
}
