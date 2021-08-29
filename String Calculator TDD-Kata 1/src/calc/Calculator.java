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
			Vector<Integer> negn = new Vector<>();
			Vector<Integer> num = new Vector<>();
			
			int neg = 0;
			int sum = 0;
			int c = 0;
			
			String temp = "";
			
			for(int i = 0; i<len; i++)
			{
				Matcher mx = Pattern.compile("^(\\+|-)?\\d+$").matcher(n[i]);
				while(mx.find())
				{	
					temp = mx.group();
					c = Integer.parseInt(temp);
					
					if(c<0)
					{
						negn.add(c);
					}
					if(c>1000)
						c=0;
						
					num.add(c);
					sum +=c;
				 }
			}
			
			if(negn.size() > 0)
				throw new RuntimeException("Negative numbers are not allowed: " + negn);
			
			return sum;
		}		
	}
	
	private static String[] tokenizing(String s)
	{
		if(s.startsWith("//"))
		{
			if(s.startsWith("//["))
				return any_length_delimeter(s);
			else
				return split_delimeter_custom(s);	
		}
		else
		{
			return split_delimeter_newline_comma(s);	
		}
	}
	
	
	private static String[] split_delimeter_newline_comma(String s)
	{
		String[] n = s.split(",|\n");
		return n;
	}
	
	private static String[] split_delimeter_custom(String s)
	{
		Matcher mt = Pattern.compile("//(.)\n(.*)").matcher(s);
		mt.matches();
		String del = mt.group(1);
		String num = mt.group(2);
		return num.split(del);
	}
	
	private static String[] any_length_delimeter(String s)
	{
		Matcher mt = Pattern.compile("//(\\[.+\\])\n(.*)").matcher(s);
		mt.matches();
		String del = mt.group(1);
		String num = mt.group(2);
		return num.split(del);
	}
	
}
