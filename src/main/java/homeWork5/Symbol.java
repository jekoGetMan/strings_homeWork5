package homeWork5;

public class Symbol implements Inter {
    boolean dot;
    public String someTxt;

    // проверка
    Symbol(String someTxt){
        this.someTxt = someTxt;
        if(someTxt.matches("([\u3030.,!?;:()])")){
            dot = true;
            System.out.print(this.someTxt);
        }
        else {
            dot = false;
            System.out.print(" " + this.someTxt);
        }

    }
    //хэш
    @Override
    public int hashCode() {
        return someTxt.hashCode();
        /*
Если хеш-коды разные, то и входные объекты гарантированно разные.
Если хеш-коды равны, то входные объекты не всегда равны.
         */
    }


    //проверка на равность
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Symbol)) return false;
        if (this == o) return true;

        Symbol word = (Symbol) o;

        return someTxt.equals(word.someTxt);
    }
}
