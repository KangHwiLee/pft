package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.extern.log4j.Log4j2;

@Log4j2

public class KOSPI {

	private static String key = "BxcWG0ueyR3PlJiksIoqpwFsFQJyLjESYHD0G0HAKVdvre4PLyY04bt73WD3q4Gj0fS4CkStegrF21Ai%2BeDqIw%3D%3D";
	private static String url = "http://apis.data.go.kr/1160100/service/GetMarketIndexInfoService/getStockMarketIndex";
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		try {
			StringBuilder builder = new StringBuilder(url);
			builder.append("?" + URLEncoder.encode("serviceKey","UTF-8")+"="+key);
			builder.append("&" + URLEncoder.encode("resultType","UTF-8")+"="+URLEncoder.encode("json","UTF-8"));
			builder.append("&" + URLEncoder.encode("numOfRows","UTF-8")+"=1");
			
			
			URL url = new URL(builder.toString());
			HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static Object json_list(String url) {
		Object obj = null;
		try {
			JSONObject json = new JSONObject( data_list(url) );
			obj = ((JSONObject)((JSONObject)((JSONObject)json.get("response")).get("body")).get("items")).get("item");
		}catch(Exception e) {
			log.error("기상청 공공데이터 오류로 인한 JSON 변환 불가:[{}]\n{}", url, e.getMessage());
		}
		if( obj==null ) return null;
		else {
			if ( obj instanceof JSONArray )	return (JSONArray)obj;
			else return (JSONObject)obj;
		}
	}
	
	private static String data_list(String url){
		String result = "";
		try{
			HttpURLConnection conn 
				= (HttpURLConnection)(new URL( url )).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			BufferedReader reader;
			if( conn.getResponseCode()>=200 && conn.getResponseCode()<=300){
				reader = new BufferedReader( new InputStreamReader( conn.getInputStream(), "utf-8" ) );
			}else{
				reader = new BufferedReader( new InputStreamReader( conn.getErrorStream(), "utf-8" ) );
			}
			StringBuilder data = new StringBuilder();
			String line;
			while( (line = reader.readLine()) !=null ){ 
				data.append( line );
			}
			reader.close();
			conn.disconnect();
			result = data.toString();
		
		}catch(Exception e){
			log.error("기상청 공공데이터 정보요청중 오류:{}", e.getMessage());
		}
		return result;
	}

}
