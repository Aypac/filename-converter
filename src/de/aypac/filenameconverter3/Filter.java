package de.aypac.filenameconverter3;

import de.aypac.filenameconverter3.*;

public class Filter {

    String replace;
    String replaceBy;
    private boolean CS;
    private boolean regex;

    public Filter(String Replace, String ReplaceBy, boolean caseSensitive, boolean regex) {
        this.replaceBy = ReplaceBy;
        this.replace = Replace;
        this.CS = caseSensitive;
        this.regex = regex;
    }

    public void edit(String Replace, String ReplaceBy, boolean caseSensitive, boolean regex) {
        this.replaceBy = ReplaceBy;
        this.replace = Replace;
        this.CS = caseSensitive;
        this.regex = regex;
    }

    public String getReplace() {
        return this.replace;
    }

    public String getReplaceBy() {
        return this.replaceBy;
    }

    public boolean isCaseSensitive() {
        return this.CS;
    }

    public boolean isRegex() {
        return this.regex;
    }

    public String execute(String a) {
        if (this.isRegex()) {
            a = a.replaceAll(this.getReplace(), this.getReplaceBy());
        } else if (!this.isCaseSensitive()) {
            a = a.replace(this.getReplace(), this.getReplaceBy());
            //String replace = this.getReplace();
            //a = a.replaceAll("(?i)" + replace, this.getReplaceBy());
        } else {
            a = a.replace(this.getReplace(), this.getReplaceBy());
        }
        return a;
    }
}
