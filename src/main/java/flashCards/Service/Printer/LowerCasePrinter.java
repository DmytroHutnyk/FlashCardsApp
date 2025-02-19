package flashCards.Service.Printer;

import flashCards.Model.IEntry;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Profile("LowerCase")
public class LowerCasePrinter implements IPrinter {


    public void printDictionary(List<IEntry> entries) {
        for (IEntry entry : entries) {
            Map<String, String> map = entry.getTranslations();
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> translation : map.entrySet()) {
                result.append(translation.getKey())
                        .append(": ")
                        .append(translation.getValue().toLowerCase())
                        .append(" ");
            }

            System.out.println(result);
        }
    }
}
