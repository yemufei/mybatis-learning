package com.example.lean.database;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 通过userid查询
     * @param userid
     * @return
     */
     User queryUserByUserid(String userid);

    /**
     * 通过username查询
     * @param username
     * @return
     */
    User queryUserByUsername(String username);
}
