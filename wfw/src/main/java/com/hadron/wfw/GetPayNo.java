package com.hadron.wfw;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname GetPayNo.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public class GetPayNo {
public static String getOrderNo(){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	 int max=100000,min=1;
	 int ran2 = (int) (Math.random()*(max-min)+min); 
	String nowdate = sdf.format(new Date())+ran2;
	return "P"+nowdate;
}
}