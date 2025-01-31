package flashCards.Service.Printer;

import flashCards.Model.BasicEntry;

import java.util.List;

public interface IPrinter {

    void printDictionary(List<BasicEntry> entries);
}
