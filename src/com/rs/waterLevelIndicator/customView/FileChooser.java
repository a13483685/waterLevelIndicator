package com.rs.waterLevelIndicator.customView;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.view.MainFrm;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFrame{


    public FileChooser(String fileClass,Component parent){
        JFileChooser chooser = new JFileChooser(Constans.LOG_PATH+fileClass);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("日志文件", "log");
        chooser.setFileFilter(filter);
        chooser.showDialog(parent,"选择文件");
        File file = chooser.getSelectedFile();
//        if(file.isDirectory()){
//            System.out.println("文件夹:"+file.getAbsolutePath());
//        }else
        if(file.isFile()){ System.out.println("文件:"+file.getAbsolutePath());
        try {
            Runtime.getRuntime().exec("NotePad.exe"+" "+file.getAbsolutePath());
        } catch (IOException e1) {
            e1.printStackTrace(); }
        }
    }
}

