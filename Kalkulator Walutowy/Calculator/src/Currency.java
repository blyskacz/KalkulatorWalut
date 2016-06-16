

import java.util.ArrayList;

class Rate
{
	public double rate;
	public String date;
	public Rate(double rate, String date) {
		this.rate = rate;
		this.date = date;
	}
	
}

public class Currency extends Item
{
	public String tag;
	public ArrayList <Rate> rates = new ArrayList <Rate>();
	
	public Currency(String name, String update, String tag) 
	{
		super(name, update, 0);
		this.tag=tag;
	}

	
}