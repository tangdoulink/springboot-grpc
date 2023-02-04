package com.zpb.grpc.config;

import com.zpb.grpc.proto.UserServiceGrpc;
import com.zpb.grpc.service.impl.UserServiceGrpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author pengbo.zhao
 * @version 1.0
 * @description grpc-config
 * @createDate 2021/12/14 18:13
 * @updateDate 2021/12/14 18:13
 */
@Slf4j
@Configuration
public class GrpcConfig {

    private static final Integer GRPC_PORT = 8888;

    @Bean
    public Server grpcServer(final UserServiceGrpcImpl userServiceGrpc) throws IOException {
        // 创建 gRPC Server 对象
        Server server = ServerBuilder.forPort(GRPC_PORT)
                .addService(userServiceGrpc)
                .build();
        // 启动 gRPC Server
        server.start();
        log.info("#################################");
        log.info("[ grpcServer 启动完成，端口为: {} ]", server.getPort());
        log.info("#################################");
        return server;
    }

}
