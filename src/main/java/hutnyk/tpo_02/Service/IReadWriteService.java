package hutnyk.tpo_02.Service;


import hutnyk.tpo_02.Model.IEntry;

import java.util.List;

public interface IReadWriteService {

    List<IEntry> readFile(String filePath);
    void writeFile(String fileName, List<IEntry> data);
}

