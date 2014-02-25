package com.example.test1;

public class XmlVidKvest
{
	String	vid;
	String	kvest;

	public XmlVidKvest()	{
		super();
		vid 	= "1";
		kvest 	= "0";
	}

	public void setKvest(String kvest)	{
		this.kvest = kvest;
	}

	public void setVid(String vid)	{
		this.vid = vid;
	}

	
	public Integer getKvest()	{
		return Integer.parseInt(kvest);
	}

	public Integer getVid()	{
		return Integer.parseInt(vid);
	}
		
}
