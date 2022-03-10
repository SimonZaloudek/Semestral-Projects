public enum MapaTemplate {
    MAPA(new boolean[][]{
        { true, true , true , true , true , true , true , true , true , true , true , false, false, false, false, true , true , true , true , true , true , true , true , true , true , true },
        { true, false, false, true , false, false, true , false, false, false, true , false, false, false, false, true , false, true , false, false, false, false, false, false, false, true },
        { true, false, false, true , false, false, false, false, false, false, false, true , true , true , true , false, false, true , false, false, true , true , true , false, false, true },
        { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true },
        { true, false, false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, true , false, false, false, false, false, false, false, true },
        { true, false, false, true , true , true , false, false, true , true , true , false, false, false, false, false, true , true , true , true , false, false, true , false, false, true },
        { true, false, false, false, true , false, false, false, false, false, true , true , true , false, false, false, false, true , false, false, false, false, true , false, false, true },
        { true, false, false, false, true , false, false, false, false, false, false, true , false, false, false, false, false, false, false, false, false, false, true , false, false, true },
        { true, false, false, false, true , false, false, true , false, false, false, false, false, false, false, false, false, true , false, false, false, false, true , false, false, true },
        { true, false, false, false, true , false, false, true , true , true , true , false, true , true,  true , false, false, true , false, false, false, false, false, false, false, true },
        { true, false, false, false, false, false, false, true , false, false, false, false, true , false, false, false, false, true , false, false, false, false, true , false, false, true },
        { true, false, false, false, false, false, false, true , false, false, false, false, true , false, false, false, false, false, false, false, false, false, true , false, false, true },
        { true, true , true , true , true , true , true , true , true , true , true , true , true , true,  true , true , true , true , true , true , true , true , true , true , true , true },
    }); 
        
    private final boolean[][] template;
    
    MapaTemplate(boolean[][] template) {
        this.template = template;
    }
    
    public boolean[][] getTemplate() {
        return this.template;
    }
}
