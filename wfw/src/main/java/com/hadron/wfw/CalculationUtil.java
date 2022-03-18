package com.hadron.wfw;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * 精确计算工具类(加，减，乘，除，返回较大值，返回较小值)
 */
public class CalculationUtil {

	/**
	 * 提供精确加法计算的add方法
	 */
	public static String add(String value1, String value2) {
		return add(value1, value2, 0, 0);
	}

	/**
	 * 提供精确加法计算的add方法(默認四捨五入)
	 * 
	 * @param value1
	 *            被加数
	 * @param value2
	 *            加数
	 * @param scale
	 *            精确范围(小数点后几位)
	 */
	public static String add(String value1, String value2, int scale) {
		return add(value1, value2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确加法计算的add方法
	 * 
	 * @param value1
	 *            被加数
	 * @param value2
	 *            加数
	 * @param scale
	 *            精确范围(小数点后几位)
	 * @param roundingMode
	 *            精確模式
	 */
	public static String add(String value1, String value2, int scale, int mode) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		BigDecimal result = b1.add(b2);
		// mode为0，则不需要精确
		if (mode != 0) {
			result = result.setScale(scale, mode);
		}
		return result.toString();
	}

	public static int compareTo(String value1, String value2, int scale, int mode) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		BigDecimal result = b1.subtract(b2);
		// mode为0，则不需要精确
		if (mode != 0) {
			result = result.setScale(scale, mode);
		}
		return result.compareTo(BigDecimal.ZERO);
	}

	/**
	 * 提供精确的除法运算方法divide
	 * 
	 * @param value1
	 *            被除数
	 * @param value2
	 *            除数
	 */
	public static String divide(String value1, String value2) throws IllegalAccessException {
		return divide(value1, value2, 0, null);
	}

	/**
	 * 提供精确的除法运算方法divide(默認四捨五入)
	 * 
	 * @param value1
	 *            被除数
	 * @param value2
	 *            除数
	 * @param scale
	 *            精确范围(小数点后几位)
	 */
	public static String divide(String value1, String value2, int scale) throws IllegalAccessException {
		return divide(value1, value2, scale, RoundingMode.HALF_UP);
	}

	/**
	 * 提供精确的除法运算方法divide
	 *
	 * @param value1
	 *            被除数
	 * @param value2
	 *            除数
	 * @param scale
	 *            精确范围(小数点后几位)
	 * @param roundingMode
	 *            精確模式
	 */
	public static String divide(String value1, String value2, int scale, RoundingMode roundingMode)
			throws IllegalAccessException {
		// 如果精确范围小于0，抛出异常信息
		if (scale < 0) {
			throw new IllegalAccessException("精确度不能小于0");
		}
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		// roundingMode为null，则不需要精确
		if (roundingMode != null) {
			return new Double(b1.divide(b2, scale, roundingMode).doubleValue()).toString();
		} else {
			return new Double(b1.divide(b2).doubleValue()).toString();
		}
	}

