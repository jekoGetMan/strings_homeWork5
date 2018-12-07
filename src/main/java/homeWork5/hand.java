package homeWork5;

import java.util.ArrayList;
import java.util.HashSet; // ����� Object ����� ����� hashCode(), ������� ������������ ������� HashSet ��� ������������ ���������� ��������, ��������� � ���������.
// � ������� ��������, ��������� � HashSet, ���� ����� ������ ���� ������������� (override).
import java.util.Set;
/*
HashSet, TreeSet � LinkedHashSet ��������� � ��������� Set.
� ���������� Set ������ ������� �������� ������ � ����� ����������, � ������ ���������� Set ���������� ������ ������� �������� ���������.
� HashSet ������� ��������� ������������ �� �������� ���������.
���� ������� �������� ��� ��� �����, ����������� ��������� TreeSet, � ������� ������� �������� ����������������
�� ����������� � ������� ��������� ��� LinkedHashSet � ��������� ��������� � ������� ����������.

��������� ����� ������������ ��� �������� ��������������, ����� �� ����� ����� ���������, ����������� �� ������
��������� ���������, ������� �� �������� ������ ���������� ���������� HashSet, ���������������� ��� �������� ������.

 */
import java.io.IOException; //���� & ����� exceptions
import java.io.BufferedReader;
import java.io.FileReader;
/*
                            Task_005
������� ��������� ��������� ������ �������� �� ���������������� �
�������������� �������: ������, �����, �����������, ���� ���������� �
��. �� ���� ������� � ������������� ������ �������� ��������� �
������������������ �������� ����� ��������.
 */

public class hand {

    ArrayList<Statement> content;
    // ������� �����������
    public final static String DELIMITERS = "\u3030.!?";

    public void parse() throws IOException {
        //����� BufferedWriter ���������� ����� � �����, �������������� ����������� ������������
        //�������, ��� ����� ������ ���������� ��������� � ����������� �������� ��� ������ ������.
        BufferedReader in = new BufferedReader(new FileReader("C:\\task2-master\\src\\main\\files\\lol1.txt"));
        // ����� FileWriter �������� ����������� �� ������ Writer. �� ������������ ��� ������ ��������� ������.
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

    // 3. ����� ����� ����� � ������ �����������, �������� ��� �� � ����� ��
    // ��������� �����������.
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

    //	4. �� ���� �������������� ������������ ������ ����� � ���������� ��� ����������
    //	����� �������� �����.
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

    // 1. ����� ���������� ���������� ����������� ������, � ������� ���� ����������
    // �����.
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
