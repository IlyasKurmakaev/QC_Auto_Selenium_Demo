package FileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private FileManager(){};
    private final String filePath = "./src/test/resources/IdClientBase.txt";

    private static FileManager fileManager;

    public static FileManager getInstance() { // ленивая инициализация
        if (fileManager == null) {
            fileManager = new FileManager();
            return fileManager;
        } else {
            return fileManager;
        }
    }

    public String[] getClientsFieldById(int id) { // что-то вроде десереализатора
        FileReader fr= null;
        try {
            fr = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            new RuntimeException("Файл \"" + filePath + "\" не найден");
        }
        Scanner scan = new Scanner(fr);
        String tempStr;
        String[] arrStr = new String[0];

        while (scan.hasNextLine()) {
            tempStr = scan.nextLine();
            arrStr = tempStr.split(" ");
            if (Integer.parseInt(arrStr[0]) == id) {
                break;
            }
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (arrStr.length == 0 ) {
            new RuntimeException("Пользователем с id \"" + id + " не найден");
        }
        return arrStr;
    }
}
