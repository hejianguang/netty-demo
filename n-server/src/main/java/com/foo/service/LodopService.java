package com.foo.service;

import com.foo.api.LodopApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jianguang he on 2017/7/20.
 */
@Service
public class LodopService {

    private static Logger logger = LoggerFactory.getLogger(LodopService.class);

    private final static Map<String, Map<String, String>> lodopMap = new HashMap<>();


    public String insert(String modelId, String lodopCode, String modelUniqueStr){
        Map<String, String> map = new HashMap<>();
        map.put("str", modelUniqueStr);
        map.put("code", lodopCode);
        lodopMap.put(modelId, map);
        return "成功";
    }

    public Map<String, String> getByModelId(String modelId){
        Map<String, String> dataMap = lodopMap.get(modelId);
        if (dataMap == null){
            return null;
        }
        String code = dataMap.get("code");
        Pattern p = Pattern.compile("LODOP.ADD_PRINT_TEXTA(.*?);\\n");
        Matcher m = p.matcher(code);
        while (m.find()) {
            String pStr = m.group(1);
            String[] strs = pStr.split("\"");
            if (strs.length != 5){
                continue;
            }
            dataMap.put(strs[1], strs[3]);
        }
        return dataMap;
    }

    public String deleteByModelId(String modelId){
        Map<String, String> result = lodopMap.remove(modelId);
        if (StringUtils.isEmpty(result )){
            logger.info("delete failed of not saved element");
        }
        return "chenggong";
    }

//    public static void main(String[] args){
//        String code = "LODOP.PRINT_INIT(\"设计样例\");\n" +
//                "LODOP.ADD_PRINT_TEXTA(\"$aa$\",45,158,100,20,\"新加文本1\");\n" +
//                "LODOP.ADD_PRINT_TEXTA(\"$bb$\",92,154,100,20,\"新加文本2\");\n";
//
//        String str = "@J0yHEH1QG1IBIS0APyMOGSISCGVAPt0XJ1OFGyECHS0APxyHEH1DLJ5yoSODIRj9ZN0XFIESGGR9AQHAPxyHEH0lCGxlQDbAPygDHx5ZEHMHKD0XFIESGIOuozIfHSOHGQ0jQDcWIRIAZG0kAGtAPxyHEH0lCGR1AN0XQDcoHSWBI0yRIRuqQDcWIRIAHTShMJkDHSEZCGtjZN0XFIESGGR9ZGNjQDcWIRIAZw0kZQNAPt0XJ1OFGxuSFHqVIS0APxyHEH1DLJ5yoSODIRj9AwNjQDcWIRIAZG0lZN0XFIESGGV9ZwNAPt0XJ0AZDIAGFH5REIuqQDcWIRIAZG0lQDcWIRIAZw0lQDbAPygQo250MJ50KD0XFIESGIOuozIfHSOHGQ02FmLeAxf2nQIkDmZ1GQMZQDcWIRIAZG01pTS3AIykMmIjLHt1pUymGIR9CD0XFIESGGV9AKOuqmIMpJp1pTSVAKO5p01aCG0APt0XJ2y0MJ1hLJ1yKD0XFIESGGR9LJRAPxyHEH0lCJWvQDbAPygGqUyfMH5uoJImp10APxyHEH0kCJy0MJ1hLJ1yBj0XFIESGGV9nKEyoJ5uoJH7QDcoFIESGHIBES0APt==";
//
//        String regex = "LODOP.ADD_PRINT_TEXTA(.*?);\\\\n";
//        Pattern mPattern = Pattern.compile(regex);
//        Matcher mMatcher = mPattern.matcher(code);
//        while (mMatcher.find()) {
//            System.out.println(mMatcher.group(1));
//        }
//    }


    public static void main(String[] a) {
        //String str = "rrwerqq84461376qqasfdasdfrrwerqq84461377qqasfdasdaa654645aafrrwerqq84461378qqasfdaa654646aaasdfrrwerqq84461379qqasfdasdfrrwerqq84461376qqasfdasdf";
        String str ="LODOP.PRINT_INIT(\"设计样例\");\n" +
                "LODOP.ADD_PRINT_TEXTA(\"$aa$\",45,158,100,20,\"新加文本1\");\n" +
                "LODOP.ADD_PRINT_TEXTA(\"$bb$\",92,154,100,20,\"新加文本2\");\n";

        Pattern p = Pattern.compile("LODOP.ADD_PRINT_TEXTA(.*?);\\n");
        //Pattern p = Pattern.compile("qq(.*?)qq");
        Matcher m = p.matcher(str);
        ArrayList<String> strs = new ArrayList<String>();
        while (m.find()) {
            strs.add(m.group(1));
            String[] strss = m.group(1).split("\"");
            System.out.print(11);
        }
        for (String s : strs){
            System.out.println(s);
        }
    }
}
