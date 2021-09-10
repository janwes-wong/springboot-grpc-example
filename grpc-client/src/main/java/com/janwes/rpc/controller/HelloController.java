package com.janwes.rpc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proto.helloworld.GreeterGrpc;
import proto.helloworld.HelloReply;
import proto.helloworld.HelloRequest;

import javax.annotation.Resource;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.rpc.controller
 * @date 2021/9/10 16:09
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    /**
     * http://localhost:2510/hello/sayHello
     */
    @RequestMapping("/sayHello")
    public String sayHello() {
        HelloRequest request = HelloRequest.newBuilder()
                .setName("my name is LiLei")
                .build();
        HelloReply helloReply = greeterBlockingStub.sayHello(request);
        log.info(">>> receive message:{}", helloReply.getMessage());
        return helloReply.getMessage();
    }
}
