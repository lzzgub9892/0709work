package com.woniu.po;

import java.io.Serializable;

public class Goods implements Serializable{
	private int gid;
	private String gname;
	private int tid;
	private String gimg;
	private double gprice;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getGimg() {
		return gimg;
	}
	public void setGimg(String gimg) {
		this.gimg = gimg;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", tid=" + tid + ", gimg=" + gimg + ", gprice=" + gprice
				+ "]";
	}
	public Goods(int gid, String gname, int tid, String gimg, double gprice) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.tid = tid;
		this.gimg = gimg;
		this.gprice = gprice;
	}
	public Goods() {
		super();
	}
	
}
