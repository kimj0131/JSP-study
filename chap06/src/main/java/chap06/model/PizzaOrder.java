package chap06.model;

// 데이터 클래스, 모델, dto, vo, ...
// 컬렉션과 함께 사용하면서 데이터를 담아놓기 위한 용동의 클래스
public class PizzaOrder {
	
	String size;
	int qty;

	String pizzaName;
	int price;
	
	public PizzaOrder(String size, int qty, String pizzaName, int price) {
		this.size = size;
		this.qty = qty;
		
		this.pizzaName = pizzaName;
		this.price = price;
	}
	
	public String getSize() {
		return size;
	}
	
	public int getQty() {
		return qty;
	}
	
	public String getPizzaName() {
		return pizzaName;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("<li>%s, 가격:%d / 사이즈:%s, %d판</li>",pizzaName, price, size, qty);
	}
	
}
