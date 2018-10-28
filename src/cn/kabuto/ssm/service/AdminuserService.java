package cn.kabuto.ssm.service;

import cn.kabuto.ssm.exception.UserException;
import cn.kabuto.ssm.pojo.Adminuser;

public interface AdminuserService {
	public Adminuser adminLogin(Adminuser adminuser) throws UserException;
}
