package com.janwes.rpc;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.rpc
 * @date 2021/9/10 15:21
 * @description
 */
@Slf4j
@Component
public class ServiceManager {

    private Server server;
    private static final int GRPC_SERVER_PORT = 9091;

    public void loadService(Map<String, Object> grpcServiceBeanMap) throws IOException, InterruptedException {
        ServerBuilder serverBuilder = ServerBuilder.forPort(GRPC_SERVER_PORT);
        // 采用注解扫描方式，添加服务
        for (Object bean : grpcServiceBeanMap.values()) {
            serverBuilder.addService((BindableService) bean);
            log.info(bean.getClass().getSimpleName() + " is registry in Spring Boot！");

        }
        server = serverBuilder.build().start();

        log.info("grpc server is started at " + GRPC_SERVER_PORT);

        // 增加一个钩子，当JVM进程退出时，Server 关闭
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                log.info("*** shutting down gRPC server since JVM is shutting down");
                if (server != null) {
                    server.shutdown();
                }
                log.info("*** server shutdown！！！！");
            }
        });
        server.awaitTermination();
    }
}
