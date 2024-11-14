package hutnyk.tpo_02.Repository;

import hutnyk.tpo_02.Model.IEntry;

import java.util.Map;

public interface IEntryRepository {
    String addWord(IEntry entry, boolean override);
    void displayDictionary();
    IEntry generateQuiz();
    boolean isBasic();
}
