package com.jdc.assignment.modle.Imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.domain.Registration;
import com.jdc.assignment.modle.RegistrationModel;

public class RegistrationModelImp implements RegistrationModel {

	private static final String SELECT_STUD = """
			select rg.id, rg.student, rg.phone, rg.email, op.id classId , op.start_date, op.teacher from
			registration rg join open_class op on rg.open_class_id = op.id
			where op.id = ?
			""";
	private static final String INSERT = "insert into registration (open_class_id, student, phone,email) values (?,?,?,?) ";
	private DataSource dataSource;

	public RegistrationModelImp(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Registration> findByClass(int open_class_id) {
		var list = new ArrayList<Registration>();
		try (var con = dataSource.getConnection(); var stmt = con.prepareStatement(SELECT_STUD)) {
			stmt.setInt(1, open_class_id);
			var rs = stmt.executeQuery();
			while (rs.next()) {

				var open = new OpenClass();

				open.setId(rs.getInt("id"));
				open.setStartDate(rs.getDate("start_date").toLocalDate());
				open.setTeacher(rs.getString("teacher"));

				var reg = new Registration();

				reg.setOpenClass(open);
				reg.setId(rs.getInt("id"));
				reg.setStudent(rs.getString("student"));
				reg.setPhone(rs.getString("phone"));
				reg.setEmail(rs.getString("email"));

				list.add(reg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void input(Registration reg) {

		try (var con = dataSource.getConnection(); var stmt = con.prepareStatement(INSERT)) {
			stmt.setInt(1, reg.getOpenClass().getId());
			stmt.setString(2, reg.getStudent());
			stmt.setString(3, reg.getPhone());
			stmt.setString(4, reg.getEmail());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
