package it.edu.cannizzaro.quartab25.catalogo;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

public class Main extends Application {

    static BST<ElementoCatalogo> catalogo = new BST<>();

    private final String USERNAME_ADMIN = "admin";
    private final String PASSWORD_ADMIN = "1234";
    public ListView<String> lista = new ListView<>();
    TextField fieldCerca = new TextField();

    public static void main(String[] args) {
        catalogo.caricaCSV();
        launch(args);
        catalogo.salvaCSV("catalogo.csv");
    }

    @Override
    public void start(Stage stage) {
        scegliRuolo(stage);
    }


    //------------------------------------------------------------------------

    public void salvaElementi(){
        catalogo.salvaCSV("catalogo.csv");
        lista.getItems().add("Elementi salvati con successo!");
    }
    public void visualizzaElementi(){
        lista.getItems().clear();   // svuota
        catalogo.stampa(catalogo.radice, lista);          // ricarica dalla BST
        lista.setManaged(true);
        lista.setVisible(true);
    }
    public void cercaElementi(){
        String codice = fieldCerca.getText();
        ElementoCatalogo trovato = catalogo.cerca(new Libro(codice,"","","",""));
        lista.getItems().clear();
        if (trovato != null) {
            lista.getItems().add(trovato.stampaEtichettaFX());
        } else {
            lista.getItems().add(
                    "Elemento non trovato"
            );
        }
        lista.setVisible(true);
    }
    public void eliminaElemento(){
        String codice = fieldCerca.getText();

        ElementoCatalogo chiave = new Libro(codice, "", "", "", "");
        ElementoCatalogo trovato = catalogo.cerca(chiave);
        lista.getItems().clear();

        if(trovato != null){
            catalogo.elimina(chiave);
            lista.getItems().add("Elemento eliminato");
        } else {
            lista.getItems().add("Elemento non trovato");
        }
    }
    public void aggiungiElementi(){

        Stage sceltaStage = new Stage();
        sceltaStage.setTitle("Aggiungi Elemento");

        sceltaStage.initModality(Modality.APPLICATION_MODAL);

        Label titolo = new Label("Seleziona tipo");

        ComboBox<String> scelta = new ComboBox<>();
        scelta.getItems().addAll("Libro", "Film", "Videogioco");
        scelta.setPromptText("Scegli tipo");

        Button continua = new Button("Continua");

        VBox root = new VBox(15, titolo, scelta, continua);
        root.setAlignment(Pos.CENTER);

        continua.setOnAction(e -> {

            String tipo = scelta.getValue();

            if(tipo == null) return;

            sceltaStage.close();

            switch(tipo){

                case "Libro":
                    apriLibro();
                    break;

                case "Film":
                    apriFilm();
                    break;

                case "Videogioco":
                    apriVideogioco();
                    break;
            }
        });

        Scene scene = new Scene(root, 250, 200);
        sceltaStage.setScene(scene);
        sceltaStage.show();
    }
    public void compraElemento(){
        String codice = fieldCerca.getText();

        ElementoCatalogo trovato =
                catalogo.cerca(new Libro(codice,"","","",""));

        lista.getItems().clear();

        if(trovato != null){

            lista.getItems().add(
                    "Hai acquistato: " +
                            trovato.stampaEtichettaFX()
            );

        }else{
            lista.getItems().add("Elemento non trovato");
        }
    }
    public void apriLibro(){

        Stage stage = new Stage();
        stage.setTitle("Aggiungi Libro");

        Label titolo = new Label("LIBRO");
        titolo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField codice = new TextField();
        codice.setPromptText("Codice");

        TextField titoloField = new TextField();
        titoloField.setPromptText("Titolo");

        TextField anno = new TextField();
        anno.setPromptText("Anno");

        TextField prezzo = new TextField();
        prezzo.setPromptText("Prezzo");

        TextField autore = new TextField();
        autore.setPromptText("Autore");

        Button aggiungi = new Button("Aggiungi Libro");
        aggiungi.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        aggiungi.setOnAction(e -> {

            catalogo.inserisci(new Libro(
                    codice.getText(),
                    titoloField.getText(),
                    anno.getText(),
                    prezzo.getText(),
                    autore.getText()
            ));

            stage.close();
        });

        VBox root = new VBox(12,
                titolo,
                codice,
                titoloField,
                anno,
                prezzo,
                autore,
                aggiungi
        );

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20;");

        stage.setScene(new Scene(root, 350, 350));
        stage.show();
    }
    public void apriFilm(){

        Stage stage = new Stage();
        stage.setTitle("Aggiungi Film");

        Label titolo = new Label("FILM");
        titolo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField codice = new TextField();
        codice.setPromptText("Codice");

        TextField titoloField = new TextField();
        titoloField.setPromptText("Titolo");

        TextField anno = new TextField();
        anno.setPromptText("Anno");

        TextField prezzo = new TextField();
        prezzo.setPromptText("Prezzo");

        TextField regista = new TextField();
        regista.setPromptText("Regista");

        Button aggiungi = new Button("Aggiungi Film");
        aggiungi.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        aggiungi.setOnAction(e -> {

            catalogo.inserisci(new Film(
                    codice.getText(),
                    titoloField.getText(),
                    anno.getText(),
                    prezzo.getText(),
                    regista.getText()
            ));

            stage.close();
        });

        VBox root = new VBox(12,
                titolo,
                codice,
                titoloField,
                anno,
                prezzo,
                regista,
                aggiungi
        );

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20;");

        stage.setScene(new Scene(root, 350, 350));
        stage.show();
    }
    public void apriVideogioco(){

        Stage stage = new Stage();
        stage.setTitle("Aggiungi Videogioco");

        Label titolo = new Label("VIDEOGIOCO");
        titolo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField codice = new TextField();
        codice.setPromptText("Codice");

        TextField titoloField = new TextField();
        titoloField.setPromptText("Titolo");

        TextField anno = new TextField();
        anno.setPromptText("Anno");

        TextField prezzo = new TextField();
        prezzo.setPromptText("Prezzo");

        TextField piattaforma = new TextField();
        piattaforma.setPromptText("Piattaforma");

        Button aggiungi = new Button("Aggiungi Videogioco");
        aggiungi.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        aggiungi.setOnAction(e -> {

            catalogo.inserisci(new Videogioco(
                    codice.getText(),
                    titoloField.getText(),
                    anno.getText(),
                    prezzo.getText(),
                    piattaforma.getText()
            ));

            stage.close();
        });

        VBox root = new VBox(12,
                titolo,
                codice,
                titoloField,
                anno,
                prezzo,
                piattaforma,
                aggiungi
        );

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20;");

        stage.setScene(new Scene(root, 350, 350));
        stage.show();
    }
    public void scegliRuolo(Stage stage){

        Label titolo = new Label("CHI SEI?");
        titolo.setStyle("""
            -fx-font-size: 24px;
            -fx-font-weight: bold;
            """);

        Button utente = new Button("Utente");
        Button admin = new Button("Admin");

        utente.setPrefWidth(200);
        admin.setPrefWidth(200);

        VBox root = new VBox(20, titolo, utente, admin);

        root.setAlignment(Pos.CENTER);

        root.setStyle("""
            -fx-background-color: #f5f6fa;
            """);

        Scene scene = new Scene(root, 400, 300);

        stage.setScene(scene);
        stage.show();

        // UTENTE
        utente.setOnAction(e -> {
            apriCatalogo(stage, false);
        });

        // ADMIN
        admin.setOnAction(e -> {
            loginAdmin(stage);
        });
    }
    public void loginAdmin(Stage stage){

        Label titolo = new Label("LOGIN ADMIN");

        titolo.setStyle("""
            -fx-font-size: 22px;
            -fx-font-weight: bold;
            """);

        TextField utente = new TextField();
        utente.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Label errore = new Label();

        Button login = new Button("Accedi");
        Button back = new Button("←");

        back.setStyle("""
        -fx-background-color: transparent;
        -fx-font-size: 18px;
        -fx-cursor: hand;
        """);

        back.setOnAction(e -> {
            scegliRuolo(stage);
        });

        HBox topBar = new HBox(10, back, titolo);
        topBar.setAlignment(Pos.CENTER_LEFT);

        VBox root = new VBox(20,
                topBar,
                utente,
                password,
                login,
                errore
        );

        root.setAlignment(Pos.CENTER);

        root.setStyle("""
            -fx-background-color: #f5f6fa;
            -fx-padding: 30;
            """);

        utente.setMaxWidth(200);
        password.setMaxWidth(200);
        login.setPrefWidth(200);

        Scene scene = new Scene(root, 400, 300);

        stage.setScene(scene);

        login.setOnAction(e -> {

            String user = utente.getText();
            String pass = password.getText();

            if(user.equals(USERNAME_ADMIN)
                    && pass.equals(PASSWORD_ADMIN)){

                apriCatalogo(stage, true);

            }else{

                errore.setText("Username o password errati");
                errore.setStyle("-fx-text-fill: red;");
            }
        });
    }
    public void apriCatalogo(Stage stage, boolean admin){

        Button back = new Button("←");

        back.setStyle("""
        -fx-background-color: transparent;
        -fx-font-size: 18px;
        -fx-cursor: hand;
        """);
        back.setOnAction(e -> {
            scegliRuolo(stage);
        });

        stage.setTitle("Catalogo Multimediale");

        // ---------------- TITOLO ----------------
        Label titolo = new Label("CATALOGO");
        titolo.setStyle("""
            -fx-font-size: 24px;
            -fx-font-weight: bold;
            -fx-text-fill: #2c3e50;
            -fx-padding: 10 0 20 0;
            """);

        // ---------------- CERCA ----------------
        fieldCerca.setPromptText("Cerca per codice...");
        fieldCerca.setMaxWidth(Double.MAX_VALUE);

        fieldCerca.setStyle("""
            -fx-background-radius: 6;
            -fx-padding: 8;
            -fx-border-color: #dcdcdc;
            -fx-border-radius: 6;
            """);

        // ---------------- LISTA ----------------
        lista.setPrefSize(600, 450);
        lista.setFixedCellSize(55);

        lista.setStyle("""
            -fx-background-color: #f5f6fa;
            -fx-border-color: #dcdcdc;
            -fx-border-radius: 10;
            -fx-background-radius: 10;
            -fx-font-size: 14px;
            """);

        // ---------------- BOTTONI ----------------
        Button btnAggiungi = new Button("Aggiungi");
        Button btnCerca = new Button("Cerca");
        Button btnVisualizza = new Button("Visualizza");
        Button btnElimina = new Button("Elimina");
        Button btnSalva = new Button("Salva");
        Button btnCompra = new Button("Compra");
        if(!admin){
            btnAggiungi.setVisible(false);
            btnElimina.setVisible(false);
            btnSalva.setVisible(false);
        } else {
            btnCompra.setVisible(false);
        }

        Button[] buttons = {btnAggiungi, btnCerca, btnVisualizza, btnElimina, btnSalva, btnCompra};

        for(Button b : buttons){

            b.setMaxWidth(Double.MAX_VALUE);

            String base = """
                -fx-background-color: transparent;
                -fx-text-fill: #2c3e50;
                -fx-font-size: 14px;
                -fx-padding: 10;
                -fx-background-radius: 8;
                -fx-cursor: hand;
                """;

            String hover = """
                -fx-background-color: #e3eaf5;
                -fx-text-fill: #2c3e50;
                -fx-font-size: 14px;
                -fx-padding: 10;
                -fx-background-radius: 8;
                """;

            b.setStyle(base);

            b.setOnMouseEntered(e -> {
                b.setStyle(hover);
                b.setTranslateX(3);
            });

            b.setOnMouseExited(e -> {
                b.setStyle(base);
                b.setTranslateX(0);
            });
        }

        // ---------------- EVENTI ----------------
        btnAggiungi.setOnAction(e ->    aggiungiElementi()      );
        btnCerca.setOnAction(e ->       cercaElementi()         );
        btnVisualizza.setOnAction(e ->  visualizzaElementi()    );
        btnElimina.setOnAction(e ->     eliminaElemento()       );
        btnSalva.setOnAction(e ->       salvaElementi()         );
        btnCompra.setOnAction(e ->      compraElemento()        );

        // ---------------- SIDEBAR ----------------
        VBox sidebar = new VBox(15,
                back,
                titolo,
                fieldCerca,
                btnCerca,
                btnAggiungi,
                btnVisualizza,
                btnCompra,
                btnElimina,
                btnSalva
        );
        // ---

        sidebar.setStyle("""
            -fx-background-color: #f0f4f8;
            -fx-padding: 20;
            """);
        sidebar.setPrefWidth(220);

        // ------------- CONTENT ----------------


        VBox content = new VBox(15, lista);
        content.setStyle("""
            -fx-background-color: #ffffff;
            -fx-padding: 20;
            """);

        // ---------------- ROOT ----------------
        BorderPane root = new BorderPane();
        root.setLeft(sidebar);
        root.setCenter(content);

        Scene scene = new Scene(root, 950, 550);

        stage.setScene(scene);
        stage.show();




    }

