public class Mapa {

    public static final int SIRKA_MAPY = 26;
    public static final int VYSKA_MAPY = 13;
    public static final int STRANA = 50;
    
    private Stvorec[][] pixely;
    private boolean[][] template;
    
    public Mapa() {
        this.template = template;
        this.pixely = new Stvorec[VYSKA_MAPY][SIRKA_MAPY];
        
        for (int riadok = 0; riadok < VYSKA_MAPY; riadok++) {
            for (int stlpec = 0; stlpec < SIRKA_MAPY; stlpec++) {
                if (MapaTemplate.MAPA.getTemplate()[riadok][stlpec]) {
                    Stvorec pixel = new Stvorec();
                    pixel.posunVodorovne(-60 + stlpec * STRANA);
                    pixel.posunZvisle(-50 + riadok * STRANA);
                    pixel.zmenStranu(STRANA);
                    pixel.zmenFarbu("black");
                    this.pixely[riadok][stlpec] = pixel;
                    this.pixely[riadok][stlpec].zobraz();
                }
            }
        }
    }
    
    public Stvorec[][] getPixely() {
        return this.pixely;
    }    
}
