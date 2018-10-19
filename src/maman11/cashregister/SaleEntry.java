package maman11.cashregister;

public class SaleEntry {

	private Item m_item;
	
	private static final String DELIMITER = "|";
	
	private int m_quantity;
	
	public SaleEntry(Item item, int quantity)
	{
		m_item = item;
		m_quantity = quantity;
	}
	
	public Item getItem() {
		return m_item;
	}
	
	public int getQuantity() {
		return m_quantity;
	}
	
	public static String getHeaderString() {
		return "Item Name"
				+ DELIMITER
				+ "Item Price"
				+ DELIMITER
				+ "Quantity"
				+ DELIMITER
				+ "Total Price (Item Price x Quantity)";
	}
	
	// Product    |Price         |Quantity     |Total Price
	// Orange     |3.21          |3            |9.63
	// Tomato     |11.2          |2            |22.4
	public String toString() {
		String delimiter = " | ";
		String itemName = this.getItem().getName();
		double itemPrice = this.getItem().getPrice();
		int quantity = this.getQuantity();
		return itemName
				+ delimiter
				+ itemPrice
				+ delimiter
				+ quantity
				+ delimiter
				+ itemPrice * quantity;
	}
}
