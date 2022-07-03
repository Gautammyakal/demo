package tester;

import java.util.Scanner;

import dao.StockDao;



import static utils.HibernateUtils.*;

public class StockPriceEscalation {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			getSf();// hib booted.
			
			StockDao dao=new StockDao();
			System.out.println("Updated stocks");
			dao.updateStockPrices().forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getSf().close();// cn pool will be destroyed.
		}

	}

}
