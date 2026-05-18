package com.example.tuniwwayandroid;

public class Tour {
    private String destination, date, nomGuide;
    private double prix; // Prix en TND
    private int imageRes;
    private double prixUsd = -1; // -1 signifie non calculé

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
    public double getPrixUsd() { return prixUsd; }
    public void setPrixUsd(double prixUsd) { this.prixUsd = prixUsd; }
}