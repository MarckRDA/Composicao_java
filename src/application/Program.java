package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		Date instant = new Date();
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date bthdate = sdf.parse(sc.next());
		sc.nextLine();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Order order = new Order(instant, OrderStatus.valueOf(status), 
				new Client(name, email, bthdate));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i< n+1; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantityProduct = sc.nextInt();
			sc.nextLine();
			OrderItem item = new OrderItem(quantityProduct, productPrice, 
					new Product(productName, productPrice));
			order.addItem(item);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + sdf2.format(order.getMoment()));
		System.out.println("Order Status: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + 
				" (" + sdf.format(order.getClient().getBithDate()) + ") - " + order.getClient().getEmail());
		
		System.out.println("Order Items: ");
		System.out.println(order);
		System.out.println("Total price: " + String.format("%.2f", order.total()));
		
		
		sc.close();

	}

}
