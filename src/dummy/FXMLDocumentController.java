/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.jpl7.Query;
import org.jpl7.Term;
/**
 *
 * @author Administrator
 */

 
public class FXMLDocumentController implements Initializable {
   
    private String q;
    private String odgovor;
    private String ispis="";
    private String pitanje;
    @FXML
    private TextArea txtareaPrikaz;
    @FXML
    private TextField txtfieldq;
    
    @FXML
    private void klikNaGumbic(ActionEvent event) {
        pitanje="";
        pitanje=txtfieldq.getText();
        ispis += odgovor(pitanje);
        ispis += System.getProperty("line.separator");
        txtareaPrikaz.setText(ispis);
        txtfieldq.setText("");
    }
    
    @FXML 
    private String odgovor (String pitanje){
        q="";
        String file = "consult('proba.pl')";
        Query query = new Query(file);
        System.out.println(query.hasSolution() ? "success" : "error");
        
        String []strArray=pitanje.replace(" ", ", ").replace(".", "").replace("?", "").replace("!","").split(" ");
        q += "alter([";
        
        for(int i=0;i<strArray.length;i++){
            q += strArray[i];
        }
        q += "],X).";
        Query query2 = new Query(q);
        query2.open();
        
        odgovor = query2.getSolution().get("X").toString();
        odgovor = odgovor.replaceAll("[^a-zA-Z0-9\\u0020]","");
        query2.close();
        
        if (odgovor.equals(pitanje + " ")){
            return "Ne znam. :)";
        }
        else{
            return odgovor;
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
