package com.foo.controller;

import com.foo.PersonProto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hejianguang
 * @version 1.0
 * @title
 * @description
 * @date 2021/5/12 10:41 上午
 * @copyright Copyright (c) 2014  ALL RIGHTS RESERVED.
 * @company 北京凯声文化传媒有限责任公司
 */


@RestController
public class TestController {


    @PostMapping(produces = "application/x-protobuf")
    public String testRequest(@RequestBody PersonProto personProto) {

        return "";
    }
}
