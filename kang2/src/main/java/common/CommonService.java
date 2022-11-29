package common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CommonService {

	public void cctv_start(int num) throws Exception, IOException  {
		//java.net.Socket socket = new java.net.Socket("121.179.4.96", 8888);
		java.net.Socket socket = new java.net.Socket("localhost", 8888);

		while(true) {
		
		InputStream input  = socket.getInputStream();
		OutputStream writer = null;
		writer = socket.getOutputStream();
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		System.out.print("보낼 데이터 입력 : ");
		Scanner send = new Scanner(System.in);
		String response = send.next();
		
		map.put("room_num", num);
		map.put("client", response);
		
		String jsonStr = gson.toJson(map);
		System.out.println("보낼 데이터 : " +jsonStr.toString());
		byte[] byteArr = jsonStr.getBytes("UTF-8");
		
		writer.write(byteArr, 0, byteArr.length);
        writer.flush();
		
        if(response.equals("exit")) {
        	System.out.println("socket종료");
        	break;
        }
        	
			/*byte[] bt = new byte[1024];
			int n = input.read(bt);
			
			final String data = new String(bt, 0, n);
			JSONObject json = new JSONObject(data);
				 
			System.out.println(json.toString());
			System.out.println("이게 될까");
			*/
		}
		
     //   socket.close();
	}
	
}
