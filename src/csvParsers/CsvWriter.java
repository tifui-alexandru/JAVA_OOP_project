package csvParsers;

public class CsvWriter {
    private static CsvWriter stingleInstance = null;

    public static CsvWriter getInstance() {
        if (stingleInstance == null)
            stingleInstance = new CsvWriter();
        return stingleInstance;
    }
}
