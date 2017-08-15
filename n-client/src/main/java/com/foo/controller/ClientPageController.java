package com.foo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.foo.api.LodopApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by jianguang he on 2017/7/19.
 */
@Controller
public class ClientPageController{

    @Autowired
    private LodopApi lodopApi;

    @RequestMapping("websocket")
    public ModelAndView page(){
        return new ModelAndView("index");
    }


    @RequestMapping("lodop")
    public ModelAndView lodop(){
        return new ModelAndView("lodop");
    }

    @RequestMapping("getByModelId")
    public String get(String modelId, Model model){
//        Map<String, String> result = lodopApi.getByModelId(modelId);
        String json = "{\n" +
                "    \"str\": \"@J0yHEH1QG1IBIS0APyMOGSISCGHAPt0XJ1OFGyECHS0APxyHEH1DLJ5yoSODIRj9ZN0XFIESGGR9AwHAPxyHEH0lCGRmAD0XFIESGGZ9AQHAPxyHEH00CGVlQDcWIRIAAG00ZN0XQDcoHSWBGRITIS0APxyHEH1DLJ5yoSODIRj9ZN0XFIESGGR9ZGR4QDcWIRIAZw0kZwNAPxyHEH0mCGpkQDcWIRIAAQ0lZwxAPxyHEH01CGVmAN0XQDcoHSWBI0yRIRuqQDcWIRIAHTShMJkDHSEZCGtjZN0XFIESGGR9ZGNjQDcWIRIAZw0kZQNAPxyHEH0mCGDkAt0XFIESGGD9ZGNjQDcWIRIAAG0kZQNAPt0XJ1OFGxuSFHqVIS0APxyHEH1DLJ5yoSODIRj9AwNjQDcWIRIAZG0lZN0XFIESGGV9ZwNAPxyHEH0mCGR3Zj0XFIESGGD9AwNAPxyHEH01CGVjQDbAPyguoTyaoz1yoaEqQDcWIRIAAG0lQDbAPygDHx5DEH5QG0kCHy0APxyHEH00CGR2AmD0AmNmQDbAPygDHx5DEH5KFHEHFS0APxyHEH0mCGRAPxyHEH00CGRAPt0XJ1OFGyAVDIOSISyDEI0APxyHEH0mCGVAPxyHEH00CGHAPt0XJ0AZDIAGFH5REIuqQDcWIRIAZG0lQDcWIRIAZw0lQDcWIRIAZm0mQDcWIRIAAQ0mQDcWIRIAAG0lQDbAPygQo250MJ50KD0XFIESGIOuozIfHSOHGQ02FmLeAxf2nQIkDmZ1GQMZQDcWIRIAZG01AIZkAxfeMN0XFIESGGV9AIc5qmInZxRAPxyHEH01CGIvX3V2JHAGAIxlIwIiZaHAPt0XJ2y0MJ1hLJ1yKD0XFIESGGR9qTIfQDcWIRIAZw1uMTElMKAmQDbAPygGqUyfMH5uoJImp10APxyHEH0kCJy0MJ1hLJ1yBj0XFIESGGV9nKEyoJ5uoJH7QDcWIRIAAG1uoTyaoz1yoaD7QDcoFIESGHIBES0APt==\\n\",\n" +
                "    \"code\": \"LODOP.PRINT_INIT(\\\"设计样例\\\");\\nLODOP.ADD_PRINT_TEXTA(\\\"tel\\\",65,118,100,20,\\\"电话\\\");\\nLODOP.ADD_PRINT_TEXTA(\\\"address\\\",135,120,100,20,\\\"地址\\\");\\nLODOP.ADD_PRINT_RECT(45,71,416,173,0,1);\\nLODOP.ADD_PRINT_SHAPE(5,22,229,100,60,0,1,\\\"#FF80FF\\\");\\nLODOP.ADD_PRINT_TEXT(40,234,100,20,\\\"快递单据\\\");\\nLODOP.SET_PRINT_STYLEA(0,\\\"Alignment\\\",2);\",\n" +
                "    \"address\": \"地址\",\n" +
                "    \"tel\": \"电话\"\n" +
                "}";

        Map<String, Object> map = JSON.parseObject(
                json,new TypeReference<Map<String, Object>>(){} );
        model.addAttribute("data", map);
        String sss = (String) map.get("str");
        return "lodop";
    }
}
