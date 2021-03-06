package ModuloAdquisicionConocimiento;

public class BaseConocimiento {

    /*Conocimiento acerca de la MotherBoard*/
    private boolean BEEP_CODE;
    private boolean COMP_MB_Q;
    private boolean COMP_F;
    private boolean VOLT_SC;

    /*Conocimiento de la tarjeta de red*/
    private boolean PUERTO_F;
    
 /*Conocimiento del Disco Duro*/
    private boolean VENTANA_ERROR_HD;
    private boolean APP_INST_RECIENTE;
    private boolean ITEMS_OCULTOS_PROTEGIDOS;
    private boolean TABLAS_DANADAS;
    private boolean MASTER_BOOT_RECORD;

    /*Conocimiento de la Fuente de Poder*/
    private boolean FP_POLVOSA;
    private boolean VENTILADOR_F;
    private boolean CORTO_CIRCUITO;
    private boolean CAPACIDADFP_S;

    /*Conocimiento de la Tarjeta Grafica*/
    private boolean VENTANA_ERROR_TG;
    private boolean ARTF_P;
    private boolean VENT_TI;

    /*Conocimiento de las memorias RAM*/
    private boolean VENTANA_ERROR_RAM;
    private boolean PINES_MR_L;

    /*Conocimiento GLOBAL*/
    private boolean PC_ENC;
    private boolean PC_LENTA;
    private boolean CONCLUSION;
    private String EXPLICACION;
    private boolean VIRUS;
    private boolean UNIDAD_LEGIBLE;
    private boolean ERROR_FABRICACION;
    private boolean CAIDAS_GOLPES;
    private boolean TIEMPO_VIDA_ALTO;
    private boolean CAMBIOS_TEMPERATURA;
    private boolean APAGONES_DESCONEXIONES;
    private boolean FIRMWARE_ACT;
    private boolean SO_ENCIENDE;
    private boolean MSG_W;

    public BaseConocimiento() {
        this.BEEP_CODE = false;
        this.COMP_MB_Q = false;
        this.COMP_F = false;
        this.VOLT_SC = true;

        this.VENTANA_ERROR_HD = false;
        this.APP_INST_RECIENTE = false;
        this.ITEMS_OCULTOS_PROTEGIDOS = false;
        this.TABLAS_DANADAS = false;
        this.MASTER_BOOT_RECORD = false;

        this.FP_POLVOSA = false;
        this.VENTILADOR_F = true;
        this.CAPACIDADFP_S = false;
        this.VENTANA_ERROR_RAM = false;
        this.PINES_MR_L = true;

        this.VENTANA_ERROR_TG = false;
        this.ARTF_P = false;
        this.VENT_TI = false;

        this.PC_ENC = true;
        this.PC_LENTA = false;
        this.CONCLUSION = false;
        this.ERROR_FABRICACION = false;
        this.CAIDAS_GOLPES = false;
        this.TIEMPO_VIDA_ALTO = false;
        this.CAMBIOS_TEMPERATURA = false;
        this.APAGONES_DESCONEXIONES = false;
        this.CORTO_CIRCUITO = false;
        this.FIRMWARE_ACT = true;
        this.SO_ENCIENDE = false;
        this.UNIDAD_LEGIBLE = true;
        this.VIRUS = false;
        this.MSG_W = false;
        this.PUERTO_F = true;

    }

    public boolean isPUERTO_F() {
        return PUERTO_F;
    }

    public void setPUERTO_F(boolean PUERTO_F) {
        this.PUERTO_F = PUERTO_F;
    }

    public boolean isVENTANA_ERROR_TG() {
        return VENTANA_ERROR_TG;
    }

    public void setVENTANA_ERROR_TG(boolean VENTANA_ERROR_TG) {
        this.VENTANA_ERROR_TG = VENTANA_ERROR_TG;
    }

    public boolean isARTF_P() {
        return ARTF_P;
    }

    public void setARTF_P(boolean ARTF_P) {
        this.ARTF_P = ARTF_P;
    }

    public boolean isVENT_TI() {
        return VENT_TI;
    }

    public void setVENT_TI(boolean VENT_TI) {
        this.VENT_TI = VENT_TI;
    }

    public boolean isMSG_W() {
        return MSG_W;
    }

    public void setMSG_W(boolean MSG_W) {
        this.MSG_W = MSG_W;
    }

    public boolean isVENTANA_ERROR_RAM() {
        return VENTANA_ERROR_RAM;
    }

    public void setVENTANA_ERROR_RAM(boolean VENTANA_ERROR_RAM) {
        this.VENTANA_ERROR_RAM = VENTANA_ERROR_RAM;
    }

    public boolean isPINES_MR_L() {
        return PINES_MR_L;
    }

    public void setPINES_MR_L(boolean PINES_MR_L) {
        this.PINES_MR_L = PINES_MR_L;
    }

    public boolean isPC_LENTA() {
        return PC_LENTA;
    }

    public void setPC_LENTA(boolean PC_LENTA) {
        this.PC_LENTA = PC_LENTA;
    }

    public boolean isFP_POLVOSA() {
        return FP_POLVOSA;
    }

    public void setFP_POLVOSA(boolean FP_POLVOSA) {
        this.FP_POLVOSA = FP_POLVOSA;
    }

    public boolean isVENTILADOR_F() {
        return VENTILADOR_F;
    }

    public void setVENTILADOR_F(boolean VENTILADOR_F) {
        this.VENTILADOR_F = VENTILADOR_F;
    }

    public boolean isCORTO_CIRCUITO() {
        return CORTO_CIRCUITO;
    }

    public void setCORTO_CIRCUITO(boolean CORTO_CIRCUITO) {
        this.CORTO_CIRCUITO = CORTO_CIRCUITO;
    }

