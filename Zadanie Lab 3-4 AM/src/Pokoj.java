
public class Pokoj {
	String Nazwa;
	Double Dlugosc;
	Double Szerokosc;
	Double Wysokosc;
	
	public Pokoj(String _nazwa, double _dlugosc, double _szerokosc, double _wysokosc){
		Nazwa = _nazwa;
		Dlugosc = _dlugosc;
		Szerokosc = _szerokosc;
		Wysokosc = _wysokosc;
	}
	
	public Double Objetosc()throws Exception
	{
		if(Dlugosc < 0 || Wysokosc <0 || Szerokosc < 0) throw new Exception("Wymiary pokoju nie zgadzaja sie.");
		return Dlugosc*Szerokosc*Wysokosc; 
	}
	
	public Double PowierzchnieScian() throws Exception{
		if(Dlugosc < 0 || Wysokosc <0 || Szerokosc < 0) throw new Exception("Wymiary pokoju nie zgadzaja sie.");
		return 2 * Szerokosc * Wysokosc + 2 * Dlugosc * Wysokosc; 
	}
	
	public Double PowierzchniePodlogi() throws Exception{
		if(Dlugosc < 0 || Wysokosc <0 || Szerokosc < 0) throw new Exception("Wymiary pokoju nie zgadzaja sie.");
		return Dlugosc * Szerokosc; 
	}
	public Double PobierzKosztMalowania(double _cenaZaM)throws Exception{
		if(_cenaZaM < 0) throw new Exception("Cena za metr mniejsza od 0.");
		return PowierzchnieScian()*_cenaZaM;
	}
	
	public Double PobierzKosztPodlogi(double _cenaZaM)throws Exception{
		if(_cenaZaM < 0) throw new Exception("Cena za metr mniejsza od 0.");
		return PowierzchniePodlogi()*_cenaZaM;
	}
}
