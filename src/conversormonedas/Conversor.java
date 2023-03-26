package conversormonedas;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class Conversor {

    private String tipoFrom;
    private String tipoTo;
    private double valor;

    public Conversor(String tipoFrom, String tipoTo) {
        this.tipoFrom = tipoFrom.toUpperCase();
        this.tipoTo = tipoTo.toUpperCase();
        obtenerDivisas();
    }
    
    public Conversor(String tipoFrom, String tipoTo,double monto) {
        this.tipoFrom = tipoFrom;
        this.tipoTo = tipoTo;
    }

    public String getTipoFrom() {
        return tipoFrom;
    }

    public String getTipoTo() {
        return tipoTo;
    }

    public double getValor() {
        return valor;
    }

    public void setTipoFrom(String TipoFrom) {
        this.tipoFrom = TipoFrom;
    }

    public void setTipoTo(String TipoTo) {
        this.tipoTo = TipoTo;
    }  

    @Override
    public String toString() {
        return "De " + tipoFrom + " a " + tipoTo;
    }

    public void obtenerDivisas() {
        double moneda = 0;
        try
        {
            String StringUrl = "https://api.exchangerate.host/latest?base=###&symbols=%%%";
            StringUrl = StringUrl.replace("###", tipoFrom);
            StringUrl = StringUrl.replace("%%%", tipoTo);

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

                moneda = Double.parseDouble(jsonObject2.get(tipoTo).toString());
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        this.valor = moneda;
    }
    
    public double obtenerTemperatura(double monto){
        if(tipoFrom.equals("°C") && tipoTo.equals("°F")){
            return ((monto*9)/5)+32;
        } else if(tipoFrom.equals("°C") && tipoTo.equals("K")){
            return monto + 273.15;
        } else if(tipoFrom.equals("°C") && tipoTo.equals("°R")){
            return ((monto*9)/5) + 491.67;
        } else if(tipoFrom.equals("°F") && tipoTo.equals("°C")){
            return ((monto - 32)*5)/9;
        } else if(tipoFrom.equals("°F") && tipoTo.equals("K")){
            return ((monto + 459.67)*5)/9;
        } else if(tipoFrom.equals("°F") && tipoTo.equals("°R")){
            return monto + 459.67;
        } else if(tipoFrom.equals("K") && tipoTo.equals("°C")){
            return monto - 273.15;
        } else if(tipoFrom.equals("K") && tipoTo.equals("°F")){
            return (((monto - 273.15)*9)/5) + 32; 
        } else if(tipoFrom.equals("K") && tipoTo.equals("°R")){
            return monto*1.8;
        } else if(tipoFrom.equals("°R") && tipoTo.equals("°C")){
            return ((monto - 491.67)*5)/9;
        } else if(tipoFrom.equals("°R") && tipoTo.equals("°F")){
            return monto - 459.67;
        } else if(tipoFrom.equals("°R") && tipoTo.equals("K")){
            return monto/(1.8);
        } else if(tipoFrom.equals(tipoTo)){
            return monto;
        }
        return 0;
    }
}
