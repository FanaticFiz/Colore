package com.example.test1;

public class XmlVidKvest
{
	String	vid;
	String	kvest;
	
	Integer nomerUrov;
	Integer kolvoHodov;
	

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
	
	// Здесь мы проверяем на выполнения условия поставленного на уровне
	// вид поставленной цели: ХОДЫ (отрицательное число) или ВРЕМЯ (положительное).
	public Boolean kvest_TEST(int cel, int time, int kolvoHodov)
	{
		Boolean b=true;
		if (kvest.equals("0")) {
			
		}else {
			if (cel > 0) {
			//  Цель ВРЕМЯ
				b = false;	
			}else {
			// 	Цель ХОДЫ
				if (kolvoHodov == Math.abs(cel)) {
					b = true;
				}else {
					b = false;
				}
			}
		}
		return b;
	}
}
