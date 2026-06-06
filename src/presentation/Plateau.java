/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import metier.Case;
import metier.Partie;

/**
 *
 * @author daniel
 */
public class Plateau extends JFrame {
    
    private Partie partie;
    private JPanel champ = new JPanel();
    private final List<CaseUI> casesUIs = new ArrayList<>();
    
    public Plateau(Partie partie){
        this.partie = partie;
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.initialiserChamp();
        this.add(champ, BorderLayout.CENTER);
    }
    
    public void afficher(){
        for(CaseUI casesUI : casesUIs){
            casesUI.afficher();
        }
    }
    
    private void initialiserChamp(){
        int nombreLignes = this.partie.getNiveau().getNombreLignes();
        int nombreColonnes = this.partie.getNiveau().getNombreColonnes();
        champ.setLayout(new GridLayout(nombreLignes, nombreColonnes));
        
        for (Case _case: this.partie.getCases()){
            CaseUI caseUI = new CaseUI(_case, this);
            this.casesUIs.add(caseUI);
            this.champ.add(caseUI);
        }
    }

    public List<CaseUI> getCaseUIs() {
        return casesUIs;
    }
    
}
