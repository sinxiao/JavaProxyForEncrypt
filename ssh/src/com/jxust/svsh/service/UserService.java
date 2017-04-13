package com.jxust.svsh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.svsh.common.Utils;
import com.jxust.svsh.dao.EuserHome;
import com.jxust.svsh.entity.Euser;

@Service
@Transactional
public class UserService {

	@Autowired
	public EuserHome userDao;
	
	public Euser addUser(Euser euser)
	{
		userDao.attachDirty(euser);
		List<Euser> eusers = userDao.findByExample(euser);
		if(eusers!=null&&eusers.size()>0){
			euser = eusers.get(0);
			return euser;
		}
		return null;
	}
	
	public Euser updateUser(Euser euser)
	{
		euser = userDao.merge(euser);
		return euser;
	}

	public boolean login(Euser euser)
	{
		
		if(!Utils.textIsEmpty(euser.getInEmail())){
			
		}
		if(!Utils.textIsEmpty(euser.getPhone())){
			
		}
		
		List<Euser> eusers = userDao.findByExample(euser);
		
		if(eusers!=null&&eusers.size()>0){
			//判断是否被锁定
			Integer lock = euser.getIslock();
			if(lock.intValue()==0){
				return true;
			}
		}
		
		return false;
	}
	
	public Euser getUser(Euser euser)
	{
		List<Euser> eusers = userDao.findByExample(euser);
		if(eusers!=null&&eusers.size()>0){
			return eusers.get(0);
		}
		return null;
	}
	
	public Euser getUserById(int euid)
	{
		Euser eusers = userDao.findById(Integer.valueOf(euid));
		if(eusers!=null){
			return eusers;
		}
		return null;
	}
	
}
