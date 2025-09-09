package com.ulp.ejemplomenu2.modelo;

public class PalabraModel {
    private String palabraEspanol;
    private String palabraIngles;
    private int foto;

    public PalabraModel(String palabraEspanol, String palabraIngles, int foto) {
        this.palabraEspanol = palabraEspanol;
        this.palabraIngles = palabraIngles;
        this.foto = foto;
    }

    public String getPalabraEspanol() {
        return palabraEspanol;
    }

    public void setPalabraEspanol(String palabraEspanol) {
        this.palabraEspanol = palabraEspanol;
    }

    public String getPalabraIngles() {
        return palabraIngles;
    }

    public void setPalabraIngles(String palabraIngles) {
        this.palabraIngles = palabraIngles;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
