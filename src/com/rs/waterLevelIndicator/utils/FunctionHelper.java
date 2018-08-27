package com.rs.waterLevelIndicator.utils;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class FunctionHelper {
    public static void SaveSelectedDevToFile(String selectedDev){
        BufferedWriter writer = null;
        File file = new File("d:\\"+ "devSelected" + ".json");
        //如果文件不存在，则新建一个
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "UTF-8"));
            writer.write(selectedDev);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @return 上次一选择的设备
     */
    public static String getLastSelectedDevToFile(){
        String Path="d:\\"+ "devSelected" + ".json";
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }


    public static String getAllDate(){
        SimpleDateFormat lFormat;
        //格式可以自己根据需要修改
        lFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String gRtnStr = lFormat.format(new Date());
        return gRtnStr;
    }

    /**

     * frame中的控件自适应frame大小：改变大小位置和字体

     * @param frame 要控制的窗体

     * @param proportionW 当前和原始的比例

     */

    public static void modifyComponentSize(JFrame frame, float proportionW, float proportionH){
        try
        {
            Component[] components = frame.getRootPane().getContentPane().getComponents();
            for(Component co:components)
            {
                float locX = co.getX() * proportionW;
                float locY = co.getY() * proportionH;
                float width = co.getWidth() * proportionW;
                float height = co.getHeight() * proportionH;
                co.setLocation((int)locX, (int)locY);
                co.setSize((int)width, (int)height);
                int size = (int)(5*co.getFont().getSize() * proportionH);
                Font font = new Font(co.getFont().getFontName(), co.getFont().getStyle(), size);
                co.setFont(font);
            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
    }

    //统一界面字体
    public static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys();
             keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }
}
