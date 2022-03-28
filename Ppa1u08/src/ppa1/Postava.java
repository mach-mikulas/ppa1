package ppa1;

/**
 * @author Mikulas Mach
 * @version 211128
 */
public class Postava {

    final Svet svet;
    final int startX;
    final int startY;
    final int domovX;
    final int domovY;

    int aktualniX;
    int aktualniY;

    /**
     * Konstruktor postavz
     */
    public Postava(Svet svet, int startX, int startY, int domovX, int domovY){
        this.svet = svet;
        this.startX = startX;
        this.startY = startY;
        this.domovX = domovX;
        this.domovY = domovY;
        this.aktualniX = startX;
        this.aktualniY = startY;
    }

    /**
     * Metoda zajistujici pohyb postavy
     */
    public boolean jdi(Smer smer){
        if(smer == null){
            return false;
        }
        switch(smer){
            case SEVER:
                if(svet.uzemi(aktualniX, aktualniY-1) == ' ' || svet.uzemi(aktualniX, aktualniY-1) == '^'){
                    aktualniY -=1;
                    return true;
                }
                else{
                    return false;
                }

            case VYCHOD:
                if(svet.uzemi(aktualniX+1, aktualniY) == ' ' || svet.uzemi(aktualniX+1, aktualniY) == '^'){
                    aktualniX +=1;
                    return true;
                }
                else{
                    return false;
                }

            case JIH:
                if(svet.uzemi(aktualniX, aktualniY+1) == ' ' || svet.uzemi(aktualniX, aktualniY+1) == '^'){
                    aktualniY +=1;
                    return true;
                }
                else{
                    return false;
                }

            case ZAPAD:
                if(svet.uzemi(aktualniX-1, aktualniY) == ' ' || svet.uzemi(aktualniX-1, aktualniY) == '^'){
                    aktualniX -= 1;
                    return true;
                }
                else {
                    return false;
                }
            default:
                return false;
        }
    }

    /**
     * Metoda kontrolujici, zda je postava uz doma
     */
    public boolean jeDoma(){
        if(aktualniX == domovX && aktualniY == domovY){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Metoda, ktra vykrasli postavu na platno
     */
    public void vykresli(GUI gui){
        gui.zapis(domovX, domovY, '^');
        gui.zapis(aktualniX, aktualniY, '@');
    }
}
