
package conversormonedas;


public class Monedas {

    private String abreviacion;
    private String pais;

    public Monedas(String abreviacion, String pais) {
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
