import java.util.*;
public class StringCalculator
{
    private int sum=0;
    private String delimiters=",\\n";
    final List<Integer> negativeNumbers = new ArrayList<Integer>();
    public int add(String input) throws Exception
    {
        if (input.equals("")||input.equals(" "))
        {
            sum=0;
        }
        else if(input.substring(0, 2).equals("//"))
        {
            String NewDelimiters = input.substring(2, input.indexOf("\\n"));
            String numbers = input.substring(input.indexOf("\\n") + 2);
            delimiters += NewDelimiters.replace("[","");
            delimiters = delimiters.replace("]","");
            StringTokenizer result = new StringTokenizer(numbers, delimiters);
            while (result.hasMoreTokens())
            {
                Checking(result.nextToken());
            }
            if (negativeNumbers.size()!=0)
            {
                System.out.println("Від'ємні: " + negativeNumbers);
                throw new Exception("Недозволені від'ємні числа");
            }
        }
        else
        {
            StringTokenizer result1 = new StringTokenizer(input, delimiters);
            while (result1.hasMoreTokens())
            {
                Checking(result1.nextToken());
            }
            if (negativeNumbers.size()!=0)
            {
                System.out.println("Від'ємні: " + negativeNumbers);
                throw new Exception("Недозволені від'ємні числа");
            }
        }
        return sum;
    }
    private void Checking(String number)
    {
        int num = Integer.parseInt(number);
        if (num < 0)
        {
            negativeNumbers.add(num);
        }
        if (num > 1000)
        {
            return;
        }
        sum += num;
    }
}
