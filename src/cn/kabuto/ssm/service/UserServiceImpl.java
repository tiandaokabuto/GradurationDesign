package cn.kabuto.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.kabuto.ssm.exception.UserException;
import cn.kabuto.ssm.mapper.UserMapper;
import cn.kabuto.ssm.pojo.User;
import cn.kabuto.ssm.pojo.UserExample;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 登录功能
	 */
	@Override
	public User login(User user) throws UserException {
		
		User u = this.findByname(user.getUsername());
		
		if(u==null){
			throw new UserException("用户不存在,请进行注册");
		}
		if(!u.getPassword().equals(user.getPassword())){
			throw new UserException("密码错误!");
		}
		if(u.getSta()==(byte)0){
			throw new UserException("您还没有激活账户!");
		}
		if(u.getUsestate()==(byte)0){
			throw new UserException("账户被冻结!");
		}
		return u;
	
	}

	/**
	 * 注册功能
	 */
	@Override
	public void regist(User user) throws UserException {

		User u = this.findByname(user.getUsername());

		// 校验用户名是否重复
		if (u != null) {
			throw new UserException("用户已经存在");
		}
		// 用户名没有重复,校验邮箱
		u = this.findByEmail(user.getEmail());
		// 校验邮箱是否被使用
		if (u != null) {
			throw new UserException("邮箱已被注册");
		}
		user.setSta((byte)0);
		// 两者都没有重复,添加用户
		userMapper.insert(user);
	}
	/**
	 * 注册登录辅助功能--根据名字查询用户 
	 */
	@Override
	public User findByname(String username) throws UserException {
		UserExample example = new UserExample();

		UserExample.Criteria c = example.createCriteria();

		c.andUsernameEqualTo(username);

		List<User> list = userMapper.selectByExample(example);

		if(list!=null&& list.size()>0){
			return list.get(0);
		}
		
		return null;
	}
	/**
	 * 查询辅助功能--根据邮箱查询用户
	 */
	@Override
	public User findByEmail(String email) throws UserException {
		UserExample example = new UserExample();

		UserExample.Criteria c = example.createCriteria();

		c.andEmailEqualTo(email);

		List<User> list = userMapper.selectByExample(example);
		
		if(list!=null&& list.size()>0){
			return list.get(0);
		}
		
		return null;
	}
	/**
	 * 注册辅助功能--根据激活码查找用户
	 */
	@Override
	public User findByCode(String code) throws UserException {
		UserExample example = new UserExample();

		UserExample.Criteria c = example.createCriteria();

		c.andCodeEqualTo(code);

		List<User> list = userMapper.selectByExample(example);
		
		if(list!=null&& list.size()>0){
			return list.get(0);
		}
		
		return null;
	}
	/**
	 * 注册辅助功能--邮箱验证
	 */
	@Override
	public void activate(String code) throws UserException {
		
		User u = this.findByCode(code);
		
		if(u==null){
			throw new UserException("激活码无效");
		}
		if(u.getSta()==(byte)1){
			throw new UserException("您已经激活!");
		}

		u.setSta((byte)1);
		
		userMapper.updateByPrimaryKey(u);
	}

	
	/**
	 * 更新用户信息
	 *
	 */
	@Override
	public User updateInf(User user) throws UserException {
		userMapper.updateByPrimaryKeySelective(user);
		
		return user;
		
	}

	/**
	 * 修改密码
	 */
	@Override
	public void updatePassword(String newPassword, User user)
			throws UserException {
		user.setPassword(newPassword);
		
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User findByUid(Integer uid) throws UserException {
		User user = userMapper.selectByPrimaryKey(uid);
		return user;
	}
	
	@Override
	public List<User> findAllUser() throws UserException {
		List<User> userList = userMapper.findAllUser();
		return userList;
	}
}
