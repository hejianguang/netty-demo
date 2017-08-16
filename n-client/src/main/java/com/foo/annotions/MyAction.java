package com.foo.annotions;

import java.lang.annotation.*;

/**
 * Created by jianguang he on 2017/8/15.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAction {

    String name() default "hejianguang";
}
