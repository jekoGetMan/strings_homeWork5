package homeWork5;

import java.io.IOException;

 class Main {
    public static void main(String[] args) throws IOException {
        hand handler = new hand();
        handler.parse();
        System.out.println(" THE FIRST TASK IS:\t" + handler.Task1());
        System.out.println(" THE 3RD TASK IS:\t" + handler.Task3().someTxt);
        System.out.println("FOURTH TASK IS:\t" + handler.Task4(9));
    }
}
