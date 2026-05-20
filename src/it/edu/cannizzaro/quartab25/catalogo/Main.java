package it.edu.cannizzaro.quartab25.catalogo;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

public class Main extends Application {
    static BST<ElementoCatalogo> catalogo = new BST<>();
    public static void main(String[] args) {
        catalogo.caricaCSV();
        launch(args);
    }

    public ListView<String> lista = new ListView<>();
    TextField fieldCerca = new TextField();

    @Override
    public void start(Stage stage){
        stage.setTitle("CATALOGO");
        Label titolo = new Label("CATALOGO MULTIMEDIALE");
        titolo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        fieldCerca.setPromptText("Codice da cercare/eliminare");
        fieldCerca.setMaxWidth(150);

        Label lblElementi = new Label("Elementi: ");
        lblElementi.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");
        lista.setPrefHeight(300);

        Button btnAggiungiEle = new Button("Aggiungi elemento");
        Button btnEliminaEle = new Button("Elimina elemento");
        Button btnCercaEle = new Button("Cerca elemento");
        Button btnVisualizzaEle = new Button("Visualizza elementi");
        Button btnSalvaEle = new Button("Salva");

        btnAggiungiEle.setOnAction(e ->   {    aggiungiElementi();     });
        btnEliminaEle.setOnAction(e ->    {    eliminaElemento();      });
        btnCercaEle.setOnAction(e ->      {    cercaElementi();        });
        btnVisualizzaEle.setOnAction(e -> {    visualizzaElementi();   });
        btnSalvaEle.setOnAction(e ->      {    salvaElementi();        });

        VBox menu = new VBox(
                15,
                titolo,
                btnCercaEle,
                fieldCerca,
                btnAggiungiEle,
                btnVisualizzaEle,
                btnEliminaEle,
                btnSalvaEle,
                lista
        );
        menu.setPadding(new Insets(20));
        menu.setAlignment(Pos.TOP_CENTER);
        menu.setPrefWidth(250);

        BorderPane bordo = new BorderPane();
        bordo.setTop(titolo);
        bordo.setLeft(menu);
        bordo.setCenter(lista);
        BorderPane.setAlignment(titolo, Pos.CENTER);
        BorderPane.setMargin(titolo, new Insets(20));

        Scene scene = new Scene(bordo, 800, 400);
        stage.setScene(scene);
        stage.setOnCloseRequest(windowEvent -> {
            salvaElementi();
        });
        stage.show();
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

        Label titoloPagina = new Label("SCELTA");
        titoloPagina.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button libro = new Button("Libro");
        Button film = new Button("Film");
        Button videogioco = new Button("Videogioco");

        VBox vbox = new VBox(10, titoloPagina, libro, film, videogioco);
        vbox.setAlignment(Pos.CENTER);

        // ---------------- LIBRO ----------------

        libro.setOnAction(e -> {

            sceltaStage.close();

            Stage stageLibro = new Stage();
            stageLibro.setTitle("LIBRO");
            stageLibro.initModality(Modality.APPLICATION_MODAL);

            Label titolo = new Label("LIBRO");
            titolo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

            TextField insCodice = new TextField();
            insCodice.setPromptText("Codice");

            TextField insTitolo = new TextField();
            insTitolo.setPromptText("Titolo");

            TextField insAnno = new TextField();
            insAnno.setPromptText("Anno");

            TextField insPrezzo = new TextField();
            insPrezzo.setPromptText("Prezzo");

            TextField insAutore = new TextField();
            insAutore.setPromptText("Autore");

            Button aggiungi = new Button("Aggiungi");

            aggiungi.setOnAction(ev -> {

                Libro nuovoLibro = new Libro(
                        insCodice.getText(),
                        insTitolo.getText(),
                        insAnno.getText(),
                        insPrezzo.getText(),
                        insAutore.getText()
                );

                catalogo.inserisci(nuovoLibro);

                stageLibro.close();
            });

            VBox root = new VBox(
                    10,
                    titolo,
                    insCodice,
                    insTitolo,
                    insAnno,
                    insPrezzo,
                    insAutore,
                    aggiungi
            );

            root.setAlignment(Pos.CENTER);

            Scene scene = new Scene(root, 400, 400);

            stageLibro.setScene(scene);
            stageLibro.show();
        });

        // ---------------- FILM ----------------

        film.setOnAction(e -> {

            sceltaStage.close();

            Stage stageFilm = new Stage();
            stageFilm.setTitle("FILM");
            stageFilm.initModality(Modality.APPLICATION_MODAL);

            Label titolo = new Label("FILM");
            titolo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

            TextField insCodice = new TextField();
            insCodice.setPromptText("Codice");

            TextField insTitolo = new TextField();
            insTitolo.setPromptText("Titolo");

            TextField insAnno = new TextField();
            insAnno.setPromptText("Anno");

            TextField insPrezzo = new TextField();
            insPrezzo.setPromptText("Prezzo");

            TextField insRegista = new TextField();
            insRegista.setPromptText("Regista");

            Button aggiungi = new Button("Aggiungi");

            aggiungi.setOnAction(ev -> {

                Film nuovoFilm = new Film(
                        insCodice.getText(),
                        insTitolo.getText(),
                        insAnno.getText(),
                        insPrezzo.getText(),
                        insRegista.getText()
                );

                catalogo.inserisci(nuovoFilm);

                stageFilm.close();
            });

            VBox root = new VBox(
                    10,
                    titolo,
                    insCodice,
                    insTitolo,
                    insAnno,
                    insPrezzo,
                    insRegista,
                    aggiungi
            );

            root.setAlignment(Pos.CENTER);

            Scene scene = new Scene(root, 400, 400);

            stageFilm.setScene(scene);
            stageFilm.show();
        });

        // ---------------- VIDEOGIOCO ----------------

        videogioco.setOnAction(e -> {

            sceltaStage.close();

            Stage stageVideogioco = new Stage();
            stageVideogioco.setTitle("VIDEOGIOCO");
            stageVideogioco.initModality(Modality.APPLICATION_MODAL);

            Label titolo = new Label("VIDEOGIOCO");
            titolo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

            TextField insCodice = new TextField();
            insCodice.setPromptText("Codice");

            TextField insTitolo = new TextField();
            insTitolo.setPromptText("Titolo");

            TextField insAnno = new TextField();
            insAnno.setPromptText("Anno");

            TextField insPrezzo = new TextField();
            insPrezzo.setPromptText("Prezzo");

            TextField insPiattaforma = new TextField();
            insPiattaforma.setPromptText("Piattaforma");

            Button aggiungi = new Button("Aggiungi");

            aggiungi.setOnAction(ev -> {

                Videogioco nuovoVideogioco = new Videogioco(
                        insCodice.getText(),
                        insTitolo.getText(),
                        insAnno.getText(),
                        insPrezzo.getText(),
                        insPiattaforma.getText()
                );

                catalogo.inserisci(nuovoVideogioco);

                stageVideogioco.close();
            });

            VBox root = new VBox(
                    10,
                    titolo,
                    insCodice,
                    insTitolo,
                    insAnno,
                    insPrezzo,
                    insPiattaforma,
                    aggiungi
            );

            root.setAlignment(Pos.CENTER);

            Scene scene = new Scene(root, 400, 400);

            stageVideogioco.setScene(scene);
            stageVideogioco.show();
        });

        Scene scene = new Scene(vbox, 200, 200);

        sceltaStage.setScene(scene);
        sceltaStage.show();
    }


    //-------------------------------------------------------------------------------------------------------------

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
