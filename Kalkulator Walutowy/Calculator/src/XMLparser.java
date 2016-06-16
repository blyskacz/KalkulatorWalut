import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLparser 
{
	public String currencyURL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist-90d.xml";
	ArrayList<Currency> currency = new ArrayList<Currency>();
	public String metalURL = "http://www.xmlcharts.com/cache/precious-metals.php";
	ArrayList<Metal> metal = new ArrayList<Metal>();
	public String GPWURL = "http://www.money.pl/gielda/indeksy_gpw";
	ArrayList<GPW> GPW = new ArrayList<GPW>();
	
	public void download(String file, String type)
	{
		String currURL = "";
		if(type.equals("metal"))
		{
			currURL = this.metalURL;
		}
		else if(type.equals("currency"))
		{
			currURL = this.currencyURL;
		}
		else if(type.equals("gpw"))
		{
			currURL = GPWURL;
		}
		
	    URL cURL;
	    URLConnection cConnection;
	    BufferedReader cReader;
	    String sLine;
	    StringBuilder cResponse;
	    String sResponse = null;

	    try
	    {
	        cURL = new URL(currURL);
	        cConnection = cURL.openConnection();
	        cReader = new BufferedReader(new InputStreamReader(cConnection.getInputStream()));
	        cResponse = new StringBuilder();

	        while((sLine = cReader.readLine()) != null)
	        {
	            cResponse.append(sLine);
	        }

	        sResponse = cResponse.toString();
	        
	        FileWriter fw;
			try 
			{
				fw = new FileWriter(file);
				fw.write(sResponse);
			    fw.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	
	public void downloadCurrency()
	{
	    this.download("backup.xml", "currency");
	}
	
	public void updateCurrency()
	{
	
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("backup.xml");
			NodeList nList = doc.getElementsByTagName("Cube");
			NodeList elem = nList.item(0).getChildNodes();
			for(int k = 0;k<elem.getLength();k++)
			{
				Node temp = elem.item(k);
				//System.out.println("data");
				Element eElement2 = (Element) temp;
				String time = eElement2.getAttribute("time");
				//System.out.println(time);
				NodeList elem2 = temp.getChildNodes();
				for(int i = 0;i<elem2.getLength();i++)
				{
					Node temp3 = elem2.item(i);
					if (temp3.getNodeType() == Node.ELEMENT_NODE) 
					{
						Element eElement = (Element) temp3;
						if(k==0)
						{
							this.currency.add(new Currency("nazwa", time, eElement.getAttribute("currency")));
						}
						this.currency.get(i).rates.add(new Rate(Double.parseDouble(eElement.getAttribute("rate")), time));
						//System.out.println(eElement.getAttribute("currency")+":"+eElement.getAttribute("rate"));
					}
				}
			}
                        currency.add(new Currency("nazwa", "update", "EUR"));
                        ArrayList <Rate> rates = currency.get(0).rates;
                        for(int i=0; i<rates.size(); i++)
                        currency.get(currency.size()-1).rates.add(new Rate(1.0, rates.get(i).date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void downloadMetal()
	{
		this.download("metal.xml", "metal");
	}

	public void updateMetal()
	{
		try {
			 
		    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("metal.xml");
			NodeList nList = doc.getElementsByTagName("currency");
			for(int k = 0;k<nList.getLength();k++)
			{
				Node temp = nList.item(k);
				Element eElement2 = (Element) temp;
				if(!eElement2.getAttribute("access").equals("eur")) continue;
				NodeList elem2 = temp.getChildNodes();
				for(int i = 0;i<elem2.getLength();i++)
				{
					Node temp3 = elem2.item(i);
					if (temp3.getNodeType() == Node.ELEMENT_NODE) 
					{
						Element eElement = (Element) temp3;
						this.metal.add(new Metal(eElement.getAttribute("access").toUpperCase(), "update", Double.parseDouble(eElement.getTextContent())));
					}
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void downloadGPW()
	{
		this.download("gpw.html", "gpw");
	}
	
	public void updateGPW() 
	{
		File in = new File("gpw.html");
		org.jsoup.nodes.Document doc = null;
                try {
                    doc = Jsoup.parse(in, null);
                } catch (IOException ex) {
                    Logger.getLogger(XMLparser.class.getName()).log(Level.SEVERE, null, ex);
                }
		
		Elements content = doc.getElementsByClass("tabela");
		Elements links = content.get(0).getElementsByTag("tr");

		for (int i=2;i<7;i++) 
		{
		    Elements curr = links.get(i).getElementsByTag("td");
		    String curr1 = curr.get(7).text().replace(",", ".");
		    String curr2 = curr.get(8).text().replace("+", "");
		    curr2 = curr2.replace(",", ".");
                    double tmp;
                    if(curr2.equals("-"))
                        tmp=0;
                    else
                        tmp=Double.parseDouble(curr2);
                    
		    this.GPW.add(new GPW(curr.get(1).text(), curr.get(13).text(), Double.parseDouble(curr1), tmp)); 
		}
	}
}