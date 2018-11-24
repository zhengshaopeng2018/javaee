package com.Ben.dao;

import com.Ben.domain.User;
import com.Ben.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public void add(User user) {
        JdbcTemplate jdbc = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = " insert into user values(null,?,?,?)";
        String[] eles = {user.getCname(),user.getCsource(),user.getCaddress()};
        jdbc.update(sql, eles);
    }
}
