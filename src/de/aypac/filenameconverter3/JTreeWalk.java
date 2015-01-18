package de.aypac.filenameconverter3;

import de.aypac.filenameconverter3.*;
import java.io.File;

public class JTreeWalk
        extends Thread {

    private File root;
    private String path;
    private Filter[] filter;
    boolean b = true;
    int cDirs = 0;
    int cFiles = 0;
    boolean ignorePerms;

    JTreeWalk() {
        System.out.println("Startverzeichnis:\n" + this.path);
    }

    JTreeWalk(String s, Filter[] newFilter, boolean ignorePerm) {
        this.path = s;
        this.filter = newFilter;
        this.ignorePerms = ignorePerm;
        this.root = new File(s);
    }

    public void run() {
        treewalk(this.root);
        Main.ready();
    }

    private void treewalk(File f) {
        this.cFiles += 1;
        Main.setStatus(this.cFiles, this.cDirs);

        File[] files = f.listFiles();
        if ((files == null) || (files.length < 1)) {
            return;
        }
        for (int i = 0; (i < files.length) && (this.b); i++) {
            if (files[i].isDirectory()) {
                treewalk(files[i]);
            } else {
                this.cDirs += 1;
                Main.setStatus(this.cFiles, this.cDirs);

                String a = files[i].getName();
                for (int i2 = 0; (this.filter.length > i2) && (this.b); i2++) {
                    Filter cur = this.filter[i2];
                    a = cur.execute(a);
                }
                String b = files[i].getAbsoluteFile().getAbsolutePath();
                b = b.substring(0, b.lastIndexOf('\\') + 1);
                File buf = new File(b + a);
                if (this.ignorePerms) {
                    files[i].setWritable(true);
                }
                if (files[i].canWrite()) {
                    if (!buf.equals(files[i].getAbsoluteFile().getAbsolutePath())) {
                        files[i].renameTo(buf);
                    }
                } else {
                    System.err.println("File \"" + files[i].getAbsoluteFile().getAbsolutePath() + "\" could not be renamed! (no write rights)");
                }
            }
        }
    }

    public void interrupt() {
        this.b = false;
    }
}
