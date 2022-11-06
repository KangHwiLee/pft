package contant;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
	public class ContantDAO{

	@Autowired private SqlSession sql;
	
	public void contant_update(ContantVO vo) {
		sql.update("contant.mapper.contant_update", vo);
	}
	
	public List<ContantVO> contant_list(){
		return sql.selectList("contant.mapper.contant_list");
	}
	
	public ContantVO contant_detail(int num) {
		return sql.selectOne("contant.mapper.contant_detail", num);
	}
	
	public void add_paging_contant() {
		sql.update("contant.mapper.add_paging_contant");
	}
	
	public int paging_total() {
		return sql.selectOne("contant.mapper.paging_total");
	}
	
	public List<ContantVO> paging_contant_load(int num){
		return sql.selectList("contant.mapper.paging_contant_load", num);
	}
}
