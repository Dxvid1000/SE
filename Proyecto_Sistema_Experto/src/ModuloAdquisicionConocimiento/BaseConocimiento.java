package ModuloAdquisicionConocimiento;

public class BaseConocimiento {
    private boolean BEEP_CODE; /*Conocimiento acerca de la MotherBoard*/    
    private boolean COMP_MB_Q;
    private boolean COMP_F;
    private boolean VOLT_SC;
    private boolean MB_F;
    
    private boolean PC_ENC;
    private boolean CONCLUSION;
    private String EXPLICACION;
    
    /*Conocimiento de la tarjeta de red*/

    private boolean POLLNG;
    private boolean IRQ_CONTROL;
    private boolean ENT_PROGRAMADA;
    private boolean DMA; 
    private boolean DNS_CLEAN;
                
    public BaseConocimiento() {
        this.BEEP_CODE = false;        
        this.COMP_MB_Q = false;
        this.COMP_F = false;
        this.VOLT_SC = false;
        this.PC_ENC = false;
        this.MB_F = false;
        this.CONCLUSION = false;
        
        this.POLLNG = false; 
        this.IRQ_CONTROL = false;
        this.ENT_PROGRAMADA = false; 
        this.DMA = false; 
        this.DNS_CLEAN = false; 

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

    public boolean isMB_F() {
        return MB_F;
    }

    public void setMB_F(boolean MB_F) {
        this.MB_F = MB_F;
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
    
    public boolean isPOLLNG() {
        return POLLNG;
    }
    
    public void setPOLLNG(boolean POLLNG){
        this.POLLNG = POLLNG; 
    }
    
    public boolean isIRQ_CONTROL(){
        return IRQ_CONTROL;
    }
    
    public void setIRQ_CONTROL(boolean IRQ_CONTROL){
        this.IRQ_CONTROL = IRQ_CONTROL;                
    }
    
    public boolean isENT_PROGRAMADA(){
        return ENT_PROGRAMADA;
    }
    
    public void setENT_PROGRAMDA(boolean ENT_PROGRAMADA){
        this.ENT_PROGRAMADA = ENT_PROGRAMADA;
    }
    
    public boolean isDMA(){
        return DMA; 
    }
    
    public void setDMA(boolean DMA){
        this.DMA = DMA;
    }
          
    public boolean isDNS_CLEAN(){
        return DNS_CLEAN;
    }
    
    public void setDNS_CLEAN(boolean DNS_CLEAN){
        this.DNS_CLEAN = DNS_CLEAN;
    }
    
}
