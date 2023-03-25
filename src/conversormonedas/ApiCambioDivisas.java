package conversormonedas;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiCambioDivisas {

    private String monedaFrom;
    private String monedaTo;
    private double valor;

    public ApiCambioDivisas(String monedaFrom, String monedaTo) {
        this.monedaFrom = monedaFrom.toUpperCase();
        this.monedaTo = monedaTo.toUpperCase();
        this.valor = obtenerDivisas();
    }

    public String getMonedaFrom() {
        return monedaFrom;
    }

    public String getMonedaTo() {
        return monedaTo;
    }

    public double getValor() {
        return valor;
    }

    public void setMonedaFrom(String monedaFrom) {
        this.monedaFrom = monedaFrom;
        this.valor = obtenerDivisas();
    }

    public void setMonedaTo(String monedaTo) {
        this.monedaTo = monedaTo;
        this.valor = obtenerDivisas();
    }

    @Override
    public String toString() {
        return "De " + monedaFrom + " a " + monedaTo;
    }

    public double obtenerDivisas() {
        double moneda = 0;
        try
        {
            String StringUrl = "https://api.exchangerate.host/latest?base=###&symbols=%%%";
            StringUrl = StringUrl.replace("###", monedaFrom);
            StringUrl = StringUrl.replace("%%%", monedaTo);

            URL url = new URL(StringUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200)
            {
                throw new RuntimeException("Ocurrio un error: " + responseCode);
            } else
            {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext())
                {
                    informationString.append(scanner.nextLine());
                }

                scanner.close();

                JSONArray jsonArray = new JSONArray("[" + informationString.toString() + "]");
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                JSONObject jsonObject2 = (JSONObject) jsonObject.get("rates");

                moneda = Double.parseDouble(jsonObject2.get(monedaTo).toString());
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return moneda;
    }
}
