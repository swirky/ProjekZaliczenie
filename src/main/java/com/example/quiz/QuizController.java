package com.example.quiz;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Callable;

public class QuizController {
    private int pkt;
    private ArrayList<Pytanie> pytania;
    private int index;
    private boolean started;

    public QuizController() {
        started = false;
        pkt = 0;
        index = 0;
    }

    //obiekty kontrolek
    @FXML
    private Label pytanieText;

    @FXML
    private Button odpBtn;

    @FXML
    private RadioButton rdA;
    @FXML
    private RadioButton rdB;
    @FXML
    private RadioButton rdC;
    @FXML
    private RadioButton rdD;

    @FXML
    private ToggleGroup group;

    @FXML
    private Label pathLabel;
    @FXML
    private TextField pathField;

    @FXML
    private Button createBtn;

    @FXML
    private Label pytanieLabel;

    @FXML
    private TextField pytanieField;

    @FXML
    private Label aLabel;

    @FXML
    private TextField aField;

    @FXML
    private Label bLabel;

    @FXML
    private TextField bField;

    @FXML
    private Label cLabel;

    @FXML
    private TextField cField;

    @FXML
    private Label dLabel;

    @FXML
    private TextField dField;

    @FXML
    private Label popLabel;

    @FXML
    private TextField popField;

    @FXML
    private Button nastBtn;

    @FXML
    private Button zapiszBtn;

    @FXML
    private Button powrotBtn;

    @FXML
    private Label newPathLabel;

    @FXML
    private TextField newPathField;

    @FXML
    private Button newPathBtn;

    @FXML
    private Button usunBtn;

    @FXML
    private Button wyjdzButton;

    @FXML
    protected void onWyjdzButtonCLick(){

        System.exit(0);
    }

    @FXML
    protected void usunQuiz()
    {
        File f = new File(pathField.getText());
        f.delete();
    }

    @FXML
    protected void onCreateBtnClick(){
        pytania = new ArrayList<>();


        wyjdzButton.setManaged(false);
        wyjdzButton.setVisible(false);
        pytanieText.setManaged(false);
        pytanieText.setVisible(false);

        odpBtn.setManaged(false);
        odpBtn.setVisible(false);

        pathLabel.setManaged(false);
        pathLabel.setVisible(false);

        pathField.setManaged(false);
        pathField.setVisible(false);

        usunBtn.setManaged(false);
        usunBtn.setVisible(false);

        createBtn.setManaged(false);
        createBtn.setVisible(false);



        powrotBtn.setManaged(true);
        powrotBtn.setVisible(true);
        pytanieLabel.setManaged(true);
        pytanieLabel.setVisible(true);
        pytanieField.setManaged(true);
        pytanieField.setVisible(true);

        aLabel.setManaged(true);
        aLabel.setVisible(true);
        aField.setManaged(true);
        aField.setVisible(true);

        bLabel.setManaged(true);
        bLabel.setVisible(true);
        bField.setManaged(true);
        bField.setVisible(true);

        cLabel.setManaged(true);
        cLabel.setVisible(true);
        cField.setManaged(true);
        cField.setVisible(true);

        dLabel.setManaged(true);
        dLabel.setVisible(true);
        dField.setManaged(true);
        dField.setVisible(true);

        popLabel.setManaged(true);
        popLabel.setVisible(true);
        popField.setManaged(true);
        popField.setVisible(true);

        nastBtn.setManaged(true);
        nastBtn.setVisible(true);

        zapiszBtn.setManaged(true);
        zapiszBtn.setVisible(true);
    }

    @FXML
    protected void addNext(){ //zdarzenie klikniecia dodaj pytanie
        String pyt = pytanieField.getText();
        String odpA = aField.getText();
        String odpB = bField.getText();
        String odpC = cField.getText();
        String odpD = dField.getText();
        String poprawnaTxt = popField.getText();

        int poprawna = 0;

        if(poprawnaTxt.toLowerCase().equals("a")){
            poprawna = 0;
        }
        else if(poprawnaTxt.toLowerCase().equals("b")){
            poprawna = 1;
        }
        else if(poprawnaTxt.toLowerCase().equals("c")){
            poprawna = 2;
        }
        else if(poprawnaTxt.toLowerCase().equals("d")) {
            poprawna = 3;
        }


        Pytanie pytanie = new Pytanie(pyt,poprawna,odpA,odpB,odpC,odpD);
        pytania.add(pytanie);


        pytanieField.setText("");
        aField.setText("");
        bField.setText("");
        cField.setText("");
        dField.setText("");
        popField.setText("");
    }

