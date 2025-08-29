public interface IUserRepository {
    boolean login(String username, String password);
    void adduser(User user);
    User getUserByID(int ID);
    User getUserByUsername(String username);


}
