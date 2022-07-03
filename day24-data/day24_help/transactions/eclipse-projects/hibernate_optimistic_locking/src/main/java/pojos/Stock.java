package pojos;

import javax.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {
	private Integer id;
	private String company;
	private int quantity;
	private double price;
	private int version;
	
	public Stock() {
		System.out.println("stock def");
	}

	public Stock(String company, int quantity, double price) {
		super();
		this.company = company;
		this.quantity = quantity;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(columnDefinition = "int(10)")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(columnDefinition = "double(6,1)")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", company=" + company + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
