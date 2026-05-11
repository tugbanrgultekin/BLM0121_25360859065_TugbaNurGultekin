package com.bank.app.service;
import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.people.BankaPersoneli;
import com.bank.app.people.Kisi;
import com.bank.app.people.Musteri;
import java.util.ArrayList;

public class BankaService {
	private ArrayList<Musteri> musteriler; // musteriler isimli yeni bir Arraylist oluşturuluyor.
	
	public BankaService() {
        this.musteriler = new ArrayList<>(); // BankaService'in parametreli constructor'ı.
    } 
	
	public void musteriOlustur(String ad,String soyad, String email, int telNo) { // Müşteri oluşturmak istendiğinde çalışacak method.
		Musteri yeniMusteri = new Musteri(ad,soyad,email,telNo); // Oluşturulan müşteri yeniMusteri değişkenine aktarılarak musteriler listesine ekleniyor.
		musteriler.add(yeniMusteri);
	}
	public void hesapAc(Musteri musteri, String hesapTuru) { // Hesap açılmak istendiğinde çalıştırılacak method.
		musteri.hesapEkle(hesapTuru); // Kullanıcıdan hangi hesapTuru'nde hesap açmak istediği bilgisini alıyor.
		System.out.println(musteri.getAd() + " için " + hesapTuru + " hesabı oluşturuldu.");
	}
	public void paraYatir(BankaHesabi hesap, double miktar) { // Hesaba para yatırmak istendiğinde çalışacak method.
		double yeniBakiye = hesap.getBakiye()+miktar; // Olan bakiyeye miktar kadar ekleme yapılıyor.
		hesap.setBakiye(hesap.getBakiye()+miktar);
		System.out.println("İşlem başarılı! Güncel Bakiyeniz: " + yeniBakiye);
	}
	public void transferYap(VadesizHesap gonderen, BankaHesabi alici, double miktar) { // Hesaplar arası transfer yapılmak istendiğinde çalışacak method.
		gonderen.paraTransferi(alici, gonderen, miktar);
	}
	public void krediKartiTanimla(Musteri musteri, double limit) { // Kredi kartı tanımlamak istendiğinde çalışacak method.
		musteri.krediKartiEkle(limit); // İçerisinde limit kadar para bulunan kredi kartı tanımlanıyor.
		System.out.println(musteri.getAd() + " için " + limit + " TL limitli kart tanımlandı.");
	}
	public void borcOde(VadesizHesap hesap, KrediKarti kart, double miktar) { // Borç ödemek istendiğinde çalışacak method.
		hesap.krediKartiBorcOdeme(kart, miktar);
	}
	public void hesapSil(Musteri musteri, BankaHesabi hesap) { // Hesap silinmek istendiğinde çalışacak method.
		musteri.hesapSil(hesap);
	}
	public ArrayList<Musteri> getMusteriler() { // Yukarıdaki parametrenin getter methodu.
        return musteriler;
    }
}
