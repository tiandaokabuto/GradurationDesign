package cn.kabuto.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.kabuto.ssm.exception.UserException;
import cn.kabuto.ssm.mapper.AdminuserMapper;
import cn.kabuto.ssm.pojo.Adminuser;

public class AdminuserServiceImpl implements AdminuserService {
	
	@Autowired
	private AdminuserMapper adminuserMapper;
	
	@Override
	public Adminuser adminLogin(Adminuser adminuser) throws UserException {
		Adminuser a = adminuserMapper.findAdminByName(adminuser.getAdminusername());
		if(a==null){
			throw new UserException("用户不存在");
		}
		if(!a.getPassword().equals(adminuser.getPassword())){
			throw new UserException("密码错误!");
		}
		return a;
	}
}
