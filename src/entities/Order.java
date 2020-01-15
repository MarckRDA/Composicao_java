package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enuns.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	
	private List <OrderItem> orderItems = new ArrayList<>();
	private Client client;
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List<OrderItem> getOrderItens() {
		return orderItems;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		orderItems.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}
	
	public Double total() {
		double sum = 0	;
		for(OrderItem c: orderItems) {
			sum += c.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(OrderItem c: orderItems) {
			sb.append(c.getProduct().getName() + ", ");
			sb.append(c.getProduct().getPrice() + ", ");
			sb.append("Quantity: " + c.getQuantity() + ", ");
			sb.append("Subtotal: " + c.subTotal() + "\n");
		}
		return sb.toString();
	}
}
