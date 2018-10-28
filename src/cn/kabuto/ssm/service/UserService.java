package cn.kabuto.ssm.service;

import java.util.List;

import cn.kabuto.ssm.exception.UserException;
import cn.kabuto.ssm.pojo.User;

public interface UserService {
	public User login(User user)throws UserException;
	public void regist(User user)throws UserException;
	public User findByname(String username)throws UserException;
	public User findByEmail(String email)throws UserException;
	public void activate(String code)throws UserException;
	public User findByCode(String code)throws UserException;
	public User updateInf(User user )throws UserException;
	public void updatePassword(String newPassword,User user )throws UserException;
	public User findByUid(Integer uid)throws UserException;
	public List<User> findAllUser()throws UserException;
}
