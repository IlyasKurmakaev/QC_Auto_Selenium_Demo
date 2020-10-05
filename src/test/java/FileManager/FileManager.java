package FileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileManager {
    private final String filePath = "./src/test/resources/IdClientBase.txt";

    public String getUserName(int id) {
        return clientFields(id).get(UserFields.USER_NAME);
    }

    public String getPassword(int id) {
        return clientFields(id).get(UserFields.PASSWORD);
    }

    private Map<UserFields, String> clientFields(int id) {
        Map<UserFields, String> res = new HashMap<UserFields, String>();
        FileReader fr= null;
        try {
            fr = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            new RuntimeException("Файл \"" + filePath + "\" не найден");
        }
        Scanner scan = new Scanner(fr);
        String tempStr;
        String[] arrStr;
        while (scan.hasNextLine()) {
            tempStr = scan.nextLine();
            arrStr = tempStr.split(" ");
            if (Integer.parseInt(arrStr[0]) == id) {
                res.put(UserFields.USER_NAME, arrStr[1]);
                res.put(UserFields.PASSWORD, arrStr[2]);
            }
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    private enum UserFields {
        USER_NAME,
        PASSWORD
    }
}
