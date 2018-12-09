package homeWork5;

import java.io.IOException;

 class Main {
    public static void main(String[] args) throws IOException {
        hand handler = new hand();
        handler.parse();
        System.out.println("1)THE FIRST TASK IS:\t" + handler.Task1());
        System.out.println("2)THE THIRD TASK IS:\t" + handler.Task3().someTxt);
        System.out.println("4)THE FOURTH TASK IS:\t" + handler.Task4(9));
    }
}
