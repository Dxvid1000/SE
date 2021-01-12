/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloInterfazUsuario;

import MotorInferencia.BaseDatos_Conocimientos_Explicacion;
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
    BaseDatos_Conocimientos_Explicacion motorI = new BaseDatos_Conocimientos_Explicacion();
    ImageIcon iconoP = new ImageIcon("pregunta.jpg");

    public void fallaMB(Component rootPane){
        int respuesta;
        
            respuesta = JOptionPane.showConfirmDialog(rootPane, "Al encender la PC escucha pitidos provenientes de la misma?", "Preguntas", YES_NO_OPTION, INFORMATION_MESSAGE, iconoP);
            motorI.conocimiento.setBEEP_CODE((respuesta == 0) ? true : false);
            motorI.problemaMB(); //Primero se evalua de acuerdo a las reglas de inferencia
            if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
                JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION());
                System.exit(0);
            }

            respuesta = JOptionPane.showConfirmDialog(rootPane, "Hay componentes o partes de la placa quemados?", "Preguntas", YES_NO_OPTION, INFORMATION_MESSAGE, iconoP);
            motorI.conocimiento.setCOMP_MB_Q((respuesta == 0) ? true : false);
            motorI.problemaMB();
            if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
                JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION());
                System.exit(0);
            }

            respuesta = JOptionPane.showConfirmDialog(rootPane, "Los componentes funcionan en una placa diferente?", "Preguntas", YES_NO_OPTION, INFORMATION_MESSAGE, iconoP);
            motorI.conocimiento.setCOMP_F((respuesta == 0) ? true : false);
            motorI.problemaMB();
            if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
                JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION());
                System.exit(0);
            }

            respuesta = JOptionPane.showConfirmDialog(rootPane, "El voltaje suministrado por la fuente de poder es el correcto?", "Preguntas", YES_NO_OPTION, INFORMATION_MESSAGE, iconoP);
            if (respuesta == 1) {
                respuesta = JOptionPane.showConfirmDialog(rootPane, "Cambiar al voltaje correcto y probar a encender la PC\nEnciende?", "Preguntas", YES_NO_OPTION, INFORMATION_MESSAGE, iconoP);
                motorI.conocimiento.setPC_ENC((respuesta == 0) ? true : false);
                motorI.problemaMB();
                if (motorI.conocimiento.isCONCLUSION()) { //Si se logro una conclusion entonces se muestra, si no entonces continua con las demas preguntas...
                    JOptionPane.showMessageDialog(rootPane, motorI.conocimiento.getEXPLICACION());
                    System.exit(0);
                }
            }

            respuesta = JOptionPane.showConfirmDialog(rootPane, "Vamos a probar a restablecer el CMOS\nPrimero Quitamos la Pila de reloj del BIOS\n"
                    + "Esperamos 5 minutos antes de volver a colocarla\nEnciende?", "Preguntas", YES_NO_OPTION, INFORMATION_MESSAGE, iconoP);
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
    
    public void fallaTR(Component rootPane){
        int respuesta; 
        
        respuesta = JOptionPane.showConfirmDialog(rootPane, "Al conectar el cable de red ¿Es detectado?");
        motorI.conocimiento.setIRQ_CONTROL((respuesta == 0)? true : false);
        motorI.problemaTR();
        if (motorI.conocimiento.isCONCLUSION()){
            JOptionPane.showConfirmDialog(rootPane, motorI.conocimiento.getEXPLICACION());
            System.exit(0);
        }
        
        respuesta = JOptionPane.showConfirmDialog(rootPane, "¿Hay algún otro dispositivo de red exterior conectado a la PC?");
        if(respuesta == 1){
            respuesta = JOptionPane.showConfirmDialog(rootPane, "Revisar conexión de hardware externo", "Preguntas", YES_NO_OPTION, INFORMATION_MESSAGE);
            motorI.conocimiento.setDMA((respuesta == 0) ? true : false);
            motorI.problemaTR();
        if (motorI.conocimiento.isCONCLUSION()){
            JOptionPane.showConfirmDialog(rootPane, motorI.conocimiento.getEXPLICACION());
            System.exit(0);
            }
        }
        respuesta = JOptionPane.showConfirmDialog(rootPane, "¿Hay conexión inalambrica activa?","Preguntas",YES_NO_OPTION, INFORMATION_MESSAGE);
        if(respuesta == 1){
            respuesta =JOptionPane.showConfirmDialog(rootPane, "Todo funciona correctamente", "Preguntas", INFORMATION_MESSAGE);
            motorI.conocimiento.setDNS_CLEAN((respuesta == 0)? true : false);
            motorI.problemaTR();
        if (motorI.conocimiento.isCONCLUSION()){
            JOptionPane.showConfirmDialog(rootPane, motorI.conocimiento.getEXPLICACION());
            System.exit(0);
            }
        }
    
        respuesta = JOptionPane.showConfirmDialog(rootPane, "Analizar mediante el gestor de soluciones un posible fallo de conexión");
        motorI.conocimiento.setDNS_CLEAN((respuesta == 0)? true : false);
        motorI.problemaTR();
        if (motorI.conocimiento.isCONCLUSION()){
            JOptionPane.showConfirmDialog(rootPane, motorI.conocimiento.getEXPLICACION());
            System.exit(0);
        }
    }
}