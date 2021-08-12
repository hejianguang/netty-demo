package com.netty.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author: he
 * @date: 2019/4/29
 */
@ExtendWith(TimingExtension.class)
@DisplayName("初始化测试")
public class InitTest {

    private static final Logger logger = Logger.getLogger(InitTest.class.getName());

    @RepeatedTest(30)
    @DisplayName("系统测试")
    public void sys() throws Exception{
        //junit 断言
        Assertions.assertEquals("1", "1");
        //assertj流式断言
        org.assertj.core.api.Assertions.assertThat("abc").as("字符串各种判断").contains("a").startsWith("s");
    }


    @ParameterizedTest
    @DisplayName("参数测试")
    @CsvSource({"0,1,1", "3,4,9"})
    public void paramTest(int a, int b, int c){
        logger.info("a:"+ a +";b:"+ b);
        Assertions.assertEquals(c, a+b);
    }


    private int test1(int n){
        if (n == 0){
            return 0;
        }
        n--;
//        System.out.println(n);
        return test1(n);
    }

    @Test
    public void test(){
        test1(90000);
    }

    @Test
    public void test11(){
        List<Long> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i=1; i< 9000; i++){
//            System.out.println(i);
        }
    }
}
