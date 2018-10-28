package cn.kabuto.ssm.service;

import cn.kabuto.ssm.exception.CategoryException;
import cn.kabuto.ssm.pojo.Category;

public interface CategoryService {
	public Category findByCid(Integer cid)throws CategoryException;
}
