import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Pokoj sypialnia = new Pokoj("Sypialnia",3,3,5);
		Pokoj lazienka = new Pokoj("Lazienka",10,10,10);
		
		PokazDanePokoju(sypialnia);
		PokazDanePokoju(lazienka);
		
		Pokoj pokoj = pobierzPokoj();
		
		try {
			zapiszPokoj(pokoj);
		} catch (Exception e) {
			System.out.println("Blad podczas zapisywania.");
		}
	}
	
	public static void PokazDanePokoju(Pokoj _pokoj) throws Exception
	{
		double _kosztMalowania, _kosztPodlogi;
		System.out.println("Pokoj: \t" + _pokoj.Nazwa);
		System.out.println("Dlugosc: \t" + _pokoj.Dlugosc);
		System.out.println("Szerokosc: \t" + _pokoj.Szerokosc);
		System.out.println("Wysokosc: \t" + _pokoj.Wysokosc);
		System.out.println("Objetosc: \t" + _pokoj.Objetosc());
		System.out.println("Pole scian: \t" + _pokoj.PowierzchnieScian());
		System.out.println("Pole podlogi: \t" + _pokoj.PowierzchniePodlogi());
		System.out.println("Podaj koszt malowania za metr kw: ");
		_kosztMalowania = pobierzDouble();
		
		
		try{
			System.out.println("Koszt malowania = \t" + _pokoj.PobierzKosztMalowania(_kosztMalowania));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("Podaj koszt podlogi za metr kw: ");
		_kosztPodlogi = pobierzDouble();
		try{
			System.out.println("Koszt podlogi = \t" + _pokoj.PobierzKosztPodlogi(_kosztPodlogi));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static String pobierzString()
    {
    	String x = "";
    	while (x.trim().equals("")){
    		System.out.println("Wprowadz string");
    		if(sc.hasNextLine())
    			x = sc.nextLine();
    	}
    	return x;
    }

	public static Pokoj pobierzPokoj(){
		System.out.println("Nazwa pokoju: ");
		String nazwa = pobierzString();
		System.out.println("Wysokosc: ");
		double wysokosc = pobierzDouble();
		System.out.println("Szerokosc: ");
		double szerokosc = pobierzDouble();
		System.out.println("Dlugosc: ");
		double dlugosc = pobierzDouble();
		
		
		return new Pokoj(nazwa, dlugosc, szerokosc, wysokosc);
	}
	public static Double pobierzDouble()
	{
		Double x = -1.0;
		while (x<0){
			System.out.println("Provide non-negative number");
			x = sc.nextDouble();
		}
		return x;
	}
	
	public static void zapiszPokoj(Pokoj pokoj){
		BufferedWriter wr = null;

		try
		{
		    wr = new BufferedWriter( new FileWriter(pokoj.Nazwa+".txt"));
		    wr.write("Nazwa: " + pokoj.Nazwa + "\t");
		    wr.write("Dlugosc: " + pokoj.Dlugosc+ "\t");
		    wr.write("Szerokosc: " + pokoj.Szerokosc+ "\t");
		    wr.write("Wysokosc: " + pokoj.Wysokosc);
		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( wr != null)
		        wr.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
	}

}




