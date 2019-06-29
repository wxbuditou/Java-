package cn.it.cast.Dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.it.cast.DB.DBConnection;
import cn.it.cast.domain.Admin;
import cn.it.cast.student.Student;
import cn.it.cast.teacher.Teacher;

public class UserDao {
	
	public Object valideUserExist(String username,String ad) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBConnection.getDataSource());
		String sql=null;
		if (ad.equals("student")) {	//学生
			sql = "select *  from table_student where student_number=?";
			return queryRunner.query(sql, new BeanHandler<Student>(Student.class),username);
		}else if (ad.equals("teacher")) {	//教师
			sql = "select *  from table_teacher where teacher_number=?";
			return queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),username);
		}else if (ad.equals("adminstrator")) {	//管理员
			sql = "select *  from table_ad where ad_number=?";
			return queryRunner.query(sql, new BeanHandler<Admin>(Admin.class),username);
		}
		return null;
	}

	public Object validate(String username, String password, String position) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBConnection.getDataSource());
		String sql=null;
		if (position.equals("student")) {	//学生
			sql = "select *  from table_student where student_number=?";
			return queryRunner.query(sql, new BeanHandler<Student>(Student.class),username);
		}else if (position.equals("teacher")) {	//教师
			sql = "select *  from table_teacher where teacher_number=?";
			return queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),username);
		}else if (position.equals("adminstrator")) {	//管理员
			sql = "select *  from table_ad where ad_number=?";
			return queryRunner.query(sql, new BeanHandler<Admin>(Admin.class),username);
		}
		return null;
	}

	public Student validateStudent(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBConnection.getDataSource());
		Date date = new Date();
		Timestamp onlinetime = new Timestamp(date.getTime());
		String sql = "select *  from table_student where student_number=? and student_password=?";
		Object[] params = {username,password};
		Student student = queryRunner.query(sql, new BeanHandler<Student>(Student.class),params);
		if (student!=null) {
			sql = "update table_student set student_onlinetime = ? where student_number=?";
			queryRunner.update(sql,onlinetime,username);
		}
		return student;
	}

	public Teacher validateTeacher(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBConnection.getDataSource());
		Date date = new Date();
		Timestamp onlinetime = new Timestamp(date.getTime());
		String sql = "select *  from table_teacher where teacher_number=? and teacher_password=?";
		Teacher teacher = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),username,password);
		if (teacher!=null) {	//更新上线时间
			sql = "update table_teacher set teacher_onlinetime = ? where teacher_number=?";
			queryRunner.update(sql,onlinetime,username);
		}
		
		return teacher; 
	}

	public Admin validateAdmin(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBConnection.getDataSource());
		Date date = new Date();
		Timestamp onlinetime = new Timestamp(date.getTime());
		String sql = "select *  from table_ad where ad_number=? and ad_password=?";
		Admin admin = queryRunner.query(sql, new BeanHandler<Admin>(Admin.class),username,password);
		if (admin!=null) {
			sql = "update table_ad set ad_onlinetime = ? where ad_number=?";
			queryRunner.update(sql,onlinetime,username);
		}
		return admin;
	}

}
