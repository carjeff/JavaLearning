package study.bufferedChar;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jason
 * @date 2022/7/14 14:00
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        try (
                Reader reader = new FileReader("src/src/study/bufferedChar/csb.txt");
                BufferedReader br = new BufferedReader(reader);
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/src/study/bufferedChar/new.txt"));
                )
        {
            List<String> data = new ArrayList<>();
            String line;
            while ((line = br.readLine())!= null){
                data.add(line);
            }

            System.out.println(data);
            //自定义排序规则
            List<String> sizes = new ArrayList<>();
            Collections.addAll(sizes,"一","二","三","四","五","六","七","八","九","十","十一","十二");
            Collections.sort(data, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return sizes.indexOf(o1.substring(0,o1.indexOf("."))) - sizes.indexOf(o2.substring(0,o2.indexOf(".")));
                }
            });
            System.out.println(data);

            for (String datum : data) {
                bw.write(datum);
                bw.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
