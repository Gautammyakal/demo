package dao;

import java.util.List;
import static utils.HibernateUtils.*;
import org.hibernate.*;

import pojos.Stock;

public class StockDao {
	
	public Integer addStock(Stock s){
		Integer id=null;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			id=(Integer)hs.save(s);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return id;
	}
	public List<Stock> getStocks() {
		List<Stock> l1 = null;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery("select s from Stock s", Stock.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	public String purchaseStock(int stockId, int qty) throws Exception {
		String mesg = "Stock purchase failed!";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Stock s = hs.get(Stock.class, stockId);
			if (s != null) {
				s.setQuantity(s.getQuantity() - qty);
				mesg = "stock purchase successful @ price =" + s.getPrice();
				System.out.println("Press enter to continue");
				System.in.read();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	public List<Stock> updateStockPrices() {
		List<Stock> l1 = null;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery("select s from Stock s", Stock.class).getResultList();
			l1.forEach(s->s.setPrice(s.getPrice()+500));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

}
