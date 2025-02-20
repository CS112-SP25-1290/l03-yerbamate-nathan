import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
  	{
		CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
		Scanner keyboard = new Scanner(System.in);

		int choice, ounces, brewTemp, count = 0;
		String name;
		double price;
		
		do
    	{
			System.out.println("1) Enter new Tea");
			System.out.println("2) Enter new Yerba Mate");
			System.out.println("3) Exit");
			System.out.print(">>");
			choice = keyboard.nextInt();
			keyboard.nextLine();

			switch (choice)
			{
			    case 1: // Tea
			        System.out.print("Enter name      : \n");
			        name = keyboard.nextLine();
			        System.out.print("Enter ounces    : \n");
			        ounces = keyboard.nextInt();
			        System.out.print("Enter price     $ \n");
			        price = keyboard.nextDouble();
			        System.out.print("Enter brew temperature (in Celsius): ");
			        brewTemp = keyboard.nextInt();

			        // Create a Tea, put into array
			        inventory[count] = new Tea(name, ounces, price, brewTemp);

					System.out.println("Your tea order has been added: " + inventory[count]);
			        count++;
			        break;
				case 2:
					System.out.print("Enter name      : ");
					name = keyboard.nextLine();
					System.out.print("Enter ounces    : ");
					ounces = keyboard.nextInt();
					System.out.print("Enter price     $ ");
					price = keyboard.nextDouble();
					System.out.print("Enter brew temperature (in Celsius): ");
					brewTemp = keyboard.nextInt();

					// Create a YerbaMate, put into array
					inventory[count] = new YerbaMate(name, ounces, price, brewTemp, 0);

					System.out.println("Your YerbaMate order has been added: " + inventory[count]);
					count++;
					break;
			}

		} while (choice != 3);

		System.out.println("The most expensive current Yerba is: " + getMostExpensiveYerba(inventory));
		System.out.println("The average price of a caffeinated beverage is: $" + getAveragePrice(inventory));
	}


	private static YerbaMate getMostExpensiveYerba(CaffeinatedBeverage[] objs) {
		YerbaMate highestPricedYerba = null;

		for(CaffeinatedBeverage bev : objs) {
			if(bev == null) continue;

			if(!(bev instanceof YerbaMate thatYerba)) {
				continue;
			}

			if(highestPricedYerba == null || highestPricedYerba.getPrice() < thatYerba.getPrice()) {
				highestPricedYerba = thatYerba;
			}
		}

		return highestPricedYerba;
	}

	private static double getAveragePrice(CaffeinatedBeverage[] objs) {
		double total = 0;
		int iterations = 0;

		for(CaffeinatedBeverage bev : objs) {
			if(bev == null) continue;

			total+=bev.getPrice();
			iterations++;
		}

		return Double.parseDouble(String.format("%.2f", total / iterations));
	}
}