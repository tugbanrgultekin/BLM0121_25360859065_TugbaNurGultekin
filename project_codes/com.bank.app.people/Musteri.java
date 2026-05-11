package com.bank.app.people;
import com.bank.app.cards.KrediKarti; //Bu sınıfta kullanmam gereken elemanlar bildiriliyor.
import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;

import java.util.ArrayList; //ArrayList kütüphanesi

public class Musteri extends Kisi{ // Kisi sınıfının içindeki parametreleri içeren Musteri sınıfı oluşturuluyor.
	private String musteriNumarasi;
	private ArrayList<BankaHesabi> hesaplar;
	private ArrayList<KrediKarti> krediKartlari;
	
	
	public Musteri(String ad, String soyad, String email, int telefonNumarasi) { // Musteri sınıfının parametreli constructor'ı yazılıyor.
		super(ad,soyad,email,telefonNumarasi); // super() ile yukarıda yaptığımız miraslamadan parametreler çağırılıyor.
		int rastgeleNo = (int)(Math.random() * 900000) + 100000; // Math.random() ile raporda verildiği gibi rastgele numara atamaları yapılıyor.
	    this.musteriNumarasi = "M" + rastgeleNo;
		this.hesaplar = new ArrayList<>(); // Yeni bir  hesaplar listesi oluşturuldu, işlemleri bu liste üzerinden yapacağız.
	    this.krediKartlari = new ArrayList<>(); //Yeni bir  krediKartlari listesi oluşturuldu, işlemleri bu liste üzerinden yapacağız.
	}
	//-------------GETTER/SETTER METHODALR-------------- yukarıdaki parametrelere ait getter ve setter methodları yazılıyor.
	public ArrayList<BankaHesabi> getHesaplar() {
	    return hesaplar;
	}
	public void setHesaplar(ArrayList<BankaHesabi> hesaplar) {
	    this.hesaplar = hesaplar;
	}
	public ArrayList<KrediKarti> getKrediKartlari() {
	    return krediKartlari;
	}
	public void setKrediKartlari(ArrayList<KrediKarti> krediKartlari) {
	    this.krediKartlari=krediKartlari;
	}
	public String getMusteriNumarasi() {
		return musteriNumarasi;
	}
	public void setMusteriNumarasi(String musteriNumarasi) {
		this.musteriNumarasi=musteriNumarasi;
	}
	//---------------------------------------------------
	public void hesapEkle(String hesapTuru) {// Eklemek istenilen hesapTuru parametresi ile hesap ekleniyor.
		if("Vadesiz".equalsIgnoreCase(hesapTuru)) { // Kullandığım .equalsIgnoreCase kullanıcının girdiği herhangi büyük veya küçük harfi aynı algılayacak.
			hesaplar.add(new VadesizHesap(0.0)); // Kullanıcının girdiği hesap türü "Vadesiz Hesap" ise, 0.0 bakiyeli yeni bir  Vadesiz hesap oluşturuluyor.
		}else if("Yatirim".equalsIgnoreCase(hesapTuru)) {
			hesaplar.add(new YatirimHesabi(0.0)); // Kullanıcının girdiği hesap türü "Yatırım Hesabı" ise, 0.0 bakiyeli yeni bir  Yatırım Hesabı oluşturuluyor.
		}
	
	}
	public void krediKartiEkle(double limit) { // Kullanıcı kredi kartını bu method ile ekliyor. Limit: içerisinde bulunması istenen para miktarı.
		KrediKarti yeniKart = new KrediKarti(limit,0.0);
		krediKartlari.add(yeniKart);
	}
	public void hesapSil(BankaHesabi hesap) { // BankaHesabi türünden oluşturulan hesap siliniyor.
		if(hesap.getBakiye()>0) {// Hesaptaki bakiye sıfırdan büyükse uyarı veriliyor.
			System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
		}else if(hesap.getBakiye()==0) {//Hesaptaki bakiye sıfıra eşitse silme işlemi gerçekleştiriliyor.
			hesaplar.remove(hesap);
			System.out.println("Hesabınız başarıyla silindi.");
		}
	}
	public void krediKartiSil(KrediKarti kart) { // KrediKarti türünden kart siliniyor.
		if(kart.getGuncelBorc()>0) { // Kart içerisindeki borç sıfırdan büyükse uyarı veriliyor.
			System.out.println("Lütfen öncelikle borç ödemesini yapınız.");
		}else if(kart.getGuncelBorc()==0) { // Kart içerisindeki borç sıfıra eşitse silme işlemi gerçekleştiriliyor.
			krediKartlari.remove(kart);
			System.out.println("Kredi kartınız başarıyla silinmiştir.");
		}
	}
	@Override//Geçersiz Kılma
	public String toString() {// Kullanıcının bütün bilgileri veriliyor.
	    return "Müşteri Bilgileri:\n" +
	           "Ad Soyad: " + getAd() + " " + getSoyad() + "\n" +
	           "Müşteri Numarası: " + musteriNumarasi + "\n" +
	           "E-mail: " + getEmail() + "\n" +
	           "Telefon: " + getTelefonNumarasi();
	}
}
