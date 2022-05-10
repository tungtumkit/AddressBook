package Main;
import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.UIManager.LookAndFeelInfo;

public class App {
    public App() {
        AppWindow Window = new AppWindow();
        
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.setVisible(true);
    }
 
    public static void main(String [] agrs) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Unable to set LookAndFeel.");
        }
        
        new App();
    }
}
