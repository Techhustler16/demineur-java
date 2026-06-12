/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.text.html.MinimalHTMLWriter;

/**
 *
 * @author daniel
 */
public class Partie {
    
    private LocalDate heureDebut;
    private LocalDate heureFin;
    private boolean gagner = false;
    
    private List<Case> cases = new ArrayList();
    private Miniteur miniteur;
    private CompteurMine compteurMine;
    private Niveau niveau;
    private EtatJeuEnum etat;
    
    public Partie(Niveau niveau){
        this.niveau = niveau;
        this.etat = EtatJeuEnum.ATTENTE;
        int nombereCases = niveau.getNombreCases();
        for(int i = 0; i < nombereCases; i++){
            Case _case = new Case(this);
            this.cases.add(_case);
        }
    }
    
    public Case getCase(int ligne, int colonne) throws Exception {
        int nombreColonnes = this.niveau.getNombreColonnes();
        int position = ligne * nombreColonnes + colonne;
        if(position < 0 || position >= this.niveau.getNombreCases()){
            throw new Exception("Coordonnées invalides");
        }
        return this.cases.get(position);
    }
    
    public void demarrer(Case premiereCase){
        if(this.etat == EtatJeuEnum.ATTENTE){
            this.etat = EtatJeuEnum.ENCOURS;
            this.setMines(premiereCase);
        }
        
    }
   
    
    public void setMines(Case caseExceptee){
        int nombreMines = this.niveau.getNombreMines();
        int nombreCases = this.niveau.getNombreCases();
        int compteur = 0;
        Random random = new Random();
        while(compteur < nombreMines){
            int position = random.nextInt(nombreCases);
            Case _case = this.cases.get(position);
            if(!_case.isMinee() && _case != caseExceptee){
                _case.setMine();
                compteur ++;
            }
        }
        
    }
   
    
    public void terminerAvecEchec(){
        this.etat = EtatJeuEnum.TERMINEE;
        this.toutDevoiler();
    }
    
    public void toutDevoiler(){
        for(Case _case : cases){
            _case.devoiler();
        }
    }

    public LocalDate getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalDate heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalDate getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalDate heureFin) {
        this.heureFin = heureFin;
    }

    public boolean isGagner() {
        return gagner;
    }

    public void setGagner(boolean gagner) {
        this.gagner = gagner;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public Miniteur getMiniteur() {
        return miniteur;
    }

    public void setMiniteur(Miniteur miniteur) {
        this.miniteur = miniteur;
    }

    public CompteurMine getCompteurMine() {
        return compteurMine;
    }

    public void setCompteurMine(CompteurMine compteurMine) {
        this.compteurMine = compteurMine;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    
}
