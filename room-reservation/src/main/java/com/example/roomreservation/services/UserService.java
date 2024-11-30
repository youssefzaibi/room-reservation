package com.example.roomreservation.services;

import com.example.roomreservation.models.User;
import com.example.roomreservation.models.UserRole;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    UserRole saveUserRole (UserRole userRole);
    void addUserRoleToUser(String userName, String userRoleName);
    User getUser(String UserName);
    List<User> getUsers();
}