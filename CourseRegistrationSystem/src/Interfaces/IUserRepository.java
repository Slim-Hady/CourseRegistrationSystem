package Interfaces;
import Entits.*;
public interface IUserRepository {
    boolean login(String username, String password);
    void adduser(User user);
    User getUserByID(int ID);
    User getUserByUsername(String username);
    void updateUser(User user);

    void deleteUser(int ID);

}