	/**
	 * 比较大小 ：返回较大的那个
	 */
	public static String getMax(String value1, String value2) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return new Double(b1.max(b2).doubleValue()).toString();
	}

	/**
	 * 比较大小 ：返回较小的那个
	 */
	public static String getMin(String value1, String value2) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return new Double(b1.min(b2).doubleValue()).toString();
	}

	/**
	 *
	 * 提供精确乘法运算的multiply方法
	 * 
	 * @param value1
	 *            被乘数
	 * @param value2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static String multiply(String value1, String value2) {
		return multiply(value1, value2, 0, 0);
	}

	/**
	 * 提供精确乘法运算的multiply方法(默認四捨五入)
	 * 
	 * @param value1
	 *            被乘数
	 * @param value2
	 *            乘数
	 * @param scale
	 *            精确范围(小数点后几位)
	 */
	public static String multiply(String value1, String value2, int scale) {
		return multiply(value1, value2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确乘法运算的multiply方法
	 * 
	 * @param value1
	 *            被乘数
	 * @param value2
	 *            乘数
	 * @param scale
	 *            精确范围(小数点后几位)
	 * @param roundingMode
	 *            精確模式
	 */
	public static String multiply(String value1, String value2, int scale, int mode) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		BigDecimal result = b1.multiply(b2);
		// mode为0，则不需要精确
		if (mode != 0) {
			result = result.setScale(scale, mode);
		}
		return result.toString();
	}

	/**
	 * 提供精确减法运算的subtract方法
	 * 
	 * @param value1
	 *            被减数
	 * @param value2
	 *            减数
	 * @return 两个参数的差
	 */
	public static String subtract(String value1, String value2) {
		return subtract(value1, value2, 0, 0);
	}

	/**
	 * 提供精确减法运算的subtract方法(默認四捨五入)
	 * 
	 * @param value1
	 *            被减数
	 * @param value2
	 *            减数
	 * @param scale
	 *            精确范围(小数点后几位)
	 */
	public static String subtract(String value1, String value2, int scale) {
		return subtract(value1, value2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确减法运算的subtract方法
	 * 
	 * @param value1
	 *            被减数
	 * @param value2
	 *            减数
	 * @param scale
	 *            精确范围(小数点后几位)
	 * @param roundingMode
	 *            精確模式
	 */
	public static String subtract(String value1, String value2, int scale, int mode) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		BigDecimal result = b1.subtract(b2);
		// mode为0，则不需要精确
		if (mode != 0) {
			result = result.setScale(scale, mode);
		}
		return result.toString();
	}

	
	public static boolean isNumericZidai(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
		String bigStr;
		try {
		bigStr = new BigDecimal(str).toString();
		} catch (Exception e) {
		return false;//异常 说明包含非数字。
		}

		Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
		if (!isNum.matches()) {
		return false;
		}
		return true;
		}
	
	
	public     static   boolean   check(String   fstrData)

	{
				
				char   c   =   fstrData.charAt(0);
				
				if(((c>='a'&&c<='z')   ||   (c>='A'&&c<='Z')))
				
				{
				
				return   true;
				
				}else{
				
				return   false;
				
				}

	}

	
	public static void main(String[] args) {

		// QLExpress
		try {
			System.out.println(CalculationUtil.divide("111", "100", 2));
			System.out.println(CalculationUtil.add("111", "100", 2));
			System.out.println(CalculationUtil.multiply("111", "100", 2));
			System.out.println(CalculationUtil.subtract("111", "100", 2));
			
//			
//			double aa = -19162431.1254;
//			String a = "111";
//			String b = "-19162431a1254";
//			String c = "中文";
//			String d = "a";
//			System.out.println(CalculationUtil.isNumericZidai(Double.toString(aa)));
//			System.out.println(CalculationUtil.isNumericZidai(a));
//			System.out.println(isNumericZidai(d));
//			System.out.println(isNumericZidai(c));
//			
			String temp2 = "&(&b&-&c&)&/&(&d&-&c&)&";
			
			String temp = "&(&b&-&c&)&/&(&d&-&c&)&";
			
			String newstr = "a="+temp.replace("&", "");
			System.out.println("before [ "+temp +"] after = ["+newstr+"]");
			
//			
//			String [] aa1 = temp.split("&");
//			
//			System.out.println(aa1.toString());
//			
//			String expressString = "a=(b-c)/(d-c)";
//			
//			for (String string : aa1) {
//				System.out.println(string+"===="+isNumericZidai(string));
//			}

			ExpressRunner runner = new ExpressRunner(false, false);

			DefaultContext<String, Object> context = new DefaultContext<String, Object>();
			context.put("b", new BigDecimal("0.1694915254237288"));
			context.put("c", new BigDecimal("0.15384615384615385"));
			context.put("d", new BigDecimal("1"));

			Object r = null;
			try {
				r = runner.execute(newstr, context, null, false, false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.print("r=" + r);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}