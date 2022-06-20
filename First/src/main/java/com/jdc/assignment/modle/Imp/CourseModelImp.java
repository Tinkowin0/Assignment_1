package com.jdc.assignment.modle.Imp;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.jdc.assignment.domain.Course;
import com.jdc.assignment.modle.CourseModel;

public class CourseModelImp implements CourseModel {
	private static final String SELECT_ALL = " select * from course";
	private static final String INSERT = " insert into course (name , fees , duration, description) values (?, ?, ?, ?)";
	private static final String SELECT_ONE = " select * from course where id = ?";
	private DataSource dataSource;

	public CourseModelImp(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Course> getAll() {
		var list = new ArrayList<Course>();
		try (var con = dataSource.getConnection(); var stmt = con.prepareStatement(SELECT_ALL)) {
			var result = stmt.executeQuery();
			while (result.next()) {
				var course = new Course();
				course.setId(result.getInt("id"));
				course.setName(result.getString("name"));
				course.setFees(result.getInt("fees"));
				course.setDuration(result.getInt("duration"));
				course.setDescription(result.getString("description"));
				list.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void save(Course course) {
		try (var con = dataSource.getConnection(); var stmt = con.prepareStatement(INSERT)) {
			stmt.setString(1, course.getName());
			stmt.setInt(2, course.getFees());
			stmt.setInt(3, course.getDuration());
			stmt.setString(4, course.getDescription());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Course findById(int id) {
		var course = new Course();
		try (var con = dataSource.getConnection(); var stmt = con.prepareStatement(SELECT_ONE)) {
			stmt.setInt(1, id);
			var result = stmt.executeQuery();
			while (result.next()) {
				course.setId(result.getInt("id"));
				course.setName(result.getString("name"));
				course.setFees(result.getInt("fees"));
				course.setDuration(result.getInt("duration"));
				course.setDescription(result.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}
}
