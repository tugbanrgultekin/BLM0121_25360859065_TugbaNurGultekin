package com.bank.app.accounts;
import com.bank.app.cards.KrediKarti; // KrediKarti class'ından kullanılmak istenen parametreler için bildirim yapılıyor.

public class VadesizHesap extends BankaHesabi{ // BankaHesabi'ndan miras alınan VadesizHesap sınıfı oluşturuluyor.
private String hesapTuru;
	
	public VadesizHesap(double bakiye) { // VadesizHesap sınıfının parametreli constructor'ı.
		super(bakiye);
	}
	//-----------GETTER/SETTER METHODLAR----------yukarıda verilen parametrenin getter ve setter metodları.
	public String getHesapTuru() {
		return hesapTuru;
	}
	public void setHesapturu(String hesapTuru) {
		this.hesapTuru=hesapTuru;
	}
	//-------------------------------------------------
	public void paraTransferi(BankaHesabi aliciHesap, BankaHesabi gonderenHesap, double miktar) { // Hesaplar arası para transferi yapılıyor.
		if(gonderenHesap.getBakiye()>miktar || gonderenHesap.getBakiye()==miktar ) { // Gönderen hesabın bakiyesi gönderilmek istenen miktara eşit veya ondan büyükse transfer yapılabilyor.
			double yeniBakiyeG=gonderenHesap.getBakiye()-miktar; // Gönderen hesaptan miktar kadar azaltma yapılıp yeni bakiyeye eşitleniyor.
			gonderenHesap.setBakiye(yeniBakiyeG);
			double yeniBakiyeA=aliciHesap.getBakiye()+miktar; // Alıcı hesaba miktar kadar ekleme yapılıp yeni bakiyeye eşitleniyor.
			aliciHesap.setBakiye(yeniBakiyeA);
		}else { // Bakiye ya yeterlidir ya da yetersizdir 3. bir ihtimal yok o yüzden else kullanılıyor.
			System.out.println("Hesapta bulunan bakiye yetersiz!");
		}
	}
	public void krediKartiBorcOdeme(KrediKarti kart, double miktar) { // Kart borcu ödeniyor.
		if (this.getBakiye() >= miktar) { // Elde olan bakiye ödenmek istenen borç miktarına eşit veya büyükse ödeme yapılıyor. 
	        this.setBakiye(this.getBakiye() - miktar); // Eldeki bakiyeden ödenen borç kadar düşüş oluyor. 
	        kart.setGuncelBorc(kart.getGuncelBorc() - miktar); // Kalan borç, önceki borçtan ödenen miktar çıkarılarak tekrar hesaplanıyor.
	    }
	}
	@Override//Geçersiz Kılma
	public String toString() { // Bilgiler çıktı olarak veriliyor.
	    return "Hesap IBAN: " + getIban() + 
	           "\nGüncel Bakiye: " + getBakiye() + " TL";
	}
}
