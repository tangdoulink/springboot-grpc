package com.zpb.grpc.controller;

import com.zpb.grpc.proto.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author pengbo.zhao
 * @version 1.0
 * @description index-controller
 * @createDate 2021/12/14 20:16
 * @updateDate 2021/12/14 20:16
 */
@RestController
@RequestMapping("index")
public class IndexController {

    @Resource
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @GetMapping("get")
    public String get(@RequestParam("id") Integer id){
        UserGetRequest userGetRequest = UserGetRequest.newBuilder().setId(id).build();
        UserGetResponse userGetResponse = userServiceBlockingStub.get(userGetRequest);
        return userGetResponse.getName();
    }

    @PostMapping("create")
    public Integer create(@RequestParam("name") String name, @RequestParam("gender") Integer gender) {
        UserCreateRequest userCreateRequest = UserCreateRequest.newBuilder()
                .setGender(gender).setName(name).build();

        UserCreateResponse userCreateResponse = userServiceBlockingStub.create(userCreateRequest);
        return userCreateResponse.getId();
    }


}
