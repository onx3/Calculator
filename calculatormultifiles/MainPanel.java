package calculatormultifiles;

import javax.swing.*;

// This create the main panel that holds the other panels containing the various
// buttons of the calculator.
// It includes methods for adding child panels as well as a getter.
public class MainPanel {
    private JPanel mainJPanel;

    MainPanel() {
        mainJPanel = new JPanel();
    }

    // Added a child JPanel to this panel.
    public void addChildPanel(JPanel childPanel){
        mainJPanel.add(childPanel);
    }

    // Getter 
    public JPanel getJPanel(){
        return(mainJPanel);
    }

}


