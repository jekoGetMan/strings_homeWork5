package homeWork5;

import java.util.ArrayList;
import java.util.HashSet; // Класс Object имеет метод hashCode(), который используется классом HashSet для эффективного размещения объектов, заносимых в коллекцию.
// В классах объектов, заносимых в HashSet, этот метод должен быть переопределен (override).
import java.util.Set;
/*
HashSet, TreeSet и LinkedHashSet относятся к семейству Set.
В множествах Set каждый элемент хранится только в одном экземпляре, а разные реализации Set используют разный порядок хранения элементов.
В HashSet порядок элементов определяется по сложному алгоритму.
Если порядок хранения для вас важен, используйте контейнер TreeSet, в котором объекты хранятся отсортированными
по возрастанию в порядке сравнения или LinkedHashSet с хранением элементов в порядке добавления.

Множества часто используются для проверки принадлежности, чтобы вы могли легко проверить, принадлежит ли объект
заданному множеству, поэтому на практике обычно выбирается реализация HashSet, оптимизированная для быстрого поиска.

 */
import java.io.IOException; //ввод & вывод exceptions
import java.io.BufferedReader;
import java.io.FileReader;
/*
                            Task_005
Создать программу обработки текста учебника по программированию с
использованием классов: Символ, Слово, Предложение, Знак препинания и
др. Во всех задачах с формированием текста заменять табуляции и
последовательности пробелов одним пробелом.
 */

public class hand {

    ArrayList<Statement> content;
    // заюзаем разделители
    public final static String DELIMITERS = "\u3030.!?";

    public void parse() throws IOException {
        //Класс BufferedWriter записывает текст в поток, предварительно буферизируя записываемые
        //символы, тем самым снижая количество обращений к физическому носителю для записи данных.
        BufferedReader in = new BufferedReader(new FileReader("C:\\task2-master\\src\\main\\files\\lol1.txt"));
        // Класс FileWriter является производным от класса Writer. Он используется для записи текстовых файлов.
        String cont = "";
        String[] sentences;

        this.content = new ArrayList<Statement>();
        String bar = in.readLine();
        String readLine = bar;

        while (readLine != null) {

            if (readLine.equals("")) {
                bar = bar + readLine;
                readLine = in.readLine();
                continue;
            }

            int i;
            int index = 0;
            String c = "";

            if (DELIMITERS.indexOf(bar.charAt(bar.length() - 1)) > -1) {
                c += bar.charAt(bar.length() - 1);
            }
            sentences = bar.split("[.?\u2026]+");

            for (i = 0; i < sentences.length - 1; i++) {
                cont = sentences[i] + bar.charAt(sentences[i].length() + index);
                index += cont.length();
                this.content.add(new Statement(cont));
            }
            cont = sentences[i] + c;
            if (!c.equals("")) {
                this.content.add(new Statement(cont));
                cont = "";
            }
            readLine = in.readLine();
            bar = cont + " " + readLine;
        }
    }

    // 3. Найти такое слово в первом предложении, которого нет ни в одном из
    // остальных предложений.
    public Symbol Task3() {
        Set<Symbol> allWords = new HashSet<Symbol>();
        for (int i = 1; i < content.size(); i++) {
            allWords.addAll(content.get(i).words);
        }
        for (Symbol word : content.get(0).words) {
            if (!allWords.contains(word))
                return word;
        }
        return null;
    }

    //	4. Во всех вопросительных предложениях текста найти и напечатать без повторений
    //	слова заданной длины.
    public HashSet<String> Task4(int length) {
        HashSet<String> words = new HashSet<String>();
        int i = 0;
        while (i < content.size()) {
            if (content.get(i).text.endsWith("?")) {
                int j = 0;
                while (j < content.get(i).words.size()){
                    if (content.get(i).words.get(j).text.length() == length) {
                        words.add(content.get(i).words.get(j).text);
                    }
                    j++;
                }
            }
            i++;
        }
        return words;
    }

    // 1. Найти наибольшее количество предложений текста, в которых есть одинаковые
    // слова.
    public int Task1() {
        int count = 0;
        for (Statement sentence : content) {
            Set<Symbol> key = new HashSet<Symbol>(sentence.words);
            if (key.size() < sentence.words.size()) {
                count++;
            }
        }
        return count;
    }
}
