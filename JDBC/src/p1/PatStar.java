package p1;

import java.util.Scanner;

public class PatStar {

	public static void main(String[] args) 
	{
		int count=0;
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for (int i = 1; i <= n; i++) 
		{
			if((i%2)==0)
			{
				for(int j=1;j<=i;j++)
				{
					count++;
					System.out.print(count);
				}
				//System.out.print(i+1);
				System.out.println();
			}	
			else
			{
				//System.out.print(i+1);
				for(int j=1;j<=i;j++)
				{
					count++;
					System.out.print(count);
				}
				System.out.println();
			}
		}
	}

}
