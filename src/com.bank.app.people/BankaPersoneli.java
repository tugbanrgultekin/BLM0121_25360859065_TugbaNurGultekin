package com.bank.app.people;
import java.util.Random;
import java.util.ArrayList; // ArrayList kütüphanesi

public class BankaPersoneli extends Kisi{ // Kisi sınıfından miras alınarak BankaPersoneli sınıfı oluşturuluyor.
	private String personalID;
	private ArrayList<Musteri> musteriler; // musteriler adında yeni bir liste oluşturuluyor.

	
	public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi){
		super(ad,soyad,email,telefonNumarasi); // super() ile miras alınan sınıf içerisindeki parametreler çekiliyor.
	}
	//------------GETTER/SETTER METHODLAR------yukarıdaki parametrelerin getter ve setter methodalrı.
	public ArrayList<Musteri> getMusteriler() {
	    return musteriler;
	}
	public void setMusteriler(ArrayList<Musteri> musteriler) {
	    this.musteriler=musteriler;
	}
	public String getPersonalID() {
		return personalID;
	}
	public void setPersonalId(String personalID) {
		this.personalID=personalID;
	}
	//--------------------------------------------------
	@Override//Geçersiz Kılma
	public String toString() { // Bilgiler çıktı olarak veriliyor.
	    return "Personel: " + getAd() + " " + getSoyad() + 
	           "\nPersonel ID: " + getPersonalID();
	}
}
