package common;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class CommonService {

	public HashMap<String, Integer> paging(HashMap<String, Integer> map) {
		HashMap<String, Integer> paging = new HashMap<String, Integer>();
		int total = map.get("total");
		int status = map.get("status");
		int now_page = map.get("now_page");
		int count = map.get("count");
		if(total%count == 0) { total = total/count;}
		else {total = total/count+1;}
		if(status == 0) {
			now_page = 1;
			if(total < 11) {
				paging.put("now_page", now_page);
				paging.put("start", now_page);
				paging.put("end", total);
			}else {
				
				paging.put("now_page", now_page);
				paging.put("start", now_page);
				paging.put("end", 10);
			}
		}else if(status == 1) {
			if(now_page < 11) {
				now_page = 1;
				int end = 10;
				if(total < 11) {
					paging.put("now_page", now_page);
					paging.put("start", now_page);
					paging.put("end", total);
				}else {
					paging.put("now_page", now_page);
					paging.put("start", now_page);
					paging.put("end", end);
				}
			}else {
				if(now_page % 10 == 0) {
					paging.put("now_page", (now_page-1)/10*10);
					paging.put("start", (now_page/10-2)*10+1);
					paging.put("end", (now_page/10-1)*10);
				}else {
				paging.put("now_page", (now_page/10)*10);
				paging.put("start", (now_page/10-1)*10+1);
				if(total - (now_page/10-1)*10+1 < 11) {
					paging.put("end", total);
				}else {
					paging.put("end", now_page/10*10);
				}
				}
			}
		}else if(status == 2) {
				if(total%10 != 0) {
				if((now_page-1)/10*10 == (total/10)*10) {
					now_page = total;
					paging.put("now_page", total);
					paging.put("start", (now_page/10*10+1));
					paging.put("end", total);
				}else {
					if((now_page/10+1)*10 > total/10*10) {
					paging.put("now_page", ((now_page/10)*10+1));
					paging.put("start", ((now_page/10)*10+1));
					paging.put("end", total);
					}
					else if((now_page/10)*10 == total/10*10) {
						paging.put("now_page", ((total/10+1)*10+1));
						paging.put("start", ((total/10+1)*10+1));
						paging.put("end", total);
					}else {
						
						if((now_page/10+1)*10 == total/10*10) {
							paging.put("now_page", ((now_page/10+1)*10+1));
							paging.put("start", ((now_page/10+1)*10+1));
							paging.put("end", total);
						}else if(now_page%10 == 0) {
							paging.put("now_page", ((now_page/10)*10+1));
							paging.put("start", ((now_page/10)*10+1));
							paging.put("end", ((now_page/10+1)*10));
						}
						else {
						paging.put("now_page", ((now_page/10+1)*10+1));
						paging.put("start", ((now_page/10+1)*10+1));
						paging.put("end", (now_page/10+2)*10);
						}
					}
					
				}
				}else {
					
					if((now_page-1)/10*10 == (total/10-1)*10) {		// 10페이지 -> 11페이지 가는경우
						now_page = total;
						paging.put("now_page", total);
						paging.put("start", (now_page/10*10+1));
						paging.put("end", total);
					}else {
						paging.put("now_page", ((now_page/10+1)*10+1));	//7페이지 -> 11페이지 가는경우
						paging.put("start", ((now_page/10+1)*10+1));
						paging.put("end", total);
					}
				}
		}else {
			now_page = total/10*10+1;
			paging.put("now_page", total);
			paging.put("start", total/10*10+1);
			paging.put("end", total);
		}
		return paging;
	
}
	
}
