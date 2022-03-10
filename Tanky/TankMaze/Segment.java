public class Segment {
    
    private Obdlznik segment;
    
    public Segment(int sX, int sY, int sirka, int vyska) {
        this.segment = new Obdlznik();
        this.segment.zmenStrany(sirka, vyska);
        this.segment.zmenPolohu(sX, sY);
        this.segment.zmenFarbu("red");
        this.segment.zobraz();
    }
    
    public void zasviet() {
        this.segment.zobraz();
    }
    
    public void zhasni() {
        this.segment.skry();
    }
}
