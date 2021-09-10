package com.janwes.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.rpc
 * @date 2021/9/10 16:04
 * @description
 */
@SpringBootApplication
public class GrpcClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }
}
