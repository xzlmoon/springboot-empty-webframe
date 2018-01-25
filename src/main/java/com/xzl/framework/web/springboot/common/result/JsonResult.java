package com.xzl.framework.web.springboot.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Xuezl on 2018/1/25.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class JsonResult<T> implements Serializable {

    @ApiModelProperty(value="状态码，200是成功")
    private Integer code = 200;
    @ApiModelProperty(value="返回消息")
    private String message = "操作成功！";
    private String forwardUrl;
    @ApiModelProperty(value="分页数据总数")
    private Long total;
    @ApiModelProperty(value="返回数据")
    protected   T data;


    public static final Integer CODE_SUCCESS = 200;

    public static final Integer CODE_ERROR= 500;



    public static JsonResult NO_DATA_ERROR = new JsonResult(500, "操作失败!");
    public static JsonResult NO_DATA_SUCCESS = new JsonResult(200,"操作成功！");
    public static JsonResult INVOKE_TIMEOUT = new JsonResult(9999,"调用服务超时！");


    public JsonResult(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public JsonResult(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public JsonResult(Integer code,String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult(T data) {
        super();
        this.data = data;
    }

    public JsonResult() {
        super();
    }

    public JsonResult(Long total, T data) {
        this.total = total;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData( T data) {
        this.data = data;
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public JsonResult<T> addTotal(Long total){
        this.total = total;
        return this;
    }

    public JsonResult<T>  forward(String url){
        this.forwardUrl = url;
        return this;
    }
}