package cn.kabuto.ssm.service;

import java.util.List;

import cn.kabuto.ssm.exception.GoodsException;
import cn.kabuto.ssm.pojo.Goods;
import cn.kabuto.ssm.pojo.GoodsExtend;

public interface GoodsService {
	//添加商品
	public void addGoods(Goods goods)throws GoodsException;
	//按用户id查找商品,按时间排序
	public List<GoodsExtend> findGoodsByUid(Integer uid)throws GoodsException;
	//修改商品信息
	public void editGoodsSubmit(Goods goods) throws GoodsException;
	//删除商品
	public void deleteGoods(Integer gid)throws GoodsException;
	//按分类查找商品,按时间排序
	public List<GoodsExtend> selectByCidOrderByTime(Integer cid)throws GoodsException;
	//查找全部商品,按时间排序,数量限制
	public List<GoodsExtend> selectAllOrderByTime()throws GoodsException;
/*	public List<Goods> selectByCid(Integer cid)throws GoodsException;
 * 
*/	
	//按商品名称模糊查询,按时间排序
	public List<GoodsExtend> selectByGname(String gname)throws GoodsException;
	//按按商品id查询
	public GoodsExtend selectByGid(Integer gid)throws GoodsException;
	//按商品id查询
	public Goods findByGid(Integer gid)throws GoodsException;
	//查找全部商品
	public List<GoodsExtend> findAllGoods()throws GoodsException;
}
