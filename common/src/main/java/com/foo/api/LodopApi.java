package com.foo.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by jianguang he on 2017/7/21.
 */
@FeignClient(value = "lodop")
public interface LodopApi {

    @RequestMapping("getByModelId")
    Map<String, String> getByModelId(String modelId);

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    String insert(@RequestParam("modelId") String modelId,
                  @RequestParam("lodopCode") String lodopCode,
                  @RequestParam("modelUniqueStr") String modelUniqueStr);

    @RequestMapping("deleteByModelId")
    String deleteByModelId(String modelId);
}
