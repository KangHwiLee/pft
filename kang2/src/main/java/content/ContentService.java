package content;

import java.util.HashMap;
import java.util.List;

public interface ContentService {

	void content_form(ContentVO vo);
	List<ContentVO> content_list(int num);
	int content_total();
}
