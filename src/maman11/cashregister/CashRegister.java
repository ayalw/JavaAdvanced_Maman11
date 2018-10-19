package maman11.cashregister;

import java.util.ArrayList;
import java.util.List;

public class CashRegister {
	
	private double m_totalSum;
	private List<SaleEntry> m_currentSale;
	
	public CashRegister() {
		this(0);
	}
	
	public CashRegister(double initialSum) {
		m_totalSum = initialSum;
	}
	
	public double getTotalSum() {
		return m_totalSum;
	}
	
	public boolean isAnyOngoingSale() {
		return m_currentSale != null && m_currentSale.size() > 0;
	}
	
	public String getCurrentSaleString() {
		if (m_currentSale == null) return "-No ongoing sale-";
		StringBuilder sb = new StringBuilder();
		sb.append(SaleEntry.getHeaderString());
		sb.append(System.lineSeparator());
		for (SaleEntry se : m_currentSale) {
			sb.append(se.toString());
			sb.append(System.lineSeparator());
		}
		sb.append("----Total sale price: " + getTotalPrice() + "----" + System.lineSeparator());
		return sb.toString();
	}
	
	public void addSaleEntry(Item item, int quantity) {
		if (m_currentSale == null) {
			m_currentSale = new ArrayList<SaleEntry>(); 
		}
		m_currentSale.add(new SaleEntry(item, quantity));
	}
	
	public double getTotalPrice() {
		double totalPrice = 0;
		for (SaleEntry se : m_currentSale) {
			totalPrice += (se.getItem().getPrice() * se.getQuantity());
		}
		return totalPrice;
	}
	
	public PaymentResult checkoutCurrentSale(double payment) {
		double totalPrice = getTotalPrice();
		if (payment < totalPrice) {
			return new PaymentResult(false, 0);
		}
		else {
			double change = payment - totalPrice;
			m_totalSum += payment;
			m_totalSum -= change;
			return new PaymentResult(true, change);
		}		
	}

}
