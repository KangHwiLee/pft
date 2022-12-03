package content;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDAO {
	@Autowired private SqlSession sql;
	
	public void content_form(ContentVO vo) {
		sql.insert("content.mapper.content_form", vo);
	}
	
	public List<ContentVO> content_list(int num){
		return sql.selectList("content.mapper.content_list", num);
	}
	
	public int content_total() {
		return sql.selectOne("content.mapper.content_total");
	}
	public List<ContentVO> paging_table(int num){
		return sql.selectList("content.mapper.paging_table", num);
	}
	
}
