package com.bank.app.people;

public class Kisi { 
	private String ad;
	private String soyad;
	private String email;
	private int telefonNumarasi;
	
	
	public Kisi(String ad, String soyad, String email, int telefonNumarasi){ // Kisi sınıfının parametreli constructor'ı.
		this.ad=ad;
		this.soyad=soyad;
		this.email=email;
		this.telefonNumarasi=telefonNumarasi;
	}
	//-------------GETTER/SETTER METHODALR--------yukarıdaki parametrelerin getter ve setter methodları.
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad=ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad=soyad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public int getTelefonNumarasi() {
		return telefonNumarasi;
	}
	public void setTelefonNumarasi(int telefonNumarasi) {
		this.telefonNumarasi= telefonNumarasi;
	}
	//---------------------------------------------------
	@Override//Geçersiz Kılma
	public String toString() {// Kullanıcının bütün bilgileri veriliyor.
	    return "Kişi Bilgileri:\n" +
	           "Ad Soyad: " + getAd() + " " + getSoyad() + "\n" +
	           "E-mail: " + getEmail() + "\n" +
	           "Telefon: " + getTelefonNumarasi();
	}
}
