package db_study;

import java.util.ArrayList;

import db.DBConnectionMgr;
import repository.user.User;


public class UserDaoTest {

	public static void main(String[] args) {
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		UserDao userDao = new UserDao(pool);
		ArrayList<User> userList = userDao.getUserAll();//대입을 한다.
		
		for(User user : userList) {
			System.out.println(user);
		}
		System.out.println("==========getUser()========");
		User user = userDao.getUserByUsername("jongbum");
		System.out.println(user);
		
	}

}
