import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String s = readFromFile("input.txt");
            writeToFile(calculator(s)+"");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static double calculator(String s) throws Exception{
        String[] s1 = s.split(" ");
            if (!s1[0].matches("\\d+") || !s1[2].matches("\\d+")) throw new Exception("Error! Not number");
            if (!s1[1].matches("[/*+-]")) throw new Exception("Operation Error!");
            if (Integer.parseInt(s1[2]) == 0&&s1[1].equals("/")) throw new Exception("Error! Division by zero");
            double a = Double.parseDouble(s1[0]);
            double b = Double.parseDouble(s1[2]);
            if (s1[1].equals("/")) return a / b;
            if (s1[1].equals("*")) return a * b;
            if (s1[1].equals("+")) return a + b;
            if (s1[1].equals("-")) return a - b;
            return 0;
    }

    public static String readFromFile(String file_name) throws IOException{
        FileReader reader = new FileReader("input.txt");
        String s="";
        int c;
        while ((c=reader.read())!=-1){
            s+=(char)c;
        }
        reader.close();
        return s;
    }

    public static void writeToFile(String s) throws IOException{
        FileWriter writer = new FileWriter("output.txt");
        writer.write(s);
        writer.append('\n');
        writer.flush();
    }
}