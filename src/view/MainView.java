package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JTextField userInput;
    private JComboBox selectionMenu;

    public MainView(int width, int height){
        setSize(width, height);
        setTitle("Einheitenumrechner");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        addUIcomponents();
    }

    public void addUIcomponents(){
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

}
