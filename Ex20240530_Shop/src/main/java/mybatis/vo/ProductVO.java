package mybatis.vo;

public class ProductVO {

	// shop_t에서 필요한 컬럼들을 멤버로 선언!
	private String	num, // 기본키
					category, // 카테고리
					p_num, // 제품번호
					p_name, // 제품명
					p_company, // 제조회사
					p_image_s, // 썸네일 이미지
					p_image_l, // 상세보기 이미지
					p_content, // 제품설명
					p_date; // 등록일
	
	private int p_price, // 정가
				p_saleprice, // 세일가
				quant, // 수량
				totalprice; // 총액

	public void setNum(String num) {
		this.num = num;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setP_num(String p_num) {
		this.p_num = p_num;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public void setP_company(String p_company) {
		this.p_company = p_company;
	}

	public void setP_image_s(String p_image_s) {
		this.p_image_s = p_image_s;
	}

	public void setP_image_l(String p_image_l) {
		this.p_image_l = p_image_l;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public void setP_saleprice(int p_saleprice) {
		this.p_saleprice = p_saleprice;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getNum() {
		return num;
	}

	public String getCategory() {
		return category;
	}

	public String getP_num() {
		return p_num;
	}

	public String getP_name() {
		return p_name;
	}

	public String getP_company() {
		return p_company;
	}

	public String getP_image_s() {
		return p_image_s;
	}

	public String getP_image_l() {
		return p_image_l;
	}

	public String getP_content() {
		return p_content;
	}

	public String getP_date() {
		return p_date;
	}

	public int getP_price() {
		return p_price;
	}

	public int getP_saleprice() {
		return p_saleprice;
	}

	public int getQuant() {
		return quant;
	}

	public int getTotalprice() {
		return totalprice;
	}
	
	
	
}
