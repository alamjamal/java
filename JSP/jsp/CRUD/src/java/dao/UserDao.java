
package dao;

import bean.UserBean;
import java.util.List;

public interface UserDao {
    public void addUser(UserBean userBean);
    public void removeUser(int userId);
    public void updateUser(UserBean userBean);
    public List<UserBean> getAllUsers();
    public UserBean getUserById(int userId);
    
    
    
    
}
