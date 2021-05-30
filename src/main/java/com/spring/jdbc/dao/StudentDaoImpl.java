package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		String query = "insert into student(id, name, city) values(?, ?, ?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public int change(Student student) {

		String updateQuery = "update student set name=?, city=? where id=?";
		int update = this.jdbcTemplate.update(updateQuery, student.getName(), student.getCity(), student.getId());
		return update;
	}

	public int delete(int studentId) {
		String deleteQuery = "Delete from student where id=?";
		int delete = this.jdbcTemplate.update(deleteQuery, studentId);
		return delete;
	}

	public Student getStudent(int studentID) {

		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student queryForObject = this.jdbcTemplate.queryForObject(query, rowMapper, studentID);
		return queryForObject;

//		String query = "select * from student where id=?";
		
//		Student queryForObject = this.jdbcTemplate.queryForObject(query, new RowMapper<Student>() {
//
//			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student();
//				student.setId(rs.getInt(1));
//				student.setCity(rs.getNString("city"));
//				student.setName(rs.getNString("name"));
//				return student;
//			}
//			
//		}, studentID);
		
//		RowMapper<Student> mapper = (ResultSet rs, int rowNum) -> {
//			try {
//				Student student = new Student();
//				student.setId(rs.getInt(1));
//				student.setCity(rs.getNString("city"));
//				student.setName(rs.getNString("name"));
//				return student;
//			}catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			return null;
//		};
		
//		Student queryForObject = this.jdbcTemplate.queryForObject(query, (ResultSet rs, int rowNum) -> {
//			try {
//				Student student = new Student();
//				student.setId(rs.getInt(1));
//				student.setCity(rs.getNString("city"));
//				student.setName(rs.getNString("name"));
//				return student;
//			}catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			return null;
//		}, studentID);
		
//		Student queryForObject = this.jdbcTemplate.queryForObject(query, mapper, studentID);
	}

	@Override
	public List<Student> getAllRecord() {
		String query = "Select * from student";
		List<Student> studentList = this.jdbcTemplate.query(query, new RowMapperImpl());
		return studentList;
	}

}
