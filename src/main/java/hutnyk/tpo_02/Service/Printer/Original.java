package hutnyk.tpo_02.Service.Printer;

import hutnyk.tpo_02.Model.IEntry;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
@Profile("Original")
public class Original implements IPrinter{

    public void printDictionary(List<IEntry> entries) {
        for (IEntry entry : entries) {
            Map<String, String> map = entry.getTranslations();
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> translation : map.entrySet()) {
                result.append(translation.getKey())
                        .append(": ")
                        .append(translation.getValue())
                        .append(" ");
            }

            System.out.println(result);
        }
    }
}
