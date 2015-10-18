package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if (text.equals(""))
		
			return 0;

		else if (text.contains("-"))
		{
			String totalMessage ="";
			String message = "Negatives not allowed: ";
			for (int i = 0; i < text.length(); i++)
			{
				if (text.substring(i, i+1).contains("-"))
				{
					if(i>0)
					{
						message += ",";
					}	

					totalMessage = message + text.substring(i, i+2);
				}
			}
			throw new IllegalArgumentException(totalMessage);
		}

		else if (text.startsWith("//"))
		{
			return sum(splitNumbers(text));
		}

		else if (text.contains(","))
		{	
			return sum(splitNumbers(text));
		}

		else if (text.contains("\n"))
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
			String delimiter = "";
			if (numbers.startsWith("//["))
			{	
				if (numbers.contains("]["))
				{
					String[] arr = numbers.split("\n");	
					int length = numbers.indexOf("\n"); 			
					delimiter = numbers.substring(3, length-1);

					String result = "";
					for (int i = 0; i < delimiter.length(); i++)
					{
						if((delimiter.charAt(i) != '[' && delimiter.charAt(i) != ']'))
						result += "\\" + delimiter.substring(i, i+1);
					}
					
					result = "[" + result + "]";
					return arr[1].split(result);
				}

				String[] arr = numbers.split("\n");	
				int length = numbers.indexOf("]"); 			
				delimiter = numbers.substring(3, length);

				String result = "";
				for (int i = 0; i < delimiter.length(); i++)
				{
					result += "\\" + delimiter.substring(i, i+1);
				}

				return arr[1].split(result);
			}



			delimiter = numbers.substring(2,3);
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
        	if (!number.isEmpty())
        	{
        		int tempNumber = toInt(number);
        		if(tempNumber <= 1000)
        		{
					total += tempNumber;
				}
			}
		}
		return total;
    }

}