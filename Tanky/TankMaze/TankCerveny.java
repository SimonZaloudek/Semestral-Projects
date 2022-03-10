public class TankCerveny {
    
    private Obrazok tankCerveny;
    
    private int cerveneX;
    private int cerveneY;
       
    public TankCerveny(int cerveneX, int cerveneY) {
        this.cerveneX = cerveneX;
        this.cerveneY = cerveneY;
           
        this.tankCerveny = new Obrazok("assets/tankCerveny.png");
        
        
        this.tankCerveny.zmenPolohu(this.cerveneX, this.cerveneY);
        
        this.tankCerveny.zmenUhol(-180);
        
        
        this.tankCerveny.zobraz();
    }
    
    public void posunZvisle(int cislo) {
        this.tankCerveny.posunZvisle(cislo);
    }
    
    public void posunVodorovne(int cislo) {
        this.tankCerveny.posunVodorovne(cislo);
    }
    
    public void zmenPolohuC(int x, int y) {
        this.cerveneX = x;
        this.cerveneY = y;
        
        this.tankCerveny.zmenPolohu(x, y);
    }
    
    public void zmenUhol(int uhol) {
        this.tankCerveny.zmenUhol(uhol);
    }
    
    public int getCerveneX() {
        return this.cerveneX;
    }
    
    public void setCerveneX(int cerveneX) {
        this.cerveneX = cerveneX;
    }
    
    public int getCerveneY() {
        return this.cerveneY;
    }
    
    public void setCerveneY(int cerveneY) {
        this.cerveneY = cerveneY;    
    }
}