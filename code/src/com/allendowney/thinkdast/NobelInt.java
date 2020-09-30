import java.util.*;
public class NobelInt {
	public static void findnobelInt(Vector<Integer>v)
	{
		int min=v.get(0);
		int n=v.size();
		for(int i=0;i<n;i++) {
		if(v.get(i)<0)
		{
			min=0;
		
		}
		if(min>v.get(i))
		{
			min=v.get(i);
			
		}
		}
		if(min==n-1)
		{
			System.out.println("Nobel Integer :"+ min);
		}
		else
		{
			System.out.println("Nobel Integer: "+0);
		}
	}
public static void main(String []args)
{
	Vector <Integer>vec=new Vector<>();
	vec.add(15);
	vec.add(17);
	vec.add(18);
	vec.add(14);
	vec.add(4);
	findnobelInt(vec);
	
}
}
