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
        view.setlengthUnit(calcData.getlengthUnitString());
        view.setWeightUnit(calcData.getWeightUnitString());
        view.addUIcomponents();
        view.addTypeMenuListener();
        view.addButtonHandler(this::calculate);
    }
    public void calculate(ActionEvent actionEvent){
        calcData.setUserInput(view.getUserInputText());
        try {
            Double inputNum = calcData.getUserInput();
            switch (view.getSelectedTypeIndex()) {
                case 0:
                    Double result = (inputNum * calcData.getLengthUnit().get(view.getFirstSelectedItem()))
                            / calcData.getLengthUnit().get(view.getSecondSelectedItem());
                    view.showResult(result);
                    break;
                case 1:
                    result = (inputNum * calcData.getWeightUnit().get(view.getFirstSelectedItem()))
                            / calcData.getWeightUnit().get(view.getSecondSelectedItem());
                    view.showResult(result);
                    break;
        }
        } catch (NullPointerException e){
            view.showParseError();
        }
    }
}