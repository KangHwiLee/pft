package model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisConfig;

public class CctvService extends MyBatisConfig {
	SocketDAO dao = new SocketDAO();
	
	public List<CctvVO> last_commu(int num) {
		
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
		List<CctvVO> list =  dao.last_commu(num);
		return list;
		 }
	}

	public void commu_update(int num) {
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
		dao.commu_update(num);
		 }
	}

	public CctvVO cctv_info(int num) {
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
			 System.out.println("service 됨");
		return dao.cctv_info(num);
		 }
	}

	public CctvVO reboot_dir_update(int num) {
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
		return dao.reboot_dir_update(num);
		 }
	}
	public void update_directory(HashMap<String, Object> map) {
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
		dao.update_directory(map);
		 }
	}	
	public void cctv_delete(int num) {
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
		dao.cctv_delete(num);
		 }
	}
	public void auto_reboot_delete(HashMap<String, Object> map) {
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
		dao.auto_reboot_delete(map);
		 }
	}	

	public void auto_reboot_update(HashMap<String, Object> map) {
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
		dao.auto_reboot_update(map);
		 }
	}
	public int cctv_del_check(int num) {
		System.out.println("서비스 잘와짐");
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
		return dao.cctv_del_check(num);
		 }
	}

	public void error_check(HashMap<String, Integer> error) {
		 try(SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()){
				dao.error_check(error);
				 }
		
	}
}
