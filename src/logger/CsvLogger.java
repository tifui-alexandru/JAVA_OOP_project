package logger;

import service.Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvLogger {
    private static CsvLogger stingleInstance = null;

    public static CsvLogger getInstance() {
        if (stingleInstance == null)
            stingleInstance = new CsvLogger();
        return stingleInstance;
    }

    public void logInfo(String action) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        List<String> data = new ArrayList<>();
        data.add(action);
        data.add(timeStamp);

        Main.writer.writeData("logger/logger.csv", data);
    }
}
