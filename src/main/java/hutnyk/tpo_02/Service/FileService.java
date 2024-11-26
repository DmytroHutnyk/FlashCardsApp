package hutnyk.tpo_02.Service;

import hutnyk.tpo_02.Model.BasicEntry;
import hutnyk.tpo_02.Model.IEntry;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FileService implements IReadWriteService {

   public List<IEntry> readFile(String filename){
       List<IEntry> entries = new ArrayList<>();
       ClassPathResource resource = new ClassPathResource(filename);
       try(BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))){
           String line;
           while((line = reader.readLine()) != null){
               String[] parts = line.split(";");
               entries.add(new BasicEntry(parts[0], parts[1], parts[2]));
           }
       }catch (IOException e){
           e.printStackTrace();
       }
       return entries;
   }

    public void writeFile(String filename, List<IEntry> data) {
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (IEntry entry : data) {
                StringBuilder line = new StringBuilder();

                Map<String, String> translations = entry.getTranslations();
                for (Map.Entry<String, String> translation : translations.entrySet()) {
                    line.append(translation.getKey()).append(":").append(translation.getValue()).append(";");
                }

                if (line.length() > 0) {
                    line.setLength(line.length() - 1);
                }
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
