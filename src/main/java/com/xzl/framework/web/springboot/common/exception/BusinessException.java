package com.xzl.framework.web.springboot.common.exception;

/**
 * Created by Xuezl on 2018/1/25.
 */
public class BusinessException extends  RuntimeException  {
	public BusinessException(String msg){
		super(msg);  
	}

}

