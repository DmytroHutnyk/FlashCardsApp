package flashCards.Service;


import flashCards.Model.IEntry;

import java.util.List;

public interface IReadWriteService {

    List<IEntry> readFile(String filePath);
    void writeFile(String fileName, List<IEntry> data);
}

