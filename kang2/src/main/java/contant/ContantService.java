package contant;

import java.util.HashMap;
import java.util.List;

public interface ContantService {

	void contant_update(ContantVO vo);
	List<ContantVO> contant_list();
	ContantVO contant_detail(int num);
	void add_paging_contant();
	int paging_total();
	List<ContantVO> paging_contant_load(int num);
}
