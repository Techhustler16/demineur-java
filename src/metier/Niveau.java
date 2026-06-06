/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

/**
 *
 * @author daniel
 */
public class Niveau {
    
    private final String libelle;
    private final int nombreLignes;
    private final int nombreColonnes;
    private final int nombreMines;
    
    public Niveau(){
        this("Débutant", 9, 9, 10);
    }
    
    public Niveau(String libelle, int nombreLignes, int nombreColonnes, int nombreMines){
        this.libelle = libelle;
        this.nombreLignes = nombreLignes;
        this.nombreColonnes = nombreColonnes;
        this.nombreMines = nombreMines;
    }
    
    public int getNombreCases(){
        return this.nombreLignes * this.nombreColonnes;
    }
    
    public String getLibelle(){
        return this.libelle;
    }

    public int getNombreLignes() {
        return nombreLignes;
    }

    public int getNombreColonnes() {
        return nombreColonnes;
    }

    public int getNombreMines() {
        return nombreMines;
    }
    
}
