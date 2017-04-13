package com.jxust.svsh.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jxust.svsh.common.AESStr;
import com.jxust.svsh.common.Configer;
import com.jxust.svsh.common.Utils;
import com.jxust.svsh.entity.Euser;
import com.jxust.svsh.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	public UserService userService;

	/**
	 * 执行注册操作
	 * 
	 * @param name
	 * @param phone
	 * @param email
	 * @param pwd
	 * @param ismobile
	 * @return
	 */
	@RequestMapping("/register")
	public String doRegister(String phone, String email, String pwd, String ismobile) {
		Euser user = new Euser();
		if (!Utils.textIsEmpty(phone)) {
			user.setPhone(phone);
		}
		if (!Utils.textIsEmpty(email)) {
			user.setInEmail(email);
		}

		Euser nowuser = userService.getUser(user);
		if (nowuser != null) {
			return "{ret:-1,tip:\"user-exits\"}";
		}
		if (!Utils.textIsEmpty(pwd)) {
			user.setInPwd(pwd);
		}
		user.setCreatetime(Utils.getNowDateStr());

		user = userService.addUser(user);
		if (user != null) {
			return "{ret:0,tip:\"regist-ok\",uid:" + user.getUid().intValue()+"}";
		} else if (user == null) {
			return "{ret:-1,tip:\"regist-fail\"}";
		}
		return "{ret:-1,tip:\"error\"}";
	}

	/**
	 * 执行登录操作
	 * 
	 * @param name
	 * @param pwd
	 * @param ismobile
	 * @param map
	 * @return
	 */
	@RequestMapping("/login")
	public String doLogin(String name, String pwd, String ismobile, Map<String, Object> map) {
		Euser user = new Euser();
		user.setInPwd(pwd);
		if (name.contains("@")) {
			user.setInEmail(name);
		}
		// 判断是否是11位的数字
		if (name.matches("^\\d{11}$")) {
			user.setPhone(name);
		}

		boolean login = userService.login(user);
		if (login) {
			if (ismobile.equals("1")) {
				// 针对user生成一个token ，下发一个token-key
				StringBuffer token_key = new StringBuffer();

				token_key.append(UUID.randomUUID().toString()).append(System.currentTimeMillis())
						.append(UUID.randomUUID().toString());
				Euser u = userService.getUser(user);
				String tokenkey = AESStr.AESEncode(Configer.COMMON_KEY + u.getUid().intValue(),
						Utils.SHA1(token_key.toString()));

				return "{ret:0,tip:\"login-ok\",tokenkey:\"" + tokenkey + "\",uid:" + u.getUid().intValue()+"}";
			}
		} else {
			Euser nuser = userService.getUser(user);
			if (nuser == null) {
				return "{ret:-1,tip:\"user-not-exits\"}";
			} else {
				return "{ret:-1,tip:\"pwd-error\"}";
			}
		}
		return "error";
	}

	/**
	 * 获取用户的信息，用户详情，用户朋友列表，用户消息列表
	 * 
	 * @param tokenId
	 * @param value
	 * @param diff
	 *            时间因子
	 * @return
	 */
	@RequestMapping("/fetchData")
	public String fechUserData(String uid, String value, String diff) {

		return null;
	}

}
