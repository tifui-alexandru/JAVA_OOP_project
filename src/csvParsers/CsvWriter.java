package csvParsers;

import java.io.*;
import java.util.List;

import static service.Main.reader;

public class CsvWriter {
    private static CsvWriter stingleInstance = null;

    public static CsvWriter getInstance() {
        if (stingleInstance == null)
            stingleInstance = new CsvWriter();
        return stingleInstance;
    }

    public void writeData(String path, List<String> newData) throws IOException {
        var currData = reader.readData(path);
        currData.add(newData);

        FileWriter csvWriter = new FileWriter(path);

        for (var row : newData) {
            csvWriter.append(String.join(", ", row));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
