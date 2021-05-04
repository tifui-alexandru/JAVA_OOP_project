package csvParsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvReader {
    private static CsvReader stingleInstance = null;

    public static CsvReader getInstance() {
        if (stingleInstance == null)
            stingleInstance = new CsvReader();
        return stingleInstance;
    }

    public List<List<String>> readData(String path) throws FileNotFoundException {
        List<List<String>> retVal = new ArrayList<>();
        Scanner sc = new Scanner(new File(path));

        while (sc.hasNext()) {
            String line = sc.nextLine();
            List <String> listLine = Arrays.asList(line.split(", "));
            retVal.add(listLine);
        }

        sc.close();
        return retVal;
    }
}
