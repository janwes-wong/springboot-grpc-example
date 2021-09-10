package com.janwes.rpc;

import com.janwes.rpc.annotation.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Map;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.rpc
 * @date 2021/9/10 15:10
 * @description
 */
@SpringBootApplication
public class GrpcServerApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GrpcServerApplication.class, args);
        Map<String, Object> grpcServiceBeanMap = applicationContext.getBeansWithAnnotation(GrpcService.class);
        ServiceManager serviceManager = applicationContext.getBean(ServiceManager.class);
        serviceManager.loadService(grpcServiceBeanMap);
    }
}
