package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StockDao;
import pojos.Stock;

public class AddStock {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {

			StockDao dao = new StockDao();
			System.out.println("Enter stock company qty price");
			System.out.println(dao.addStock(new Stock(sc.next(), sc.nextInt(), sc.nextDouble())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
