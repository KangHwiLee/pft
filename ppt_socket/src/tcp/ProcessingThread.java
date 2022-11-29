package tcp;

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
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.cj.xdevapi.JsonArray;

import model.CctvService;
import model.CctvVO;
import model.SocketDAO;

public class ProcessingThread extends Thread {
	private Socket socket;
	private Logger logger = LoggerFactory.getLogger(ProcessingThread.class);
	private CctvService dao;

	public ProcessingThread(Socket socket, CctvService dao) {
		this.socket = socket;
		this.dao = dao;
	}
	
	public void run(){
		
		int bug_status = 1;
			
		BufferedReader reader = null;
		ffmpeg_start ffm = new ffmpeg_start();
		
		
		
		try {
			
			while(true) {
			
			System.out.println("----------------------- processing Thread ------------------------");
			InputStream input  = socket.getInputStream();
			byte[] bt = new byte[1024];
			int n = input.read(bt);
			final String data = new String(bt, 0, n);
			
			JSONObject json = new JSONObject(data);
			int status = json.getInt("status");								//status 1:등록, 2:수정, 3:삭제 
			int cctv_no = json.getInt("cctv_no");
			
			System.out.println(json.toString());
			
			CctvVO vo = null;
			vo = dao.cctv_info(cctv_no);
			String DATA_DIRECTORY = "C:\\nginx-1.22.0\\nginx-1.22.0\\html\\cctv\\";
			String hls_url = "http://121.179.4.96:82/cctv/";
			String uuid = UUID.randomUUID().toString() + "_";
			
			
				 HashMap<String, Object> map = new HashMap<String, Object>();
				 map.put("rtsp", vo.getRtsp());
				 map.put("cctv_no", cctv_no);

				 if(status == 1) {
					 String n_uuid = UUID.randomUUID().toString() + "_";
					 File m_dir = new File(DATA_DIRECTORY+n_uuid+cctv_no) ;
					 if(!m_dir.exists()) {
						 m_dir.mkdir();
					 }
					 map.put("dir", DATA_DIRECTORY+n_uuid+cctv_no);
					 map.put("hls", hls_url+n_uuid+cctv_no+"/index.m3u8");
					 dao.update_directory(map);
					 // 디렉토리 생성, hls_url 생성, 필요한거는 위에 DATA_DIRECTORY, HLS_URL
					 bug_status = ffm.ffmpeg_cmd(map);		
					 vo = dao.cctv_info(cctv_no);
				 }else if(status == 2) {
					 vo = dao.cctv_info(cctv_no);
					 File dir = new File(vo.getDirectory());
					 if(!dir.exists()) {
						 dir.mkdir();
					 }
					 map.put("dir", vo.getDirectory());
					 bug_status = ffm.ffmpeg_cmd(map);
				 }
				 
				 if(bug_status == 1) {
					 System.out.println("소켓 강제종료?");
					 File dir = new File(vo.getDirectory());
					 File[] dirs = dir.listFiles();
					 if(dirs != null) {
					 for(File playlist : dirs) {
						 playlist.delete();
					 }
					 }
					 break;
				 }else {
					 System.out.println("소켓 강제종료2");
					 File dir = new File(DATA_DIRECTORY+uuid+cctv_no);
					 
					 if(!dir.exists()) {
						 System.out.println("파일 없음 재부팅인듯");
						 break;
					 }
				 }
				 }
				 
				 
			System.out.println(bug_status);
			
			
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

