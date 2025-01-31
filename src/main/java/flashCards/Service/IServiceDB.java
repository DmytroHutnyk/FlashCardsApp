package flashCards.Service;

import flashCards.Model.IEntry;

public interface IServiceDB {

   String addEntry(IEntry entry, boolean override);
   void displayDictionary();
   String deleteEntry(String english);
   String updateEntry(IEntry english, String beforeModification);
   boolean isPresent(String english);
   IEntry generateQuiz();
}
