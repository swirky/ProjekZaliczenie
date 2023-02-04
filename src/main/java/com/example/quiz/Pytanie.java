package com.example.quiz;

public class Pytanie {
    private String text;
    private String[] odp;
    private int poprawna;

    public Pytanie(String text, int poprawna, String...odp) {
        this.text = text;
        this.odp = odp;
        this.poprawna = poprawna;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOdp() {
        return odp;
    }

    public void setOdp(String[] odp) {
        this.odp = odp;
    }

    public int getPoprawna() {
        return poprawna;
    }

    public void setPoprawna(int poprawna) {
        this.poprawna = poprawna;
    }
}
