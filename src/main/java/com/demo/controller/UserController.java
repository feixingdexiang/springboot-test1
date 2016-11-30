package com.demo.controller;

import com.demo.entity.UserInfo;
import com.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Neal.Chen on 2016/11/9.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("getuser")
    public Object getUser(int id)
    {
        return userService.getUser(id);
    }

    @RequestMapping("getusersbyrole")
    @ResponseBody
    public ResponseEntity<?> getUsers(String role)
    {
        return new ResponseEntity<>(userService.getusersByRole(role), HttpStatus.OK);

    }

    @RequestMapping("adduser")
    public Object addUser(@RequestBody UserInfo userEntity)
    {
        return userService.adduser(userEntity);
    }

    @RequestMapping("updateuser")
    public Object updateUser(@RequestBody UserInfo userEntity)
    {
        return userService.updateUser(userEntity);
    }

    @RequestMapping("deleteuser")
    public Object deleteUser(int id)
    {
        return userService.deleteUser(id);
    }
}
