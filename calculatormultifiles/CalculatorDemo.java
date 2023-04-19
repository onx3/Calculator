package calculatormultifiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;   
import java.util.Map;
import java.util.HashMap;
   // import the List class


/**
 * CalculatorDemo0, an example of student implementation that received full credit
 */
public class CalculatorDemo extends JFrame implements ActionListener{
    /**
     * @author Metsis, Tesic, Steckler
     */
    JButton addButton, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, Delete, CE, C, div,
            sqrt, mul, pow, sub, prop, pm, dot, eq;
    JTextField mainTextField;
    double result = 0, n1 = 0;
    ManagementPanel mgntPanel;
    MainPanel mainPanel;
    List<JButton> mgntButtons; 

    PanelButtons corePanel;
    ThirdLine thirdPanel;
    FourthLine fourthPanel;
    FifthLine fifthPanel;

    List<JButton> coreButtons;
    List<JButton> thirdButtons;
    List<JButton> fourthButtons;
    List<JButton> fifthButtons;


    //Mark the first number for easy calculation
    int first = 1;

    //First number for percentage calculation
    double num;

    //Flag for appending digits or starting a new number
    /*1->Appending a digit to the existing number
      2->Taking a new number as input*/
    int opt = 2;

    //Flag to mark binary operation for '=' button
    /*0->No Operation
      1->Addition
      2->Subtraction
      3->Division
      4->Multiplication*/
    int eqFlag1 = 0 , eqFlag2 = 0;

    CalculatorDemo() {
        setTitle("Calculator");
        setSize(400,300);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }


