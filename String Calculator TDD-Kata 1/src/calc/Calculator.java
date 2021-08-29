package calc;

public class Calculator {

	public static int add(String s)
	{
		if(s.isEmpty())
			return 0;
		
		else if(s.contains(","))
		{
			String[] n = s.split(",|\n");
			int len = n.length;
			int[] num = new int[len];
			
			int sum = 0;
			
			for(int i = 0; i<len; i++)
			{
				num[i] = Integer.parseInt(n[i]);
				sum += num[i];
			}
			
			return sum;
		}		
		else
			return Integer.parseInt(s);
	}
}