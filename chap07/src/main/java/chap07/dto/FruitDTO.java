package chap07.dto;

public class FruitDTO {
	private String fruit_name;
	private Integer fruit_price;
	private String fruit_grade;
	
	public FruitDTO(String fruit_name, Integer fruit_price, String fruit_grade) {
		super();
		this.fruit_name = fruit_name;
		this.fruit_price = fruit_price;
		this.fruit_grade = fruit_grade;
	}

	
	public String getDivRow() {
		return String.format("<div>%s</div>"
				+ "<div>%d원</div>"
				+ "<div>%s</div>"
				, fruit_name, fruit_price, fruit_grade);
	}
	
	
	public String getFruit_name() {
		return fruit_name;
	}

	public void setFruit_name(String fruit_name) {
		this.fruit_name = fruit_name;
	}

	public Integer getFruit_price() {
		return fruit_price;
	}

	public void setFruit_price(Integer fruit_price) {
		this.fruit_price = fruit_price;
	}

	public String getFruit_grade() {
		return fruit_grade;
	}

	public void setFruit_grade(String fruit_grade) {
		this.fruit_grade = fruit_grade;
	}

	
	
}
