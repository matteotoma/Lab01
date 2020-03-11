package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTime;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    void doCancella(ActionEvent event) {
    	double start = System.nanoTime();
    	String c = txtResult.getSelectedText();
    	elenco.cancella(c);
    	String risultato = "";
    	for(String s: elenco.getElenco()) {
    		if(risultato.equals(""))
    			risultato += s;
    		else
    			risultato += "\n" + s;
    	}
    	txtResult.clear();
    	txtResult.appendText(risultato);
    	txtTime.clear();
    	double finish = System.nanoTime();
    	txtTime.appendText(""+(finish-start));
    }

    @FXML
    void doInsert(ActionEvent event) {
    	double start = System.nanoTime();
    	String p = txtParola.getText();
    	elenco.addParola(p);
    	String risultato = "";
    	for(String s: elenco.getElenco()) {
    		if(risultato.equals(""))
    			risultato += s;
    		else
    			risultato += "\n" + s;
    	}
    	txtResult.clear();
    	txtResult.appendText(risultato);
    	txtParola.clear();
    	txtTime.clear();
    	double finish = System.nanoTime();
    	txtTime.appendText(""+(finish-start));
    }

    @FXML
    void doReset(ActionEvent event) {
    	double start = System.nanoTime();
    	txtResult.clear();
    	elenco.reset();
    	txtTime.clear();
    	double finish = System.nanoTime();
    	txtTime.appendText(""+(finish-start));
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
