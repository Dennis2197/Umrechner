package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;


public class MainView extends JFrame {
    private JTextField userInput;
    private JComboBox<String> selectionMenuInput;
    private JComboBox<String> selectionMenuOutput;

    private JButton button;
    private String[] units;

    public MainView(int width, int height) {
        setSize(width, height);
        setTitle("Einheitenumrechner");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void addUIcomponents() {
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(new EmptyBorder(10, 50, 5, 50));

        centerPanel.add(Box.createVerticalGlue());

        JLabel headlineLabel = new JLabel("Einheitenrechner");
        headlineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(headlineLabel);

        JLabel inputInfoLabel = new JLabel("Geben Sie bitte die umzurechnende Zahl in das Eingabefeld ein:");
        inputInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(inputInfoLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        userInput = new JTextField();
        userInput.setMaximumSize(new Dimension(200, 25));
        userInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(userInput);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel comboBoxInfoLabel = new JLabel("Wählen Sie die Ausgangseinheit");
        comboBoxInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(comboBoxInfoLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        selectionMenuInput = new JComboBox<>(units);
        selectionMenuInput.setMaximumSize(new Dimension(200, 25));
        selectionMenuInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(selectionMenuInput);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel outputComboBoxInfoLabel = new JLabel("Wählen Sie die gewünschte Einheit");
        outputComboBoxInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(outputComboBoxInfoLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        selectionMenuOutput = new JComboBox<>(units);
        selectionMenuOutput.setMaximumSize(new Dimension(200, 25));
        selectionMenuOutput.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(selectionMenuOutput);

        centerPanel.add(Box.createVerticalGlue());

        button = new JButton("Umrechnen");
        bottomPanel.add(button);
    }

    public void addButtonHandler(ActionListener listener){
        button.addActionListener(listener);
    }

    public void showResult(Double result){
        JOptionPane.showMessageDialog(this, getUserInput() + "" + getFirstSelectedItem()
                + " sind umgerechnet " + result + "" + getSecondSelectedItem(), "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setUnits(String[] unitArray){
        units = unitArray;
    }
    public String getFirstSelectedItem(){
        return (String)selectionMenuInput.getSelectedItem();
    }
    public String getSecondSelectedItem(){
        return (String)selectionMenuOutput.getSelectedItem();
    }
    public Double getUserInput(){
        String input = userInput.getText();
        try{
            Double inputDouble = Double.parseDouble(input);
            return inputDouble;
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Bitte geben Sie nur Zahlen ein",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
