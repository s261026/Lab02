package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	LinkedList<Parole> inserite = new LinkedList<Parole>();
	LinkedHashMap<String, String> inserimenti = new LinkedHashMap<String, String>();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtWord;

	@FXML
	private Button btnTranslate;

	@FXML
	private TextArea txtArea;

	@FXML
	private Button btnClear;

	@FXML
	void doClear(ActionEvent event) {
		txtArea.clear();
		txtWord.clear();

	}

	@FXML
	void doTranslate(ActionEvent event) {

		/*
		 * Lo scopo del programma (Figura 1) è quello di permettere all’utente di:
		 * 
		 * - Inserire una nuova parola e la relativa traduzione secondo il seguente
		 * pattern: <parola aliena> <traduzione> (separate da uno spazio) Cliccando sul
		 * bottone Translate la parola viene aggiunta al dizionario.
		 * 
		 * - Cercare la traduzione di una parola esistente inserendo <parola aliena> e
		 * facendo click sul bottone Translate. La traduzione verrà visualizzata
		 * nell’area di testo sottostante.
		 * 
		 * 
		 * Implementare i controlli per eventuali errori sull’input: gli unici caratteri
		 * ammessi sono [a-zA-Z] (ossia solo le lettere alfabetiche, siano essere
		 * maiuscole o minuscole), ma la ricerca deve essere case insensitive. Si
		 * suggerisce di convertire tutto il testo ricevuto in minuscolo prima di
		 * elaborarlo.
		 */

		String parolaInserita = txtWord.getText();

		if(parolaInserita.contains(String.valueOf(Math.random())))
			txtArea.appendText("Numeri non permessi");
			
		else
		{

			String[] campi;
			boolean trovata = false;
			
			
			if (parolaInserita.contains(" ")) {
				campi = parolaInserita.split(" ");
				Parole p = new Parole(campi[0], campi[1]);
				
				for (Parole pp: inserite)
					if(campi[0].equals(pp.getParola()))
						trovata = true;
				//RIVEDI		
				if (campi[1] != null && trovata == true) {
					// inserimenti.put(alieno, italiano);
					p.varie.add(campi[1]);
					txtArea.appendText("Le traduzioni italiane di " + campi[0] + " sono: " + p.varie + "\n");
					System.out.println(p.varie);
					}
				else if(campi[1] != null && trovata == false) {
							
							inserite.add(p);
							p.varie.add(campi[1]);
							txtArea.appendText("La traduzione italiana di " + campi[0] + " è: " + campi[1] + "\n");
						}
					
				else if(campi[1]==null) {
					txtArea.appendText(
							"Per tradurre eliminare lo spazio dopo la parola\nPer aggiungere inserire parola e traduzione\n");
				}	
					
					
				} 

			 else {
				/*
				 * for (int i=0; i<inserimenti.size(); i++)
				 * if(parolaInserita.equalsIgnoreCase(inserimenti.get(i)))
				 * txtArea.appendText(inserimenti.values().toString()); else
				 * txtArea.appendText("Parola aliena non presente nel dizionario");
				 */

				for (Parole pp : inserite)
					if (pp.getParola().equalsIgnoreCase(parolaInserita))
						txtArea.appendText("La traduzione di " + pp.getParola() + " è: " + pp.getTraduzione() + "\n");
					else
						txtArea.appendText("Parola aliena non presente nel dizionario\n");
			}
			
		}
		

		txtWord.clear();

	}

	@FXML
	void initialize() {
		assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

	}
}
