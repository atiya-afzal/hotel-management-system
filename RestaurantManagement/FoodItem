package com.example.Lodgify.RestaurantManagement;

import com.example.Lodgify.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodItem implements Tools {
//  UI COMPONENTS
    private Menu previous;
    public void setPrevious(Menu previous) {
        this.previous = previous;
    }

//  CONTROLLER CODE
    @FXML
    private TextField nameInput;
    @FXML
    private Button addInventoryButton;
    @FXML
    private Button save;

//  ASSISTENT
    SizePriceQuantity spq;

//  ADD SIZE PRICE AND QUANTITY
    @FXML
    private void handleAddInventory(ActionEvent event) {
        if(sizePriceQuantities.size()<=5){

            if(!nameInput.getText().trim().isEmpty()){
                SaveThings();
                spq = new SizePriceQuantity();
                spq.setPrevious(this);
                switchScene(event,"/com/example/Lodgify/RestaurantManagement/SizePriceQuantity.fxml","SizePriceQuantity",spq);
            }
            else{
                showAlert("ERROR","NAME CANNOT BE EMPTY");
            }

        }
        else{
            showAlert("ERROR","NO MORE SPACE ONLY 5 FOOD ITEMS ALLOWED");
        }


    }

//  NAME SAVER
    @FXML
    public void SaveThings(){
        setName(nameInput.getText().toLowerCase().trim());
    }

//  PROCCESSING AFTER SETTING THE SIZE PRICE AND QUANTITY
    public void nextProccessing(){
        nameInput.setText(getName());
        try{
            sizePriceQuantities.add(spq);
            setSizePriceQuantities(sizePriceQuantities);
        }catch (IllegalArgumentException e){
            showAlert("ERROR",e.getMessage().toUpperCase());
            sizePriceQuantities.remove(spq);
        }

    }




// EXIT BUTTON TO GO BACK TO MENU
    @FXML
    public void exit(ActionEvent event) {
                       switchScene(event, "/com/example/Lodgify/RestaurantManagement/Menu.fxml", "Menu", previous);
                       previous.nextProccessing();
    }


//  MAIN LOGIC

    private String name="";
    private ArrayList<SizePriceQuantity> sizePriceQuantities=new ArrayList<>();





    // Constructors
    public FoodItem(String name) {
        this.name = name;
        this.sizePriceQuantities = new ArrayList<>(); // Initialize the list to avoid null issues
    }

    public FoodItem() {
        this("no name", new ArrayList<>(5));
    }

    public FoodItem(String name, ArrayList<SizePriceQuantity> sizePriceQuantities) {
        setName(name);
        setSizePriceQuantities(sizePriceQuantities);
    }

    // Copy constructor
    public FoodItem(FoodItem foodItem) {
        this(foodItem.getName(), new ArrayList<>(foodItem.sizePriceQuantities));
    }

    // Getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim().toLowerCase();
    }

    public ArrayList<SizePriceQuantity> getSizePriceQuantities() {
        return sizePriceQuantities;
    }

//  functions
    public void setSizePriceQuantities(ArrayList<SizePriceQuantity> sizePriceQuantities) {

        for (int i = 0; i < sizePriceQuantities.size(); i++) {
            for (int j = i + 1; j < sizePriceQuantities.size(); j++) {
                if (sizePriceQuantities.get(i).getSize().equals(sizePriceQuantities.get(j).getSize())) {
                    throw new IllegalArgumentException("Duplicate size found: " + sizePriceQuantities.get(i).getSize());
                 }
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(getName()).append("\nSizes: ");

        for (SizePriceQuantity spq : sizePriceQuantities) {
            stringBuilder.append(spq.toString()).append(";");
        }

        return stringBuilder.toString();
    }
}
