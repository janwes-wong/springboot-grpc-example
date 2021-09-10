package com.janwes.rpc.service;

import com.janwes.rpc.annotation.GrpcService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import proto.helloworld.GreeterGrpc;
import proto.helloworld.HelloReply;
import proto.helloworld.HelloRequest;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.rpc.service
 * @date 2021/9/10 15:04
 * @description
 */
@Slf4j
@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        log.info(">>> GreeterService receive param,name：" + request.getName());
        HelloReply helloReply = HelloReply.newBuilder().setMessage("who are you").build();
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }
}
