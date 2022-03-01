
import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) {
        String ch = "";
        String phoneme = "";
        long startTime = System.currentTimeMillis();

        String file = "C:\\Users\\admin\\Desktop\\NLP course\\work 1\\單字詞_13053(注音_無聲調).dic";
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader read = new BufferedReader(isr);) {
            String line;
            // 讀入建立字典
            HashMap<String, String> dict = new HashMap<String, String>();
            while ((line = read.readLine()) != null) {
                line = line.replace("\n", "");
                String s[] = line.split("\\,");
                // System.out.println(s[0] + s[1]);
                if (s.length > 1) {
                    ch = s[0];
                    phoneme = s[1];
                    dict.put(ch, phoneme);
                } else {
                    continue;
                }
            }

            String file2 = "C:\\Users\\admin\\Desktop\\NLP course\\work 1\\GigaWord_text_lm\\GigaWord_text_lm";
            try (InputStreamReader isr2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
                    BufferedReader read2 = new BufferedReader(isr2);) {
                String line2;
                // 讀入建立字典
                HashMap<String, Integer> phonemedict = new HashMap<String, Integer>();
                while ((line2 = read2.readLine()) != null) {

                    for (int i = 0; i < line2.length(); i++) {
                        char c = line2.charAt(i);
                        String txt = String.valueOf(c);
                        if (txt != "") {
                            boolean status = dict.containsKey(txt);
                            if (status == true) {
                                String v = dict.get(txt);
                                for (int k = 0; k < v.length(); k++) {
                                    char c1 = v.charAt(k);
                                    String tone = String.valueOf(c1);

                                    boolean te = phonemedict.containsKey(tone);
                                    if (te == true) {
                                        Integer sums = phonemedict.get(tone) + 1;
                                        phonemedict.put(tone, sums);

                                    } else {
                                        phonemedict.put(tone, 1);
                                    }
                                }

                            } else {
                                continue;
                            }

                        } else {
                            continue;
                        }

                    }

                }
                System.out.println(phonemedict);
                // 要獲取執行時間的程式碼片
                long endTime = System.currentTimeMillis();
                System.out.println("程式執行時間：" + (double) (endTime - startTime) / 1000 + "s");

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}