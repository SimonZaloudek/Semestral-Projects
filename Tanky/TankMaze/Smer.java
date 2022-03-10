public enum Smer {
    VPRED(0, -20),
    VZAD(0, 20),
    VLAVO(-20, 0),
    VPRAVO(20, 0);
    
    private int x;
    private int y;
    
    Smer(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}
