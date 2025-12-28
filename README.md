
<< Interface >> 
Controlleur

<< abstract >>  
Capteur

Type

observers

+ enum Type {PRESSION, TEMPERATURE }

# typeCapteur : Enum<Type>
- controlleurs: ArrayList<Controlleur> {leaf}

+ attach(ctrl : Controlleur) : void
+ dettach(ctrl : Controlleur) : void
+ notifyControlleurs() : void

+ getDataAcuelle() : double
+ setDataActuelle(double dataActuelle) : void

typeCapteur

+ update(capteur: Capteur)

Abstract 
methods 

ConcreteControlleur

- chauffageActif : boolean
- climatisationActif : boolean
- ventilationActif : boolean

+ update(capteur: Capteur)

CapteurPression

CapteurTemperature

capteur

- pression : double


+ getDataAcuelle() : double
+ setDataActuelle(double dataActuelle) : void

- temperature : double 


+ getDataAcuelle() : double
+ setDataActuelle(double dataActuelle) : void

MAIN : SIMULATION
£ - --.....-
*
=
+ - - - - . ..-<img width="2368" height="3142" alt="image" src="https://github.com/user-attachments/assets/cf7859a1-fca7-44f3-b16e-438004217863" />
