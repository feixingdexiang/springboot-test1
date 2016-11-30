package com.demo.service.impl;

import com.demo.dao.IUserDao;
import com.demo.entity.UserInfo;
import com.demo.service.IUserService;
import com.demo.utils.ResultMsg;
import com.demo.utils.ResultStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neal.Chen on 2016/11/9.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userdao;

    @Override
    @Modifying
    public ResultMsg adduser(UserInfo userEntity) {
        ResultMsg resultMsg;
        try {
            userdao.save(userEntity);
            resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), userEntity);
        } catch (Exception e) {
            resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(), ResultStatusCode.SYSTEM_ERR.getErrmsg(), userEntity);
        }
        return resultMsg;
    }

    @Override
    public ResultMsg getUser(int id) {
        ResultMsg resultMsg;
        try {
            UserInfo userEntity = userdao.findUserInfoById(id);
             resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), userEntity);
        } catch (Exception e) {
            resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(), ResultStatusCode.SYSTEM_ERR.getErrmsg(), null);
        }
        return resultMsg;
    }

    @Override
    @Modifying
    public ResultMsg updateUser(UserInfo userEntity) {
        ResultMsg resultMsg;
        try {
            UserInfo user = userdao.findUserInfoById(userEntity.getId());
            if (user != null)
            {
                user.setName(userEntity.getName());
                userdao.save(user);
                resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), null);
            }else {
                resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(), ResultStatusCode.SYSTEM_ERR.getErrmsg(), null);
            }

        } catch (Exception e) {
            resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(), ResultStatusCode.SYSTEM_ERR.getErrmsg(), null);
        }
        return resultMsg;
    }

    @Override
    @Modifying
    public ResultMsg deleteUser(int id) {
        ResultMsg resultMsg;
        try {
            userdao.delete((long) id);
            resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), null);
        } catch (Exception e) {
            resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(), ResultStatusCode.SYSTEM_ERR.getErrmsg(), null);
        }
        return resultMsg;
    }

    @Override
    public ResultMsg getusersByRole(String role) {
        ResultMsg resultMsg;
        try {
            List<UserInfo> userEntities = userdao.findUserInfoByRole(role);
            resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), userEntities);
        } catch (Exception e) {
            resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(), ResultStatusCode.SYSTEM_ERR.getErrmsg(), null);
        }
        return resultMsg;
    }
}
