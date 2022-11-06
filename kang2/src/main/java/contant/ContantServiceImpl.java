package contant;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContantServiceImpl implements ContantService{
	@Autowired private ContantDAO dao;
	
	@Override
	public void contant_update(ContantVO vo) {
		dao.contant_update(vo);
	}
	
	@Override
	public List<ContantVO> contant_list(){
		return dao.contant_list();
	}
	
	@Override
	public ContantVO contant_detail(int num) {
		return dao.contant_detail(num);
	}
	
	@Override
	public void add_paging_contant() {
		dao.add_paging_contant();
	}
	
	@Override
	public int paging_total() {
		return dao.paging_total();
	}
	
	@Override
	public List<ContantVO> paging_contant_load(int num){
		return dao.paging_contant_load(num);
	}
}
