package com.xzl.framework.web.springboot.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Xuezl on 2017/11/22.
 */
public class ExceptionUtil {

    public static String getMessage(Exception e){
        StringWriter out = new StringWriter();
        e.printStackTrace(new PrintWriter(out));
        return out.toString();
    }
}
