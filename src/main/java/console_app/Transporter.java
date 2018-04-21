package console_app;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

import static java.lang.StrictMath.abs;

class Transporter {

    private TreeMap<Integer, ArrayList<String>> text = new TreeMap<>();
    private ArrayList<String> transposeText = new ArrayList<>();
    private int maxWordsInLine = 0;
    private int maxWordLength = 0;

    Transporter(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        createMap(br);
        br.close();
    }
    Transporter() throws IOException{
        System.out.println("Введите текст: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        createMap(br);
        br.close();
    }

    private void createMap(BufferedReader reader) throws IOException {
        Integer i = 0;
        String l;
        while ((l = reader.readLine()) != null) {
            String[] parts = l.split(" +|\\n");
            if (parts.length > maxWordsInLine) {
                maxWordsInLine = parts.length;
            }
            ArrayList list = new ArrayList();
            for (String part : parts) {
                if (part.length() > maxWordLength)
                    maxWordLength = part.length();
                list.add(part);
            }
            text.put(i, list);
            i++;
        }
    }

    void transpose() {
        for (int i = 0; i < maxWordsInLine; i++) {
            for (Integer key : text.keySet()) {
                if (!text.get(key).isEmpty()) {
                    transposeText.add(text.get(key).get(0));
                    text.get(key).remove(0);
                }
            }
            transposeText.add("\n");
        }
    }

    void cut(int a) {
        for (int i = 0; i < transposeText.size(); i++) {
            if (!Objects.equals(transposeText.get(i), "\n")) {
                while (transposeText.get(i).length() > a) {
                    transposeText.set(i, transposeText.get(i).substring(0, a));
                }
            }
        }
    }

    void leftSide(int length) {
        int k;
        for (int i = 0; i < transposeText.size() - 1; i++) {
            if (!transposeText.get(i).equals("\n") && !transposeText.get(i + 1).equals("\n") && transposeText.get(i).length() <= length) {
                StringBuilder sb = new StringBuilder();
                k = abs(transposeText.get(i).length() - length);
                while (k >= -1) {
                    sb.append(" ");
                    k--;
                }
                transposeText.set(i,transposeText.get(i) + sb.toString());
            }
        }
    }

    void rightSide(int lenght) {
        int k;
        for (int i = 0; i < transposeText.size() - 1; i++) {
            if (!transposeText.get(i).equals("\n")) {
                StringBuilder sb = new StringBuilder();
                k = abs(transposeText.get(i).length() - lenght);
                while (k >= 0) {
                    sb.append(" ");
                    k--;
                }
                transposeText.set(i,sb.toString() + transposeText.get(i));
            }
        }
    }


    String convert() {
        StringBuilder result = new StringBuilder();
        for (String s : transposeText) {
            result.append(s);
        }
        return result.toString();
    }


    void writeToFile(String ofile) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ofile));
            writer.write(convert());
            writer.close();
        }

    void writeToConsole() {
        System.out.println(convert());
    }
}
