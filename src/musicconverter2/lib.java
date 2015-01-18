package musicconverter2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

public class lib {

    private static String filterfile = System.getenv("APPDATA") + "\\MC2\\" + "filters.mc2f";

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

    static void saveFilter(Filter[] filter, String name) {
        File f = new File(filterfile);
        BufferedWriter sw = null;
        BufferedReader sr = null;
        try {
            f.setWritable(true);
            sr = new BufferedReader(new FileReader(f));
            String a = "";
            boolean write = false;
            String filecontent = "";
            while ((a = sr.readLine()) != null) {
                if (!a.startsWith(">")) {
                    if (a.equals(">" + name)) {
                        write = false;
                    } else {
                        write = true;
                    }
                }
                if (write) {
                    filecontent = filecontent + a + "\r\n";
                }
            }
            sr.close();
            sw = new BufferedWriter(new FileWriter(f));
            sw.write(filecontent + "\r\n");
            sw.write(">" + name + "\r\n");
            for (Filter fd : filter) {
                sw.write(fd.getReplace() + "\r\n" + fd.getReplaceBy() + "\r\n");
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

    static Filter[] loadFilter(String file) {
        Stack filter = new Stack();
        File f = new File(filterfile);
        BufferedReader sw = null;
        try {
            f.createNewFile();
            sw = new BufferedReader(new FileReader(f));
            String a = "";
            String b = "";
            boolean read = false;
            while ((a = sw.readLine()) != null) {
                if (a.startsWith(">")) {
                    if (a.equals(">" + file)) {
                        read = true;
                    } else {
                        read = false;
                    }
                } else if ((read) && (a != "") && ((b = sw.readLine()) != "")
                        && (read)) {
                    filter.add(new Filter(a, b));
                }
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
        return (Filter[]) filter.toArray(new Filter[1]);
    }

    static ListModel loadFilterlist() {
        File f = new File(filterfile);

        DefaultListModel lm = new DefaultListModel();

        BufferedReader sr = null;
        try {
            f.getParentFile().mkdirs();
            if (!f.exists()) {
                f.createNewFile();
                f.setWritable(true);
            }
            sr = new BufferedReader(new FileReader(f));
            String a = "";
            while ((a = sr.readLine()) != null) {
                if (a.startsWith(">")) {
                    lm.addElement(a.substring(1));
                }
            }
            return (ListModel) lm;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                sr.close();
            } catch (IOException ex) {
                Logger.getLogger(lib.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (ListModel) lm;
    }
}
