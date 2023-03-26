package conversormonedas;

public class Moneda {

    private String abreviacion;
    private String pais;

    public Moneda(String abreviacion, String pais) {
        this.abreviacion = abreviacion;
        this.pais = pais;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return abreviacion + " - " + pais;
    }

}
