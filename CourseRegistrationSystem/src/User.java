public class User {
      protected String username;
      protected String password;
      protected int ID;
      protected String role;

    public User() {}
    public User(int id, String username, String password , String role) {
        this.ID = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
      public String getUsername() {
        return username;
      }

      public void setUsername(String username) {
        this.username = username;
      }

      public String getPassword() {
        return password;
      }

      public void setPassword(String password) {
        this.password = password;
      }

      public int getID() {
        return ID;
      }

      public void setID(int ID) {
        this.ID = ID;
      }

      public String getRole(){ return role;}

      public void setRole(String role){this.role = role;}
    @Override
    public String toString() {
        return "User{id=" + ID + ", username='" + username + ", role=" + role + "}";
    }
}
