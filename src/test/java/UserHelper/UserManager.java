package UserHelper;

import DateBaseHelper.DataBaseManager;

public class UserManager {
    public User getUserById(int id) {
        DataBaseManager dbManager = new DataBaseManager();
        String userName = dbManager.getUserName(id);
        String password = dbManager.getPassword(id);
        User userRes = new User(userName, password);
        return userRes;
    }
}
