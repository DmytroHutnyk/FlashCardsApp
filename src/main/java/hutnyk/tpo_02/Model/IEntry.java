package hutnyk.tpo_02.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IEntry {
    Map<String, String> getTranslations();
    void setTranslations(String english, String german, String polish);
    String getEnglish();
    String getGerman();
    String getPolish();
}
