package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.ProductVO;

public class ShopDAO {

	// 나중에 useBean으로 등록하여 사용할 객체
	public static ProductVO[] getList(String category) {
//		System.out.println("12312312312312312313313");
		ProductVO[] p_ar = null;
		
		// 인자로 받은 카테고리 값 중 하나를 받아서
		// shop_t라는 테이블로부터 해당 값을 검색한다.
		
//		System.out.println("");
		
		SqlSession ss = FactoryService.getFactory().openSession(); 
		
		List<ProductVO> p_list = ss.selectList("shop.cate_list", category);
		ss. close();
		
		// list의 요소들을 배열로 변환하자!
		if(p_list != null && !p_list.isEmpty()) {
			// ar을 list 크기만큼 배열을 생성하자
			p_ar = new ProductVO[p_list.size()];
			
//			int i=0;
//			for(ProductVO pvo: p_list) {
//				p_ar[i] = pvo;
//				i++;
//			}
			
			// p_list의 요소들을 한번에 배열에 복사한다.
			p_list.toArray(p_ar);
		}
		
		return p_ar;
	}
	
	
}