    @FXML
    protected void saveQuiz(){

        pytanieLabel.setManaged(false);
        pytanieLabel.setVisible(false);
        pytanieField.setManaged(false);
        pytanieField.setVisible(false);

        aLabel.setManaged(false);
        aLabel.setVisible(false);
        aField.setManaged(false);
        aField.setVisible(false);

        bLabel.setManaged(false);
        bLabel.setVisible(false);
        bField.setManaged(false);
        bField.setVisible(false);

        cLabel.setManaged(false);
        cLabel.setVisible(false);
        cField.setManaged(false);
        cField.setVisible(false);

        dLabel.setManaged(false);
        dLabel.setVisible(false);
        dField.setManaged(false);
        dField.setVisible(false);

        popLabel.setManaged(false);
        popLabel.setVisible(false);
        popField.setManaged(false);
        popField.setVisible(false);

        nastBtn.setManaged(false);
        nastBtn.setVisible(false);

        zapiszBtn.setManaged(false);
        zapiszBtn.setVisible(false);


        newPathLabel.setManaged(true);
        newPathLabel.setVisible(true);

        newPathField.setManaged(true);
        newPathField.setVisible(true);

        newPathBtn.setManaged(true);
        newPathBtn.setVisible(true);
    }

    @FXML
    protected void saveQuizConfirm(){

        zapis(pytania,newPathField.getText());

        //ukrywanie elementow
        newPathLabel.setManaged(false);
        newPathLabel.setVisible(false);

        newPathField.setManaged(false);
        newPathField.setVisible(false);

        newPathBtn.setManaged(false);
        newPathBtn.setVisible(false);

        //pokazywanie elementow
        pytanieText.setManaged(true);
        pytanieText.setVisible(true);

        odpBtn.setManaged(true);
        odpBtn.setVisible(true);

        pathLabel.setManaged(true);
        pathLabel.setVisible(true);

        pathField.setManaged(true);
        pathField.setVisible(true);

        usunBtn.setManaged(true);
        usunBtn.setVisible(true);

        createBtn.setManaged(true);
        createBtn.setVisible(true);


    }

    @FXML
    protected void odpButtonClick() {
        if(started) {
            if (index < pytania.size()) {
                if (rdA.isSelected() && pytania.get(index).getPoprawna() == 0) {
                    pkt++;
                } else if (rdB.isSelected() && pytania.get(index).getPoprawna() == 1) {
                    pkt++;
                } else if (rdC.isSelected() && pytania.get(index).getPoprawna() == 2) {
                    pkt++;
                } else if (rdD.isSelected() && pytania.get(index).getPoprawna() == 3) {
                    pkt++;
                }
            }
            index++;
        }
        else {
            try {
                pytania = odczyt(pathField.getText());
                pathLabel.setText("Wczytaj quiz z pliku:");

                pathLabel.setVisible(false);
                pathLabel.setManaged(false);
                pathField.setVisible(false);
                pathField.setManaged(false);
                usunBtn.setManaged(false);
                usunBtn.setVisible(false);
                createBtn.setVisible(false);
                createBtn.setManaged(false);

                started = true;
            }
            catch (Exception ex){
                pathLabel.setText("Niepoprawna ścieżka do pliku wprowadź jeszcze raz.");
                return;
            }
        }

        if(index < pytania.size()){
            Pytanie p = pytania.get(index);
            pytanieText.setText(p.getText());
            odpBtn.setText("Odpowiedz");

            rdA.setManaged(true);
            rdA.setVisible(true);
            rdA.setText(p.getOdp()[0]);
            rdB.setManaged(true);
            rdB.setVisible(true);
            rdB.setText(p.getOdp()[1]);
            rdC.setManaged(true);
            rdC.setVisible(true);
            rdC.setText(p.getOdp()[2]);
            rdD.setManaged(true);
            rdD.setVisible(true);
            rdD.setText(p.getOdp()[3]);
        }
        else if(index >= pytania.size()){
            pytanieText.setText("Koniec quizu zdobyłeś: " + pkt + " pkt");

            rdA.setVisible(false);
            rdB.setVisible(false);
            rdC.setVisible(false);
            rdD.setVisible(false);

            odpBtn.setVisible(false);
            odpBtn.setManaged(false);

            powrotBtn.setVisible(true);
            powrotBtn.setManaged(true);
        }


    }

