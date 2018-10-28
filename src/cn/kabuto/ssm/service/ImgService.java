package cn.kabuto.ssm.service;

import java.util.List;

import cn.kabuto.ssm.exception.ImgException;
import cn.kabuto.ssm.pojo.Img;

public interface ImgService {
	public void addImg(Img img)throws ImgException;
	public List<Img> findByGid(Integer gid)throws ImgException;
}
