package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Db.DBAction;
import Dto.Userinfo;

public class MemberDao {	
	public int insertData(Userinfo dto) {
		int result = 0;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql;
		try {
			sql  = "insert into member(id, pw, name, address, age, sex, e_mail)"
					+ "values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setInt(5, dto.getAge());
			pstmt.setString(6, dto.getSex());
			pstmt.setString(7, dto.getEmail());
			
			result = pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return result;
		
	}
}