    public boolean isCAPACIDADFP_S() {
        return CAPACIDADFP_S;
    }

    public void setCAPACIDADFP_S(boolean CAPACIDADFP_S) {
        this.CAPACIDADFP_S = CAPACIDADFP_S;
    }

    public boolean isVIRUS() {
        return VIRUS;
    }

    public void setVIRUS(boolean VIRUS) {
        this.VIRUS = VIRUS;
    }

    public boolean isVENTANA_ERROR_HD() {
        return VENTANA_ERROR_HD;
    }

    public void setVENTANA_ERROR_HD(boolean VENTANA_ERROR_HD) {
        this.VENTANA_ERROR_HD = VENTANA_ERROR_HD;
    }

    public boolean isAPP_INST_RECIENTE() {
        return APP_INST_RECIENTE;
    }

    public void setAPP_INST_RECIENTE(boolean APP_INST_RECIENTE) {
        this.APP_INST_RECIENTE = APP_INST_RECIENTE;
    }

    public boolean isITEMS_OCULTOS_PROTEGIDOS() {
        return ITEMS_OCULTOS_PROTEGIDOS;
    }

    public void setITEMS_OCULTOS_PROTEGIDOS(boolean ITEMS_OCULTOS_PROTEGIDOS) {
        this.ITEMS_OCULTOS_PROTEGIDOS = ITEMS_OCULTOS_PROTEGIDOS;
    }

    public boolean isUNIDAD_LEGIBLE() {
        return UNIDAD_LEGIBLE;
    }

    public void setUNIDAD_LEGIBLE(boolean UNIDAD_LEGIBLE) {
        this.UNIDAD_LEGIBLE = UNIDAD_LEGIBLE;
    }

    public boolean isTABLAS_DANADAS() {
        return TABLAS_DANADAS;
    }

    public void setTABLAS_DANADAS(boolean TABLAS_DANADAS) {
        this.TABLAS_DANADAS = TABLAS_DANADAS;
    }

    public boolean isCAMBIOS_TEMPERATURA() {
        return CAMBIOS_TEMPERATURA;
    }

    public void setCAMBIOS_TEMPERATURA(boolean CAMBIOS_TEMPERATURA) {
        this.CAMBIOS_TEMPERATURA = CAMBIOS_TEMPERATURA;
    }

    public boolean isAPAGONES_DESCONEXIONES() {
        return APAGONES_DESCONEXIONES;
    }

    public void setAPAGONES_DESCONEXIONES(boolean APAGONES_DESCONEXIONES) {
        this.APAGONES_DESCONEXIONES = APAGONES_DESCONEXIONES;
    }

    public boolean isMASTER_BOOT_RECORD() {
        return MASTER_BOOT_RECORD;
    }

    public void setMASTER_BOOT_RECORD(boolean MASTER_BOOT_RECORD) {
        this.MASTER_BOOT_RECORD = MASTER_BOOT_RECORD;
    }

    public boolean isCAIDAS_GOLPES() {
        return CAIDAS_GOLPES;
    }

    public void setCAIDAS_GOLPES(boolean CAIDAS_GOLPES) {
        this.CAIDAS_GOLPES = CAIDAS_GOLPES;
    }

    public boolean isTIEMPO_VIDA_ALTO() {
        return TIEMPO_VIDA_ALTO;
    }

    public void setTIEMPO_VIDA_ALTO(boolean TIEMPO_VIDA_ALTO) {
        this.TIEMPO_VIDA_ALTO = TIEMPO_VIDA_ALTO;
    }

    public boolean isFIRMWARE_ACT() {
        return FIRMWARE_ACT;
    }

    public void setFIRMWARE_ACT(boolean FIRMWARE_ACT) {
        this.FIRMWARE_ACT = FIRMWARE_ACT;
    }

    public boolean isSO_ENCIENDE() {
        return SO_ENCIENDE;
    }

    public void setSO_ENCIENDE(boolean SO_ENCIENDE) {
        this.SO_ENCIENDE = SO_ENCIENDE;
    }

    public boolean isERROR_FABRICACION() {
        return ERROR_FABRICACION;
    }

    public void setERROR_FABRICACION(boolean ERROR_FABRICACION) {
        this.ERROR_FABRICACION = ERROR_FABRICACION;
    }

    public boolean isBEEP_CODE() {
        return BEEP_CODE;
    }

    public void setBEEP_CODE(boolean BEEP_CODE) {
        this.BEEP_CODE = BEEP_CODE;
    }

    public boolean isCOMP_MB_Q() {
        return COMP_MB_Q;
    }

    public void setCOMP_MB_Q(boolean COMP_MB_Q) {
        this.COMP_MB_Q = COMP_MB_Q;
    }

    public boolean isCOMP_F() {
        return COMP_F;
    }

    public void setCOMP_F(boolean COMP_F) {
        this.COMP_F = COMP_F;
    }

    public boolean isVOLT_SC() {
        return VOLT_SC;
    }

    public void setVOLT_SC(boolean VOLT_SC) {
        this.VOLT_SC = VOLT_SC;
    }

    public boolean isPC_ENC() {
        return PC_ENC;
    }

    public void setPC_ENC(boolean PC_ENC) {
        this.PC_ENC = PC_ENC;
    }

    public boolean isCONCLUSION() {
        return CONCLUSION;
    }

    public void setCONCLUSION(boolean CONCLUSION) {
        this.CONCLUSION = CONCLUSION;
    }

    public String getEXPLICACION() {
        return EXPLICACION;
    }

    public void setEXPLICACION(String EXPLICACION) {
        this.EXPLICACION = EXPLICACION;
    }

}
