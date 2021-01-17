/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloInterfazUsuario;

import MotorInferencia.BaseHechos_Explicacion;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author Vasquez
 */
public class FallasPC {

    BaseHechos_Explicacion motorI = new BaseHechos_Explicacion();

    public void fallaMB(Component rootPane) {
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Al encender la PC escucha pitidos provenientes de la misma?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setBEEP_CODE((respuesta == 0) ? true : false);
        motorI.problemaMB(); //Primero se evalua de acuerdo a las reglas de inferencia
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Hay componentes o partes de la placa quemados?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setCOMP_MB_Q((respuesta == 0) ? true : false);
        motorI.problemaMB();
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION());
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Los componentes funcionan en una placa diferente?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setCOMP_F((respuesta == 0) ? true : false);
        motorI.problemaMB();
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION());
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "El voltaje suministrado por la fuente de poder es el correcto?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setVOLT_SC((respuesta == 0) ? true : false);
        motorI.problemaMB();
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION());
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Vamos a probar a restablecer el CMOS\nPrimero Quitamos la Pila de reloj del BIOS\n"
                + "Esperamos 5 minutos antes de volver a colocarla\nEnciende?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            motorI.conocimiento.setPC_ENC(true);
            motorI.problemaMB();
            if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
                JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION());
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "La MotherBoard es inservible");
            System.exit(0);
        }

    }

    public void fallaTR(Component rootPane) {
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Al conectar el cable de red ¿Es detectado?");
        motorI.conocimiento.setIRQ_CONTROL((respuesta == 0) ? true : false);
        motorI.problemaTR();
        if (motorI.conocimiento.isCONCLUSION()) {
            JOptionPane.showConfirmDialog(rootPane, motorI.conocimiento.getEXPLICACION());
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "¿Hay algún otro dispositivo de red exterior conectado a la PC?");
        if (respuesta == 1) {
            respuesta = JOptionPane.showConfirmDialog(rootPane, "Revisar conexión de hardware externo", "Preguntas", YES_NO_OPTION, INFORMATION_MESSAGE);
            motorI.conocimiento.setDMA((respuesta == 0) ? true : false);
            motorI.problemaTR();
            if (motorI.conocimiento.isCONCLUSION()) {
                JOptionPane.showConfirmDialog(rootPane, motorI.conocimiento.getEXPLICACION());
                System.exit(0);
            }
        }
        respuesta = JOptionPane.showConfirmDialog(rootPane, "¿Hay conexión inalambrica activa?", "Preguntas", YES_NO_OPTION, INFORMATION_MESSAGE);
        if (respuesta == 1) {
            respuesta = JOptionPane.showConfirmDialog(rootPane, "Todo funciona correctamente", "Preguntas", INFORMATION_MESSAGE);
            motorI.conocimiento.setDNS_CLEAN((respuesta == 0) ? true : false);
            motorI.problemaTR();
            if (motorI.conocimiento.isCONCLUSION()) {
                JOptionPane.showConfirmDialog(rootPane, motorI.conocimiento.getEXPLICACION());
                System.exit(0);
            }
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Analizar mediante el gestor de soluciones un posible fallo de conexión");
        motorI.conocimiento.setDNS_CLEAN((respuesta == 0) ? true : false);
        motorI.problemaTR();
        if (motorI.conocimiento.isCONCLUSION()) {
            JOptionPane.showConfirmDialog(rootPane, motorI.conocimiento.getEXPLICACION());
            System.exit(0);
        }
    }

    public void fallaDD(Component rootPane) {
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Se han instalados aplicaciones recientemente?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setAPP_INST_RECIENTE((respuesta == 0) ? true : false);
        respuesta = JOptionPane.showConfirmDialog(rootPane, "Los archivos aparerecen como protegidos u ocultos?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setITEMS_OCULTOS_PROTEGIDOS((respuesta == 0) ? true : false);
        respuesta = JOptionPane.showConfirmDialog(rootPane, "Aparecen ventanas de error constantemente?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setVENTANA_ERROR_HD((respuesta == 0) ? true : false);
        motorI.problemaDD();//Primero se evalua de acuerdo a las reglas de inferencia
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "El BIOS detecta al dispositivo conectado?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            motorI.conocimiento.setFIRMWARE_ACT(true);
            respuesta = JOptionPane.showConfirmDialog(rootPane, "Hay acceso de escritura y/o lectura al Disco Duro?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            motorI.conocimiento.setUNIDAD_LEGIBLE((respuesta == 0) ? true : false);
            motorI.problemaDD();//Primero se evalua de acuerdo a las reglas de inferencia
            if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
                JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
                System.exit(0);
            }
        } else {
            respuesta = JOptionPane.showConfirmDialog(rootPane, "El Firmware o controlador esta actualizado?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            motorI.conocimiento.setFIRMWARE_ACT((respuesta == 0) ? true : false);
            motorI.problemaDD();//Primero se evalua de acuerdo a las reglas de inferencia
            if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
                JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
                System.exit(0);
            }
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "La PC o el DD ha subrido caidas o golpes recientemente?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setCAIDAS_GOLPES((respuesta == 0) ? true : false);
        motorI.problemaDD();//Primero se evalua de acuerdo a las reglas de inferencia
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Se presentan cambios de temperatura constantemente?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setCAMBIOS_TEMPERATURA((respuesta == 0) ? true : false);
        motorI.problemaDD();//Primero se evalua de acuerdo a las reglas de inferencia
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Ha habido apagones o desconexiones?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setAPAGONES_DESCONEXIONES((respuesta == 0) ? true : false);
        respuesta = JOptionPane.showConfirmDialog(rootPane, "El SO arranca normalmente?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setSO_ENCIENDE((respuesta == 0) ? true : false);
        motorI.problemaDD();//Primero se evalua de acuerdo a las reglas de inferencia
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "El tiempo de vida es alto?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setTIEMPO_VIDA_ALTO((respuesta == 0) ? true : false);
        motorI.conocimiento.setPC_ENC((respuesta == 0) ? true : false);
        motorI.problemaDD();//Primero se evalua de acuerdo a las reglas de inferencia
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

    }

    public void fallaFP(Component rootPane) {
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(rootPane, "El ventilador de la Fuente de Poder funciona?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setVENTILADOR_F((respuesta == 0) ? true : false);
        motorI.problemaFP();//Primero se evalua de acuerdo a las reglas de inferencia
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Ha sufrido de apagones o desconexiones recientemente?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setCORTO_CIRCUITO((respuesta == 0) ? true : false);
        motorI.problemaFP();//Primero se evalua de acuerdo a las reglas de inferencia
        if (respuesta == 0) {
            respuesta = JOptionPane.showConfirmDialog(rootPane, "La PC enciende?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            motorI.conocimiento.setPC_ENC((respuesta == 0) ? true : false);
            motorI.problemaFP();//Primero se evalua de acuerdo a las reglas de inferencia
            if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
                JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
                System.exit(0);
            }
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Ha conectado dispositivos nuevos recientemente?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setCAPACIDADFP_S((respuesta == 0) ? true : false);
        motorI.conocimiento.setPC_ENC(false);
        motorI.problemaFP();//Primero se evalua de acuerdo a las reglas de inferencia
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

    }

    public void fallaRAM(Component rootPane) {
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(rootPane, "La PC esta lenta?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setPC_LENTA((respuesta == 0) ? true : false);
        motorI.problemaRAM();//Primero se evalua de acuerdo a las reglas de inferencia        
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Ha aparecido alguna ventana de error?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setVENTANA_ERROR_RAM((respuesta == 0) ? true : false);
        motorI.problemaRAM();//Primero se evalua de acuerdo a las reglas de inferencia        
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "El BIOS detecta las memorias RAM?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setUNIDAD_LEGIBLE((respuesta == 0) ? true : false);
        respuesta = JOptionPane.showConfirmDialog(rootPane, "Los pines de conexion de las memorias estan limpias?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setPINES_MR_L((respuesta == 0) ? true : false);
        if (respuesta == 0) {
            motorI.problemaRAM();//Primero se evalua de acuerdo a las reglas de inferencia
            if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
                JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Limpiar los pines con una goma de borrar de pan y volver a intentarlo.", "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

    }

    public void fallaTG(Component rootPane) {
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Han aparecido ventanas de error?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setVENTANA_ERROR_TG((respuesta == 0) ? true : false);
        motorI.problemaTG();//Primero se evalua de acuerdo a las reglas de inferencia        
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Han aparecido mensajes de windows de error?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setMSG_W((respuesta == 0) ? true : false);
        motorI.problemaTG();//Primero se evalua de acuerdo a las reglas de inferencia        
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Han aparecido nieve o signos extranos en la pantalla?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setARTF_P((respuesta == 0) ? true : false);
        motorI.problemaTG();//Primero se evalua de acuerdo a las reglas de inferencia        
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }

        respuesta = JOptionPane.showConfirmDialog(rootPane, "Al iniciar la PC los ventiladores arrancan a su maxima capacidad?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setVENT_TI((respuesta == 0) ? true : false);
        respuesta = JOptionPane.showConfirmDialog(rootPane, "Se presentan cambios de temperatura muy radicales?", "Preguntas", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        motorI.conocimiento.setCAMBIOS_TEMPERATURA((respuesta == 0) ? true : false);
        motorI.problemaTG();//Primero se evalua de acuerdo a las reglas de inferencia        
        if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
            JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION(), "Conclusion", INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}
