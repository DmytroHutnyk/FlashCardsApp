package hutnyk.tpo_02.Model;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "basic_entry")
public class BasicEntry implements IEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String english;
    private String german;
    private String polish;

    public BasicEntry() {};

    public BasicEntry(String english, String german, String polish) {
        this.english = english;
        this.german = german;
        this.polish = polish;
    }

    public Map<String, String> getTranslations(){
        Map<String, String> translations = new HashMap<>();
        translations.put("english", english);
        translations.put("german", german);
        translations.put("polish", polish);
        return translations;
    }

    public void setTranslations(String english, String german, String polish){
        this.english = english;
        this.german = german;
        this.polish = polish;
    }

    public void setTranslations(Map<String, String> translations){
        english = translations.get("english");
        german = translations.get("german");
        polish = translations.get("polish");
    }

    public boolean isBasic(){
        return true;
    }

    public String getEnglish() {
        return english;
    }

    public String getGerman() {
        return german;
    }

    public String getPolish() {
        return polish;
    }

    public String toString(){
        return "english: " + english + " german: " + german + " polish: " + polish;
    }
}
