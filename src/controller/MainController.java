package controller;

import view.MainView;

public class MainController {
    private final MainView view;


    public MainController(MainView view){
        this.view = view;
    }

    public static void main(String[] args) {
        new MainController(
                new MainView(1080, 720)
        );
    }
    }