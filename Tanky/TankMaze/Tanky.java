public class Tanky {    
    private Manazer manazer;
    
    //Tanky
    private TankCerveny tankCerveny;
    private TankModry tankModry;
    
    //Scoreboard
    private Scoreboard score;
    
    //Smery
    private Smer poslednyModrySmer;
    private Smer poslednyCervenySmer;
    
    //Mapa
    private Mapa mapa;
    private Stvorec[][] pixely;
    
    //WinCon
    private int pocitadloM;
    private int pocitadloC;
    
    //Stats
    private int pocetStrielM;
    private int pocetStrielC;
    private float percentoM;
    private float percentoC;
    
    //Strela
    private Strela strela;
    
    public Tanky() {
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this); 
        
        this.tankCerveny = new TankCerveny(100, 105);
        this.tankModry = new TankModry(1200, 550);
        
        this.score = new Scoreboard(0, 0);
        this.pocitadloM = 0;
        this.pocitadloC = 0;
        
        this.pocetStrielM = 0;
        this.pocetStrielC = 0;
        this.percentoM = 0;
        this.percentoC = 0;
        
        this.mapa = new Mapa();
        this.pixely = this.mapa.getPixely();
        
        //this.restartujTanky();
    }
    
    //GetteryTankov
    public TankCerveny getTankCerveny() {
        return this.tankCerveny;
    }
    
    public TankModry getTankModry() {
        return this.tankModry;
    }
    
    //PohybCezTik
    public void tikT() {
        //PohybM
        if (this.manazer.getPohybM() == Smer.VPRED) {
            this.posunZvisleModry(-5);
            this.tankModry.zmenUhol(0);
            this.poslednyModrySmer = this.manazer.getPohybM();
        } else if (this.manazer.getPohybM() == Smer.VZAD) {
            this.posunZvisleModry(5);
            this.tankModry.zmenUhol(-180);
            this.poslednyModrySmer = this.manazer.getPohybM();
        } else if (this.manazer.getPohybM() == Smer.VLAVO) {
            this.posunVodorovneModry(-5);
            this.tankModry.zmenUhol(-90);
            this.poslednyModrySmer = this.manazer.getPohybM();
        } else if (this.manazer.getPohybM() == Smer.VPRAVO) {
            this.posunVodorovneModry(5);
            this.tankModry.zmenUhol(90);
            this.poslednyModrySmer = this.manazer.getPohybM();
        }
        //SmerC
        if (this.manazer.getPohybC() == Smer.VPRED) {
            this.posunZvisleCerveny(-5);
            this.tankCerveny.zmenUhol(0);
            this.poslednyCervenySmer = this.manazer.getPohybC();
        } else if (this.manazer.getPohybC() == Smer.VZAD) {
            this.posunZvisleCerveny(5);
            this.tankCerveny.zmenUhol(-180);
            this.poslednyCervenySmer = this.manazer.getPohybC();
        } else if (this.manazer.getPohybC() == Smer.VLAVO) {
            this.posunVodorovneCerveny(-5);
            this.tankCerveny.zmenUhol(-90);
            this.poslednyCervenySmer = this.manazer.getPohybC();
        } else if (this.manazer.getPohybC() == Smer.VPRAVO) {
            this.posunVodorovneCerveny(5);
            this.tankCerveny.zmenUhol(90);
            this.poslednyCervenySmer = this.manazer.getPohybC();
        }

    }
    
    //InicializaciaDruhehoTiku
    public void tikS() {
        Strela.tik();
    }
    
    //Strielanie
    public void vystrelM() {
        new Strela(this.poslednyModrySmer, this.pixely, this, this.tankModry.getModreX() + this.poslednyModrySmer.getX(), this.tankModry.getModreY() + this.poslednyModrySmer.getY());
        this.pocetStrielM++;
    }
    
    public void vystrelC() {
        new Strela(this.poslednyCervenySmer, this.pixely, this, this.tankCerveny.getCerveneX() + this.poslednyCervenySmer.getX(), this.tankCerveny.getCerveneY() + this.poslednyCervenySmer.getY());
        this.pocetStrielC++;
    }
    
    //PohybovaKolizia
    public boolean kolizia(int x, int y) {
        for (int riadok = 0; riadok < Mapa.VYSKA_MAPY; riadok++) {
            for (int stlpec = 0; stlpec < Mapa.SIRKA_MAPY; stlpec++) {
                if (this.pixely[riadok][stlpec] != null) {
                    if (this.pixely[riadok][stlpec].obsahujeSuradnice(x, y)) {
                        return true;
                    }
                }
            }
        }
        return false;   
    }
    
    //InicPohybu
    private void posunZvisleModry(int dlzka) {
        if (!this.kolizia(this.tankModry.getModreX(), this.tankModry.getModreY() + dlzka)) {
            this.tankModry.posunZvisle(dlzka);
            this.tankModry.setModreY(this.tankModry.getModreY() + dlzka);
        }
    }
    
    private void posunVodorovneModry(int dlzka) {
        if (!this.kolizia(this.tankModry.getModreX() + dlzka, this.tankModry.getModreY())) {
            this.tankModry.posunVodorovne(dlzka);
            this.tankModry.setModreX(this.tankModry.getModreX() + dlzka);
        }
    }
    
    private void posunZvisleCerveny(int dlzka) {
        if (!this.kolizia(this.tankCerveny.getCerveneX(), this.tankCerveny.getCerveneY() + dlzka)) {
            this.tankCerveny.posunZvisle(dlzka);
            this.tankCerveny.setCerveneY(this.tankCerveny.getCerveneY() + dlzka);
        }
    }
    
    private void posunVodorovneCerveny(int dlzka) {
        if (!this.kolizia(this.tankCerveny.getCerveneX() + dlzka, this.tankCerveny.getCerveneY())) {
            this.tankCerveny.posunVodorovne(dlzka);
            this.tankCerveny.setCerveneX(this.tankCerveny.getCerveneX() + dlzka);
        }
    }
    
    //LogickeFunkcie
    private void restartujTanky() {
        this.tankCerveny.zmenPolohuC(100, 105);
        this.tankCerveny.zmenUhol(-180);
        this.poslednyCervenySmer = Smer.VZAD;
        
        this.tankModry.zmenPolohuM(1200, 550);
        this.tankModry.zmenUhol(0);
        this.poslednyModrySmer = Smer.VPRED;
        
        Strela.zmazStrely();
    }
    
    public void cervenyKill() {
        this.score.cervenyKill();
        this.pocitadloC++;
        if (!this.winCon()) {
            this.restartujTanky();
        } else {
            this.ukonciHru();
        }
    }
    
    public void modryKill() {
        this.score.modryKill();
        this.pocitadloM++;
        if (!this.winCon()) {
            this.restartujTanky();    
        } else {
            this.ukonciHru();
        }
                        
    }
    
    public boolean winCon() {
        if (this.pocitadloC >= 5 || this.pocitadloM >= 5) {
            return true;
        }
        return false;
    }
    
    public String vitaz() {
        if (this.pocitadloM >= 5) {
            return "Modry";
        } else if (this.pocitadloC >= 5) { 
            return "Cerveny";
        }
        return null;
    }
    
    private float percentoUspesnostiC() {
        this.percentoC = this.percentoC + ((float)this.pocitadloC / (float)this.pocetStrielC) * 100;

        return this.percentoC;
    }
    
    private float percentoUspesnostiM() {
        this.percentoM = this.percentoM + ((float)this.pocitadloM / (float)this.pocetStrielM) * 100;
        
        return this.percentoM;
    }
    
    private void ukonciHru() {
        this.manazer.prestanSpravovatObjekt(this);
        System.out.println("Koniec Hry:\n___________\nVitaz: " + this.vitaz() + "\nSkore: Cerveny " + this.pocitadloC + " - " + this.pocitadloM + " Modry");
        System.out.println("\nStatistiky:\n___________\nPocet Striel: Cerveny: " + this.pocetStrielC + " Modry: " + this.pocetStrielM);
        System.out.println("\nUspesnost Strelby (%): Cerveny: " + this.percentoUspesnostiC() + "%" + " Modry: " + this.percentoUspesnostiM() + "%");
    }
    
    public void zrus() {
        this.manazer.prestanSpravovatObjekt(this);
        System.out.println("Ukoncil si hru");
    }    
}
