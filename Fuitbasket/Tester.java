package task1;
import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		int n;
	 String mycolor;
	 double myweight;
	     String myname;
		 boolean myfresh;
		Scanner in=new Scanner(System.in);
		int size=0;
		System.out.println("Enter the size of your bucket: ");
		n=in.nextInt();
		Fruit arr[]=new Fruit[n];
		int choice;
		
		while(size<n){
			System.out.println("Enter the fruit to add on your basket");
			System.out.println("1: Mango ,2:Apple ,3:Orange");
			choice=in.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Please enter the color of fruit: ");
				mycolor=in.next();
				System.out.println("Please enter the name of fruit: ");
				myname=in.next();
				System.out.println("Please enter the weight of fruit: ");
				myweight=in.nextInt();
				System.out.println("Is the fruit fresh type true or false");
				myfresh=in.nextBoolean();
				System.out.println(myfresh);
				if(myfresh) {
					 arr[size]=new Mango(mycolor,myweight,myname,true);
					 size++;
					 System.out.println("Mango is added");
					 break;
				}
				else {
					System.out.println("really sorry you can add only good food please add another one");
					break;
				}
			case 2:
				System.out.println("Please enter the color of fruit: ");
				mycolor=in.next();
				System.out.println("Please enter the name of fruit: ");
				myname=in.next();
				System.out.println("Please enter the weight of fruit: ");
				myweight=in.nextInt();
				System.out.println("Is the fruit fresh type true or false");
				myfresh=in.nextBoolean();
				System.out.println(myfresh);
				if(myfresh) {
					 arr[size]=new Apple(mycolor,myweight,myname,true);
					 size++;
					 System.out.println("Apple is added");
					 break;
				}
				else {
					System.out.println("really sorry you can add only good food please add another one");
					break;
				}
			case 3:
				System.out.println("Please enter the color of fruit: ");
				mycolor=in.next();
				System.out.println("Please enter the name of fruit: ");
				myname=in.next();
				System.out.println("Please enter the weight of fruit: ");
				myweight=in.nextInt();
				System.out.println("Is the fruit fresh type true or false");
				myfresh=in.nextBoolean();
				System.out.println(myfresh);
				if(myfresh) {
					 arr[size]=new Orange(mycolor,myweight,myname,true);
					 size++;
					 System.out.println("Orange is added");
					 break;
				}
				else {
					System.out.println("really sorry you can add only good food please add another one");
					break;
				}
			case 4:
				n=size;
				break;
			default:
				System.out.println("please enter valid choice dear!!");
				break;
				
				
			}
			
		}
		System.out.println("the basket is full");
		System.out.println("----------------------------------------");
		System.out.println("You added items are:");
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
			if(arr[i] instanceof Apple) {
				Apple a=(Apple)arr[i];
				a.jam();
			}
			if(arr[i] instanceof Mango) {
				Mango m=(Mango)arr[i];
				m.pulp();
			}
			if(arr[i] instanceof Orange) {
				Orange o=(Orange)arr[i];
				o.juice();
			}
				
		}
		System.out.println("Thanks for purchasing with us");
	
	}

}
