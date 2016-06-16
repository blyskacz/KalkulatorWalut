import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		XMLparser xml = new XMLparser();
		xml.downloadCurrency();
		xml.updateCurrency();
		
		ArrayList<Currency> r = xml.currency;
		
		for(int i = 0;i<r.size();i++)
		{
			System.out.println(r.get(i).update+" "+r.get(i).tag);
			for(int k=0;k<r.get(i).rates.size();k++)
			{
				System.out.println(r.get(i).rates.get(k).date+" "+r.get(i).rates.get(k).rate);
			}
		}
		
		xml.downloadMetal();
		xml.updateMetal();
		
		ArrayList<Metal> m = xml.metal;
		
		for(int i = 0;i<m.size();i++)
		{
			System.out.println(m.get(i).name+" : "+m.get(i).current);
		}
		
	}

}
