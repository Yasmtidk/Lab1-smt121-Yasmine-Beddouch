package com.yasmine;

public class CapteurTemperature extends Capteur{

    private double temperatureActuelle;

    public CapteurTemperature(){
        typeCapteur = Type.TEMPERATURE;
    }

    public double getDataActuelle(){
        return temperatureActuelle;
    }

    public void setDataActuelle(double dataActuelle){
        this.temperatureActuelle = dataActuelle;
        notifyControlleurs();
    }

}
