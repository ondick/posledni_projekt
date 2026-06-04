package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Random;


public class HelloController {
    Random rand = new Random();
    @FXML
    private Label VybranyZakText, VybranaPoznamkaText;
    @FXML
    private TextField TextFieldZak, TextFieldPoznamka;
    @FXML
    private ListView<String> ZaciListView, PoznamkyListView;
    @FXML
    private final ObservableList<String> ZaciObservable = FXCollections.observableArrayList();
    @FXML
    private final ObservableList<String> PoznamkyObservable = FXCollections.observableArrayList();

    @FXML
    public void pridejZaka(){
        if(!TextFieldZak.getText().equals("")){
            ZaciObservable.add(TextFieldZak.getText());
            ZaciListView.setItems(ZaciObservable);
            TextFieldZak.clear();
        }
        else{
            System.out.println("Napis jmeno zaka!!!!");
        }
    }

    @FXML
    public void odebratZaka(){
        String vybrany = ZaciListView.getSelectionModel().getSelectedItem();
        ZaciObservable.remove(vybrany);
        ZaciListView.setItems(ZaciObservable);
        ZaciListView.refresh();
    }

    @FXML
    public void pridejPoznamka(){
        if(!TextFieldPoznamka.getText().equals("")){
            PoznamkyObservable.add(TextFieldPoznamka.getText());
            PoznamkyListView.setItems(PoznamkyObservable);
            TextFieldPoznamka.clear();
        }
        else {
            System.out.println("Napis poznamku!!!!");
        }

    }

    @FXML
    public void odebratPoznamka(){
        String vybrany = PoznamkyListView.getSelectionModel().getSelectedItem();
        PoznamkyObservable.remove(vybrany);
        PoznamkyListView.setItems(PoznamkyObservable);
        PoznamkyListView.refresh();
    }

    @FXML
    public void udelitPoznamku(){
        if (!ZaciListView.getItems().isEmpty() && !PoznamkyListView.getItems().isEmpty()){
            int indexZ =rand.nextInt(ZaciObservable.size());
            int indexP = rand.nextInt(PoznamkyObservable.size());
            VybranyZakText.setText("Vybrany zak: " + ZaciObservable.get(indexZ));
            VybranaPoznamkaText.setText("Poznamka: " + PoznamkyObservable.get(indexP));
        }
        else {
            System.out.println("Chybi poznamka nebo zak");
        }
    }








}
