package com.example.tabelataco.model;

public class Alimento {
    private int id;
    private String Caterogia;
    private String Alimento;
    private String Umidade;
    private String Energiakcal;
    private String kJ;
    private String Proteonag;
    private String Lipodeosg;
    private String Colesterolmg;
    private String Carboidratosg;

    public Alimento(int id, String caterogia, String alimento, String umidade, String energiakcal, String kJ, String proteonag, String lipodeosg, String colesterolmg, String carboidratosg) {
        this.id = id;
        Caterogia = caterogia;
        Alimento = alimento;
        Umidade = umidade;
        Energiakcal = energiakcal;
        this.kJ = kJ;
        Proteonag = proteonag;
        Lipodeosg = lipodeosg;
        Colesterolmg = colesterolmg;
        Carboidratosg = carboidratosg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaterogia() {
        return Caterogia;
    }

    public void setCaterogia(String caterogia) {
        Caterogia = caterogia;
    }

    public String getAlimento() {
        return Alimento;
    }

    public void setAlimento(String alimento) {
        Alimento = alimento;
    }

    public String getUmidade() {
        return Umidade;
    }

    public void setUmidade(String umidade) {
        Umidade = umidade;
    }

    public String getEnergiakcal() {
        return Energiakcal;
    }

    public void setEnergiakcal(String energiakcal) {
        Energiakcal = energiakcal;
    }

    public String getkJ() {
        return kJ;
    }

    public void setkJ(String kJ) {
        this.kJ = kJ;
    }

    public String getProteonag() {
        return Proteonag;
    }

    public void setProteonag(String proteonag) {
        Proteonag = proteonag;
    }

    public String getLipodeosg() {
        return Lipodeosg;
    }

    public void setLipodeosg(String lipodeosg) {
        Lipodeosg = lipodeosg;
    }

    public String getColesterolmg() {
        return Colesterolmg;
    }

    public void setColesterolmg(String colesterolmg) {
        Colesterolmg = colesterolmg;
    }

    public String getCarboidratosg() {
        return Carboidratosg;
    }

    public void setCarboidratosg(String carboidratosg) {
        Carboidratosg = carboidratosg;
    }
}
