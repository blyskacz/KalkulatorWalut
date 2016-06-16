
public class GPW extends Item
{
	public double change;
	public GPW(String name, String update, double current, double change) {
		super(name, update, current);
		this.change = change;
	}
	@Override
	public String toString() 
        {
		return "GPW [change=" + change + ", name=" + name + ", update=" + update + ", current=" + current + "]";
	}
}
