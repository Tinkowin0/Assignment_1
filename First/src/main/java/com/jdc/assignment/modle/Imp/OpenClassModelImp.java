package com.jdc.assignment.modle.Imp;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.jdc.assignment.domain.Course;
import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.modle.OpenClassModel;

public class OpenClassModelImp implements OpenClassModel {
	private static final String SELECT_SQL = """
			select oc.id , oc.start_date, oc.teacher,
			c.id courseId, c.name, c.duration, c.fees, c.description
			   from open_class oc join course c on oc.course_id = c.id
			   where c.id = ?
			""";
	private static final String INSERT = "insert into open_class (course_id,start_date,teacher) values (?,?,?)";
	private static final String SELECT_ONE = " select * from open_class where id = ?";
	private DataSource dataSource;

	public OpenClassModelImp(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public void creat(OpenClass openClass) {
		try (var con = dataSource.getConnection(); var stmt = con.prepareStatement(INSERT)) {
			stmt.setInt(1, openClass.getCourse().getId());
			var sqlDate = Date.valueOf(openClass.getStartDate());
			stmt.setDate(2, sqlDate);
			stmt.setString(3, openClass.getTeacher());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OpenClass> findByCourse(int courseId) {
		var list = new ArrayList<OpenClass>();
		try (var con = dataSource.getConnection(); var stmt = con.prepareStatement(SELECT_SQL)) {
			stmt.setInt(1, courseId);
			var rs = stmt.executeQuery();
			while (rs.next()) {
				var c = new Course();
				c.setId(rs.getInt("courseId"));
				c.setName(rs.getString("name"));
				c.setDuration(rs.getInt("duration"));
				c.setFees(rs.getInt("fees"));
				c.setDescription(rs.getString("description"));

				var oc = new OpenClass();
				oc.setId(rs.getInt("id"));
				oc.setCourse(c);
				oc.setTeacher(rs.getString("teacher"));
				oc.setStartDate(rs.getDate("start_date").toLocalDate());

				list.add(oc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public OpenClass findByOPId(int op_id) {
		var oc = new OpenClass();
		try (var con = dataSource.getConnection(); var stmt = con.prepareStatement(SELECT_ONE)) {
			stmt.setInt(1, op_id);
			var rs = stmt.executeQuery();
			while (rs.next()) {

				oc.setId(rs.getInt("id"));
				oc.setTeacher(rs.getString("teacher"));
				oc.setStartDate(rs.getDate("start_date").toLocalDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oc;
	}
}
