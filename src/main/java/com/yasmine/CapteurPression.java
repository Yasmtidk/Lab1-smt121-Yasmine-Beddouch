package com.yasmine;

public class CapteurPression extends Capteur{

    private double pressionActuelle;

    public CapteurPression(){
        typeCapteur = Type.PRESSION;
    }

    public double getDataActuelle(){
        return pressionActuelle;
    }

    public void setDataActuelle(double dataActuelle){
        this.pressionActuelle = dataActuelle;
        notifyControlleurs();
    }
}
