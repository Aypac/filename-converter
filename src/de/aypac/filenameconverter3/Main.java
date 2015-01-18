package de.aypac.filenameconverter3;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class Main {

    static UI ui = new UI();

    public static void main(String[] args) {
        ui.setVisible(true);
    }

    public static void setStatus(int f, int d) {
        int percentage = 0;
        ui.setStatus(d + " files in " + f + " dirs checked", percentage);
    }

    static void ready() {
        ui.ready();
        FileFilter f = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                String a = lib.filterSuffix;
                return pathname.getAbsolutePath().endsWith(a);
            }

            @Override
            public String getDescription() {
                String a = lib.filterSuffix;
                return "FileConverterFilterFile (" + a + ")";
            }
        };
    }
}
