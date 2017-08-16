package com.foo.service;

import com.foo.annotions.MyAction;
import org.springframework.stereotype.Service;

/**
 *
 * aop 练习测试
 * Created by jianguang he on 2017/8/15.
 */
@Service
public class AspectService {

    @MyAction
    public String aspectTest(String params){
        System.out.print("你好: params:" + params);
        return "你好";
    }
}
