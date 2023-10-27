package practice;

public class GenericMethodsPractice {

	public static void main(String[] args) {//caller function
		//hard coded data
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println(c);
		
		GenericMethodsPractice g = new GenericMethodsPractice();//object of class// to call non static method
		GenericMethodsPractice.add(); // to call static method you can use classname in a different class in same class no need
		add2(120, 50); //same class no need
		add2(10, 30); //you can use sysout here to print it as per wish
		g.add3(20, 50); //to call non static method create object of class
	}
//These are not a generic method at all - Generic methods should have any hard coded values
	//Simple static method
	public static void add() {
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println(c);
	}
	//Simple non static method
	public void add1() {
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println(c);
	}
	//generic method should be parameterised so that data is not hardcoded and get any data from caller
	public static int add2(int a, int b) {//called method static
		int c=a+b;
		//System.out.println(c); not optimal return is optimal
		return c;//to give any data to caller
	}
	public int add3(int a, int b) {//called function non static
		int c=a+b;
		//System.out.println(c); not optimal return is optimal
		return c;//to give any data to caller
	}
}
