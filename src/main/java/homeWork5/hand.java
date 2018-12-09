package homeWork5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

                                        //Task_005
public class hand {

    ArrayList<Statement> content;
    // заюзаем разделители
    public final static String DELIMITERS = "\u3030.!?";

    public void parse() throws IOException {
        BufferedReader link = new BufferedReader(new FileReader("C:\\task2-master\\src\\main\\files\\lol1.txt"));
        String cont = "    ";
        String[] strgs;

        this.content = new ArrayList<Statement>();
        String bar = link.readLine();
        String readLine = bar;

        while (readLine != null) {

            if (readLine.equals("")) {
                bar = bar + readLine;
                readLine = link.readLine();
                continue;
            }

            int quantity = 0;
            String var = "";

            if (DELIMITERS.indexOf(bar.charAt(bar.length() - 1)) > -1) {
                var = var + bar.charAt(bar.length() - 1);
            }
            strgs = bar.split("[.?\u3030]+");
            int ind = 0;
            while(ind < strgs.length - 1){
                cont = strgs[ind] + bar.charAt(strgs[ind].length() + quantity);
                quantity = quantity + cont.length();
                this.content.add(new Statement(cont));
                ind++;
            }

            cont = strgs[ind] + var;
            if (!var.equals("")) {
                this.content.add(new Statement(cont));
                cont = " ";
            }
            readLine = link.readLine();
            bar = cont + "     " + readLine;
        }
    }
    //3
    public Symbol Task3() {
        Set<Symbol> allsymb = new HashSet<Symbol>();
        int indx = 1;
        while (indx < content.size()){
            allsymb.addAll(content.get(indx).getSign);
            indx++;
        }
        for (Symbol key : content.get(0).getSign) {
            if (!allsymb.contains(key))
                return key;
        }
        return null;
    }

    //4
    public HashSet<String> Task4(int length) {
        HashSet<String> symbs = new HashSet<String>();
        int i = 0;
        while (i < content.size()) {
            if (content.get(i).symb.endsWith("?")) {
                int j = 0;
                while (j < content.get(i).getSign.size()){
                    if (content.get(i).getSign.get(j).someTxt.length() == length) {
                        symbs.add(content.get(i).getSign.get(j).someTxt);
                    }
                    j++;
                }
            }
            i++;
        }
        return symbs;
    }

    //1
    public int Task1() {
        int cnt = 0;
        for (Statement getWord: content) {
            Set<Symbol> key = new HashSet<Symbol>(getWord.getSign);
            if (key.size() < getWord.getSign.size()) {
                cnt++;
            }
        }
        return cnt;
    }
}
