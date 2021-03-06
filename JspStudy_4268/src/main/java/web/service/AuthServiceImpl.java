package web.service;

import java.util.HashMap;
import java.util.Map;

import repository.AuthDao;
import repository.user.User;

public class AuthServiceImpl implements AuthService{
	
	private final AuthDao authDao;
	
	public AuthServiceImpl(AuthDao authDao) {
		this.authDao = authDao;
	}
	
	
	@Override
	public Map<String, ?> signin(String username, String password){
		int result = authDao.signinUsernameAndPassword(username, password);
		
		if(result == 0) {
			Map<String, String> msg = new HashMap<String, String>();
			msg.put("400", "존재하지 않는 아이디");
			return msg;
		}else if(result == 1) {
			Map<String, String> msg = new HashMap<String, String>();
			msg.put("400", "비밀번호 오류");
			return msg;
		}else if(result == 2) {
			Map<String, String> msg = new HashMap<String, String>();
			msg.put("200", null);
			return msg;
		}else {
			Map<String, String> msg = new HashMap<String, String>();
			msg.put("500", "데이터 베이스 연결 실패");
			return msg;
		}
		
	}
	
	@Override
	public boolean usernameCheck(String username) {
		boolean result = authDao.usernameCheckByUsername(username);
		return result;
		//String msg = result ? "이미 존재하는 사용자 이름 입니다." : "가입 가능한 사용자 이름 입니다.";
		//return msg;
	}
	
	@Override
	public boolean signup(String email, String name, String username, String password) {
		User user = User.builder()
				.email(email)
				.name(name)
				.username(username)
				.password(password)
				.build();
		int result = authDao.signup(user);
		
		return result != 0 ? true : false;
	}
	
	public User getUser(String username) {
		return authDao.getUserByUsername(username);
	}
}
