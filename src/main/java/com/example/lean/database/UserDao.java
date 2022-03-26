package com.example.lean.database;


import com.example.lean.database.User;

public interface UserDao {

    /**
     * 插入User
     * @param user
     * @return
     */
    public int insertUser(User user);
}
