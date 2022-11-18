import java.lang.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Random r = new Random();
	    int randInteger = r.nextInt(100);
	    while(true){
	        sc.nextLine();
	        int a = sc.nextInt();
	        
    	    if(a>randInteger)
    	        System.out.print(a+" is greater than the RandomInteger."+"Better Luck next time");
    	    else if(a<randInteger)
    	        System.out.println(a+"is less than the RandomInteger."+"Better Luck next time");  
    	    else{ 
    	        System.out.println("Hurray! you won.");
    	        break;
    	    }
	    }
	}
}
