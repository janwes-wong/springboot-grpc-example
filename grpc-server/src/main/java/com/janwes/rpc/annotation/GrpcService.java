package com.janwes.rpc.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.rpc.annotation
 * @date 2021/9/10 14:38
 * @description
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface GrpcService {
}
