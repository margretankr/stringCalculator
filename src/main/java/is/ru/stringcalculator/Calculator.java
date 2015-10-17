package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if (text.equals(""))
		
			return 0;
		
		else if (text.contains(","))
		{	
			return sum(splitNumbers(text));
		}

		else if (text.contains("\n"))
		{
			return sum(splitNumbers(text));
		}

		else if (text.startsWith("//"))
		{

			return sum(splitNumbers(text));
		}

		else 
			return 1;		
	}

	private static String [] splitNumbers (String numbers)
	{
		if (numbers.startsWith("//"))
		{
			String delimiter = numbers.substring(2,3);
			String number = numbers.substring(4);

			return number.split(delimiter);

		}

		return numbers.split("[,\n]");
	}

	private static int toInt(String number){

		return Integer.parseInt(number);
	}

	private static int sum(String[] numbers){
 

 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

}