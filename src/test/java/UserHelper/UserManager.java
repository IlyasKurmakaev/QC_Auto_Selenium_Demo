package UserHelper;

import FileManager.FileManager;

public class UserManager {
    public User getUserById(int id) {
        FileManager fileManager = new FileManager();
        String userName = fileManager.getUserName(id);
        String password = fileManager.getPassword(id);
        User userRes = new User(userName, password);
        return userRes;
    }
}
