package console_app;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

    public class Transporter {

        private LinkedHashMap<Integer, ArrayList<String>> text = new LinkedHashMap<>();
        private ArrayList<String> transposeText = new ArrayList<>();
        private int maxWordsInLine = 0;
        private int maxWordLength = 0;

        public Transporter(String file) throws IOException {
            if (!this.equals(null)) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                createMap(br);
                br.close();
            }
            else {
                System.out.println("Введите текст: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                createMap(br);
                br.close();
            }
        }

        public void createMap(BufferedReader reader) throws IOException {
            Integer i = 0;
            String l;
            while ((l = reader.readLine()) != null) {
                String[] parts = l.split(" +|\\n");
                if (parts.length > maxWordsInLine) {
                    maxWordsInLine = parts.length;
                }
                ArrayList<String> list = new ArrayList();
                for (int k = 0; k < parts.length; k++) {
                    if (parts[k].length() > maxWordLength)
                        maxWordLength = parts[k].length();
                    list.add(parts[k]);
                }
                text.put(i, list);
                i++;
            }
        }

        public void transpose() {
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

        public void cut(int a) {
            for (int i = 0; i < transposeText.size(); i++) {
                if (transposeText.get(i) != "\n") {
                    while (transposeText.get(i).length() > a) {
                        transposeText.set(i, transposeText.get(i).substring(0, a));
                    }
                }
            }
        }

        public void leftSide(int length) {
            for (int i = 0; i < transposeText.size() - 1; i++) {
                if (!transposeText.get(i).equals("\n") && !transposeText.get(i + 1).equals("\n")) {
                    while (transposeText.get(i).length() <= length) {
                        transposeText.set(i, transposeText.get(i) + " ");
                    }
                }
            }
        }

        public void rightSide(int lenght) {
            for (int i = 0; i < transposeText.size() - 1; i++) {
                if (!transposeText.get(i).equals("\n")) {
                    while (transposeText.get(i).length() < lenght) {
                        transposeText.set(i, " " + transposeText.get(i));
                    }
                    if (!transposeText.get(i + 1).equals("\n"))
                        transposeText.set(i,transposeText.get(i) + " ");
                }
            }
        }


        public String convert() {
            StringBuilder result = new StringBuilder();
            for (String s : transposeText) {
                result.append(s);
            }
            return result.toString();
        }


        public void writeTo(String ofile) throws IOException {
            if (!this.equals(null)) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(ofile));
                writer.write(this.convert());
                writer.close();
                System.out.println(this.convert());
            }
            else
                System.out.println(this.convert());

        }


    }