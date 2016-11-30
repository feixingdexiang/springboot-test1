package com.demo.dao;

import com.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Neal.Chen on 2016/11/9.
 */
public interface IUserDao extends CrudRepository<UserInfo, Long> {
    UserInfo findUserInfoById(int id);
    List<UserInfo> findUserInfoByRole(String role);

}
