package controller;

import dao.RechnerDAO;
import view.MainView;

public class MainController {
    private final MainView view;
    private final RechnerDAO calcData;


    public MainController(RechnerDAO calcData, MainView view){
        this.calcData = calcData;
        this.view = view;
        view.setUnits(calcData.getUnitString());
        view.addUIcomponents();
    }

    public static void main(String[] args) {
        new MainController(
                new RechnerDAO(),
                new MainView(700, 500)
        );
    }
    public Double calculate(Double inputNum){
        Double result = (inputNum * 1)/2;
        return result;
    }
}