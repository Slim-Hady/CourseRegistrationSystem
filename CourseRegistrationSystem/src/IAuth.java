interface IAuth {
    User login(String username, String password, String id);
    boolean signup(String username, String password, String id, String email);
}