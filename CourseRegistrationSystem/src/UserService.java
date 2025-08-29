public class UserService {
    private IUserRepository  UserRepo;

    public UserService(IUserRepository  userRepo) {
        this.UserRepo = userRepo;
    }
    public boolean LogIn(String name , String password){
            return UserRepo.login(name , password);
    }
    public void registerUser(User user) {
        if (user.getUsername() == null || user.getUsername().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty() ||
                user.getRole() == null || user.getRole().isEmpty()) {
            System.out.println("Fields cannot be empty");
            return;
        }

        if (UserRepo.getUserByID(user.getID()) != null) {
            System.out.println("User ID already exists");
            return;
        }

        if (UserRepo.getUserByUsername(user.getUsername()) != null) {
            System.out.println("Username already exists");
            return;
        }

        UserRepo.adduser(user);
    }

    public User FindUser(int id){
        return UserRepo.getUserByID(id);
    }
}
