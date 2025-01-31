package flashCards.Repository;

import flashCards.Model.IEntry;

public interface IEntryRepository {
    String addWord(IEntry entry, boolean override);
    void displayDictionary();
    IEntry generateQuiz();
    boolean isBasic();
}
