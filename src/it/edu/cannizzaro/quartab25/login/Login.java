package it.edu.cannizzaro.quartab25.login;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Login extends Application {
    public static void main(String []args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("MBAPPE DICTATOR");

        //LOGIN
        Label lblLogin = new Label("Nome Utente: ");
        TextField txtLogin = new TextField();
        txtLogin.setPrefWidth(120);

        HBox layoutLogin = new HBox();
        layoutLogin.getChildren().add(lblLogin);
        layoutLogin.getChildren().add(txtLogin);

        //PASSOWORD
        Label lblPwd = new Label("Password: ");
        TextField txtPwd = new TextField();
        txtLogin.setPrefWidth(100);

        HBox layoutPwd = new HBox();
        layoutLogin.getChildren().add(lblPwd);
        layoutLogin.getChildren().add(txtPwd);

        VBox righe = new VBox();
        righe.setSpacing(10);
        righe.getChildren().add(layoutLogin);
        righe.getChildren().add(layoutPwd);
        Button btnLogin = new Button("Accedi");
        righe.getChildren().add(btnLogin);

        Scene scene = new Scene(righe, 250, 150);

        stage.setScene(scene);
        stage.show();
    }

}
