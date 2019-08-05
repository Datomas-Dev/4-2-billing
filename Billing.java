/*	Filename: Billing.java
	Date: 8/1/2019
	Author: David T.
	
	description...
*/
import java.util.Scanner;

public class Billing
{
	final static double SALES_TAX = 0.08;	
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		double uPrice;
		int uQty;
		double uDiscount;
		
		System.out.println("Order #1");
		System.out.print("Enter the price of your photo book >> ");
		uPrice = keyboard.nextDouble();
		receipt(uPrice);
		
		System.out.println("Order #2");
		System.out.print("Enter the price of your photo book >> ");
		uPrice = keyboard.nextDouble();
		System.out.print("Enter how many of this book you are getting >> ");
		uQty = keyboard.nextInt();
		receipt(uPrice,uQty);
		
		System.out.println("Order #3");
		System.out.print("Enter the price of your photo book >> ");
		uPrice = keyboard.nextDouble();
		System.out.print("Enter how many of this book you are getting >> ");
		uQty = keyboard.nextInt();
		System.out.print("Enter the amount of your coupon >> ");
		uDiscount = keyboard.nextDouble();
		receipt(uPrice,uQty,uDiscount);
		
		System.out.println("Thank you.");
	}
	
	public static double computeBill(double price)
	{
		return price+(price*SALES_TAX);
	}
	
	public static double computeBill(double price, int qty)
	{
		price *= qty;
		return price+(price*SALES_TAX);
	}
	
	public static double computeBill(double price, int qty, double discount)
	{
		price = (price*qty)-discount;
		price = price+(price*SALES_TAX);
		return (price > 0) ? price : 0;
	}
	
	public static void receipt(double price)
	{		
		System.out.println();
		System.out.println("========= ORDER =========");
		System.out.println("Photo Book:        $"+String.format("%.2f",price));		
		System.out.println("Tax (8%):          $"+String.format("%.2f",price*SALES_TAX));
		System.out.println("-------------------------");
		System.out.println("Total:             $"+String.format("%.2f",computeBill(price)));
		System.out.println();
	}
	
	public static void receipt(double price, int qty)
	{
		System.out.println();
		System.out.println("========= ORDER =========");
		System.out.println("Photo Book:        $"+String.format("%.2f",price*qty)+" ($"+String.format("%.2f",price)+" ea.)");
		System.out.println(" > Quantity: "+qty);
		System.out.println("Tax (8%):          $"+String.format("%.2f",(price*qty)*SALES_TAX));
		System.out.println("-------------------------");
		System.out.println("Total:             $"+String.format("%.2f",computeBill(price,qty)));
		System.out.println();
	}
	
	public static void receipt(double price, int qty, double discount)
	{
		System.out.println();
		System.out.println("========= ORDER =========");
		System.out.println("Photo Book:        $"+String.format("%.2f",price*qty)+" ($"+String.format("%.2f",price)+" ea.)");
		System.out.println(" > Quantity: "+qty);
		System.out.println("Discounts:        -$"+String.format("%.2f",discount));
		System.out.println("Tax (8%):          $"+String.format("%.2f",((price*qty)-discount)*SALES_TAX));
		System.out.println("-------------------------");
		System.out.println("Total:             $"+String.format("%.2f",computeBill(price,qty,discount)));
		System.out.println();
	}
}