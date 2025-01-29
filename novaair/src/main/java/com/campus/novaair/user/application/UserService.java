package com.campus.novaair.user.application;

import com.campus.novaair.role.domain.Role;
import com.campus.novaair.user.domain.User;
import java.util.List;

public interface UserService {
   List<User> getAllUser();
   User getUserById(Long id);
   User saveUser(User user);
   void deleteUser(Long id);
    
}
