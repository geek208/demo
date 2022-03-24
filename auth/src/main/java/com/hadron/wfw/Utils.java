package com.hadron.wfw;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public final class Utils {
    private final static Interner<Object> STRING_WEAK_POLL = Interners.newWeakInterner();



    public static String generateVCode()  {

            SecureRandom random = new SecureRandom();
            return random.nextInt(100000) + "";



    }

    public static    Interner<Object> getInternersPoll(){
        return STRING_WEAK_POLL;
        }

    public static String getCharAndNum(int length) {

        SecureRandom random = new SecureRandom();

        StringBuffer valSb = new StringBuffer();

        String charStr = "0123456789abcdefghijklmnopqrstuvwxyz";

        int charLength = charStr.length();


        for (int i = 0; i < length; i++) {

            int index = random.nextInt(charLength);

            valSb.append(charStr.charAt(index));

        }

        return valSb.toString();

    }
    
    public static boolean rangeInDefined(int current, int min, int max){
    	//Math.min(a, b)
        return Math.max(min, current) == Math.min(current, max);
    }


    public static Date getDateBy(int day) {

        return getDateBy(new Date(), day, Calendar.DAY_OF_YEAR);
    }

    public static Date getDateBy(Date date, int addTime, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, addTime);
        return calendar.getTime();
    }


    public static Date formatDate(Date date, SimpleDateFormat simpleDateFormat) {
        SimpleDateFormat thisSDF = new SimpleDateFormat("YYYYMMddHH");

        if (simpleDateFormat != null) thisSDF = simpleDateFormat;
        try {
            return thisSDF.parse(thisSDF.format(date));
        } catch (ParseException e) {
            throw new RuntimeException("转换错误", e);
        }

    }
    
    public static String getRandomStr (int length)
    {
             String result = "";
               for (int i = 0; i<length; i++)
                     {
                             int intVal = (int)(Math.random()*26+97);
                             result = result +(char) intVal;
                     }
      return result;
 }

    public static void main(String[] args) {
        //System.out.println(formatDate(new Date(), null));
       // System.out.println(getRandomStr(6));
       // System.out.println(getCharAndNum(6));
    
    	//$<100 100<$<200  200<$
    	
    	String input = "50";
    	//String exp =  "$<100";
    	//String exp =  "50<$<100";
    	String exp =  "100<$";
    	
    	String [] eq = exp.split("<");
    	
    	String n = exp.replace("$", input);
    	
       // if(e)
    	
    	//先左边
    	if(eq[0].equals("$")){
    		int c = Integer.parseInt(input);
    		int p = Integer.parseInt(eq[1]);
    		int eq2  = Math.min(c, p);
    		System.out.println("输入值==="+c+"左边 ====="+Math.min(c, p) );
    		if(c == eq2){
    			//输入值比 比右边小
    			System.out.println("输入值比 比右边小==="+c+"左边 ====="+Math.min(c, p) );
    		}
    		//
//    		if(String.valueOf(Math.min(50, 100)).equals(input)){
//    			System.out.println("输入比 当前");
//    		}
        //右边
    	}else if(eq[1].equals("$")){
    		  int c = Integer.parseInt(input);
    		  int p = Integer.parseInt(eq[0]);
    		  int eq2  = Math.min(c, p);
    		  System.out.println("输入值==="+c+"右边====="+Math.max(p, c) );
    		  //中间
    	}else {
    		  System.out.println("中间 ====="+rangeInDefined(Integer.parseInt(input),Integer.parseInt(eq[0]),Integer.parseInt(eq[2])) );
    		  System.out.println("中间 ====="+rangeInDefined(60,50,100) );
    	}
    	
    	
    	//System.out.println("右边 ====="+Math.max(110, 100) );
      
    }


}
