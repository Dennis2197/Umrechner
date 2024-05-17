package controller;

import dao.RechnerDAO;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {
    private final MainView view;
    private final RechnerDAO calcData;


    public MainController(RechnerDAO calcData, MainView view){
        this.calcData = calcData;
        this.view = view;
        view.setUnits(calcData.getUnitString());
        view.addUIcomponents();
        view.addButtonHandler(this::calculate);
    }

    public static void main(String[] args) {
        new MainController(
                new RechnerDAO(),
                new MainView(700, 500)
        );
    }
    public void calculate(ActionEvent actionEvent){
        Double inputNum = view.getUserInput();
        Double result = (inputNum * calcData.unit.get(view.getFirstSelectedItem()))
                /calcData.unit.get(view.getSecondSelectedItem());
        view.showResult(result);
    }
}