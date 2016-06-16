
public class Calculator 
{
    public double caltulate(Currency c1, Currency c2, double quantity)
    {
        double tmp = 1/c1.rates.get(0).rate;
        double result = (tmp * c2.rates.get(0).rate * quantity);
        return result;
    }
    public double caltulate(double c1, double c2)
    {
        double tmp = 1/c1;
        double result = (tmp * c2);
        return result;
    }
    public double caltulate(Metal m, Currency c)
    {
        return m.current*c.rates.get(0).rate;
    }
}
