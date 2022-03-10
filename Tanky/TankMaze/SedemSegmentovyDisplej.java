public class SedemSegmentovyDisplej {
    
    private Segment segmentA;
    private Segment segmentB;
    private Segment segmentC;
    private Segment segmentD;
    private Segment segmentE;
    private Segment segmentF;
    private Segment segmentG;
    
    public SedemSegmentovyDisplej(int x, int y, int sirka, int vyska) {
        this.segmentA = new Segment(x + sirka, y, vyska, sirka);
        this.segmentB = new Segment(x + sirka + vyska, y + sirka, sirka, vyska);
        this.segmentC = new Segment(x + sirka + vyska, y + 2 * sirka + vyska, sirka, vyska);
        this.segmentD = new Segment(x + sirka, y + 2 * sirka + 2 * vyska, vyska, sirka);
        this.segmentE = new Segment(x, y + 2 * sirka + vyska, sirka, vyska);
        this.segmentF = new Segment(x, y + sirka, sirka, vyska);
        this.segmentG = new Segment(x + sirka, y + sirka + vyska, vyska, sirka);
    }
    
    public void zobraz0() {
        this.segmentA.zasviet();
        this.segmentB.zasviet();
        this.segmentC.zasviet();
        this.segmentD.zasviet();
        this.segmentE.zasviet();
        this.segmentF.zasviet();
        this.segmentG.zhasni();
    }
    
    public void zobraz1() {
        this.segmentA.zhasni();
        this.segmentB.zasviet();
        this.segmentC.zasviet();
        this.segmentD.zhasni();
        this.segmentE.zhasni();
        this.segmentF.zhasni();
        this.segmentG.zhasni();
    }
    
    public void zobraz2() {
        this.segmentA.zasviet();
        this.segmentB.zasviet();
        this.segmentC.zhasni();
        this.segmentD.zasviet();
        this.segmentE.zasviet();
        this.segmentF.zhasni();
        this.segmentG.zasviet();
    }
    
    public void zobraz3() {
        this.segmentA.zasviet();
        this.segmentB.zasviet();
        this.segmentC.zasviet();
        this.segmentD.zasviet();
        this.segmentE.zhasni();
        this.segmentF.zhasni();
        this.segmentG.zasviet();
    }
    
    public void zobraz4() {
        this.segmentA.zhasni();
        this.segmentB.zasviet();
        this.segmentC.zasviet();
        this.segmentD.zhasni();
        this.segmentE.zhasni();
        this.segmentF.zasviet();
        this.segmentG.zasviet();
    }
    
    public void zobraz5() {
        this.segmentA.zasviet();
        this.segmentB.zhasni();
        this.segmentC.zasviet();
        this.segmentD.zasviet();
        this.segmentE.zhasni();
        this.segmentF.zasviet();
        this.segmentG.zasviet();
    }
    
    public void zobraz(int cifra) {
        switch (cifra) {
            case 0:
                this.zobraz0();
                break;
            case 1:
                this.zobraz1();
                break;
            case 2:
                this.zobraz2();
                break;
            case 3:
                this.zobraz3();
                break;
            case 4:
                this.zobraz4();
                break;
            case 5:
                this.zobraz5();
                break;

            default:
                this.error();
        }
    }
    
    public void error() {
        System.out.print("0-5");
    }
}