    //------------------------------------------------------------------------

    public static void menu(){
        Scanner s = new Scanner(System.in);
        int scelta = -1;

        while(scelta != 0){
            System.out.println("------ MENU ------");
            System.out.println("1. Aggiungi elemento");
            System.out.println("2. Cerca elemento");
            System.out.println("3. Visualizza catalogo");
            System.out.println("4. Salva catalogo in CSV");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = s.nextInt();
            s.nextLine();

            switch(scelta){
                case 1:
                    System.out.println("1. Libro");
                    System.out.println("2. Film");
                    System.out.println("3. Videogioco");
                    System.out.print("Scelta: ");
                    scelta = s.nextInt();
                    s.nextLine(); // svuota buffer sennò non funziona

                    System.out.print("Inserisci codice: ");
                    String codice = s.nextLine();
                    System.out.print("Inserisci titolo: ");
                    String titolo = s.nextLine();
                    System.out.print("Inserisci anno: ");
                    String anno = s.nextLine();
                    System.out.print("Inserisci prezzo: ");
                    String prezzo = s.nextLine();

                    switch(scelta){
                        case 1:
                            System.out.print("Inserisci autore: ");
                            String autore = s.nextLine();
                            catalogo.inserisci(new Libro(codice, titolo, anno, prezzo, autore));
                            break;
                        case 2:
                            System.out.print("Inserisci regista: ");
                            String regista = s.nextLine();
                            catalogo.inserisci(new Film(codice, titolo, anno, prezzo, regista));
                            break;
                        case 3:
                            System.out.print("Inserisci piattaforma: ");
                            String piattaforma = s.nextLine();

                            catalogo.inserisci(new Videogioco(codice, titolo, anno, prezzo, piattaforma));
                            break;
                    }
                    break;
                case 2:
                    cerca();
                    break;
                case 3:
                    catalogo.visualizza();
                    break;
                case 4:
                    catalogo.salvaCSV("catalogo.csv");
                    System.out.println("Catalogo salvato con successo in catalogo.csv!");
                    break;
            }
        }
        s.close();
    }
    public static void cerca(){
        Scanner s = new Scanner(System.in);
        System.out.print("Inserisci codice: ");
        String codice = s.nextLine();
        ElementoCatalogo trovato = catalogo.cerca(new Libro(codice, "", "", "", ""));
        if (trovato != null) {
            System.out.println("------ PRODOTTO TROVATO ------");
            trovato.stampaEtichetta();
        } else {
            System.out.println("Elemento non trovato.");
        }

    }
    public static void popolaLista(){
        catalogo.inserisci(new Libro("L01","Il Nome della Rosa", "1980","24.99", "Umberto Eco"));
        catalogo.inserisci(new Film("F01", "Pulp Fiction", "1994", "24.99", "Quentin Tarantino"));
        catalogo.inserisci(new Videogioco("V01", "The Legend of Zelda", "2017", "24.99", "Nintendo Switch"));
        catalogo.inserisci(new Libro("L02", "1984", "1949", "24.99", "George Orwell"));
        catalogo.inserisci(new Film("F02", "Interstellar", "2014", "24.99", "Christopher Nolan"));
        catalogo.inserisci(new Videogioco("V02", "Halo", "2001", "24.99", "Xbox"));
        catalogo.inserisci(new Libro("L03", "Il Gattopardo", "1958", "24.99", "Giuseppe Tomasi di Lampedusa"));
        catalogo.inserisci(new Film("F03", "Parasite", "2019", "24.99", "Bong Joon-ho"));
        catalogo.inserisci(new Videogioco("V03", "God of War", "2018", "24.99", "PlayStation 4"));
        catalogo.inserisci(new Film("F04", "La Vita è Bella", "1997", "24.99", "Roberto Benigni"));

    }
}