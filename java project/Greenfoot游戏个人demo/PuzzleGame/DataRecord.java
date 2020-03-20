import java.util.ArrayList;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *  此类提供文本读取
 *  获取rules.txt写入的游戏规则内容
 *  以及获取和写入records.txt 的游戏记录
 */
public class DataRecord  
{
    public static String getRules() throws Exception{
        String result="";
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        try{
            fileReader=new FileReader("./record/rules.txt");
            bufferedReader=new BufferedReader(fileReader);
            try{
                String read=null;
                while((read=bufferedReader.readLine())!=null){
                    result=result+read+"\r\n";
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(bufferedReader!=null){
                bufferedReader.close();
            }
            if(fileReader!=null){
                fileReader.close();
            }
        }
        return result;
    }
    
    // 读取记录
    public static String getRecords() throws Exception{
        String result="";
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        try{
            fileReader=new FileReader("./record/records.txt");
            bufferedReader=new BufferedReader(fileReader);
            try{
                String read="";
                while((read=bufferedReader.readLine())!=null){
                    String[] splictRes = read.split("\\|");
                    /*
                    * 将时间戳格式化为日期
                    * splictRes[1]:
                    *   Record:1584093234723
                    * */
                   String[] time = splictRes[1].split(":");
                   /*
                   * time[1] 为时间戳字符串
                   * */
                   String formatStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.parseLong(time[1].trim()));
                   formatStr = "Record:" + formatStr + "  " + splictRes[2] + splictRes[3] + splictRes[4];
                   result += formatStr + "\n-----------------------------------------------------------------------------\n";
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(bufferedReader!=null){
                bufferedReader.close();
            }
            if(fileReader!=null){
                fileReader.close();
            }
        }
        
        // 加上游戏提示
        result = "(按照历史耗时，步数排名，耗时、步数少的排名在前！)\n" + "1-简单模式 2-普通模式 3-困难模式\n" + result;
        return result;
    }
    
        // 保存记录
    public static void saveData(long timere, int time, int counter, int type) throws Exception {
        // 读取文件历史数据
        ArrayList<Map<String, Long>> records = new ArrayList<>();
        File file = new File("./record/", "records.txt");
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = bufferedReader.readLine()) != null && !line.equals("")) {
                // 记录项目
                Map<String, Long> item = new HashMap<>();
                line.replaceAll("\n","");
                String[] res = line.split("\\|");
                for (int i = 1; i < res.length; i++) { // 第一项为“” 所以跳过
                    String[] keyValue = res[i].split(":");
                    item.put(keyValue[0], Long.parseLong(keyValue[1].replaceAll(" ", "")));
                }
                records.add(item);
            }

            // 输出查看
            Iterator itr = records.iterator();
            while (itr.hasNext()) {
                Map<String,Long> temp = (Map<String, Long>) itr.next();
            }


            // 数据比较
            // 实现Comparator lambda写法 降序排列
            Comparator<Map<String, Long>> comparator = (o1, o2) -> {
                int costTime1 = o1.get("Time").intValue();int costTime2 = o2.get("Time").intValue();
                int steps1 = o1.get("steps").intValue();int steps2 = o2.get("steps").intValue();
                if (costTime2 == costTime1) {
                    return steps1 - steps2;
                } else {
                    return costTime1 - costTime2;
                }
            };
            // 先添加 再排序 最后只保留五个
            Map<String, Long> item3 = new HashMap<>();
            item3.put("Record", timere);
            item3.put("Time", (long)time);
            item3.put("steps", (long)counter);
            item3.put("type", (long)type);
            records.add(item3);
            // 排序输出查看
            Collections.sort(records, comparator);
            /*
            * 多余的数据删除
            * 6 条封顶
             * */
            if (records.size() > 6) {
                records.remove(6);
            }

            // 输出查看
            Iterator itr2 = records.iterator();
            while (itr2.hasNext()) {
                Map<String,Long> temp2 = (Map<String, Long>) itr2.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null) {
                bufferedReader.close();
            }
        }

        // 写入文件
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            Iterator outer = records.iterator();
            while (outer.hasNext()) {
                Map<String,Long> outrecord = (Map<String, Long>) outer.next();

                // 输出内容
                String output = "|Record:" + String.format("%-15d", outrecord.get("Record"))
                        + "|Time:" + String.format("%-3d", outrecord.get("Time"))
                        + "|steps:" + String.format("%-3d", outrecord.get("steps"))
                        + "|type:" + String.format("%-3d", outrecord.get("type")) + "|\n";

                bufferedWriter.write(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }
    
}
