package musicconverter2;

public class Filter {

    String replace;
    String replaceBy;
    private boolean CS;
    private boolean regex;

    public Filter(String Replace, String ReplaceBy) {
        this.replaceBy = ReplaceBy;
        this.replace = Replace;
    }

    public void edit(String Replace, String ReplaceBy) {
        this.replaceBy = ReplaceBy;
        this.replace = Replace;
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
}
