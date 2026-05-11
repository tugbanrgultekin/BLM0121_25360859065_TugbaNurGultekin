package com.bank.app.accounts;

public class BankaHesabi {
	private String iban;
	private double bakiye;
	
	public BankaHesabi(double bakiye){
		this.bakiye=bakiye;
		
		long rastgeleIban = (long)(Math.random() * 9000000000L) + 1000000000L; // Math.random() ile rastgele IBAN ataması yapılıyor.
	    this.iban = "TR" + rastgeleIban;
	}
	//-----------GETTER/SETTER METHODLAR-------yukarıdaki parametrelerin getter ve setter methodları.
	public double getBakiye() {
		return bakiye;
	}
	public void setBakiye(double bakiye) {
		this.bakiye=bakiye;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban=iban;
	}
	//-------------------------------------------------
	@Override//Geçersiz Kılma
	public String toString() { // Bilgiler ekrana çıktı olarak veriliyor.
		return "bakiye";
	}
}
