import java.util.*;
public class NextPermutation {
	public static void permute(int a[])
	{
		int n=a.length;
		for(int i=n-1;i>0;i-- )
		{
			if(a[i]>a[i-1])
			{
			int num=a[i-1];	
				for(int j=i-1;j<n;j++ )
				{
					if(a[j]-1==num)
					{
						int temp=a[i-1];
						a[i-1]=a[i];
						a[i]=temp;
					}
				}
				break;
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
	}
	public static void main(String [] args)
	{
		int a[]= {1,5,8,4,7,6,5,3,1};
		permute(a);
	}

}
