package com.yasmine;

import java.util.ArrayList;

public abstract class Capteur {

    protected Enum<Type> typeCapteur;
    private final ArrayList<Controlleur> controlleurs = new ArrayList<>();

    public void attach(Controlleur ctrl){
        controlleurs.add(ctrl);
    }

    public void dettach(Controlleur ctrl){
        controlleurs.remove(ctrl);
    }

    public void notifyControlleurs(){
        for (Controlleur ctrl : controlleurs){
            ctrl.update(this);
        }
    }

    public abstract double getDataActuelle();

    public abstract void setDataActuelle(double dataActuelle);
}
