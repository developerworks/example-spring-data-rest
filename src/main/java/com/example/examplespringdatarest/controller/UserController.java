/**
 * https://stackoverflow.com/questions/27010315/how-to-use-spring-boot-rest-data-to-return-xml
 */
package com.example.examplespringdatarest.controller;

import com.example.examplespringdatarest.entity.User;
import com.example.examplespringdatarest.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "user", description = "用户资源管理")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/user1", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    @ResponseBody
    @ApiOperation(value="获取用户列表", notes="")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
