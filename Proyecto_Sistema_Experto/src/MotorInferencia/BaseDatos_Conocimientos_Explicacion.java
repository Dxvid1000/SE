package MotorInferencia;

import ModuloAdquisicionConocimiento.BaseConocimiento;

public class BaseDatos_Conocimientos_Explicacion {

    public BaseConocimiento conocimiento = new BaseConocimiento(); //Con esto podemos acceder a esta instancia desde otros paquetes y clases

    public void problemaMB() {
        if (conocimiento.isPC_ENC()) { //Reglas de Inferencia y Base de Hechos
            conocimiento.setMB_F(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("La PC no presenta ningun problema con la motherboard ya que enciende normalmente."
                    + "\nLa MotherBoard funciona correctamente"); //Explicacion/Conclusion
        } else if (conocimiento.isBEEP_CODE()) {
            conocimiento.setMB_F(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION(
                    "La MotherBoard funciona correctamente"
                    + "\n\nSe ha detectado la precencia de una BEEP CODE"
                    + "\nLos BEEP CODE son pitidos ocasionados por la BIOS en donde indica algun problema de Hardware"
                    + "\n\nEstos pitidos son diferentes de acuerdo al modelo de BIOS por lo tanto investigue el BeepCode correspondiente a su PC.");
        } else if (conocimiento.isCOMP_MB_Q()) {
            conocimiento.setMB_F(false);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Los componentes se encuentran quemados o inservibles.\n\n"
                    + "\nTenemos que comprobar si la MotherBoard esta funcionando o no."
                    + "\n\nProblema ajeno a la MotherBoard.");
        } else if (!conocimiento.isCOMP_MB_Q() && conocimiento.isCOMP_F()) {
            conocimiento.setMB_F(false);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Ya que los componentes funcionan correctamente."
                    + "La MotherBoard puede estar quemada o descompuesta."
                    + "\n\nConsidere el comprar una nueva"
            );
        } else if (conocimiento.isVOLT_SC() && !conocimiento.isPC_ENC()) {
            conocimiento.setMB_F(false);
        }
    }

    public void problemaTR() {
        if (conocimiento.isPOLLNG()) {
            conocimiento.setIRQ_CONTROL(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("El estado del periferico de red funciona correctamente");
        } else if (conocimiento.isENT_PROGRAMADA()) {
            conocimiento.setENT_PROGRAMDA(false);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Revise la compatibilidad del cable de red con la entrada de red \n"
                    + "Conecte de manera correcta el cable \n"
                    + "El periferico de red esta dañado");
        } else if (conocimiento.isDNS_CLEAN()) {
            conocimiento.setDNS_CLEAN(false);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("¿Tiene conexión WiFi? \n"
                    + "Revise el diagnostico del solucionador de problemas \n"
                    + "Si detecta una falla de hardware, hay que cambiar la tarjeta de red");
        }
    }

}
