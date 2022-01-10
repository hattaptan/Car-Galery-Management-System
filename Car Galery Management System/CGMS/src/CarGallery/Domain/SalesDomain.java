package CarGallery.Domain;

import java.sql.Date;

import CarGallery.db.BuyCarDB;

public class SalesDomain {

	private int id;
	private String customername; // define variable for sales info
	private Date saletime;
	private String moneydelay;
	private int salesprice;
	private int Plaque;

	// define set and get methods

	public int getPlaque() {
		return Plaque;
	}

	public void setPlaque(int plaque) {
		Plaque = plaque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public Date getSaletime() {
		return saletime;
	}

	public void setSaletime(Date saletime) {
		this.saletime = saletime;
	}

	public String getMoneydelay() {
		return moneydelay;
	}

	public void setMoneydelay(String moneydelay) {
		this.moneydelay = moneydelay;
	}

	public int getSaleprice() {
		return salesprice;
	}

	public void setSaleprice(int saleprice) {
		this.salesprice = saleprice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Plaque;
		result = prime * result + ((customername == null) ? 0 : customername.hashCode());
		result = prime * result + id;
		result = prime * result + ((moneydelay == null) ? 0 : moneydelay.hashCode());
		result = prime * result + salesprice;
		result = prime * result + ((saletime == null) ? 0 : saletime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesDomain other = (SalesDomain) obj;
		if (Plaque != other.Plaque)
			return false;
		if (customername == null) {
			if (other.customername != null)
				return false;
		} else if (!customername.equals(other.customername))
			return false;
		if (id != other.id)
			return false;
		if (moneydelay == null) {
			if (other.moneydelay != null)
				return false;
		} else if (!moneydelay.equals(other.moneydelay))
			return false;
		if (salesprice != other.salesprice)
			return false;
		if (saletime == null) {
			if (other.saletime != null)
				return false;
		} else if (!saletime.equals(other.saletime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customername : " + customername + ", Saletime : " + saletime + ", Moneydelay : " + moneydelay
				+ ", Saleprice : " + salesprice + ", Plaque : " + BuyCarDB.find(Plaque).getPlaque();
	}

}
