package homeWork5;

import java.io.IOException;

 class Main {
     //Часть исключений может обрабатывать сама система. Но можно создать собственные исключения при помощи оператора throw.
     //Код выглядит так: throw экземпляр_Throwable
    public static void main(String[] args) throws IOException {

        hand handler = new hand();
        handler.parse();
        System.out.println(" THE FIRST TASK IS:\t" + handler.Task1());
        System.out.println(" THE 3RD TASK IS:\t" + handler.Task3().text);
        System.out.println("FOURTH TASK IS:\t" + handler.Task4(9));
    }
}
