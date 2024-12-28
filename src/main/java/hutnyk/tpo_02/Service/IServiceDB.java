package hutnyk.tpo_02.Service;

import hutnyk.tpo_02.Model.BasicEntry;
import hutnyk.tpo_02.Model.IEntry;

public interface IServiceDB {

   String addEntry(IEntry entry, boolean override);
   void displayDictionary();
   String deleteEntry(String english);
   String updateEntry(IEntry english, String beforeModification);
   boolean isPresent(String english);
   BasicEntry generateQuiz();
}
