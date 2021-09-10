package com.janwes.rpc.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import proto.helloworld.GreeterGrpc;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.rpc.config
 * @date 2021/9/10 16:03
 * @description
 */
@Configuration
public class GrpcServiceConfig {

    @Bean
    public ManagedChannel getChannel() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();
        return channel;
    }

    @Bean
    public GreeterGrpc.GreeterBlockingStub getStub(ManagedChannel channel) {
        return GreeterGrpc.newBlockingStub(channel);
    }
}
