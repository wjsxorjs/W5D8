package shop.bean;

import java.util.ArrayList;
import java.util.List;

import mybatis.vo.ProductVO;

public class Cart {
/*
	카트(장바구니)의 기능 분석
	1) 제품(ProductVO)을 저장할 수 있는 공간: List<ProductVO>
	2) 1)에서 제품을 검색하는 기능(저장할 때도 필요한 기능) // 이미 저장한 제품이면 수량 증가
	3) 1)에 제품을 저장하는 기능
	4) 1)에 제품을 삭제하는 기능
	5) 2)에서 검색한 제품의 수량을 수정하는 기능
	6) 1)에 저장된 모든 제품들의 총액 계산
	7) 1)에 저장된 모든 제품들을 배열로 반환하는 기능 // 그래야 JSP에서 보기 좋다.
	
	위 분석에 따른 장바구니의 속성(멤버변수)
	- List<ProductVO>
	- int 또는 long totalPrice; // JSP에서 해도 될 것 같다.
	
	
	장바구니의 기능(멤버메서드) 정의(명칭)
	- searchProduct : 제품검색
	- addProduct	: 제품추가
	- delProduct	: 제품삭제
	- changeCount	: 수량변경
	- getList		: 장바구니에 있는 모든 제품들을 배열로 반환하는 기능
	
*/
	private List<ProductVO> list; // 장바구니의 저장소
	private long totalPrice;
	
	public Cart() {// 생성자 - useBean정의시 자동 호출됨!
		list = new ArrayList<ProductVO>();
	}
	
	// 장바구니의 저장소(list)에서 특정 제품(ProductVO)을 검색하는 기능
	public ProductVO searchProduct(String pnum) {
		ProductVO vo = null;
		
		for(ProductVO pvo: list) {
			if(pvo.getP_num().equals(pnum)) {
				vo = pvo;
				break;
			}
		}
		
		return vo;
	}
	
	
	// 장바구니에 있는 모든 제품들을 배열로 반환하는 기능
	public ProductVO[] getList() {
		ProductVO[] ar = null;
		if(!list.isEmpty()) {
			ar = new ProductVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}
	
	// 진열대에서 제품을 하나 얻어내어 장바구니에 저장하는 기능
	public void addProduct(ShopBean sb, String pnum){
		// 먼저 이미 장바구니에 있는 제품인지 검색
		ProductVO vo = searchProduct(pnum);
		
		// 이때, vo가 null이면 새로운 제품(장바구니에 없는 제품)
		// 이때, vo가 null이 아니면 이미 장바구니에 있는 제품 = 수량 +1
		if(vo != null) {
			int qt = vo.getQuant();
			vo.setQuant(qt+1);
			return; // 수량이 증가했음으로 더 이상 하지않고 제어권 반환
		} else {
			// 장바구니에 제품이 없는 경우
			// 인자로 넘어온 pnum을 ShopBean에게 줘서
			// 해당 제품(ProductVO)을 얻어낸다.
			sb.setP_num(pnum);
			vo = sb.getProduct();
			// 진열대에서 장바구니에 저장한 제품들은
			// 기본적으로 수량은 1로 지정한다.
			vo.setQuant(1);
			list.add(vo);
		}
	}
	
	// 장바구니에서 특정 제품을 검색하여 삭제하는 기능
	public boolean delProduct(String pnum){
		boolean value = false;
		
		ProductVO vo = searchProduct(pnum);
		if(vo != null) {
			value = list.remove(vo);
		}
		
		return value;
	}
	
	// 장바구니에서 원하는 제품을 검색한 후 수량만 변경하는 기능
	public void changeCount(String pnum, int q){
		
		ProductVO vo = searchProduct(pnum);
		if(vo != null) {
			vo.setQuant(q);
		}
		
	}
	
	
	
}
