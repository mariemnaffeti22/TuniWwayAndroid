package com.example.tuniwwayandroid;

public class Tour {

    private String destination;
    private String date;
    private double prix;
    private String nomGuide;
    private int imageRes;

    public Tour(String destination, String date, double prix, String nomGuide, int imageRes) {
        this.destination = destination;
        this.date = date;
        this.prix = prix;
        this.nomGuide = nomGuide;
        this.imageRes = imageRes;
    }

    public String getDestination() { return destination; }
    public String getDate() { return date; }
    public double getPrix() { return prix; }
    public String getNomGuide() { return nomGuide; }
    public int getImageRes() { return imageRes; }
}