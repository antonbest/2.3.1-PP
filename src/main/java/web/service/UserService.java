package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

   public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(Integer id);
    public User getUserById(Integer id);
    public List<User> getAll();

}
