package com.example.notas.model;

public class Nota {
    private Integer id;
    private String titulo;

    public Nota(String titulo, String texto){
        this.titulo = titulo;
        this.texto = texto;

    }
    public Nota(Integer id, String titulo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }

    private String texto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
