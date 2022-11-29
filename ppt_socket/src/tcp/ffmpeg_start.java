package tcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.CctvService;
import model.SocketDAO;


public class ffmpeg_start{
	private Logger logger = LoggerFactory.getLogger(ffmpeg_start.class);
	
	public int ffmpeg_cmd(HashMap<String, Object> map) throws IOException {
		
		CctvService dao = new CctvService();
		
		String rtsp = (String)map.get("rtsp");
		String DATA_DIRECTORY = (String)map.get("dir");
				
		File dir = new File(DATA_DIRECTORY);
		System.out.println(dir + "  " + dir.exists());
				
				/*String cmd = "ffmpeg -i "
				+ rtsp
				+ " -map 0 "
				+ "-codec:v libx264 "
				+ "-codec:a copy "
				//+ "-max_muxing_queue_size 1024 "
				+ "-f ssegment -segment_list index.m3u8 "
				+ "-segment_list_type hls -segment_list_size 5 "
				+ "-segment_list_flags +live "
				+ "-hls_flags delete_segments "
				+ "-segment_time 10 "
				+ "-f hls "
				+ DATA_DIRECTORY + "\\index.m3u8";*/
				
				String cmd = "ffmpeg -rtsp_transport tcp -i "
				+ rtsp+" "
				+ "-an "
				+ "-preset veryfast "
				+ "-filter:v fps=fps=15 "				//15프레임 넘을 경우 segment_time, hls_time, hls_init_time 다 올려줘야함, 어느정도가 적정선인지 테스트 못함
				+ "-f ssegment -segment_list index.m3u8 "
				+ "-segment_list_type hls "
				+ "-segment_list_size 5 "
				+ "-segment_list_flags +live "
				+ "-hls_flags delete_segments "
				+ "-segment_time 0.3 "
				+ "-f hls "
				+ "-hls_init_time 0.3 "
				+ "-hls_time 0.3 "
				//+ "-hls_segment_type mpegts "
				//+ "-b:v 1000k "
				+ "-sc_threshold 0 "
				+ "-g 8 "
				+ DATA_DIRECTORY + "\\index.m3u8";
		
				
				System.out.println("cmd : " + cmd );
		Process processor = Runtime.getRuntime().exec(cmd);
		
		String line1 = null;

		BufferedReader error = new BufferedReader(new InputStreamReader(

				processor.getErrorStream()));
 
		File[] dirs = dir.listFiles();
		int stack = 0;
		int test1 = 0;					//현재 재생중인데 버그걸림 : 0, 삭제버튼상태 : 1, 재부팅버튼일경우 0의 상태로 나가서 현재 들어온 디렉토리와 DB에 저장된 디렉토리 비교
		int count = 0;
		 while ((line1 = error.readLine()) != null) {
		 System.out.println(line1); 
		 stack ++;
		 
		 if(Arrays.equals(dirs, dir.listFiles())) {
			 if(stack > 100) {
				 System.out.println("ffmpeg 종료");
				 break;
			 	}
		 	}else {stack = 0;}
		 
		 if(dir.listFiles() == null) {
			 dirs = null;
		 }else {
		dirs = dir.listFiles();
		 }
		 
		 if(count > 50) {
			 if(dao.cctv_del_check((int) map.get("cctv_no")) == 1) {
				 processor.destroy(); 
		}
			 count = 0;
		}
	else {count ++;}
	}
		 
		 if(stack > 100) {
			 processor.destroy();
			 for(File playlist : dirs) {
				 playlist.delete();
			 }
			// dir.delete();
		 }else {
			 test1 =  dao.cctv_del_check((int) map.get("cctv_no")); 
		 }
		 
		 
		return test1;
	}
	
}
