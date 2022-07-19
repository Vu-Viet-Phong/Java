package iu.dsa.sach.labs.lab02;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainApp {
    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame("DSA-2020 Baseline App");
                mainFrame.setVisible(true);
            }
        });
    }
}

