package com.demo.service;

import com.demo.entity.UserInfo;
import com.demo.utils.ResultMsg;

/**
 * Created by Neal.Chen on 2016/11/9.
 */

public interface IUserService {
    /**
     * 新增用户
     * @param userEntity
     * @return
     */
    ResultMsg adduser(UserInfo userEntity);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    ResultMsg getUser(int id);

    /**
     * 更新用户信息
     * @param userEntity
     * @return
     */
    ResultMsg updateUser(UserInfo userEntity);

    /**
     * 删除用户
     * @param id
     * @return
     */
    ResultMsg deleteUser(int id);

    /**
     * 根据用户角色获取用户列表
     * @param role
     * @return
     */
    ResultMsg getusersByRole(String role);
}
