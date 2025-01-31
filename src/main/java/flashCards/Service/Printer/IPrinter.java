package flashCards.Service.Printer;

import flashCards.Model.IEntry;

import java.util.List;

public interface IPrinter {

    void printDictionary(List<IEntry> entries);
}
