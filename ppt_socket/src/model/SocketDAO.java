package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import mybatis.MybatisFactory;

public class SocketDAO {
	private SqlSession mybatis = MybatisFactory.getSqlSession(); 
	
public List<CctvVO> last_commu(int num) {
	List<CctvVO> list =  mybatis.selectList("sqlmap.SocketMapper.last_commu", num);
	return list;
}

public void commu_update(int num) {
	mybatis.update("sqlmap.SocketMapper.commu_update", num);
}

public CctvVO cctv_info(int num) {
	System.out.println("dao됨");
	return mybatis.selectOne("sqlmap.SocketMapper.cctv_info", num);
}

public CctvVO reboot_dir_update(int num) {
	return mybatis.selectOne("sqlmap.SocketMapper.reboot_dir_update", num);
}
public void update_directory(HashMap<String, Object> map) {
	mybatis.update("sqlmap.SocketMapper.update_directory", map);
}	
public void cctv_delete(int num) {
	mybatis.delete("sqlmap.SocketMapper.cctv_delete", num);
}
public void auto_reboot_delete(HashMap<String, Object> map) {
	mybatis.update("sqlmap.SocketMapper.auto_reboot_delete", map);
}	

public void auto_reboot_update(HashMap<String, Object> map) {
	mybatis.update("sqlmap.SocketMapper.auto_reboot_update", map);
}
public int cctv_del_check(int num) {
	System.out.println("dao잘와짐");
	return mybatis.selectOne("sqlmap.SocketMapper.cctv_del_check", num);
}
public void error_check(HashMap<String, Integer> map) {
	mybatis.update("sqlmap.SocketMapper.error_check", map);
}
}
