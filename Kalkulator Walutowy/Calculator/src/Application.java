
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Application 
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException 
    {
        UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        Window w = new Window();
        w.setVisible(true);
        
    }
    
}
