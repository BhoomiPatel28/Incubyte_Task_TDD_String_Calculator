package calc;

public class Calculator {

	public static int add(String s)
	{
		if(s.isEmpty())
			return 0;
		
		else if(s.contains(","))
		{
			String[] n = s.split(",");
			return Integer.parseInt(n[0]) + Integer.parseInt(n[1]); 
		}
		
		else
			return Integer.parseInt(s);
	}
}