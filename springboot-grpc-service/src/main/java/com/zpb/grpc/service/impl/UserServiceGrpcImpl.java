package com.zpb.grpc.service.impl;

import com.zpb.grpc.proto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

/**
 * @author pengbo.zhao
 * @version 1.0
 * @description grpc-实现类
 * @createDate 2021/12/14 18:10
 * @updateDate 2021/12/14 18:10
 */
@Service
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void get(UserGetRequest request, StreamObserver<UserGetResponse> responseObserver) {
        // 创建响应对象
        UserGetResponse.Builder builder = UserGetResponse.newBuilder();
        builder.setId(request.getId())
                .setName("没有昵称: " + request.getId())
                .setGender(request.getId() % 2 + 1);
        // 返回响应
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void create(UserCreateRequest request, StreamObserver<UserCreateResponse> responseObserver) {
        // 创建响应对象
        UserCreateResponse.Builder builder = UserCreateResponse.newBuilder();
        builder.setId((int) (System.currentTimeMillis() / 1000));
        // 返回响应
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

}
