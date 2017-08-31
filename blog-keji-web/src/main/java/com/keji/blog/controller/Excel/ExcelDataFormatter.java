package com.keji.blog.controller.Excel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wb-ny291824 on 2017/8/30.
 */
public class ExcelDataFormatter {
    private Map<String,Map<String,String>> formatter=new HashMap<String, Map<String,String>>();

    public void set(String key,Map<String,String> map){
        formatter.put(key, map);
    }

    public Map<String,String> get(String key){
        return formatter.get(key);
    }
}
