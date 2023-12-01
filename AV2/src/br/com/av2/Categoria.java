package br.com.av2;

public class Categoria {
    private String descCategoria;

    // Construtor com o mesmo nome da classe que inicializa o atributo descCategoria
    public Categoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    // Método getter para descCategoria
    public String getDescCategoria() {
        return descCategoria;
    }

    // Método setter para descCategoria
    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }
}
