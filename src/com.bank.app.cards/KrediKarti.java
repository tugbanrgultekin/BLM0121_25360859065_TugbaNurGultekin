package com.bank.app.cards;

public class KrediKarti {
	private String kartNumarasi;
	private double limit;
	private double guncelBorc;
	private double kullanilabilirLimit;
	
	public KrediKarti(double limit, double guncelBorc) { // KrediKarti sınıfının parametreli constructor'ı.
		this.limit=limit;
		this.guncelBorc=guncelBorc;
	}
	//------------GETTER/SETTER METHODLAR----------yukarıdaki parametrelerin getter ve setter methodları.
	public String getKartNumarasi() {
		return kartNumarasi;
	}
	public void setKartNumarasi(String kartNumarasi) {
		this.kartNumarasi=kartNumarasi;
	}
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit=limit;
	}
	public double getGuncelBorc() {
		return guncelBorc;
	}
	public  void setGuncelBorc(double guncelBorc) {
		this.guncelBorc=guncelBorc;
	}
	public double getKullanilabilirLimit() {
		return kullanilabilirLimit;
	}
	public void setKullanilabilirLimit(double kullanilabilirLimit) {
		this.kullanilabilirLimit=kullanilabilirLimit;
	}
	//------------------------------------------------------------
	@Override //Geçersiz Kılma
	public String toString() { // Bilgileri çıktı olarak ekrana veriyor.
	    return "Kredi Kartı No: " + kartNumarasi + 
	           "\nLimit: " + limit + 
	           "\nGüncel Borç: " + guncelBorc;
	}
}
