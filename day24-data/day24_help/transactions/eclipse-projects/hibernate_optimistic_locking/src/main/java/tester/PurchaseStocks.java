package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StockDao;


import static utils.HibernateUtils.*;

public class PurchaseStocks {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);SessionFactory sf=getSf()) {
			StockDao dao=new StockDao();
			System.out.println("Available Stocks ");
			dao.getStocks().forEach(System.out::println);
			//purchase stock
			System.out.println("Enter stock id & qty to purchase");
			System.out.println(dao.purchaseStock(sc.nextInt(), sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
