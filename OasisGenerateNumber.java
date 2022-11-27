import java.lang.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Random r = new Random();
	    int randInteger = r.nextInt(100),attempts = 1,Rounds = 3,round = 0,score =0;
	    int r1 = 50,Tpoints = 0,points=150,Grade = 0;
	    
	    System.out.println("Round "+round+1+" Begins.!!");
	    while(round<Rounds){
	        int a = sc.nextInt();
	        attempts++;
	        
    	    if(a>randInteger)
    	        System.out.println(a+" is greater than the RandomInteger."+"Better Luck next time");
    	    else if(a<randInteger)
    	        System.out.println(a+" is less than the RandomInteger."+"Better Luck next time");  
    	    else{ 
    	        System.out.println("Hurray! you won.");
    	        randInteger = r.nextInt(100);
    	        Tpoints += points;
    	        score+=r1;
    	        points = 150;
    	    }
    	    if(attempts>5){
	            attempts = 0;
	            
	            System.out.println("End of Round "+(round+1)+".");
	            round++;
	            r1 = r1-10;
	            if(round!=3){
	                System.out.println("Round "+(round+1)+" Begins.!!");
	            }
	            
	        }
    	    points-=10;
	    }
	    if(Tpoints>=1250 && Tpoints<=2250){ Grade = 10;}
	    if(Tpoints>=500 && Tpoints<1250){ Grade = 9;}
	    if(Tpoints>=200 && Tpoints<500){ Grade = 8;}
	    if(Tpoints>=150 && Tpoints<200){ Grade = 7;}
	    if(Tpoints>=120 && Tpoints<150){ Grade = 6;}
	    if(Tpoints>=100 && Tpoints<120){ Grade = 5;}
	    if(Tpoints>=70 && Tpoints<100){ Grade = 4;}
	    if(Tpoints<70 ){ Grade = 3;}
	    System.out.println("Total Score :"+score);
	    System.out.println("Final Grade :"+Grade);
	    System.out.println("ThankYou !!, Play Again....");
	}
}
