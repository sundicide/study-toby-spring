package springbook.user.dao.step02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoDeleteAll extends TemplateMethodPattern {

	@Override
	protected PreparedStatement makeStatement(Connection c) throws SQLException {
		PreparedStatement ps;
		ps = c.prepareStatement("delete from users");
		return ps;
	}

}
