package MotorInferencia;

import ModuloAdquisicionConocimiento.BaseConocimiento;

public class BaseHechos_Explicacion {

    public BaseConocimiento conocimiento = new BaseConocimiento(); //Con esto podemos acceder a esta instancia desde otros paquetes y clases

    public void problemaMB() {
        if (conocimiento.isBEEP_CODE()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION(
                    "La MotherBoard funciona correctamente"
                    + "\n\nSe ha detectado la precencia de una BEEP CODE"
                    + "\nLos BEEP CODE son pitidos ocasionados por la BIOS en donde indica algun problema de Hardware"
                    + "\nEstos pitidos son diferentes de acuerdo al modelo de BIOS por lo tanto investigue el BeepCode correspondiente a su PC.");
        } else if (conocimiento.isCOMP_MB_Q()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Los componentes se encuentran quemados o inservibles."
                    + "\n\nTenemos que comprobar si la MotherBoard esta funcionando o no."
                    + "Problema ajeno a la MotherBoard.");
        } else if (!conocimiento.isCOMP_MB_Q() && conocimiento.isCOMP_F()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Ya que los componentes funcionan correctamente."
                    + "La MotherBoard puede estar quemada o descompuesta."
                    + "\n\nConsidere el comprar una nueva"
            );
        } else if (!conocimiento.isVOLT_SC()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Cambiar el voltaje suminstrado"
                    + "\n\nLas fuentes de poder cuentan con dos voltajes 120 o 220 volts. "
                    + "\nSi la fuente esta a 220v entonces bajar a 110v y probar otra vez."
                    + "\nEn caso contrario buscar cuanto voltaje necesita la placa en las especificaciones para evitar quemarla por sobre consumo."); //Explicacion/Conclusion
        }
    }

    public void problemaTR() {
        if (!conocimiento.isPUERTO_F()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Puerto descompuesto"
                    + "\n\nSe sugiere cambiar de puerto para verificar si funciona el mismo.");
        } else if (!conocimiento.isUNIDAD_LEGIBLE()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Firmware desactualizado"
                    + "\n\nSe sugiere actualizar el firmware a la version mas reciente estable desde la pagina del fabricante");
        }
    }

    public void problemaDD() {
        if (conocimiento.isAPP_INST_RECIENTE() && conocimiento.isITEMS_OCULTOS_PROTEGIDOS()
                || conocimiento.isVENTANA_ERROR_HD()) { //Reglas de Inferencia y Base de Hechos
            conocimiento.setVIRUS(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Posible presencia de un virus"
                    + "\n\nSe sugiere no leer ni escribir nada, sólo desconectarlo para evitar que se propaguen los errores"
                    + " y los daños a otras zonas y aplicar un analisis con un antivirus de confianza."); //Explicacion/Conclusion                     
        } else if (conocimiento.isFIRMWARE_ACT() && !conocimiento.isUNIDAD_LEGIBLE()) {
            conocimiento.setTABLAS_DANADAS(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Tablas de particiones danadas"
                    + "\n\nSe sugiere instalar alguna aplicación como PhotoRec y reparar las tablas de particiones, "
                    + "hacer una lectura bit a bit, exportar los archivos a un segundo disco en cuarentena, y un borrado seguro, a bajo nivel, una vez hayas recuperado la información."); //Explicacion/Conclusion            
        } else if (conocimiento.isCAIDAS_GOLPES()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("El Disco Duro puede estar inservible"
                    + "\n\nSi el disco duro sufre un zarandeo fuerte o una caída, se pueden dañar la superficie de los platos magnéticos. "
                    + "\nEs decir: que la propia aguja del cabezal lector le haga un garabato al plato (headcrash)."
                    + "\n\nConsiderar comprar uno nuevo o en caso de ser posible mandarlo a arreglar con un servicio especializado."); //Explicacion/Conclusion                           
        } else if (conocimiento.isCAMBIOS_TEMPERATURA()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("La unidad puede estar en peligro o ya inservible"
                    + "\n\nDesconectarlo inmediatamente y llevarlo a reparar a un servicio especializado."); //Explicacion/Conclusion            
        } else if (!conocimiento.isSO_ENCIENDE() && conocimiento.isAPAGONES_DESCONEXIONES()) {
            conocimiento.setMASTER_BOOT_RECORD(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Se ha danado/corrompido el registro Master Boot Record"
                    + "\n\nEsto imposibilita el arranque del Sistema Operativo"
                    + "\nAunque este error puede ser reparado con las propias aplicaciones del sistema (RecoveryDrive.exe), "
                    + "existen alternativas como EaseUS Partition Master que se encargan de hacer lo mismo sin necesidad de ir paso a paso."); //Explicacion/Conclusion            
        } else if (!conocimiento.isTIEMPO_VIDA_ALTO() && !conocimiento.isPC_ENC()) {
            conocimiento.setERROR_FABRICACION(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Posible error de fabricacion"
                    + "\n\nEn caso de tener una garantia valida se recomienda hacer uso de ella o en caso de ser posible mandarlo a arreglar con un servicio especializado."); //Explicacion/Conclusion            
        } else if (!conocimiento.isFIRMWARE_ACT()) {
            conocimiento.setFIRMWARE_ACT(false);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Actualizar el Firmware(controlador) del mismo y probar otra vez."
                    + "\n\nRevisar el número de firmware y buscar una versión actualizada, porque puede tratarse de una mera incompatibilidad."); //Explicacion/Conclusion            
        }

    }

    public void problemaFP() {
        if (!conocimiento.isVENTILADOR_F()) {
            conocimiento.setFP_POLVOSA(true);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("La Fuente de Poder esta sucia."
                    + "\n\nSe recomienda limpiarla para quitar el exceso de polvo ya que esto hace que se atore el ventilador.");
        } else if (conocimiento.isCORTO_CIRCUITO() && !conocimiento.isPC_ENC()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Fuente de Poder quemada"
                    + "\n\nDebido a la constante desconexion de la energia se ha presentado un corto ciruito."
                    + "\nConsiderar comprar una nueva o en caso de ser posible mandarlo a arreglar con un servicio especializado.");
        } else if (conocimiento.isCAPACIDADFP_S() && !conocimiento.isPC_ENC()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Fuente de Poder posiblemente quemada"
                    + "\n\nSe ha superado la capacidad de alimentacion de la fuente."
                    + "\nPruebe a desconectar los dispositivos no escenciales y a encender la PC de nuevo"
                    + "\nEn caso de no ver resultados positivos entonces considerar comprar una nueva o en caso de ser posible mandarlo a arreglar con un servicio especializado.");
        }
    }

    public void problemaRAM() {
        if (conocimiento.isPC_LENTA()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("RAM insuficiente"
                    + "\n\nLa carga excesiva de programas hace que las RAM se saturen pero puede no ser un problema exclusivo de ellas."
                    + "\nConsiderar desinstalar aplicaciones innecesarias o aumentar la cantidad de RAM."
                    + "\nAdemas de verificar si no hay otro componente creando cuellos de botella.");
        } else if (conocimiento.isVENTANA_ERROR_RAM()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("RAM insuficiente"
                    + "\n\nSe ha superado el tamano de almacenamiento posible y se han desbordado."
                    + "\nChecar el error lanzado por la ventana y corregirlo.");
        } else if (!conocimiento.isUNIDAD_LEGIBLE() && conocimiento.isPINES_MR_L()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("RAM danadas"
                    + "\n\nConsiderar comprar una nueva o en caso de ser posible mandarlo a arreglar con un servicio especializado.");
        }
    }

    public void problemaTG() {
        if (conocimiento.isVENTANA_ERROR_TG()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Error de Tarjeta Grafica"
                    + "\n\nChecar el error lanzado por la ventana y corregirlo.");
        } else if (conocimiento.isMSG_W()) {
            conocimiento.setFIRMWARE_ACT(false);
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Posibles problemas de la Tarjeta Grafica"
                    + "\n\nWindows lanza estos mensajes cuando el controlador deja de funcionar por un momento."
                    + "\nSe sugiere actualizar el firmware a la version mas reciente estable desde la pagina del fabricante");
        } else if (conocimiento.isARTF_P()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("Artefactos en pantalla"
                    + "\n\nSe muestran imágenes bizarras en pantalla, síntoma de que la GPU no ha procesado correctamente los polígonos, colores u otras figuras de la imagen.");
        } else if (conocimiento.isVENT_TI() || conocimiento.isCAMBIOS_TEMPERATURA()) {
            conocimiento.setCONCLUSION(true);
            conocimiento.setEXPLICACION("No se está refrigerando correctamente la GPU"
                    + "\nSe recomienda comprar una nueva o en caso de ser posible mandarlo a arreglar con un servicio especializado.");
        }
    }

}
