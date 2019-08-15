package com.zhiyou.utils;

import java.io.Serializable;

public class VideoResult implements Serializable{
	private static final long serialVersionUID = 1L;
	//响应业务状态
	private Integer status;
	//响应消息
	private String msg;
	//响应中的数据
	private Object data;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public VideoResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoResult(Integer status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
}