    @FXML
    protected void powrotMenu(){
        pytanieLabel.setManaged(false);
        pytanieLabel.setVisible(false);
        pytanieField.setManaged(false);
        pytanieField.setVisible(false);

        aLabel.setManaged(false);
        aLabel.setVisible(false);
        aField.setManaged(false);
        aField.setVisible(false);

        bLabel.setManaged(false);
        bLabel.setVisible(false);
        bField.setManaged(false);
        bField.setVisible(false);

        cLabel.setManaged(false);
        cLabel.setVisible(false);
        cField.setManaged(false);
        cField.setVisible(false);

        dLabel.setManaged(false);
        dLabel.setVisible(false);
        dField.setManaged(false);
        dField.setVisible(false);

        popLabel.setManaged(false);
        popLabel.setVisible(false);
        popField.setManaged(false);
        popField.setVisible(false);

        nastBtn.setManaged(false);
        nastBtn.setVisible(false);

        zapiszBtn.setManaged(false);
        zapiszBtn.setVisible(false);

        rdA.setManaged(false);
        rdB.setManaged(false);
        rdC.setManaged(false);
        rdD.setManaged(false);
//-------------------------------------------------

        powrotBtn.setManaged(false);
        powrotBtn.setVisible(false);

        newPathLabel.setManaged(false);
        newPathLabel.setVisible(false);

        newPathField.setManaged(false);
        newPathField.setVisible(false);

        newPathBtn.setManaged(false);
        newPathBtn.setVisible(false);

        wyjdzButton.setManaged(true);
        wyjdzButton.setVisible(true);

        pytanieText.setManaged(true);
        pytanieText.setVisible(true);
        pytanieText.setText("Rozpocznij QUIZ");

        odpBtn.setManaged(true);
        odpBtn.setVisible(true);

        pathLabel.setManaged(true);
        pathLabel.setVisible(true);

        pathField.setManaged(true);
        pathField.setVisible(true);

        usunBtn.setManaged(true);
        usunBtn.setVisible(true);

        createBtn.setManaged(true);
        createBtn.setVisible(true);



        started = false;
        pkt = 0;
        index = 0;

    }

    public ArrayList<Pytanie> odczyt(String path) throws IOException {
        int i = 0;

        ArrayList<Pytanie> lista = new ArrayList<>();


            String line;
            String text = null;
            String odpA = null;
            String odpB = null;
            String odpC = null;
            String odpD = null;
            int poprawna = 0;
        BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    text = line;
                } else if (i == 1) {
                    odpA = line;
                } else if (i == 2) {
                    odpB = line;
                } else if (i == 3) {
                    odpC = line;
                } else if (i == 4) {
                    odpD = line;
                } else if (i == 5) {
                    poprawna = Integer.parseInt(line);

                    lista.add(new Pytanie(text, poprawna, new String[]{odpA, odpB, odpC, odpD}));
                    i = i-1;
                }

                i++;
            }

        return lista;
    }


    public void zapis(ArrayList<Pytanie> lista, String path){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
           for(Pytanie p : pytania){
               writer.write(p.getText());
               writer.newLine();

               for(String odp : p.getOdp()){
                   writer.write(odp);
                   writer.newLine();
               }

               writer.write("" + p.getPoprawna());
               writer.newLine();
           }

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}