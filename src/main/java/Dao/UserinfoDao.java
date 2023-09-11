package Dao;

import java.io.PrintWriter;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.apache.catalina.connector.Response;

import Db.DBAction;



public class UserinfoDao {
	public boolean exist(String id,String pw) {
		
		Connection conn = DBAction.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from member");
			while(rs.next()) {
				if(rs.getString(1).equals(id)&&rs.getString(2).equals(pw)) {
					return true;
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;		
	}
	public boolean idcheck(String id) {
		Connection conn = DBAction.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from member");
			while(rs.next()) {
				if(rs.getString(1).equals(id)) {
					return false;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}
}
