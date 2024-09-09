package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entites.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired        
	private JdbcTemplate jdbcTemplate;//automaticalyy iska object create ho jayega(new se create nhi karna padega)

	
	public int insert(Student s)
	{
		//insert query
		String q="insert into Student(sid,Sname,city) values(?,?,?)";
		int r=this.jdbcTemplate.update(q,s.getId(),s.getName(),s.getCity());
		return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int change(Student s)
	{
		//update the data
		String q="update Student set Sname=?,city=? where sid=?";
		int r=this.jdbcTemplate.update(q,s.getName(),s.getCity(),s.getId());
		return r;
	}
	public int delete(int s_id)
	{
		String q="delete from Student where sid=?";
		int r=this.jdbcTemplate.update(q,s_id);
		return r;
	}
	public Student getStudent(int s_id)
	{
		String q="select * from Student where sid=?";
		RowMapper<Student> r=new RowMapperImpl();
		Student s=this.jdbcTemplate.queryForObject(q, r,s_id);
		return s;
	}
	public List<Student> getAllStudents()
	{
		String q="select * from Student";
		List<Student>mylist=this.jdbcTemplate.query(q, new RowMapperImpl());
		return mylist;
	}
	
	
}
