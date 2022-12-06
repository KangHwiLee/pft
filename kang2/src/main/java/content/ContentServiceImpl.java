package content;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl {

	@Autowired private ContentDAO dao;
	
	public void content_form(ContentVO vo) {
		dao.content_form(vo);
	}
	
	public List<ContentVO> content_list(int num){
		return dao.content_list(num);
	}
	
	public int content_total() {
		return dao.content_total();
	}
	public List<ContentVO> paging_table(HashMap<String, Integer> map){
		return dao.paging_table(map);
	}
}
