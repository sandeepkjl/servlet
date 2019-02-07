package org.example.servlet.model;

public class UserSalary {
	
	private String userId;
	private double basic;
	
	private double hra;
	private double bonus;
	private double pf;
	private double gratuity;
	private double variablePay;
	private double medical;
	
	public UserSalary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getGratuity() {
		return gratuity;
	}

	public void setGratuity(double gratuity) {
		this.gratuity = gratuity;
	}

	public double getVariablePay() {
		return variablePay;
	}

	public void setVariablePay(double variablePay) {
		this.variablePay = variablePay;
	}

	public double getMedical() {
		return medical;
	}

	public void setMedical(double medical) {
		this.medical = medical;
	}

	@Override
	public String toString() {
		return "UserSalary [userId=" + userId + ", basic=" + basic + ", hra=" + hra + ", bonus=" + bonus + ", pf=" + pf
				+ ", gratuity=" + gratuity + ", variablePay=" + variablePay + ", medical=" + medical + "]";
	}
	
	
	

}
