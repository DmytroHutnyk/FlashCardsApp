package flashCards.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IEntry {

    Map<String, String> getTranslations();

    void setTranslations(Map<String, String> translations);

    boolean isBasic();

    String getEnglish();

}
