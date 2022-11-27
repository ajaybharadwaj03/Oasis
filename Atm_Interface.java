import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
import java.lang.*;

class Account{
    static void makeRegistration(){
        Scanner inp = new Scanner(System.in);
        System.out.println("**********");
        System.out.println("Enter your name :");
        String name = inp.nextLine();
        System.out.println("Eneter your Account Number");
        Main.acc_num = inp.nextLine();
        System.out.println("Enter your user name :");
        Main.user_name = inp.nextLine();
        System.out.println("Enter your Password :");
        String pwd = inp.nextLine();
        System.out.println("Hurray! Registration completed successfully...");
        System.out.println("**********");
        Main.nextEvent();
        while(true){
            show(Main.user_name);
            int select = inp.nextInt();
            if(select == 1){
                login(name,pwd);
            }
            else if(select == 2){
                System.exit(0);
            }
            else{
                System.out.println("Bad Entry , please make another try");
            }
        }
    }
    static void show(String user_name){}
    static void login(String name, String pwd){}
}

class Deposit{
    static void deposit(){
       Scanner inp = new Scanner(System.in);
       System.out.println("**********");
       System.out.println("Enter Amount to Deposit");
       System.out.println("**********");
       int dep_val = inp.nextInt();
       Main.updateBal(dep_val);
       Main.trans_his.add("Money Deposited :");
       Main.trans_his.add(Integer.toString(dep_val));
       System.out.println("An Amount of Rs. "+dep_val+" deposited successfully");
       System.out.println("**********");
       Main.nextEvent();
    }
}

class WithDraw{
    static void withdraw(){
        Scanner inp = new Scanner(System.in);
        System.out.println("**********");
        System.out.println("Enter amount to be withdrawed :");
        int w_money = inp.nextInt();
        if(w_money<=Main.bal){
            Main.bal = Main.bal-w_money;
            Main.trans_his.add("Amount withdrawn :");
            Main.trans_his.add(Integer.toString(w_money));
            System.out.println("An Amount of Rs. "+w_money+" withdrawn successfully");
            System.out.println("**********");
        }
        else{
            System.out.println("Insufficient funds , Unable to withdraw . Please check your Balance");
            System.out.println("**********");
        }
        Main.nextEvent();
    }
}

class Transfer{
    static void transfer_money(){
        Scanner inp = new Scanner(System.in);
        System.out.println("**********");
        System.out.println("Enter the name of reciever");
        String reciever_name = inp.nextLine();
        System.out.println("Enter the Account number of Mr./Mrs. "+reciever_name);
        int rec_accno = inp.nextInt();
        System.out.println("Enter Amount to be transferred :");
        int transfer_amount = inp.nextInt();
        if(transfer_amount<=Main.bal){
            Main.bal = Main.bal-transfer_amount;
            Main.trans_his.add("Transferred Amount:");
            Main.trans_his.add(Integer.toString(transfer_amount));
            System.out.println("An Amount of Rs. "+transfer_amount +" transferred to "+reciever_name+" successfully");
            System.out.println("**********");
        }
        else{
            System.out.println("Insufficient funds , Unable to transfer. Please check your Balance");
            System.out.println("**********");
        }
    }
}

class ShowBal{
    static void showbal(){
        System.out.println("**********");
        System.out.println("The available amount in your account is Rs.");
        Main.availableBal();
        System.out.println("**********");
        Main.nextEvent();
    }
}

class History{
    static void transactions_History(){
        System.out.println("**********");
        System.out.println("Transaction History :");
        int l = 0;
        if(Main.bal>0){
            for(int i=0;i<(Main.trans_his.size()/2);i++){
                for(int j=0;j<2;j++){
                    System.out.println(Main.trans_his.get(l)+" ");
                    l++;
                }
                System.out.println("**********");
            }
        }
        else{
            System.out.println("Unable to show any transaction history, you bal is 0");
            System.out.println("**********");
        }
        Main.nextEvent();
    }
}

public class Main{
    public static String user_name;
    public static int bal=0;
    public static String acc_num;
    public static ArrayList<String> trans_his = new ArrayList<String>();
    
    static void updateBal(int dep_val){
        bal = bal+dep_val;
    }
    static void availableBal(){
        System.out.println(bal);
    }
    public static void home(){ 
        System.out.println();
        Scanner inp = new Scanner(System.in);
        System.out.println("**********");
        System.out.println("Welcome to State Bank of Andhra Pradesh");
        System.out.println("**********");
        System.out.println("Choose any from Below :");
        System.out.println("**********");
        System.out.println("1. Register");
        System.out.println("2. Quit");
        int select = inp.nextInt();
        if(select == 1){
            Account.makeRegistration();
        }
        else if(select == 2){
            System.exit(0);
        }
        else{
            System.out.println("You can select only the above two options");
            home();
        }
    }
    static void nextEvent(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome "+Main.user_name+" to Atm console!!");
        System.out.println("**********");
        System.out.println("Choose any option : ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int select = inp.nextInt();
        switch(select){
            case 1:
                Deposit.deposit();
            case 2:
                WithDraw.withdraw();
            case 3:
                Transfer.transfer_money();
            case 4:
                ShowBal.showbal();
            case 5:
                History.transactions_History();
            case 6:
                System.out.println("Thankyou , visit again.");
                System.exit(0);
        }
    }
 
    public static void main(String[] args){
        home();
    }
}
