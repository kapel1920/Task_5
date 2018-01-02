package simple;

public class GiftBox {
    // создаем новый массив(класса)
    Sweet[] mSweets = new Sweet[0];
    private double totalWeight = 0;
    private double totalPrice = 0;
    private int unNum = 1;
    private Sweet[] weight;
    public String data = "  ";

    public void addSweet(Sweet sweet)
    {
        int oldItem = mSweets.length;
        Sweet[] newSweets = new Sweet[oldItem + 1];
        for (int i = 0; i < oldItem; i++)
        {
            newSweets[i]= mSweets[i];
        }
        newSweets[oldItem]=sweet;
        // формирум номер записи в массиве
        newSweets[oldItem].unNum = oldItem + 1;
        // перезаписываем массив класса
        mSweets = newSweets;
        // считаем итог, прибавляем последний ввод
        totalWeight += sweet.weight;
        totalPrice += sweet.price;
    }


    public int delSweet(int s2)
    {
        // размер массива после удаления
        int s21 = mSweets.length - 1;
        Sweet[] strArray = new Sweet[s21];
        int j = 0;
        for(int i = 0; i < mSweets.length; i++) {
            if (i == s2 - 1){
                // вычитаем удаление
                totalPrice  -= mSweets[i].price;
                totalWeight -= mSweets[i].weight;
            }
            else
            {
                // перезаписываем данные все кроме удаленной записи
                strArray[j]= mSweets[i];
                // меняем номер записи в массиве т.к. было удаление
                strArray[j].unNum = j + 1;
                j++;
            }
        }
        // перезаписываем
        mSweets = strArray;
        return s2;
    }

    public void printItems() {
        for (int i = 0; i < mSweets.length; i++) {
            System.out.println("                              " + mSweets[i].description());
        }
    }

    //Для записи в файл через переменную data
    public String printItems1() {
        data = "Вывод из файла \n";
        for (int i = 0; i < mSweets.length; i++) {
            data += "                              " + mSweets[i].description() + "\n";
        }
        data += "                              ---------------------------------------------------------------------------- \n";
        data += "                              Итого по подароку                         вес " + getTotalWeight() + "       цена " + getTotalPrice() + "\n";
        return data;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public int getNumSweets() {
        return mSweets.length;
    }

    public int getUnNum() {return unNum; }

}