import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * Automaticky posiela spravy danym objektom:<br />
 * posunDole() - pri stlaceni klavesy DOWN<br />
 * posunHore() - pri stlaceni klavesy UP<br />
 * posunVlavo() - pri stlacen klavesy LEFT<br />
 * posunVpravo() - pri stlaceni klavesy RIGHT<br />
 * aktivuj() - pri stlaceni klavesy ENTER alebo SPACE<br />
 * zrus() - pri stlaceni klavesy ESC<br />
 * tik() - kazdych 0,25 sekundy<br />
 * vyberSuradnice(x, y) - pri kliknuti mysou
 */
public class Manazer {
    private ArrayList<Object> spravovaneObjekty;
    private long oldTick;
    private static final long TICK_LENGTH1 = 1;
    private static final long TICK_LENGTH2 = 1;
    private Smer pohybM;
    private Smer pohybC;
    private Smer smerM;
    private Smer smerC;
    
    
    private class ManazerKlaves extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            //ModryTank
            if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                Manazer.this.pohybM = Smer.VZAD;
            } 
            if (event.getKeyCode() == KeyEvent.VK_UP) {
                Manazer.this.pohybM = Smer.VPRED;
            } 
            if (event.getKeyCode() == KeyEvent.VK_LEFT) {
                Manazer.this.pohybM = Smer.VLAVO;
            } 
            if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                Manazer.this.pohybM = Smer.VPRAVO;
            }
            //CervenyTank
            if (event.getKeyCode() == KeyEvent.VK_S) {
                Manazer.this.pohybC = Smer.VZAD;
            } 
            if (event.getKeyCode() == KeyEvent.VK_W) {
                Manazer.this.pohybC = Smer.VPRED;
            } 
            if (event.getKeyCode() == KeyEvent.VK_A) {
                Manazer.this.pohybC = Smer.VLAVO;
            } 
            if (event.getKeyCode() == KeyEvent.VK_D) {
                Manazer.this.pohybC = Smer.VPRAVO;
            }
            //Strely
            if (event.getKeyCode() == KeyEvent.VK_SPACE || event.getKeyCode() == KeyEvent.VK_SPACE) {
                Manazer.this.posliSpravu("vystrelC");
            } 
            if (event.getKeyCode() == KeyEvent.VK_ENTER || event.getKeyCode() == KeyEvent.VK_ENTER) {
                Manazer.this.posliSpravu("vystrelM");
            }
            //Escape
            if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Manazer.this.posliSpravu("zrus");
            }
        }
        
        public void keyReleased(KeyEvent event) {
            //PohybM
            if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                Manazer.this.pohybM = null;
            }
            if (event.getKeyCode() == KeyEvent.VK_UP) {
                Manazer.this.pohybM = null;  
            }
            if (event.getKeyCode() == KeyEvent.VK_LEFT) {
                Manazer.this.pohybM = null;
            }
            if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                Manazer.this.pohybM = null;  
            }
            //PohybC
            if (event.getKeyCode() == KeyEvent.VK_S) {
                Manazer.this.pohybC = null;
            } 
            if (event.getKeyCode() == KeyEvent.VK_W) {
                Manazer.this.pohybC = null;
            }
            if (event.getKeyCode() == KeyEvent.VK_A) {
                Manazer.this.pohybC = null;
            }
            if (event.getKeyCode() == KeyEvent.VK_D) {
                Manazer.this.pohybC = null;
            }
        }
    }
    
    //Gettery na pohyb
    public Smer getPohybM() {
        return this.pohybM;
    }
    
    public Smer getPohybC() {
        return this.pohybC;
    }
    
    public Smer getSmerM() {
        return this.smerM;
    }
    
    public Smer getSmerC() {
        return this.smerC;
    }

    private class ManazerCasovaca implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            long newTick1 = System.nanoTime();
            if (newTick1 - Manazer.this.oldTick >= Manazer.TICK_LENGTH1 || newTick1 < Manazer.TICK_LENGTH1) {
                Manazer.this.oldTick = (newTick1 / Manazer.TICK_LENGTH1) * Manazer.TICK_LENGTH1;
                Manazer.this.posliSpravu("tikT");
            }
            long newTick2 = System.nanoTime();
            if (newTick2 - Manazer.this.oldTick >= Manazer.TICK_LENGTH2 || newTick2 < Manazer.TICK_LENGTH2) {
                Manazer.this.oldTick = (newTick2 / Manazer.TICK_LENGTH2) * Manazer.TICK_LENGTH2;
                Manazer.this.posliSpravu("tikS");
            }
        }
    }
    
    private class ManazerMysi extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            if (event.getButton() == MouseEvent.BUTTON1) {
                Manazer.this.posliSpravu("vyberSuradnice", event.getX(), event.getY());
            }
        }
    }
    
    private void posliSpravu(String selektor) {
        for (Object adresat : this.spravovaneObjekty) {
            try {
                Method sprava = adresat.getClass().getMethod(selektor);
                sprava.invoke(adresat);
            } catch (SecurityException e) {
                this.doNothing();
            } catch (NoSuchMethodException e) {
                this.doNothing();
            } catch (IllegalArgumentException e) {
                this.doNothing();
            } catch (IllegalAccessException e) {
                this.doNothing();
            } catch (InvocationTargetException e) {
                this.doNothing();
            }
        }
    }
    
    private void posliSpravu(String selektor, int prvyParameter, int druhyParameter) {
        for (Object adresat : this.spravovaneObjekty) {
            try {
                Method sprava = adresat.getClass().getMethod(selektor, Integer.TYPE, Integer.TYPE);
                sprava.invoke(adresat, prvyParameter, druhyParameter);
            } catch (SecurityException e) {
                this.doNothing();
            } catch (NoSuchMethodException e) {
                this.doNothing();
            } catch (IllegalArgumentException e) {
                this.doNothing();
            } catch (IllegalAccessException e) {
                this.doNothing();
            } catch (InvocationTargetException e) {
                this.doNothing();
            }
        }
    }
    
    private void doNothing() {
        
    }
    
    /**
     * Vytvori novy manazer, ktory nespravuje zatial ziadne objekty.
     */
    public Manazer() {
        this.spravovaneObjekty = new ArrayList<Object>();
        Platno.dajPlatno().addKeyListener(new ManazerKlaves());
        Platno.dajPlatno().addTimerListener(new ManazerCasovaca());
        Platno.dajPlatno().addMouseListener(new ManazerMysi());
    }
    
    /**
     * Manazer bude spravovat dany objekt.
     */
    public void spravujObjekt(Object objekt) {
        this.spravovaneObjekty.add(objekt);
    }
    
    public void prestanSpravovatObjekt(Object objekt) {
        this.spravovaneObjekty.remove(objekt);
    }
}
