package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Response {
	private Product response;
	
	private String query() {
		String apiUrl = "https://obpreprod.sidesoftcorp.com/happypreprod//org.openbravo.service.json.jsonrest/MaterialMgmtStorageDetail"; // URL de la API
        String username = "Openbravo";
        String password = "1234";
        
        try {
            // Codificar las credenciales en Base64
            String credentials = username + ":" + password;
            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

            // Crear la URL de la API
            URL url = new URL(apiUrl);

            // Abrir una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Agregar el encabezado de autenticación Basic Auth
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);

            // Obtener la respuesta de la API
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Procesar el JSON de respuesta
                String jsonResponse = response.toString();
                return jsonResponse;
            } else {
                return "Error en la solicitud. Código de respuesta: " + responseCode;
            }
        } catch (IOException e) {
           return e.getMessage();
        }
	}
	
	public String list () {
		try {
			Product product = new Product();
			String jsonString = this.query();
			ObjectMapper json = new ObjectMapper();
			JsonNode jsonRes = json.readTree(jsonString);
			
			String resp = jsonRes.get("response").asText();
			
			return resp;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "err";
	}

	public Product getResponse() {
		return response;
	}

	public void setResponse(Product response) {
		this.response = response;
	}
	

}
