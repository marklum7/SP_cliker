package com.example.increment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button knopka;

    @FXML
    private Label schot;

    public HelloController() throws IOException {
        socket = new Socket("localhost", 8081);

    }
    int response = 0;
    int add = 1;
    @FXML
    void onHelloButtonClick(ActionEvent event) {
        OutputStream outputStream = null;
        try {
            response+=add;
            schot.setText("Счёт " + response);
            outputStream = socket.getOutputStream();
            outputStream.write(1);
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void onHelloButtonClick1(ActionEvent event) {
        OutputStream outputStream = null;
        try {
            if(response >= add*5){
                response-=add*5;
                add++;
                schot.setText("Счёт " + response);
                outputStream = socket.getOutputStream();
                outputStream.write(1);
                outputStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    Socket socket;
    void initialize() throws IOException {

    }
}
