package UserHelper;

import FileManager.FileManager;

public class UserManager {
    private static UserManager userManager;
    private static int shift = 0;
    public static UserManager getInstance() { // ленивая инициализация
        if (userManager == null) {
            userManager = new UserManager();
            return userManager;
        } else {
            return userManager;
        }
    }

    public void refreshInstance() {
        shift = 0;
    }


    private final int INDEX_OF_USER_ID = 1;
    private final int INDEX_OF_PASSWORD = 2;
    private final int SHIFT_ALL_FIELDS = 3; // в пользователе 3 значения(id, userName, password), чтобы достичь следующего нужно сделать сдвиг на 3 позиции

    public User getNextUser(int id) {
        String[] clientsFieldById = FileManager.getInstance().getClientsFieldById(id);
        if (INDEX_OF_PASSWORD + shift - 1 >= clientsFieldById.length) {
            new RuntimeException("Следующий клиент отсутствует");
        }
        User user = new User(clientsFieldById[INDEX_OF_USER_ID + shift], clientsFieldById[INDEX_OF_PASSWORD + shift]);
        shift += SHIFT_ALL_FIELDS;
        return user;
    }
}
