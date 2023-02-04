package com.zpb.grpc.config;

import com.zpb.grpc.proto.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pengbo.zhao
 * @version 1.0
 * @description grpc-config
 * @createDate 2021/12/14 20:13
 * @updateDate 2021/12/14 20:13
 */
@Configuration
public class GrpcConfig {

    private static final Integer GRPC_PORT = 8888;

    @Bean
    public ManagedChannel userGrpcManagedChannel() {
        return ManagedChannelBuilder.forAddress("127.0.0.1", GRPC_PORT).usePlaintext().build();
    }

    @Bean
    public UserServiceGrpc.UserServiceBlockingStub userServiceGrpc() {

        // 创建 ManagedChannel 对象
        ManagedChannel userGrpcManagedChannel = this.userGrpcManagedChannel();

        // 创建 UserServiceGrpc 对象
        return UserServiceGrpc.newBlockingStub(userGrpcManagedChannel);

    }

}
