package ch09_cookie_session.user;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceImpl  implements UserService{

private UserDao userDao = new UserDao();
	
	@Override
	public User getUserByUid(String uid) {
		User user = userDao.getUserByUid(uid);
		return user;
	}

	@Override
	public List<User> getUserList(int page) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		List<User> list = userDao.getUserList(COUNT_PER_PAGE, offset);
		return list;
	}

	@Override
	public void registerUser(User user) {	// user는 아직 암호화된 패스워드가 없다고 가정
		// uid 중복 확인
		User u = userDao.getUserByUid(user.getUid());
		if (u != null)
			return;
		
		String hashedPwd = BCrypt.hashpw(user.getPwd(), BCrypt.gensalt());
		user.setPwd(hashedPwd);
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(String uid) {
		userDao.deleteUser(uid);
	}

	@Override
	public int login(String uid, String pwd) {
		User user = userDao.getUserByUid(uid);
		if (user == null)
			return USER_NOT_EXIST;
		if (BCrypt.checkpw(pwd, user.getPwd()))
			return CORRECT_LOGIN;
		return WRONG_PASSWORD;
	}


	

}