package iu.dsa.sach.labs.lab02;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class WorkingPanel extends JPanel
    implements MouseMotionListener, MouseListener, ItemListener, ActionListener {
    
    public WorkingPanel() {
        this.setBorder(BorderFactory.createEtchedBorder()); 
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        String message = String.format("mouseDragged: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        String message = String.format("mouseMoved: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if ((e.getClickCount() == 2) && !e.isConsumed()) {
            String message = String.format("Mouse Double Clicked: (x,y)=(%d,%d)", e.getX(), e.getY());
            MainFrame.infoPanel.println(message);
            e.consume();
        } else {
            String message = String.format("Mouse Clicked: (x,y)=(%d,%d)", e.getX(), e.getY());
            MainFrame.infoPanel.println(message);
        }   
    }

    @Override
    public void mousePressed(MouseEvent e) {
        String message = String.format("mousePressed: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        String message = String.format("mouseReleased: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        String message = String.format("mouseEntered: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        String message = String.format("mouseExited: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        if (state == ItemEvent.SELECTED) {
            MainFrame.infoPanel.println("Selected");
            MainFrame.btnSelect.setText("Selecting");
        } else {
            MainFrame.infoPanel.println("DeSelected");
            MainFrame.btnSelect.setText("Drawing");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MainFrame.btnCircle) {
            MainFrame.infoPanel.println("action: draw Circle");
        } else if (e.getSource() == MainFrame.btnRect) {
            MainFrame.infoPanel.println("action: draw Rect");
        } else {}
    }
}

