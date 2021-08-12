package com.foo.service;

import com.foo.A;
import com.foo.PersonProto;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author hejianguang
 * @version 1.0
 * @title
 * @description
 * @date 2021/5/11 6:38 下午
 * @copyright Copyright (c) 2014  ALL RIGHTS RESERVED.
 * @company 北京凯声文化传媒有限责任公司
 */
public class TestProto {

    public static void main(String[] args) {

        PersonProto.Person person = PersonProto.Person.newBuilder().setId(1).setName("张三").build();

        //序列化(通过protobuf生成的java类的内部方法进行序列化)
        byte[] bytes = person.toByteArray();

//反序列化(通过protobuf生成的java类的内部方法进行反序列化)
        try {
            PersonProto.Person parseFrom = PersonProto.Person.parseFrom(bytes);
            System.out.println(parseFrom.getName());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }


        String str = "abcdefj89";
        System.out.println(strReverseWithArray(str));
    }




    public static String strReverseWithArray(String string) {
        if (string == null || string.length() == 0) return string;

        char[] array = string.toCharArray();
        for(int i = 0, j = string.length() - 1; i < j; i++, j--){
            //异或运算交换元素
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
        }
        return new String(array);
    }
}
