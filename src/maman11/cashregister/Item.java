package maman11.cashregister;

public class Item {
	private String m_name;
	private double m_price;
	
	public Item(String name, double price) {
		m_name = name;
		m_price = price;
	}
	
	public String getName() {
		return m_name;
	}
	public double getPrice() {
		return m_price;
	}
}
