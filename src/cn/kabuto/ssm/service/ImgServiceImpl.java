package cn.kabuto.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.kabuto.ssm.exception.ImgException;
import cn.kabuto.ssm.mapper.ImgMapper;
import cn.kabuto.ssm.pojo.Img;
import cn.kabuto.ssm.pojo.ImgExample;

public class ImgServiceImpl implements ImgService {

	@Autowired
	private ImgMapper imgMapper;
	@Override
	public void addImg(Img img) throws ImgException {
		imgMapper.insert(img);
	}

	@Override
	public List<Img> findByGid(Integer gid) throws ImgException {
		ImgExample example = new ImgExample();

		ImgExample.Criteria c = example.createCriteria();

		c.andGidEqualTo(gid);

		List<Img> imglist = imgMapper.selectByExample(example);
		return imglist;
	}
}
