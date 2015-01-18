package de.aypac.filenameconverter3;

import de.aypac.filenameconverter3.*;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

public class lib {

    private static String localFilterPath = System.getenv("APPDATA") + "\\MC2\\";
    private static String exportPath = System.getenv("HOMEDRIVE") + "\\" + System.getenv("HOMEPATH") + "\\";
    public static String filterSuffix = ".mncf";

    public static DefaultListModel jListToModel(JList a) {
        DefaultListModel model = new DefaultListModel();
        int i = 0;
        while (a.getModel().getSize() > i) {
            model.addElement(a.getModel().getElementAt(i).toString());
            i++;
        }
        return model;
    }

    public static DefaultListModel filterToModel(Filter[] Filter) {
        DefaultListModel model = new DefaultListModel();
        int i = 0;
        while (Filter.length > i) {
            model.addElement("\"" + Filter[i].getReplace() + "\" -> \"" + Filter[i].getReplaceBy() + "\"");
            i++;
        }
        return model;
    }

    public static void saveFilterLocal(Filter[] filter, String name) {
        saveFilter(filter, localFilterPath + name + filterSuffix);
    }

    public static String exportFilter(String name) {
        File f = new File(localFilterPath + name + filterSuffix);
        File fTo = new File(exportPath + name + filterSuffix);
        if (f.exists()) {
            try {
                Files.copy(f.toPath(), fTo.toPath());
                return "Wurde erfolgreich nach " + fTo.toPath() + " exportiert.";
            } catch (IOException ex) {
                Logger.getLogger(lib.class.getName()).log(Level.SEVERE, null, ex);
                return "Es ist ein unbekannter Fehler aufgetreten, bitte per Mail melden.";
            }
        }
        return "Der ausgewählte Filter existiert nicht!";
    }

    public static Filter[] loadFilterLocal(String name) {
        return loadFilter(localFilterPath + name + filterSuffix);
    }

    public static String importFilter(String path) {
        File f = new File(path);
        File fTo = new File(localFilterPath + f.getName());
        if (f.exists()) {
            try {
                Files.copy(f.toPath(), fTo.toPath());
                return "Wurde erfolgreich importiert.";
            } catch (IOException ex) {
                Logger.getLogger(lib.class.getName()).log(Level.SEVERE, null, ex);
                return "Es ist ein unbekannter Fehler aufgetreten, bitte per Mail melden.";
            }
        }
        return "Der ausgewählte Filter existiert nicht!";
    }

    public static void deleteFilterLocal(String name) {
        File f = new File(localFilterPath + name + filterSuffix);
        if (f.exists()) {
            f.delete();
        }
    }

    static void saveFilter(Filter[] filter, String path) {
        File f = new File(path);
        BufferedWriter sw = null;
        try {
            f.getParentFile().mkdirs();
            if (!f.exists()) {
                f.createNewFile();
                f.setWritable(true);
            }
            sw = new BufferedWriter(new FileWriter(f));
            for (Filter fd : filter) {
                char a = '0';
                if (fd.isCaseSensitive()) {
                    a = '1';
                }
                char b = '0';
                if (fd.isRegex()) {
                    b = '1';
                }
                sw.write(fd.getReplace() + "\0" + fd.getReplaceBy() + "\0" + a + "\0" + b + "\0\r\n");
            }
            return;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                sw.close();
            } catch (IOException ex) {
                Logger.getLogger(lib.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static Filter[] loadFilter(String path) {
        Stack filter = new Stack();
        File f = new File(path);
        BufferedReader sw = null;
        try {
            f.createNewFile();
            sw = new BufferedReader(new FileReader(f));
            String a = "";
            String b = "";
            while ((a = sw.readLine()) != null) {
                boolean c = false, d = false;
                String[] parts = a.split("\0");
                a = parts[0];
                b = parts[1];
                c = (parts[2].contains("1"));
                d = (parts[3].contains("1"));
                filter.add(new Filter(a, b, c, d));
            }
            return (Filter[]) filter.toArray(new Filter[1]);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                sw.close();
            } catch (IOException ex) {
                Logger.getLogger(lib.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (Filter[]) filter.toArray(
                new Filter[1]);
    }

    static ListModel loadFilterlist() {
        File f = new File(localFilterPath);

        DefaultListModel lm = new DefaultListModel();

        try {
            f.getParentFile().mkdirs();
            if (f.exists()) {
                File[] filters = f.listFiles();
                for (File filter : filters) {
                    String name = filter.getName();
                    if (filter.length() > 0 && name.endsWith(filterSuffix)) {
                        lm.addElement(name.substring(0, name.lastIndexOf(filterSuffix)));
                    }

                }
            }
            return (ListModel) lm;
        } catch (Exception e) {
            System.err.println(e);
        }
        return (ListModel) lm;
    }
}
