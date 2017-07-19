package com.foo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jianguang he on 2017/7/19.
 */
@Controller
@RequestMapping("client")
public class ClientPageController {

    @RequestMapping("websocket")
    public ModelAndView page(){
        return new ModelAndView("index");
    }
}
