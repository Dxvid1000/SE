package MotorInferencia;

import ModuloAdquisicionConocimiento.BaseConocimiento;

public class BaseDatos_Conocimientos_Explicacion {

    public BaseConocimiento conocimiento = new BaseConocimiento(); //Con esto podemos acceder a esta instancia desde otros paquetes y clases

    public void problemaMB() {
        if (conocimiento.isPC_ENC()) { //Reglas de Inferencia y Base de Hechos
            conocimiento.setMB_F(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("La MotherBoard funciona correctamente"); //Explicacion/Conclusion
        } else if (conocimiento.isBEEP_CODE()) { 
            conocimiento.setMB_F(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Problema ajeno a la motherboard \n"
                    + "Investigue el BeepCode correspondiente de acuerdo al que escucha en su PC\n\n"
                    + "La MotherBoard funciona correctamente");
        } else if (conocimiento.isCOMP_MB_Q()) {
            conocimiento.setMB_F(false);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Pruebe cambiar los componentes quemados\n"
                    + "En caso de que sea la MB la que esta quemada entonces\n\n"
                    + "La MotherBoard es inservible"); 
        } else if (!conocimiento.isCOMP_MB_Q() && conocimiento.isCOMP_F()) {
            conocimiento.setMB_F(false);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("La MotherBoard es inservible");
        } else if (conocimiento.isVOLT_SC() && !conocimiento.isPC_ENC()) {
            conocimiento.setMB_F(false);
        }
    }
    
    public void problemaTR(){
        if(conocimiento.isPOLLNG()){
           conocimiento.setIRQ_CONTROL(true);
           conocimiento.setCONCLUSION(true);
           conocimiento.setEXPLICACION("El estado del periferico de red funciona correctamente");
        } else if(conocimiento.isENT_PROGRAMADA()) {
           conocimiento.setENT_PROGRAMDA(false);
           conocimiento.setCONCLUSION(true);
           conocimiento.setEXPLICACION("Revise la compatibilidad del cable de red con la entrada de red \n"
                   + "Conecte de manera correcta el cable \n"
                   + "El periferico de red esta dañado");
        } else if (conocimiento.isDNS_CLEAN()){
           conocimiento.setDNS_CLEAN(false);
           conocimiento.setCONCLUSION(true);
           conocimiento.setEXPLICACION("¿Tiene conexión WiFi? \n" 
           + "Revise el diagnostico del solucionador de problemas \n"
           + "Si detecta una falla de hardware, hay que cambiar la tarjeta de red");
        }
    }

}
