package com.demo.utils;

public class ResultMsg {
	private int errcode;
	private String errmsg;
	private Object result;
	
	public ResultMsg(int ErrCode, String ErrMsg, Object result)
	{
		this.errcode = ErrCode;
		this.errmsg = ErrMsg;
		this.result = result;
	}
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public Object getresult() {
		return result;
	}
	public void setresult(Object result) {
		this.result = result;
	}
}
