package com.woniu.po;

import java.io.Serializable;

public class Type implements Serializable{
	private int tid;
	private String tname;
	private String tdesc;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTdesc() {
		return tdesc;
	}
	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}
	@Override
	public String toString() {
		return "Type [tid=" + tid + ", tname=" + tname + ", tdesc=" + tdesc + "]";
	}
	public Type(int tid, String tname, String tdesc) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tdesc = tdesc;
	}
	public Type() {
		super();
	}
	
}
