package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JTextField userInput;
    private JComboBox<String> selectionMenuInput;
    private JComboBox<String> selectionMenuOutput;
    private JComboBox<String> typeMenuBox;
    private JButton button;
    private String[] lengthUnit;
    private String[] weightUnit;
    private String[] type = {"Längeneinheiten", "Gewichteinheiten"};
    private JPanel centerPanel;

    public MainView(int width, int height) {
        setSize(width, height);
        setTitle("Einheitenumrechner");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void addUIcomponents() {
        JPanel topPanel = new JPanel();
        centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(new EmptyBorder(10, 50, 10, 50));

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

        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel typeMenuLabel = new JLabel("Wählen Sie den Typ der Einheit aus");
        typeMenuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(typeMenuLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        typeMenuBox = new JComboBox<>(type);
        typeMenuBox.setMaximumSize(new Dimension(200, 25));
        typeMenuBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(typeMenuBox);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel comboBoxInfoLabel = new JLabel("Wählen Sie die Ausgangseinheit");
        comboBoxInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(comboBoxInfoLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        selectionMenuInput = new JComboBox<>(lengthUnit);
        selectionMenuInput.setMaximumSize(new Dimension(200, 25));
        selectionMenuInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(selectionMenuInput);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel outputComboBoxInfoLabel = new JLabel("Wählen Sie die gewünschte Einheit");
        outputComboBoxInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(outputComboBoxInfoLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        selectionMenuOutput = new JComboBox<>(lengthUnit);
        selectionMenuOutput.setMaximumSize(new Dimension(200, 25));
        selectionMenuOutput.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(selectionMenuOutput);


        button = new JButton("Umrechnen");
        bottomPanel.add(button);

        centerPanel.add(Box.createVerticalGlue());
    }

    public void addButtonHandler(ActionListener listener){
        button.addActionListener(listener);
    }

    public void showResult(Double result){
        JOptionPane.showMessageDialog(this, userInput.getText() + "" + getFirstSelectedItem()
                + " sind umgerechnet " + result + "" + getSecondSelectedItem(), "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showParseError(){
        JOptionPane.showMessageDialog(this, "Bitte geben Sie nur Zahlen ein",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void setlengthUnit(String[] lengthUnit){
        this.lengthUnit = lengthUnit;
    }
    public void setWeightUnit(String[] weightUnit){
        this.weightUnit = weightUnit;
    }
    public String getFirstSelectedItem(){
        return (String)selectionMenuInput.getSelectedItem();
    }
    public String getSecondSelectedItem(){
        return (String)selectionMenuOutput.getSelectedItem();
    }
    public String getUserInputText(){
        return userInput.getText();
    }
    public ComboBoxModel<String> getTypeMenuBoxModel(){
        return typeMenuBox.getModel();
    }
    public int getSelectedTypeIndex(){
        return typeMenuBox.getSelectedIndex();
    }
    public void switchMenuContents(String[] units){
        selectionMenuInput.setModel(new DefaultComboBoxModel<>(units));
        selectionMenuOutput.setModel(new DefaultComboBoxModel<>(units));
    }
    public void addTypeMenuListener(){
        typeMenuBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selection = typeMenuBox.getSelectedIndex();
                if(selection == 0){
                    switchMenuContents(lengthUnit);
                } else if (selection == 1) {
                    switchMenuContents(weightUnit);
                }
            }
        });
    }
}
