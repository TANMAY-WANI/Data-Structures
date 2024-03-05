package CodeForces;
import java.util.*;
public class goodCars
{
	public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
	        HashSet<Integer> set=new HashSet<>();
	        int t=sc.nextInt();
	        int arr[][]=new int[t][t];
	        for(int i=0;i<arr.length;i++)
	        {
	            for(int j=0;j<arr.length;j++)
	            arr[i][j]=sc.nextInt();
	        }
	        
	         for(int i=0;i<arr.length;i++)
	        {
	            for(int j=0;j<arr.length;j++)
	            {
	                if(arr[i][j]==1)
	                {
	                    set.add(i+1);
	                }
	                else if(arr[i][j]==2)
	                {
	                    set.add(j+1);
	                }
	                else if(arr[i][j]==3)
	                {
	                    set.add(i+1);
	                    set.add(j+1);
	                }
	            }
	        }
	        ArrayList<Integer> list=new ArrayList<>();
	       
	        for(int i=0;i<arr.length;i++)
	        {
	            if(!set.contains(i+1))
	            {
	                list.add(i+1);
	            }
	        }
	        System.out.println(list.size());
	        for(int i=0;i<list.size();i++)
	        {
	            System.out.print(list.get(i)+" ");
	        }
	    
	}

}
