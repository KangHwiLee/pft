package tcp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.T_SocketService;
import model.SocketDAO;

public class SocketService {
	private Logger logger = LoggerFactory.getLogger(SocketService.class);
	private ServerSocket server;
	private T_SocketService dao;
	
	public SocketService(){
		try {
			server = new ServerSocket(8888);
		}catch(Exception e) {
		}
		dao = new T_SocketService();
		
	}
	
	
	
	public void tcp_socket() {	
		
		while(true) {
			Socket socket = null;
			
			System.out.printf("%s 클라이언트와의 연결대기중....\n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			try{
	            // 요청이 들어올때까지 대기, 클라이언트의 연결요청이 들어오면 클라이언트소켓과 통신할 소켓을 반환
	        	socket = server.accept();
	        	String ip = socket.getInetAddress().toString().substring(1);
	        	String port =  String.valueOf(socket.getPort());
	        	System.out.printf("%s 클라이언트와 연결됨[%s:%s].\n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), ip, port);

	        	if( socket.isConnected() ) {
	        		//2020.07.22  소켓수신 병렬처리를 위한 쓰레드  
	        		new ProcessingThread(socket, dao).start();

	        	}else{
	                try{ socket.close(); }catch(Exception e){}
	        	}
	        	
			}catch(Exception e) {
			}finally {
//	            try{ socket.close(); }catch(Exception e){}
	        }
		}
	}


}
