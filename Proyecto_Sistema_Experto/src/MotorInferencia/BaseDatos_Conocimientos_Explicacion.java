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
}
