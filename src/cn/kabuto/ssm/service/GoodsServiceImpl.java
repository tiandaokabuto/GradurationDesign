package cn.kabuto.ssm.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.kabuto.ssm.exception.GoodsException;
import cn.kabuto.ssm.mapper.GoodsMapper;
import cn.kabuto.ssm.mapper.GoodsMapper2;
import cn.kabuto.ssm.pojo.Goods;
import cn.kabuto.ssm.pojo.GoodsExtend;


public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsMapper2 goodsMapper2;

	@Override
	public void addGoods(Goods goods) throws GoodsException {
		goods.setStarttime(new Date());
		goods.setFlashtime(new Date());
		goods.setState((byte)1);
		goods.setSalestate((byte)1);
		goods.setUploadstate((byte)0);
		goodsMapper.insert(goods);
	}
	@Override
	public List<GoodsExtend> findGoodsByUid(Integer uid) throws GoodsException {
		List<GoodsExtend> goodsExtendList = goodsMapper2.findGoodsByUid(uid);
		return goodsExtendList;
		
	}
	@Override
	public Goods findByGid(Integer gid) throws GoodsException {
		Goods goods = goodsMapper.selectByPrimaryKey(gid);
		return goods;
	}
	@Override
	public void editGoodsSubmit(Goods goods) throws GoodsException {
		goodsMapper.updateByPrimaryKeySelective(goods);
	}
	@Override
	public void deleteGoods(Integer gid) throws GoodsException {
		Goods goods = this.findByGid(gid);
		goods.setEndtime(new Date());
		goods.setState((byte)0);
		this.editGoodsSubmit(goods);		
	}
	@Override
	public List<GoodsExtend> selectByCidOrderByTime(Integer cid)
			throws GoodsException {
		List<GoodsExtend> goodsExtendList = goodsMapper2.selectByCidOrderByTime(cid);
		return goodsExtendList;
	}	
	@Override
	public List<GoodsExtend> selectAllOrderByTime()
			throws GoodsException {
		List<GoodsExtend> list = goodsMapper2.selectAllOrderByTime();
		return list;
	}	
/*	@Override
	public List<Goods> selectByCid(Integer cid) throws GoodsException {
		List<Goods> list = goodsMapper2.selectByCid(cid);
		return list;
	}*/	
	@Override
	public List<GoodsExtend> selectByGname(String gname) throws GoodsException {
		List<GoodsExtend> list = goodsMapper2.selectByGname(gname);
		return list;
	}	
	@Override
	public GoodsExtend selectByGid(Integer gid) throws GoodsException {
		GoodsExtend goodsExtend = goodsMapper2.selectByGid(gid);
		return goodsExtend;
	}
	@Override
	public List<GoodsExtend> findAllGoods() throws GoodsException {
		List<GoodsExtend> extendList = goodsMapper2.findAllGoods();
		return extendList;
	}
}
