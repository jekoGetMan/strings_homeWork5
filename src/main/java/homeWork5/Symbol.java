package homeWork5;


public class Symbol implements Inter {
    public String text;
    boolean isPunctuationMark;

    Symbol(String text){
        this.text = text;
        if(text.matches("([\u3030.,!?;:()])")){
            isPunctuationMark = true;
            System.out.print(this.text);
        }
        else {
            isPunctuationMark = false;
            System.out.print(" " + this.text);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;

        Symbol word = (Symbol) o;

        return text.equals(word.text);

    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
