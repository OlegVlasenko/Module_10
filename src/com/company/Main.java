package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

class Main {

    public static void main(String[] args)  {
        BufferedReader in = null;
        BufferedWriter out = null;
        Path pathIn = FileSystems.getDefault().getPath("input.txt");
        try {
            in = Files.newBufferedReader(pathIn, Charset.defaultCharset());
            out = new BufferedWriter(new FileWriter("output.txt"));
            String s;

            while ((s = in.readLine()) != null) {
                out.write(Caesar.encodeValue(s));
                out.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        pathIn = FileSystems.getDefault().getPath("output.txt");
        try {
            in = Files.newBufferedReader(pathIn, Charset.defaultCharset());
            out = new BufferedWriter(new FileWriter("output2.txt"));
            String s;

            while ((s = in.readLine()) != null) {
                out.write(Caesar.decodeValue(s));
                out.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
