package test_criteria;

import static utils.HibernateUtils.getSf;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Stock;

public class Test {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {
			Session hs = sf.getCurrentSession();
			Transaction tx = hs.beginTransaction();
			try {
				CriteriaBuilder builder = hs.getCriteriaBuilder();
				CriteriaQuery<Stock> query = builder.createQuery(Stock.class);
				Root<Stock> root = query.from(Stock.class);
				query.select(root);
				 
				List<Stock> list = hs.createQuery(query).getResultList();
				list.forEach(System.out::println);
				//cr.select(root).where(cb.gt(root.get("itemPrice"), 1000));
                 query.select(root).where(builder.gt(root.get("price"),1000 ));
                 System.out.println();
                 list = hs.createQuery(query).getResultList();
 				list.forEach(System.out::println);
				tx.commit();
			} catch (RuntimeException e) {
				tx.rollback();
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
