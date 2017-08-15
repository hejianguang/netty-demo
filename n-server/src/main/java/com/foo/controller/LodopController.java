package com.foo.controller;

import com.foo.api.LodopApi;
import com.foo.service.LodopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by jianguang he on 2017/7/20.
 */
@Controller
public class LodopController implements LodopApi {

    @Autowired
    private LodopService lodopService;

    @ResponseBody
    public Map<String, String> getByModelId(String modelId){
        //assert
        return lodopService.getByModelId(modelId);
    }


    @ResponseBody
    public String insert(String modelId, String lodopCode, String modelUniqueStr){
        //assert
        lodopService.insert(modelId, lodopCode, modelUniqueStr);
        return "1";
    }


    @ResponseBody
    public String deleteByModelId(String modelId){
        //assert
        lodopService.deleteByModelId(modelId);
        return "1";
    }

}
