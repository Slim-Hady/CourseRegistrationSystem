public interface IUserRepository {
    User findById(String id);
    void save(User user);
    void delete(String id);
}
