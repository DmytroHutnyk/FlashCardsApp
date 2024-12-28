package hutnyk.tpo_02.Service.Printer;

import hutnyk.tpo_02.Model.BasicEntry;
import hutnyk.tpo_02.Model.IEntry;

import java.util.Base64;
import java.util.List;

public interface IPrinter {

    void printDictionary(List<BasicEntry> entries);
}
