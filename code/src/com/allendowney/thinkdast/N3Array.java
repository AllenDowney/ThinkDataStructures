import java.util.*;
import java.util.Map.Entry;
public class N3Array {
	public static void n3array(int arr[])
	{
		int n=arr.length;
		Map<Integer,Integer>hm=new HashMap<>();
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(!hm.containsKey(arr[i]))
			{
				hm.put(arr[i],1);
			}
			else 
			{
				if(hm.get(arr[i])>=1)
				{
					count=hm.get(arr[i]);
					hm.put(arr[i],count+1);
				}
			}
		}
		Iterator<Map.Entry<Integer,Integer>>it=hm.entrySet().iterator();
		while(it.hasNext())
		{ 
			Entry<Integer, Integer> entry=it.next();
			if(entry.getValue()>(n/3))
			{
				System.out.println(entry.getKey());
			}
			
	}
		
	}
public static void main(String []args)
{
	int arr[]= {3, 3, 4, 2, 4, 4, 2, 4, 4};
	n3array(arr);
}
}
