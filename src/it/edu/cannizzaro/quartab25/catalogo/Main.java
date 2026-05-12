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

        fieldCerca.setPromptText("Inserisci codice");
        fieldCerca.setMaxWidth(150);

        Label lblElementi = new Label("Elementi: ");
        lblElementi.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");
        lista.setPrefHeight(300);

        Button btnAggiungiEle = new Button("Aggiungi elemento");
        Button btnCercaEle = new Button("Cerca elemento");
        Button btnVisualizzaEle = new Button("Visualizza elementi");
        Button btnSalvaEle = new Button("Salva");

        btnAggiungiEle.setOnAction(e ->   {    aggiungiElementi();     });
        btnCercaEle.setOnAction(e ->      {    cercaElementi();        });
        btnVisualizzaEle.setOnAction(e -> {    visualizzaElementi();   });
        btnSalvaEle.setOnAction(e ->      {    salvaElementi();        });

        VBox menu = new VBox(15,titolo,btnCercaEle,fieldCerca,btnAggiungiEle,btnVisualizzaEle,btnSalvaEle,lista);
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

    public void aggiungiElementi(){
        Stage inserisciElemento = new Stage();
        inserisciElemento.setTitle("Aggiungi Elementi");
        Label titoloPagina = new Label("SCELTA");
        titoloPagina.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        Button libro = new Button("Libro");
        Button film = new Button("Film");
        Button videogioco = new Button("Videogioco");
        vbox.setStyle("-fx-font-size: 15");

        Label codice = new Label("Codice: ");
        Label titolo = new Label("Titolo: ");
        Label anno = new Label("Anno: ");
        Label prezzo = new Label("Prezzo: ");

        TextField insCodice = new TextField();
        insCodice.setPromptText("Inserisci codice");
        insCodice.setMaxWidth(150);
        TextField insTitolo = new TextField();
        insTitolo.setPromptText("Inserisci titolo");
        insTitolo.setMaxWidth(150);
        TextField insPrezzo = new TextField();
        insPrezzo.setPromptText("Inserisci prezzo");
        insPrezzo.setMaxWidth(150);
        TextField insAnno = new TextField();
        insAnno.setPromptText("Inserisci anno");
        insAnno.setMaxWidth(150);

        Button aggiungi = new Button("Aggiungi");
        aggiungi.setStyle("-fx-font-size: 15");
        aggiungi.setAlignment(Pos.BOTTOM_CENTER);


        //----------- LIBRO -----------
        libro.setOnAction(actionEvent ->{
            Stage aggiungiLibro = new Stage();
            aggiungiLibro.setTitle("LIBRO");
            Label titoloLibro = new Label("LIBRO");
            titoloLibro.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            VBox vboxLibro = new VBox();
            vboxLibro.setAlignment(Pos.CENTER);
            vboxLibro.setSpacing(10);

            Label autore = new Label("Autore: ");
            TextField insAutore = new TextField();
            insAutore.setPromptText("Inserisci autore");
            insAutore.setMaxWidth(150);

            aggiungi.setOnAction(actionEvent1 -> {
                Libro nuovoLibro = new Libro(
                        insCodice.getText(),
                        insTitolo.getText(),
                        insAnno.getText(),
                        insPrezzo.getText(),
                        insAutore.getText()

                );
                catalogo.inserisci(nuovoLibro);
            });

            vboxLibro.getChildren().add(titoloLibro);
            vboxLibro.getChildren().add(codice);
            vboxLibro.getChildren().add(insCodice);
            vboxLibro.getChildren().add(titolo);
            vboxLibro.getChildren().add(insTitolo);
            vboxLibro.getChildren().add(prezzo);
            vboxLibro.getChildren().add(insPrezzo);
            vboxLibro.getChildren().add(anno);
            vboxLibro.getChildren().add(insAnno);
            vboxLibro.getChildren().add(autore);
            vboxLibro.getChildren().add(insAutore);
            vboxLibro.getChildren().add(aggiungi);
            vboxLibro.setStyle("-fx-font-size: 15");


            Scene sceneLibro = new Scene(vboxLibro,400,450);
            aggiungiLibro.setScene(sceneLibro);
            aggiungiLibro.show();

        });


        //-------------- FILM -----------------
        film.setOnAction(actionEvent -> {
            Stage aggiungiFilm = new Stage();
            aggiungiFilm.setTitle("FILM");
            Label titoloFilm = new Label("FILM");
            titoloFilm.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            VBox vboxFilm = new VBox();
            vboxFilm.setAlignment(Pos.CENTER);
            vboxFilm.setSpacing(10);

            Label regista = new Label("Regista: ");
            TextField insRegista = new TextField();
            insRegista.setPromptText("Inserisci regista");
            insRegista.setMaxWidth(150);

            aggiungi.setOnAction(actionEvent1 -> {
                Film nuovoFilm = new Film(
                        insCodice.getText(),
                        insTitolo.getText(),
                        insAnno.getText(),
                        insPrezzo.getText(),
                        insRegista.getText()
                );
                catalogo.inserisci(nuovoFilm);
            });
            vboxFilm.getChildren().add(titoloFilm);
            vboxFilm.getChildren().add(codice);
            vboxFilm.getChildren().add(insCodice);
            vboxFilm.getChildren().add(titolo);
            vboxFilm.getChildren().add(insTitolo);
            vboxFilm.getChildren().add(prezzo);
            vboxFilm.getChildren().add(insPrezzo);
            vboxFilm.getChildren().add(anno);
            vboxFilm.getChildren().add(insAnno);
            vboxFilm.getChildren().add(regista);
            vboxFilm.getChildren().add(insRegista);
            vboxFilm.getChildren().add(aggiungi);

            vboxFilm.setStyle("-fx-font-size: 15");
            Scene sceneFilm = new Scene(vboxFilm,400,450);
            aggiungiFilm.setScene(sceneFilm);
            aggiungiFilm.show();

        });

        //------------------ VIDEOGIOCO --------------------
        videogioco.setOnAction(actionEvent -> {
            Stage aggiungiVideogioco = new Stage();
            aggiungiVideogioco.setTitle("VIDEOGIOCO");
            Label titoloVIDEOGIOCO = new Label("VIDEOGIOCO");
            titoloVIDEOGIOCO.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            VBox vboxVideogioco = new VBox();
            vboxVideogioco.setAlignment(Pos.CENTER);
            vboxVideogioco.setSpacing(10);

            Label piattaforma = new Label("Piattaforma: ");
            TextField insPiattaforma = new TextField();
            insPiattaforma.setPromptText("Inserisci piattaforma");
            insPiattaforma.setMaxWidth(150);

            aggiungi.setOnAction(actionEvent1 -> {
                Videogioco vid = new Videogioco(
                        insCodice.getText(),
                        insTitolo.getText(),
                        insAnno.getText(),
                        insPrezzo.getText(),
                        insPiattaforma.getText()
                );
                catalogo.inserisci(vid);
            });


            vboxVideogioco.getChildren().add(titoloVIDEOGIOCO);
            vboxVideogioco.getChildren().add(codice);
            vboxVideogioco.getChildren().add(insCodice);
            vboxVideogioco.getChildren().add(titolo);
            vboxVideogioco.getChildren().add(insTitolo);
            vboxVideogioco.getChildren().add(prezzo);
            vboxVideogioco.getChildren().add(insPrezzo);
            vboxVideogioco.getChildren().add(anno);
            vboxVideogioco.getChildren().add(insAnno);
            vboxVideogioco.getChildren().add(piattaforma);
            vboxVideogioco.getChildren().add(insPiattaforma);
            vboxVideogioco.getChildren().add(aggiungi);



            vboxVideogioco.setStyle("-fx-font-size: 15");
            Scene sceneVideogio = new Scene(vboxVideogioco,400,450);
            aggiungiVideogioco.setScene(sceneVideogio);
            aggiungiVideogioco.show();
        });

        vbox.getChildren().add(titoloPagina);
        vbox.getChildren().add(libro);
        vbox.getChildren().add(film);
        vbox.getChildren().add(videogioco);

        Scene scene = new Scene(vbox, 150, 200);
        inserisciElemento.setScene(scene);
        inserisciElemento.show();
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
