package tcp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class TCPSocketServer {
	
	public static void main(String[] args) {
		Logger logger = (Logger) LoggerFactory.getLogger(TCPSocketServer.class);
		logger.info("TCP Socket Start!");
		
		SocketService socket = new SocketService();		
		
		Runnable tcp = new Runnable() {
			@Override
			public void run() {
				socket.tcp_socket();
			}
		};
		
		ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
		schedule.scheduleAtFixedRate(tcp, 0, 500, TimeUnit.MILLISECONDS);
		
	}
}
