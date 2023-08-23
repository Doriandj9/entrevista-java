package models;

import java.io.BufferedReader;import java.io.DataInput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.TypeReference;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class Product{
	private ArrayList<DataProducts> dataProducts;
	private  int status;
	private  int totalRows;
	private  int startRow;
	private  int endRow;
	private  Map<String, Integer> countProductsDifferent;
	private ArrayList<DataProducts> productsForUnidad;
	private ArrayList<DataProducts> productsStock;
	
	public ArrayList<DataProducts> getProductsForUnidad() {
		return productsForUnidad;
	}


	public void setProductsForUnidad(ArrayList<DataProducts> productsForUnidad) {
		this.productsForUnidad = productsForUnidad;
	}


	public ArrayList<DataProducts> getProductsStock() {
		return productsStock;
	}


	public void setProductsStock(ArrayList<DataProducts> productsStock) {
		this.productsStock = productsStock;
	}


	private String query() {
		String apiUrl = "https://obpreprod.sidesoftcorp.com/happypreprod//org.openbravo.service.json.jsonrest/MaterialMgmtStorageDetail"; // URL de la API
        String username = "Openbravo";
        String password = "1234";
        
        try {
            String credentials = username + ":" + password;
            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
            URL url = new URL(apiUrl);

          
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

       
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);


            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String jsonResponse = response.toString();
                return jsonResponse;
            } else {
                return "Error en la solicitud. Código de respuesta: " + responseCode;
            }
        } catch (IOException e) {
           return e.getMessage();
        }
	}
	
	
	public Product listProduct() {
		try {
			String jsonString = this.query();
			ObjectMapper jsonMapper = new ObjectMapper();
			JsonNode jsonParced = jsonMapper.readTree(jsonString);
			JsonNode response = jsonParced.get("response");
			JsonNode data = response.get("data"); 
			DataProducts prod = null;
			this.dataProducts = new ArrayList<DataProducts>();
			for(JsonNode productNode : data) {
				prod = new DataProducts(productNode); 
				this.dataProducts.add(prod);
			}
			this.setDataProducts(this.dataProducts);
			this.setStatus(response.get("status").asInt());
			this.setTotalRows(response.get("totalRows").asInt());
			this.setStartRow(response.get("startRow").asInt());
			this.setEndRow(response.get("endRow").asInt());
			Map<String, Integer> counterMap = (Map<String, Integer>) this.calculateProductDifferent();
			this.setCountProductsDifferent(counterMap);
			return this;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	private Map<String, Integer> calculateProductDifferent() {
		Map<String, Integer> groupByCount = new HashMap<String, Integer>();
		
		for(DataProducts product: this.getDataProducts()) {
			int count = 0;
			String key = product.getProduct();
			if (groupByCount.containsKey(key)) {
				count = groupByCount.get(key) + 1;
				groupByCount.put(product.getProduct(), count);
				continue;
			}
			
			groupByCount.put(product.getProduct(), 1);							
		}
		
		return groupByCount;
	}
	
	public Product listProductsUnidad() {
		this.listProduct();
		ArrayList<DataProducts> products = this.getDataProducts();
		ArrayList<DataProducts> productsForUnidad = new ArrayList<DataProducts>();
		for(DataProducts product : products) {
			if(!product.getuOM$_identifier().equals("UNIDAD")) {
				productsForUnidad.add(product);
			}
		}
		
		this.setDataProducts(productsForUnidad);
		
		return this;
		
	}
	
	public Product productsStock() {
		this.listProduct();
		ArrayList<DataProducts> products = this.getDataProducts();
		Comparator<DataProducts > comparator =(p1,p2) -> Integer.compare(p2.getQuantityOnHand(), p1.getQuantityOnHand());
		Collections.sort(products, comparator);
		List<DataProducts> subList = products.subList(0, 10);
		ArrayList<DataProducts> finalRes = new ArrayList<DataProducts>(subList);
		this.setDataProducts(finalRes);
		return this;
	}
	
	public Map<String, Integer> getCountProductsDifferent() {
		return countProductsDifferent;
	}


	public void setCountProductsDifferent(Map<String, Integer> countProductsDifferent) {
		this.countProductsDifferent = countProductsDifferent;
	}


	public ArrayList<DataProducts> getDataProducts() {
		return dataProducts;
	}


	public void setDataProducts(ArrayList<DataProducts> dataProducts) {
		this.dataProducts = dataProducts;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getTotalRows() {
		return totalRows;
	}


	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}


	public int getStartRow() {
		return startRow;
	}


	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	
	
}
