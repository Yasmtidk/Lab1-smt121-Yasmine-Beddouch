package com.yasmine;

public class ConcreteControlleur implements Controlleur{

    protected boolean ventilationActif = false;
    protected boolean chauffageActif = false;
    protected boolean climatisationActif = false;
    private final double TEMPCHOISI = 22.0;
    private final double PRESSIONCHOISI = 1000.0;


    @Override
    public void update(Capteur capteur) {

        System.out.print("\n--> Controleur : nouvelle valeur recue : ");

        if (capteur.typeCapteur.equals(Type.TEMPERATURE)) {

            double tempActuelle = capteur.getDataActuelle();
            System.out.printf("mesure de temperature = "+ tempActuelle +"'C ");
            analyseTemperature(tempActuelle);

        } else if(capteur.typeCapteur.equals(Type.PRESSION)){

            double pressionActuelle = capteur.getDataActuelle();
            System.out.printf("mesure de CO2 = "+ pressionActuelle +"ppm");
            analysePression(pressionActuelle);
        }
    }

    public void analyseTemperature(double tempActuelle){

        /**------------------------------------------------WHEN IT'S TOO COLD------------**/
        if(tempActuelle < TEMPCHOISI){

            //--------------------------------(Clim = OFF ==> Clim = OFF)
            if(!climatisationActif){
                System.out.print("\n    ==> STATE : Climatisation stays OFF.") ;
            }
            //--------------------------------(Clim = ON --> Clim = OFF)
            else{
                System.out.print("\n--> Controleur : Climatisation arretee.");
            }
            //---------------------------------TURN OFF the climatisation
            climatisationActif = false ;

            //--------------------------------(Chauffage = ON ==> Chauffage = ON)
            if(chauffageActif){
                System.out.print("\n    ==> STATE : Chauffage stays ON.") ;
            }
            //--------------------------------(Chauffage = OFF --> Chauffage = ON)
            else{
                System.out.print("\n--> Controleur : Chauffage demarre.");
            }
            //---------------------------------TURN ON the chauffage
            chauffageActif = true;
        }

        /**-------------------------------------------------WHEN IT'S TOO HOT----------------**/
        else if(TEMPCHOISI < tempActuelle){

            //--------------------------------(Clim = ON ==> Clim = ON)
            if(climatisationActif){
                System.out.print("\n  ==> STATE : Climatisation stays ON.") ;
            }
            //--------------------------------(Clim = OFF --> Clim = ON)
            else{
                System.out.print("\n--> Controleur : Climatisation demarre.");
            }
            //---------------------------------TURN ON the climatisation
            climatisationActif = true;

            //--------------------------------(Chauffage = OFF ==> Chauffage = OFF)
            if(!chauffageActif){
                System.out.print("\n  ==> STATE : Chauffage stays OFF.") ;
            }
            //--------------------------------(Chauffage = ON --> Chauffage = OFF)
            else{
                System.out.print("\n--> Controleur : Chauffage arretee.");
            }
            //---------------------------------TURN OFF the chauffage
            chauffageActif = false ;

        }
        /**------------------------------------------------WHEN IT'S THE PERFECT TEMP-----**/
        else {

            //--------------------------------(Clim = OFF ==> Clim = OFF)
            if(!climatisationActif){
                System.out.print("\n  ==> STATE : Climatisation stays OFF.") ;
            }
            //--------------------------------(Clim = ON --> Clim = OFF)
            else{
                System.out.print("\n--> Controleur : Climatisation arretee.");
            }
            //---------------------------------TURN OFF the climatisation
            climatisationActif = false ;

            //--------------------------------(Chauffage = OFF ==> Chauffage = OFF)
            if(!chauffageActif){
                System.out.print("\n  ==> STATE : Chauffage stays OFF.") ;
            }
            //--------------------------------(Chauffage = ON --> Chauffage = OFF)
            else{
                System.out.print("\n--> Controleur : Chauffage arretee.");
            }
            //---------------------------------TURN OFF the chauffage
            chauffageActif = false ;
        }
    }

    public void analysePression(double pressionActuelle){

        /**------------------------------------------------WHEN THE PRESSURE IS TOO HIGH---**/
        if (PRESSIONCHOISI < pressionActuelle) {
            //--------------------------------(Vent = ON ==> Vent = ON)
            if (ventilationActif) {
                System.out.print("\n  ==> STATE : Ventilation stays ON.");
            }
            //--------------------------------(Vent = OFF --> Vent = ON)
            else{
                System.out.print("\n--> Controleur : Ventilation demarre.");
            }
            //---------------------------------TURN ON the vent
            ventilationActif = true;

        /**------------------------------------------------WHEN IT'S THE PERFECT PRESSURE---**/
        }else{

            //--------------------------------(Vent = OFF ==> Vent = OFF)
            if(!ventilationActif) {
                System.out.print("\n  ==> STATE : Ventilation stays OFF.");
            }
            //--------------------------------(Vent = ON --> Vent = OFF)
            else{
                System.out.print("\n--> Controleur : Ventilation arretee.");
            }
            //---------------------------------TURN OFF the vent
            ventilationActif = false;
        }
    }
}
