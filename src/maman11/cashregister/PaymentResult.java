package maman11.cashregister;

public class PaymentResult {

	private boolean m_isSuccessful;
	
	private double m_change;
	
	public boolean getIsSuccessful() {
		return m_isSuccessful;
	}
	
	public double getChange() {
		return m_change;
	}
	
	public PaymentResult(boolean isSuccessful, double change) {
		m_isSuccessful = isSuccessful;
		m_change = change;
	}
}
