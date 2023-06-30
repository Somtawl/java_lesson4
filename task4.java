import java.util.ArrayList;
import java.util.Scanner;

public class task4 {
     public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Сколько человек добавляем ? ");
        int n = Integer.parseInt(iScanner.nextLine());
        String[] fio = new String[n];
        int[] age = new int[n];
        String[] sex = new String[n];
        int[] key = new int[n]; 
        for (int i = 0; i < n; i++)
        {
            System.out.print("Введите ФИО ");
            String GetName = iScanner.nextLine();
            fio[i] = GetName;
            System.out.print("Введите возраст ");
            String GetAge = iScanner.nextLine();
            age[i] = Integer.parseInt(GetAge);
            System.out.print("Введите пол (M или F) ");
            String GetSex = iScanner.nextLine();
            sex[i] = GetSex;
            key[i] = i;
        }
        iScanner.close();
        //Сортировка по возрасту
        int[] ageTmp = new int[n];
        for (int i = 0; i < n; i++)
        {
            ageTmp[i] = age[i];
        }
        ArrayList ageSort = new ArrayList();
        int count = 0;
        for (;ageSort.size() != n;)
        {
            int tmpAge = ageTmp[count];
            int tmpIndex = count;
            for (int j = 0; j < n; j++)
            {
                if (tmpAge >= ageTmp[j])
                {
                    tmpAge = ageTmp[j ];
                    tmpIndex = j;
                }
            }
            if (tmpAge != 100500)
            {
                ageSort.add(tmpIndex);
                ageTmp[tmpIndex] = 100500;
            }
            count++;
            if (count == n)
            {
                count = 0;
            }
        }
        System.out.println("Сортировка по возрасту");
        for (int i = 0; i < n; i++)
        {
            System.out.print(fio[(int) ageSort.get(i)] + " ");
            System.out.print(age[(int) ageSort.get(i)] + " ");
            System.out.println(sex[(int) ageSort.get(i)]);
        }
        // Сортировка по возрасту и полу
        ageSort = new ArrayList();
        ArrayList tmpList = new ArrayList();
        int Male = 0;
        int Female = 0;
        for (int i = 0; i < n;i++)
        {
            if (sex[i].equalsIgnoreCase("M"))
            {
                Male = Male + 1;
            }
            if (sex[i].equalsIgnoreCase("F"))
            {
                Female = Female + 1;
            }
        }
        count = 0;
        for (;ageSort.size() < n;)
        {
            int proc = 0;
            int tmpAge = age[count];
            int tmpIndex = count;
            String gender = "";
            int lastPerson = count;
            for(int i = 0; i < n;i++)
            {
                gender = sex[count];
                if (Male > 1)
                {
                    if (tmpAge > age[i] && sex[i].equalsIgnoreCase("M") && CheckArray(i, ageSort) != 1)
                    {
                        tmpAge = age[i];
                        tmpIndex = i;
                        gender = "M";
                        proc = 1;
                    }
                }
                if (Male == 0 & Female > 1)
                {
                    if (tmpAge > age[i] && sex[i].equalsIgnoreCase("F") && CheckArray(i, ageSort) != 1)
                    {
                        tmpAge = age[i];
                        tmpIndex = i;
                        gender = "F";
                        proc = 1;
                    }
                }
               if (Male == 1 && sex[tmpIndex].equalsIgnoreCase("M") && CheckArray(count, ageSort) != 1)
                {
                    tmpIndex = lastPerson;
                    proc = 1;
                }
                if (Male == 0 && sex[tmpIndex].equalsIgnoreCase("F") && Female == 1 && CheckArray(count, ageSort) !=1)
                {
                    tmpIndex = lastPerson;
                    proc = 1;
                }
            }
            if (Male == 1 & gender.equalsIgnoreCase("M") & proc == 1)
            {
                ageSort.add(lastPerson);
                Male--;
            }
            if (Female == 1 & gender.equalsIgnoreCase("F") & proc == 1)
            {
                ageSort.add(lastPerson);
                Female--;              
            }
            if (gender.equalsIgnoreCase("M") & Male > 1 & proc == 1)
            {
                ageSort.add(tmpIndex);
                Male--;
            }
            if (gender.equalsIgnoreCase("F") & Male == 0 & Female > 1 & proc == 1)
            {
                ageSort.add(tmpIndex);
                Female--;
            }
            count++;
            if (count == n)
            {
                count = 0;
            }
        }
        System.out.println("Сортировка по возрасту и полу");
        for (int i = 0; i < n; i++)
        {
            System.out.print(fio[(int) ageSort.get(i)] + " ");
            System.out.print(age[(int) ageSort.get(i)] + " ");
            System.out.println(sex[(int) ageSort.get(i)]);
        }
    }
    public static int CheckArray(int num,ArrayList arr)
    {
        System.out.println("Начинаем проверку числа " + num + " в массиве " + arr + " Размер массива = " + arr.size());
        if (arr.size() > 0)
        {
            System.out.println("Check " + num + " " + arr);
            for (int i = 0; i < arr.size(); i++)
            {
                int CheckNum = (int) arr.get(i);
                if (CheckNum == num)
                {
                    System.out.println(CheckNum + " уже в массиве");
                    return 1;
                }
            } 
        }
            System.out.println(num + " Всё норм");
            return 0;
    }
}