    void initComponents() {
        mainTextField = new JTextField(32);
        mainTextField.setText("0");
        add(mainTextField, BorderLayout.NORTH);
        mainTextField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        // Create main panel that will hold all the buttons and add it to the Java Frame
        mainPanel = new MainPanel();
        JPanel mainJPanel = mainPanel.getJPanel();
        add(mainJPanel,BorderLayout.CENTER);

        // Create the management button panel and add it to Main Panel
        mgntPanel = new ManagementPanel();
        corePanel = new PanelButtons();
        thirdPanel = new ThirdLine();
        fourthPanel = new FourthLine();
        fifthPanel = new FifthLine();
        
        JPanel mgntJPanel = mgntPanel.getJPanel();
        JPanel coreJPanel = corePanel.getJPanel();
        JPanel thirdJPanel = thirdPanel.getJPanel();
        JPanel fourthJPanel = fourthPanel.getJPanel();
        JPanel fifthJPanel = fifthPanel.getJPanel();

        mainPanel.addChildPanel(mgntJPanel);
        mainPanel.addChildPanel(coreJPanel);
        mainPanel.addChildPanel(thirdJPanel);
        mainPanel.addChildPanel(fourthJPanel);
        mainPanel.addChildPanel(fifthJPanel);
        
        // Create the management buttons.
        mgntButtons = mgntPanel.createButtons(this);
        coreButtons = corePanel.createButtons(this);
        thirdButtons = thirdPanel.createButtons(this);
        fourthButtons = fourthPanel.createButtons(this);
        fifthButtons = fifthPanel.createButtons(this);

        for (JButton button : mgntButtons) {
            if (button.getText() == "C")
                C = button;
                if (button.getText() == "CE")
                    CE = button;
                if (button.getText() == "Delete")
                    Delete = button;
        }

        //coreJPanel.setLayout(new GridLayout(4,3));
        for(JButton button: coreButtons){
            if (button.getText() == "7")
                b7 = button;
                if (button.getText() == "8")
                    b8 = button;
                if (button.getText() == "9")
                    b9 = button;
                if (button.getText() == "/")
                    div = button;
                if (button.getText() == "x^2")
                    pow = button;
        }
        for (JButton button : thirdButtons) {
            if (button.getText() == "4")
                b4 = button;
                if (button.getText() == "5")
                    b5 = button;
                if (button.getText() == "6")
                    b6 = button;
                if (button.getText() == "*")
                    mul = button;
                if (button.getText() == "1/x")
                    prop = button;
        }
        for (JButton button : fourthButtons) {
            if (button.getText() == "1")
                b1 = button;
                if (button.getText() == "2")
                    b2 = button;
                if (button.getText() == "3")
                    b3 = button;
                if (button.getText() == "-")
                    sub = button;
                if (button.getText() == "+/-")
                    pm = button;
        }
        for (JButton button : fifthButtons) {
            if (button.getText() == "0")
                b0 = button;
                if (button.getText() == ".")
                    dot = button;
                if (button.getText() == "sqrt")
                    sqrt = button;
                if (button.getText() == "+")
                     addButton = button;
                if (button.getText() == "=")
                    eq = button; 
        }
    }
    //Method when ActionListener calls its corresponding routine
    public void actionPerformed(ActionEvent evt) {
        String str;
        
        Map<JButton, Integer> buttonToEqFlag = new HashMap<>();
        buttonToEqFlag.put(addButton, 1);
        buttonToEqFlag.put(sub, 2);
        buttonToEqFlag.put(div, 3);
        buttonToEqFlag.put(mul, 4);

        // Check which button was clicked
        JButton clickedButton = (JButton) evt.getSource();
        Integer eqFlag = buttonToEqFlag.get(clickedButton);
        if (eqFlag != null) {
            if (first == 1) {
             result = num = Double.parseDouble(mainTextField.getText());
             eqFlag1 = eqFlag;
            } 
            else {
                n1 = Double.parseDouble(mainTextField.getText());
                eqFlag2 = eqFlag;
    }
    Switcher();
}
        else if(evt.getSource() == eq) {
            double n1=Double.parseDouble(mainTextField.getText());
            if(eqFlag1  ==  1)
                result = result + n1;
            else if(eqFlag1  ==  2)
                result = result - n1;
            else if(eqFlag1  ==  3)
                result = result / n1;
            else if(eqFlag1  ==  4)
                result = result * n1;
            else
                result = Double.parseDouble(mainTextField.getText());
            num = result;
            str = String.valueOf(result);
            mainTextField.setText(str);
        }

        //Action Corresponding to +/- button 
        else if(evt.getSource()  ==  pm) {
            double n1 = Double.parseDouble(mainTextField.getText());
            n1 = -n1;
            str = String.valueOf(n1);
            mainTextField.setText(str);
        }

        //Action Corresponding to 0 button
        else if(evt.getSource()  ==  b0) {
            if(opt  ==  1)
                str = String.valueOf(mainTextField.getText())+0;
            else
                str = " " + 0;
            opt = 1;
            mainTextField.setText(str);

        }

        //Action Corresponding to 1 button
        else if(evt.getSource()  ==  b1) {
            if(opt  ==  1)
                str = String.valueOf(mainTextField.getText())+1;
            else
                str = " " + 1;
            opt = 1;
            mainTextField.setText(str);

        }

        //Action Corresponding to 2 button
        else if(evt.getSource()  ==  b2) {
            if(opt  ==  1)
                str = String.valueOf(mainTextField.getText())+2;
            else
                str = " " + 2;
            opt = 1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 3 button
        else if(evt.getSource()  ==  b3) {
            if(opt  ==  1)
                str = String.valueOf(mainTextField.getText()) + 3;
            else
                str = " " + 3;
            opt = 1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 4 button
        else if(evt.getSource()  ==  b4) {
            if(opt  ==  1)
                str = String.valueOf(mainTextField.getText()) + 4;
            else
                str=String.valueOf(" ") + 4;
            opt = 1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 5 button
        else if(evt.getSource()  ==  b5) {
            if(opt  ==  1)
                str = String.valueOf(mainTextField.getText()) + 5;
            else
                str = " " + 5;
            opt = 1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 6 button
        else if(evt.getSource()  ==  b6) {
            if(opt  ==  1)
                str = String.valueOf(mainTextField.getText()) + 6;
            else
                str= " " + 6;
            opt = 1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 7 button
        else if(evt.getSource()  ==  b7) {
            if(opt  ==  1)
                str=String.valueOf(mainTextField.getText())+7;
            else
                str=String.valueOf(" ")+7;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 8 button
        else if(evt.getSource() == b8) {
            if(opt == 1)
                str=String.valueOf(mainTextField.getText())+8;
            else
                str=String.valueOf(" ")+8;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 9 button
        else if(evt.getSource() == b9) {
            if(opt == 1)
                str=String.valueOf(mainTextField.getText())+9;
            else
                str=String.valueOf(" ")+9;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to Delete button
        else if(evt.getSource() == Delete) {
            int len;
            str= mainTextField.getText();
            len=str.length();
            if(len>=1)
                str=str.substring(0,len-1);
            mainTextField.setText(str);
        }

        //Action Corresponding to CE button
        else if(evt.getSource() == CE) {
            result=0;
            first=1;
            opt=2;
            str=String.valueOf('0');
            mainTextField.setText(str);

        }

        //Action Corresponding to C button
        else if(evt.getSource() == C) {
            result=0;
            first=1;
            opt=2;
            mainTextField.setText("0");
        }

        //Action Corresponding to . button
        else if(evt.getSource() == dot) {
            str=String.valueOf(mainTextField.getText())+".";
            mainTextField.setText(str);
        }

        //Action Corresponding to 1/x button
        else if(evt.getSource() == prop) {
            double n1=Double.parseDouble(mainTextField.getText());
            n1=1/n1;
            str=String.valueOf(n1);
            mainTextField.setText(str);
        }

        //Action Corresponding to sqrt button
        else if(evt.getSource() == sqrt) {
            double n1=Double.parseDouble(mainTextField.getText());
            n1=Math.sqrt(n1);
            str=String.valueOf(n1);
            mainTextField.setText(str);
        }

        //Action Corresponding to x^2 button
        else if(evt.getSource() == pow) {
            double n1=Double.parseDouble(mainTextField.getText());
            n1=Math.pow(n1,2);
            str=String.valueOf(n1);
            mainTextField.setText(str);
        }

    }

    private void Switcher() {
        switch(eqFlag1) {
            case 1:add1();
                break;
            case 2:sub();
                break;
            case 3:div();
                break;
            case 4:mul();
                break;
        }
    }

    //Add called according to previous operator
    void add1() {
        if(first == 0)
            result = num = result + n1;
        String str = String.valueOf(result);
        mainTextField.setText(str);
        opt = 2;
        if(eqFlag2 != 0) {
            eqFlag1 = eqFlag2;
            eqFlag2 = 0;
        }
        first = 0;
    }

    //Sub called according to previous operator
    void sub() {
        if(first == 0)
            result = num = result - n1;
        String str = String.valueOf(result);
        mainTextField.setText(str);
        opt=2;
        if(eqFlag2 !=0)
            eqFlag1 = eqFlag2;
        first=0;
    }

    //Div called according to previous operator
    void div() {
        if(first == 0) {
            if(n1 == 0)
                mainTextField.setText("Cannot divide by zero");
            else
                result = num = result / n1;
        }
        String str=String.valueOf(result);
        mainTextField.setText(str);
        opt = 2;
        if(eqFlag2 != 0)
            eqFlag1 = eqFlag2;
        first = 0;
    }

    //Mul called according to previous operator
    void mul() {
        if(first == 0)
            result = num = result * n1;
        String str = String.valueOf(result);
        mainTextField.setText(str);
        opt = 2;
        if(eqFlag2 != 0)
            eqFlag1 = eqFlag2;
        first = 0;
    }
    public static void main(String args[]) {
        CalculatorDemo obj = new CalculatorDemo();
        obj.setVisible(true);
    }
}

