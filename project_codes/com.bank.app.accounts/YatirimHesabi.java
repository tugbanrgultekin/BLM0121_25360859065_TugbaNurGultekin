package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi{ // BankaHesabi sınıfından miras alan YatirimHesabi sınıfı oluşturuluyor.
private String hesapTuru;
	
	public YatirimHesabi(double bakiye) { // YatirimHesabi sınıfının parametreli constructor'ı.
		super(bakiye);
	}
	//-----------GETTER/SETTER METHODLAR--------yukarıdaki parametrenin getter ve setter methodları.
	public String getHesapTuru() {
		return hesapTuru;
	}
	public void setHesapturu(String hesapturu) {
		this.hesapTuru=hesapTuru;
	}
	//------------------------------------------------
	public void paraEkle(double miktar) { // Bakiyeye para ekleme işlemi yapılıyor.
		setBakiye(getBakiye()+miktar); // Bakiyeye miktar kadar para eklenip yeni bakiye oluşturuluyor.
	} 
	public void paraCek(double miktar) { // Bakiyeden para çıkarma işlemi yapılıyor. 
		if (getBakiye() >= miktar) { 
	        setBakiye(getBakiye() - miktar);// Bakiyeden miktar kadar para çıkarılıp yeni bakiye oluşturuluyor.
	    }
	}
	@Override//Geçersiz Kılma
	public String toString() { // Bilgiler ekrana çıktı olarak veriliyor.
	    return "Hesap IBAN: " + getIban() + 
	           "\nGüncel Bakiye: " + getBakiye() + " TL";
	}
}
