package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import lombok.extern.log4j.Log4j2;

@Log4j2

@Service
public class KOSPI {

	private String key = "BxcWG0ueyR3PlJiksIoqpwFsFQJyLjESYHD0G0HAKVdvre4PLyY04bt73WD3q4Gj0fS4CkStegrF21Ai%2BeDqIw%3D%3D";
	private String url = "http://apis.data.go.kr/1160100/service/GetMarketIndexInfoService/getStockMarketIndex";
	
	public List<JSONObject> chart_data(String search) throws IOException{
		// TODO Auto-generated method stub
		//try {
			StringBuilder builder = new StringBuilder(url);
			builder.append("?" + URLEncoder.encode("serviceKey","UTF-8")+"="+key);
			builder.append("&" + URLEncoder.encode("resultType","UTF-8")+"="+URLEncoder.encode("json","UTF-8"));
			builder.append("&" + URLEncoder.encode("numOfRows","UTF-8")+"=10");
			builder.append("&" + URLEncoder.encode("idxNm","UTF-8")+"="+URLEncoder.encode(search,"UTF-8"));
			//builder.append("&" + URLEncoder.encode("basDt","UTF-8")+"=20221206");
			
			Object test2 = json_list(builder.toString());
			System.out.println("??");
			JSONArray array2 = new JSONArray(test2.toString());
			List<JSONObject> list = new ArrayList<>();
			for(int i=0; i<10; i++) {
				int num = 9;
				num = 9-i;
				String testjson = "{'baseDt' : '" + array2.getJSONObject(num).get("basDt") + "', 'clpr' : '" + array2.getJSONObject(num).get("clpr") + "'}";
				JSONObject res = new JSONObject(testjson);
				
				list.add(res);
				//map.put(result, result)
				System.out.println(res);
				System.out.println("");
			}
			return list;
	}

	public  Object json_list(String url) {
		
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
	
	private  String data_list(String url){
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
