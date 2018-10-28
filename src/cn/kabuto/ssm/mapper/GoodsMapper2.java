package cn.kabuto.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kabuto.ssm.pojo.Goods;
import cn.kabuto.ssm.pojo.GoodsExtend;

public interface GoodsMapper2 {
	public List<GoodsExtend> selectByCidOrderByTime(@Param("cid")Integer cid);
	public List<GoodsExtend> selectAllOrderByTime();
	public List<Goods> selectByCid(Integer cid);
	public List<GoodsExtend> selectByGname(String gname);
	public GoodsExtend selectByGid(Integer gid);
	public List<GoodsExtend> findGoodsByUid(Integer uid);
	public GoodsExtend selectGoodsByGid(Integer gid);
	public List<GoodsExtend> findAllGoods();
}
