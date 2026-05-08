package it.edu.cannizzaro.quartab25.catalogo;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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

    @Override
    public void start(Stage stage){
        stage.setTitle("CATALOGO");
        //--------------- PAGINA PRINCIPALE -----------------
        VBox righe = new VBox();
        righe.setAlignment(Pos.CENTER);

        TextField testoCerca = new TextField();
        testoCerca.setPromptText("Inserisci codice");
        testoCerca.setMaxWidth(150);

        Label label = new Label("Elementi: ");
        label.setStyle("-fx-font-size: 15");

        ListView<String> lista = new ListView<>();
        lista.setPrefHeight(300);

        Button aggiungiEle = new Button("Aggiungi elemento");
        Button cercaEle = new Button("Cerca elemento");
        Button visualizzaEle = new Button("Visualizza elementi");
        Button salvaEle = new Button("Salva");

        aggiungiEle.setStyle("-fx-font-size: 15");
        cercaEle.setStyle("-fx-font-size: 15");
        visualizzaEle.setStyle("-fx-font-size: 15");
        salvaEle.setStyle("-fx-font-size: 15");

        righe.getChildren().add(aggiungiEle);
        righe.getChildren().add(cercaEle);
        righe.getChildren().add(testoCerca);
        righe.getChildren().add(visualizzaEle);
        righe.getChildren().add(salvaEle);
        righe.getChildren().add(label);
        righe.getChildren().add(lista);

        //------------- TASTO AGGIUNGI ----------------

        aggiungiEle.setOnAction(e -> {
            Stage inserisciElemento = new Stage();
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


                Scene sceneLibro = new Scene(vboxLibro,300,400);
                aggiungiLibro.setScene(sceneLibro);
                aggiungiLibro.show();

            });


            //-------------- FILM -----------------
            film.setOnAction(actionEvent -> {
                Stage aggiungiFilm = new Stage();
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
                Scene sceneFilm = new Scene(vboxFilm,300,400);
                aggiungiFilm.setScene(sceneFilm);
                aggiungiFilm.show();

            });

            //------------------ VIDEOGIOCO --------------------
            videogioco.setOnAction(actionEvent -> {
                Stage aggiungiVideogioco = new Stage();
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
                Scene sceneVideogio = new Scene(vboxVideogioco,300,400);
                aggiungiVideogioco.setScene(sceneVideogio);
                aggiungiVideogioco.show();
            });


            vbox.getChildren().add(libro);
            vbox.getChildren().add(film);
            vbox.getChildren().add(videogioco);
            Scene scene = new Scene(vbox, 150, 150);
            inserisciElemento.setScene(scene);
            inserisciElemento.show();
        });

        //------------- TASTO CERCA ---------------

        cercaEle.setOnAction(e -> {

            String codice = testoCerca.getText();
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
        });

        //----------------- TASTO VISUALIZZA ----------------

        visualizzaEle.setOnAction(e -> {
            lista.getItems().clear();   // svuota
            catalogo.stampa(catalogo.radice, lista);          // ricarica dalla BST
            lista.setManaged(true);
            lista.setVisible(true);

        });

        //----------------- TASTO SALVA ----------------------
        salvaEle.setOnAction(e -> {
            catalogo.salvaCSV("catalogo.csv");
            lista.getItems().add("Elementi salvati con successo!");
        });


        righe.setSpacing(10);
        Scene scene = new Scene(righe, 600, 500);
        stage.setScene(scene);
        stage.show();
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
