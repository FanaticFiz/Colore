package com.example.test1;

import java.util.ArrayList;
import java.util.Collections;

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

	public Integer getTimeKvest()	{
		if (Integer.parseInt(kvest) > 0) {
			return Integer.parseInt(kvest);
		}else {
			return 100;
		}
	}

	
	public Integer getVid()	{
		return Integer.parseInt(vid);
	}
	
	// Здесь мы проверяем на выполнения условия поставленного на уровне
	// вид поставленной цели: ХОДЫ (отрицательное число) или ВРЕМЯ (положительное).
	public Boolean kvest_TEST(int cel, int kolvoHodov, ArrayList<Integer> array_all_moovs)
	{
		Boolean b=true;
		if (kvest.equals("0")) {
			// Если не было задано ничего, то возвращаем true
			// т.е. никакой проверки делать ненадо дошли до финиша и все...
		}else {
			if (cel > 0) {
			//  Цель ВРЕМЯ
				b = true;	
			}else {
			// 	Цель ХОДЫ
				if (kolvoHodov == Math.abs(cel)) {
					// Если кол-во ходов равное то проверяем на читерство!
					boolean local_bool = false;			
					// В массиве всех ходов ищем частоту вхождния каждого элемента, если она больше 1 бьем тревогу!
					for (int i = 0; i < array_all_moovs.size(); i++){
						if (Collections.frequency(array_all_moovs, array_all_moovs.get(i))	>	1) 
						{	local_bool = true;	break; }
					}	
					if (local_bool) { 	b=false;}
					else 			{	b=true;	}
				}else {
					b = false;
				}
			}
		}
		return b;
	}
}
