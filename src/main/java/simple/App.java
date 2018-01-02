package simple;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;


public class App {
    static Scanner scan = new Scanner(System.in);
    private static String x;
    public String stF;


    public static void main(String[] args) {

        GiftBox box = new GiftBox();

        String fI = " ";

        //     String data = "  ";
        String nC = "  ";
        double pC = 0;
        double wC = 0;
        int uC  = 1;
        // int pU1 = 1;
        int s2;
        int vibor = 3;

        double totalWeight = 0;
        double totalPrice = 0;

        while (vibor != 0) {
            System.out.println("Выберите действие: ");
            System.out.println("1 - Добавить шоколадку, 2 - Добавить печение, 3 - Записать в файл, 4 - Удалить сладость из подарка, 5 - Прочитать из файла, 0 - Выход ");
            int sl = scan.nextInt();
            //Добавление шаколадки в подарок
            if (sl == 1) {
                String nc1 = scan.nextLine(); //для чистки строки nameS
                System.out.print("Введите название шоколадки: ");
                nC = scan.nextLine();
                System.out.print("Введите цену     шоколадки: ");
                pC = scan.nextInt();
                System.out.print("Введите вес      шоколадки: ");
                wC = scan.nextInt();
                box.addSweet(new Chocolate(nC, pC, wC, uC));
                uC++;
                box.printItems();
            }
            //Добавление печенья в подарок
            if (sl == 2) {
                String nc1 = scan.nextLine(); //для чистки строки nameS
                System.out.print("Введите название печенья: ");
                nC = scan.nextLine();
                System.out.print("Введите цену     печенья: ");
                pC = scan.nextInt();
                System.out.print("Введите вес      печенья: ");
                wC = scan.nextInt();
                box.addSweet(new Cookie(nC, pC, wC, uC));
                uC++;
                box.printItems();
            }
            //Запись подарка в файл (перезапись)
            if (sl == 3)
            {
                box.printItems1();
                File file = new File("C:/IdeaProjectsAplana/Task_5/src/main/java/simple/File.txt");
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                    fr.write(box.data);
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    try {
                        fr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //Удаление сладости из подарка
            if (sl == 4)
            {  System.out.print("Введите уникальный номер для удаления сладости: ");
                s2 = scan.nextInt();
                box.delSweet(s2);
                box.printItems();
            }
            //Чтение подарка из файла
            if (sl == 5)
            {
                try {
                    File file = new File("C:/IdeaProjectsAplana/Task_5/src/main/java/simple/File.txt");
                    FileReader fr = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fr);
                    String line = reader.readLine();
                    while (line != null) {
                        System.out.println(line);
                        line = reader.readLine();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            vibor = sl;
        }
        System.out.println("                              ---------------------------------------------------------------------------- ");
        box.printItems();
        System.out.println("                              Итого по подароку                         вес " + box.getTotalWeight() + "       цена " + box.getTotalPrice());
    }
}