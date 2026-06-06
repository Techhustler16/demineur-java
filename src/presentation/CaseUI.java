/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import metier.Case;

/**
 *
 * @author daniel
 */
public class CaseUI extends JButton {
    
    private final Case caseMetier;
    private final Plateau plateau;
    
    public CaseUI(Case caseMetier, Plateau plateau){
        this.caseMetier = caseMetier;
        this.plateau = plateau;
        EcouteurCaseUI ecouteur = new EcouteurCaseUI();
        this.addMouseListener(ecouteur);
        this.afficher();
    }
    
    public Case getCaseMetier(){
        return this.caseMetier;
    }
    
    public void afficher(){
        if(this.caseMetier.isDevoilee()){
            if(this.caseMetier.isMinee()){
                this.afficherMine();
            } else {
                this.afficherContenu();
            }
        } else if(this.caseMetier.isMarquee()){
            this.afficherDrapeau();
        } else {
            this.setIcon(null);
        }
    }
    
    public void afficherContenu(){
        this.setBackground(Color.WHITE);
        String texte = this.caseMetier.getContenu();
        this.setText(texte);
    }
    
    public void afficherDrapeau(){
        URL url = getClass().getResource("/images/drapeau.jpeg");
        ImageIcon icone = new ImageIcon(url);
        this.setIcon(icone);
    }
    
    public void afficherMine(){
        URL url = getClass().getResource("/images/mine.jpeg");
        ImageIcon icone = new ImageIcon(url);
        this.setIcon(icone);
    }

    public Plateau getPlateau() {
        return plateau;
    }
    
}
