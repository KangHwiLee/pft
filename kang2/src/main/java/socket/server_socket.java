package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.cj.xdevapi.JsonArray;

public class server_socket extends Thread {
	private Socket socket;
	private Logger logger = LoggerFactory.getLogger(server_socket.class);

	public server_socket(Socket socket) {
		this.socket = socket;
	}
	
	public void run(){
		
		int bug_status = 1;
			
		BufferedReader reader = null;
		
		try {
			
			while(true) {
			
			System.out.println("----------------------- processing Thread ------------------------");
		
			InputStream input  = socket.getInputStream();
			OutputStream writer = null;
			writer = socket.getOutputStream();
			byte[] bt = new byte[1024];
			int n = input.read(bt);
			
			
			
			
			final String data = new String(bt, 0, n);
			JSONObject json = new JSONObject(data);
				 
			HashMap<String, String> test = new HashMap<String, String>();
			
			int room_num = json.getInt("room_num");
			 if(json.get("client").equals("exit")) {
			 break; 
			 }
			System.out.println("수신 데이터 : " + json.get("client"));
			}
			
				 try{
					 socket.close(); System.out.printf("%s cctv 통신을 종료합니다\n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); 
				 }catch(Exception e){} 
				 
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			if(reader != null) {
				try {
					reader.close();
				}catch (Exception e) {}	
		}
			try{ 
				System.out.println("소켓 종료");
				socket.close(); 
			}catch(Exception e){}
	}
		
		
	}
	
	
	}

