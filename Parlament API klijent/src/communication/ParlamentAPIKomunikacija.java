package communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domain.Poslanik;

public class ParlamentAPIKomunikacija {

	private static final String urlPoslanika = 
			"http://147.91.128.71:9090/parlament/api/members"; 
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy."); 

	
	public List<Poslanik> vratiPoslanike() {
		try {
			String odgovorSajta = sendGet(urlPoslanika);
			Gson gson = new GsonBuilder().create();
			JsonArray poslaniciJson = gson.fromJson(odgovorSajta, JsonArray.class);
			
			LinkedList<Poslanik> listaPoslanika = new LinkedList<>();
			
			for (int i = 0; i < poslaniciJson.size(); i++) {
				
				JsonObject poslanik = (JsonObject) poslaniciJson.get(i);
				
				Poslanik p = new Poslanik();
				
				p.setId(poslanik.get("id").getAsInt());
				p.setFirstName(poslanik.get("name").getAsString());
				p.setLastName(poslanik.get("lastName").getAsString());
				if(poslanik.get("birthDate") != null)
					p.setBirthDate(sdf.parse(poslanik.get("birthDate").getAsString()));
				
				listaPoslanika.add(p);
				
			}
			return listaPoslanika;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return null;
	};
	
	private String sendGet(String url) throws IOException{
		URL urlSajta = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) urlSajta.openConnection();	
		
		connection.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						connection.getInputStream()));
		
		String response = "";
		
		while(true){
			String s = in.readLine();

			if(s != null)
				response += s;
			else break;
		}
		in.close();
		
		return response;
	}

}
