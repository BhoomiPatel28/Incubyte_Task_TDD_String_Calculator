package calc;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String s)
	{
		if(s.isEmpty())
			return 0;
		else
		{
			String[] n = tokenizing(s);
			int len = n.length;
			int[] num = new int[len];
			Vector negn = new Vector();
			
			int sum = 0;
			
			for(int i = 0; i<len; i++)
			{
				num[i] = Integer.parseInt(n[i]);
				if(num[i] < 0)
					negn.add(num[i]);
//					throw new RuntimeException("Negative numbers are not allowed: " + num[i]);
				
				sum += num[i];
			}
			
			if(negn.size() > 0)
				throw new RuntimeException("Negative numbers are not allowed: " + negn);
			
			return sum;
		}		
	}
	
	private static String[] tokenizing(String s)
	{
		if(delimeter_custom(s))
			return split_delimeter_custome(s);
		
		else
			return split_delimeter_newline_comma(s);
	}
	
	private static boolean delimeter_custom(String s)
	{
		return s.startsWith("//");
	}
	
	private static String[] split_delimeter_newline_comma(String s)
	{
		String[] n = s.split(",|\n");
		return n;
	}
	
	private static String[] split_delimeter_custome(String s)
	{
		Matcher mt = Pattern.compile("//(.)\n(.*)").matcher(s);
		mt.matches();
		String del = mt.group(1);
		String num = mt.group(2);
		return num.split(del);
	}
	
}
