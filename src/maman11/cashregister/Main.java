package maman11.cashregister;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter initial amount in cash register:");
		int amount = scanner.nextInt();
		CashRegister cashRegister = new CashRegister(amount);
		HashMap<String, Item> items = new HashMap<String, Item>();
		boolean isRunning = true;
		while (isRunning)
		{
			System.out.println("---------------------------------------");
			System.out.println("Please choose option:");
			System.out.println("1. Print total amount in cash register.");
			System.out.println("2. Create item.");
			System.out.println("3. Add item(s) to ongoing sale.");
			System.out.println("4. Print ongoing sale details.");
			System.out.println("5. Check out ongoing sale.");
			System.out.println("6. Print list of existing items.");
			System.out.println("7. Exit program.");
						
			int selection = scanner.nextInt(); //readNumber();
			switch (selection) {
			
				case 1: //Print total amount in cash register
					System.out.println("Total sum in cash register is: " + cashRegister.getTotalSum());
					break;
					
				case 2: //Create item
					System.out.println("Creating item - Enter product name:");
					String productName = scanner.next();
					System.out.println("Creating item - Enter product price:");
					double price = scanner.nextDouble();
					items.put(productName, new Item(productName, price));
					break;
	
				case 3: //Add item(s) to ongoing sale
					System.out.println("Enter product name:");
					String chosenProduct = scanner.next();
					if (!items.containsKey(chosenProduct)) {
						System.out.println("Unrecognized item name: " + chosenProduct);
					}
					else {
						System.out.println("Enter number of '" + chosenProduct +"' items:");
						int quantity = scanner.nextInt();
						Item item = items.get(chosenProduct);
						cashRegister.addSaleEntry(item, quantity);
					}
					break;
					
				case 4: //Print ongoing sale details
					System.out.println(cashRegister.getCurrentSaleString());
					break;
					
				case 5:
					if (!cashRegister.isAnyOngoingSale()) {
						System.out.println("No sale to check out!");
					}
					else {
						System.out.println("Checking out sale, total price: "+ cashRegister.getTotalPrice() +", enter payment amount:");
						double payment = scanner.nextDouble();
						PaymentResult paymentResult = cashRegister.checkoutCurrentSale(payment);
						if (paymentResult.getIsSuccessful()) {
							System.out.println("Payment accepted! your change is: " + paymentResult.getChange());
							System.out.println(cashRegister.getCurrentSaleString());
						}
						else {
							System.out.println("This is not enough money!");
						}
					}
					break;
					
				case 6: //Print list of existing items
					System.out.println("Item Name --> Price");
					for (String itemName : items.keySet()) {
						Item currItem = items.get(itemName);
						System.out.println(currItem.getName() + " --> " + currItem.getPrice());
					}
					break;
					
				case 7: //Exit
					System.out.println("Bye Bye!");
					scanner.close();
					System.exit(0);
			}
		}
	}
}
