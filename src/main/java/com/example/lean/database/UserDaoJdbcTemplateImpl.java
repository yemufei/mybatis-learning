package com.example.lean.database;

import com.example.lean.database.User;
import com.example.lean.database.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserDaoJdbcTemplateImpl implements UserDao {

    //自动导入依赖的bean
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * 手动执行的示例
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
        String sql = "INSERT INTO t_user (userid, username, sex, age) VALUES (:userid, :username, :sex, :age)";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("userid", user.getUserId());
        param.put("username", user.getUserName());
        param.put("sex", user.getSex());
        param.put("age", user.getAge());

        return jdbcTemplate.update(sql, param);
    }
}
