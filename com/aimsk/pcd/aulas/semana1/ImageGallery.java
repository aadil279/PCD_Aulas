package com.aimsk.pcd.aulas.semana1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImageGallery {
    public static void main(String[] args){
        if(args.length != 1) {
            System.out.println("Please specify a path to images!");
            return;
        }
        ImageGallery gallery = new ImageGallery(args[0]);
        gallery.startGallery();
    }
    private String[] files;
    private int currentPos = 0;
    private JFrame frame;
    public ImageGallery(String path) {
        this.files = getFileNames(new File(path).listFiles());
        this.frame = new JFrame(path);
    }

    private String[] getFileNames(File[] files) {
        String[] filenames = new String[files.length];

        for(int i = 0; i < files.length; i++)
            filenames[i] = files[i].getAbsolutePath();
        return filenames;
    }
    public void startGallery() {
        frame.setLayout(new BorderLayout());
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(files[currentPos]));
        frame.add(image, BorderLayout.CENTER);

        JButton left = new JButton("<");
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(false, image);
            }
        });
        frame.add(left, BorderLayout.WEST);

        JButton right = new JButton(">");
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(true, image);
            }
        });
        frame.add(right, BorderLayout.EAST);

        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO Implement...
            }
        });
        frame.add(update, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void move(boolean right, JLabel image) {
        String nextImage;
        if(right && currentPos+1 < files.length)
            nextImage = files[++currentPos];
        else if(!right && currentPos-1 >= 0)
            nextImage = files[--currentPos];
        else
            return;
        image.setIcon(new ImageIcon(nextImage));
        frame.repaint();
    }

}
