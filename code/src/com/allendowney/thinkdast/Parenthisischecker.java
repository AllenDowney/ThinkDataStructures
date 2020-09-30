import java.util.*;
public class Parenthisischecker {
	static void checkparent(String str)
	{
	
		Stack<Character>s=new Stack<>();
		
		
		
		for(int i1=0;i1<str.length();i1++)
		{
			char current=str.charAt(i1);
			if(str.charAt(i1)=='['||str.charAt(i1)=='('||str.charAt(i1)=='{')
			{
				s.push(current);
				
			}
			else if(str.charAt(i1)==']'||str.charAt(i1)==')'||str.charAt(i1)=='}')
			{
				if(s.isEmpty())
				{
					System.out.print("Not Balanced");
				}
				char last=s.peek();
				if(current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
				{
					s.pop();
				}
			}
			
		}
		if(s.isEmpty())
		{
			System.out.print("Balanced ");
		}
		else
		{
			System.out.print("Not Balanced");
		}
	}
public static void main(String [] args)
{
	String str="{}[][";
	checkparent(str);
}
}
