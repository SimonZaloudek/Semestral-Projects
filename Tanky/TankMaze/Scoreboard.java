public class Scoreboard {
    
    private SedemSegmentovyDisplej cerveneSkore;
    private SedemSegmentovyDisplej modreSkore;
    private Segment pomlcka;
    
    private int aktHodnotaC;
    private int aktHodnotaM;
    private int maxHodnota = 10;
    
    public Scoreboard(int aktHodnotaC, int aktHodnotaM) {
        this.cerveneSkore = new SedemSegmentovyDisplej(575, 10, 10, 25);
        this.modreSkore = new SedemSegmentovyDisplej(675, 10, 10, 25);
        this.pomlcka = new Segment(635, 45, 25, 10);
        //X - 575
        //Y - 10
        
        this.aktHodnotaC = aktHodnotaC;
        this.aktHodnotaM = aktHodnotaM;
        
        this.zobrazAktHodnotuC();
        this.zobrazAktHodnotuM();
    }
    
    public void zobrazAktHodnotuC() {
        this.cerveneSkore.zobraz(this.aktHodnotaC % 10);
    }
    
    public void zobrazAktHodnotuM() {
        this.modreSkore.zobraz(this.aktHodnotaM % 10);
    }
    
    public int cervenyKill() {
        this.aktHodnotaC = this.aktHodnotaC + 1;
        
        this.aktHodnotaC = this.aktHodnotaC % this.maxHodnota;
        this.zobrazAktHodnotuC();
        
        return this.aktHodnotaC % this.maxHodnota;
    }
    
    public int modryKill() {
        this.aktHodnotaM = this.aktHodnotaM + 1;
        
        this.aktHodnotaM = this.aktHodnotaM % this.maxHodnota;
        this.zobrazAktHodnotuM();
        
        return this.aktHodnotaM % this.maxHodnota;
    }
}
