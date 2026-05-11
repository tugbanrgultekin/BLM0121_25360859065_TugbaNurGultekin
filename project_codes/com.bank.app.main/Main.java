package com.bank.app.main;

import com.bank.app.service.BankaService; 
import com.bank.app.people.Musteri;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

public class Main {
    public static void main(String[] args) {
       
        BankaService servis = new BankaService(); // Banka servisini başlatıyor.

        
        servis.musteriOlustur("Tuğba Nur", "Gültekin", "tugbanrgultekin@gmail.com", 53156789); // Müşteri oluşturma
        Musteri m1 = servis.getMusteriler().get(0); // Müşteriler listesine m1 adında yeni bir müşteri ekliyor.
        
        System.out.println("\n==== MÜŞTERİ BİLGİLERİ ====");
        System.out.println(m1.toString()); // m1 müşterisinin müşteri bilgilerini yazdırıyor.

        System.out.println("\n====MÜŞTERİ ADINA HESAP AÇMA====");
        System.out.println("Hesap Açıldı.");
        servis.hesapAc(m1, "Vadesiz"); //Müşteri adına hesap açma
        servis.hesapAc(m1, "Yatırım");
        
       
        VadesizHesap vadesizHesap = (VadesizHesap) m1.getHesaplar().get(0);  // Açılan hesapları rahat kullanmak için değişkenlere atıyor.
        YatirimHesabi yatirimHesabi = (YatirimHesabi) m1.getHesaplar().get(1);

        System.out.println("\n====HESABA PARA YATIRMA===="); 
        System.out.println("HESAP KULLANIMA HAZIR.");
        servis.paraYatir(vadesizHesap, 100000.0); // Hesaba para yatırma

        System.out.println("\n====HESAPLAR ARASI TRANSFER====");
        System.out.println("Transfer yapıldı.");
        System.out.println("Transfer Öncesi Vadesiz Bakiye: " + vadesizHesap.getBakiye()); 
        System.out.println("Transfer Öncesi Yatırım Bakiye: " + yatirimHesabi.getBakiye());
        
        
        servis.transferYap(vadesizHesap, yatirimHesabi, 50000.0);// Hesaplar arasında para transferi gerçekleştirme
        
        System.out.println("Transfer Sonrası Vadesiz Bakiye: " + vadesizHesap.getBakiye());
        System.out.println("Transfer Sonrası Yatırım Bakiye: " + yatirimHesabi.getBakiye());

        System.out.println("\n====MÜŞTERİYE KREDİ KARTI TANIMLAMA====");
        servis.krediKartiTanimla(m1, 200000.0); // Müşteriye kredi kartı tanımlama
        KrediKarti kart = m1.getKrediKartlari().get(0);

        System.out.println("\n====KREDİ KARTI BORCU ÖDEME====");
        
        kart.setGuncelBorc(8000.0); // Kredi kartı borcu ödeme işlemi yapma
        System.out.println("Ödenmeden Önce Kart Borcu: " + kart.getGuncelBorc()); 
        
        
        servis.borcOde(vadesizHesap, kart, 3000.0);
        System.out.println("Ödeme Sonrası Kart Borcu: " + kart.getGuncelBorc());
        System.out.println("Ödeme Sonrası Vadesiz Bakiye: " + vadesizHesap.getBakiye());

        System.out.println("\n====HESAP SİLME İŞLEMİ====");
        
        System.out.println("Dolu hesabı silme denemesi:"); // İçinde para olan yatırım hesabını silmeye çalışıyor, uyarı vericek.
        servis.hesapSil(m1, yatirimHesabi); // Gerekli şartlar sağlandığında hesap silme işlemi gerçekleştirme
        
       
        System.out.println("\nBakiye sıfırlandıktan sonra silme denemesi:"); // Yatırım hesabının bakiyesini 0 yapıp tekrar silme işlemi yapıyor, silecek.
        yatirimHesabi.setBakiye(0); // Yatırım hesabı içerisindeki bakiyeyi sıfır yapıp siliyor.
        servis.hesapSil(m1, yatirimHesabi);

        
    }
}