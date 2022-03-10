import java.util.ArrayList;

public class Strela {
    
    private static ArrayList<Strela> strely = new ArrayList<>();
    private Stvorec[][] pixely;
    private Stvorec strela;
    private Smer smer;
    
    private int x;
    private int y;
   
    private Tanky tanky;
    
    public Strela(Smer smer, Stvorec[][] pixely, Tanky tanky, int x, int y) {
        this.strela = new Stvorec();
        
        this.strela.zmenPolohu(x - 5, y - 5);
        this.strela.zmenStranu(10);
        
        
        Strela.strely.add(this);
        this.smer = smer;
        
        
        this.pixely = pixely;
        
        this.tanky = tanky; 
        
        this.x = x;
        this.y = y;
        
        
        this.strela.zobraz();
    }
    
    public static void tik() {
        for (Strela strela : Strela.strely) {
            strela.posunStrelu();
        }
    }
    
    private void posunStrelu() {
        if (this.smer == Smer.VPRED) {
            this.posunZvisle(-20);
        } else if (this.smer == Smer.VZAD) {
            this.posunZvisle(20);
        } else if (this.smer == Smer.VLAVO) {
            this.posunVodorovne(-20);
        } else if (this.smer == Smer.VPRAVO) {
            this.posunVodorovne(20);
        }
    }
    
    public Kolizia kolizia(int x, int y) {
        TankCerveny cerveny = this.tanky.getTankCerveny();
        TankModry modry = this.tanky.getTankModry();
        
        if (x >= cerveny.getCerveneX() - 15 && x < cerveny.getCerveneX() + 15 && y >= cerveny.getCerveneY() - 15 && y < cerveny.getCerveneY() + 15) {
            return Kolizia.CERVENY;
        }
        if (x >= modry.getModreX() - 15 && x < modry.getModreX() + 15 && y >= modry.getModreY() - 15 && y < modry.getModreY() + 15) {
            return Kolizia.MODRY;
        }
        for (int riadok = 0; riadok < Mapa.VYSKA_MAPY; riadok++) {
            for (int stlpec = 0; stlpec < Mapa.SIRKA_MAPY; stlpec++) {
                if (this.pixely[riadok][stlpec] != null) {
                    if (this.pixely[riadok][stlpec].obsahujeSuradnice(x, y)) {
                        return Kolizia.STENA;
                    }
                }
            }
        }
        return null;   
    }
    
    private void posunZvisle(int dlzka) {
        Kolizia hit = this.kolizia(this.x, this.y + dlzka);
        if (hit == null) {
            this.strela.posunZvisle(dlzka);
            this.y = this.y + dlzka;
        } else {
            if (hit == Kolizia.CERVENY) {
                this.tanky.modryKill();
            } else if (hit == Kolizia.MODRY) {
                this.tanky.cervenyKill();
            }
            this.zmazStrelu();
        } 
    }
    
    private void posunVodorovne(int dlzka) {
        Kolizia hit = this.kolizia(this.x + dlzka, this.y);
        if (hit == null) {
            this.strela.posunVodorovne(dlzka);
            this.x = this.x + dlzka;
        } else { 
            if (hit == Kolizia.CERVENY) {
                this.tanky.modryKill();
            } else if (hit == Kolizia.MODRY) {
                this.tanky.cervenyKill();
            } 
            this.zmazStrelu();
        }
    }
    
    private void zmazStrelu() {
        this.strela.skry();
        this.strely.remove(this.strela);
    }
    
    public static void zmazStrely() {
        for (Strela strela : Strela.strely) {
            strela.zmazStrelu();
        }
    }
}
