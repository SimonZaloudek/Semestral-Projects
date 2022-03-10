public class TankModry {
    
    private Obrazok tankModry;
    
    private int modreX;
    private int modreY;
       
    public TankModry(int modreX, int modreY) {
        this.modreX = modreX;
        this.modreY = modreY;
        
        this.tankModry = new Obrazok("assets/tankModry.png");
        
        
        this.tankModry.zmenPolohu(this.modreX, this.modreY);
        
        this.tankModry.zmenUhol(0);
        
        
        this.tankModry.zobraz();
    }
    
    public void posunZvisle(int cislo) {
        this.tankModry.posunZvisle(cislo);
    }
    
    public void posunVodorovne(int cislo) {
        this.tankModry.posunVodorovne(cislo);
    }
    
    public void zmenPolohuM(int x, int y) {
        this.modreX = x;
        this.modreY = y;
        
        this.tankModry.zmenPolohu(x, y);
    }
    
    public void zmenUhol(int uhol) {
        this.tankModry.zmenUhol(uhol);
    }
    
    public int getModreX() {
        return this.modreX;
    }
    
    public void setModreX(int modreX) {
        this.modreX = modreX;
    }
    
    public int getModreY() {
        return this.modreY;
    }
    
    public void setModreY(int modreY) {
        this.modreY = modreY;    
    }
}
