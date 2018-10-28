package cn.kabuto.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class GoodsExtend extends Goods{
	private List<Img> imgList =  new ArrayList<Img>();

	public List<Img> getImgList() {
		return imgList;
	}
	public void setImgList(List<Img> imgList) {
		this.imgList = imgList;
	}
	
	
}
