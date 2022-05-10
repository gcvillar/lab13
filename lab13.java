
import java.util.ArrayList;

public class lab13
{
    private ArrayList<Integer> list = new ArrayList<>();
	public void readData(String filename)
	{
		try
		{
		// open the file
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn = input.readLine();
			while(inn != null)
	        {
	           list.add(Integer.valueOf(inn));
	           inn = input.readLine();
	            
	        }
	        input.close();
        //store values from file in an ArrayList<Integer>
		}
		catch(Exception e)
        {
            System.out.println("File not found.");
            System.exit(0);
        }
        
	}
	public long getTotalCount()
	{
		//use a stream to return the number of values in the array
        long  totalCount = list.stream().count();
        return totalCount;

	}
	public long getOddCount()
	{
		long oddCount = list.stream().filter(x -> x % 2 == 1).count();
        return oddCount;
	}
	public long getEvenCount()
	{
		long evenCount = list.stream().filter(x -> x % 2 == 0).count();
		return evenCount;
	}
	public long getDistinctGreaterThanFiveCount()
	{
		long distinctCount = list.stream().filter(x -> x > 5).distinct().count();
        return distinctCount;
	}
	public Integer[] getResult1()
	{
		Integer[] result1 = list.stream().filter(x -> x%2==0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
        return result1;
	}
	public Integer[] getResult2()
	{
		Integer[] result2 = list.stream().limit(50).map(x -> x * x).map(x -> x * 3).toArray(Integer[]::new);
        return result2;
	}
	public Integer[] getResult3()
	{
        Integer[] result3 = list.stream().filter(x -> x % 2 == 1).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
        return result3;
	}
	// put code here to populate expectedResult1 with the values in testData.get(0)
				// so that you can use "assertArrayEquals" to verify expectedResult1 and lab.getResult1() are the same
						
}
