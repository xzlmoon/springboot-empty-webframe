package com.xzl.framework.web.springboot.common.result;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by Xuezl on 2018/1/25.
 */
public class MapResult extends  JsonResult {

    public static MapResult MAP_SUCCESS = new MapResult();

    public MapResult(){
        super(new HashMap<String, Object>());
    }

    public MapResult addResult(String key, Object value){
        ((Map)data).put(key,value);
        return  this;
    }
}
