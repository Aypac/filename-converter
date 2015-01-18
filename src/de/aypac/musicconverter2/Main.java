package de.aypac.musicconverter2;

public class Main {

    static UI ui = new UI();

    public static void main(String[] args) {
        ui.setVisible(true);
    }

    public static void setStatus(int f, int d) {
        ui.setStatus(f, d);
    }

    static void ready() {
        ui.ready();
    }
}
