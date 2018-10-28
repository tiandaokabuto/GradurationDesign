package cn.kabuto.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.kabuto.ssm.exception.CategoryException;
import cn.kabuto.ssm.mapper.CategoryMapper;
import cn.kabuto.ssm.pojo.Category;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public Category findByCid(Integer cid) throws CategoryException {
		Category category = categoryMapper.selectByPrimaryKey(cid);
		return category;
	}

}
