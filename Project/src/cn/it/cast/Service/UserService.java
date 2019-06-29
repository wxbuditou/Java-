package cn.it.cast.Service;

import java.sql.SQLException;

import cn.it.cast.Dao.UserDao;
import cn.it.cast.domain.Admin;
import cn.it.cast.student.Student;
import cn.it.cast.teacher.Teacher;

public class UserService {

	public Object validate(String username, String password, String position) throws SQLException {
		UserDao userDao = new UserDao();
		return userDao.validate(username,password,position);
	}

	public Student validateStudent(String username, String password) throws SQLException {
		UserDao userDao =new UserDao();
		return userDao.validateStudent(username,password);
	}

	public Teacher validateTeacher(String username, String password) throws SQLException {
		UserDao userDao = new UserDao();
		return userDao.validateTeacher(username,password);
	}

	public Admin validateAdmin(String username, String password) throws SQLException {
		UserDao userDao = new UserDao();
		return userDao.validateAdmin(username,password);
	}

	

}
