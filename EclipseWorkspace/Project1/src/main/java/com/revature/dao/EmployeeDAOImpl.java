package com.revature.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Override
	public String[] getUserInfo(String username, String password) {
		String[] userInfo = new String[5];
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "{call SPUSERVIEW(?,?,?,?,?,?,?)}";
			//call my stored procedure, why a stored procedure?
			//because i didn't feel confident in my sql knowledge beforehand
			//and had to prove it to myself.
			cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.registerOutParameter(3,java.sql.Types.VARCHAR);
			cs.registerOutParameter(4,java.sql.Types.VARCHAR);
			cs.registerOutParameter(5,java.sql.Types.VARCHAR);
			cs.registerOutParameter(6,java.sql.Types.VARCHAR);
			cs.registerOutParameter(7,java.sql.Types.VARCHAR);
			cs.execute();
			userInfo[0] = cs.getString(3);
			userInfo[1] = cs.getString(4);
			userInfo[2] = cs.getString(5);
			userInfo[3] = cs.getString(6);
			userInfo[4] = cs.getString(7);
			System.out.println(userInfo[4]);
			System.out.println(userInfo[0]);
			System.out.println(userInfo[2]);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	@Override
	public void setUserInfo(String fieldToSet, String valToSet, int employeeId) {
		try(Connection con = ConnectionUtil.getConnection()){
			String stmt = "UPDATE EMPLOYEE SET "+fieldToSet;
			String sql = stmt + " = ? WHERE EMPLOYEEID = ?";
			String commit = "COMMIT";
			//haha prepared statement, you think you are smarter than me?
			//bend to my will, hahaha,
			//so you can't set the column name in a prepared statement
			//however you can just append some stuff to the front of a prepared statement
			//then have that stuff be dynamic.
			//you foolish computer thing, I am your GOD!
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, valToSet);
			pstmt.setInt(2, employeeId);
			pstmt.executeUpdate();
			Statement s = con.createStatement();
			s.execute(commit);
			//I want the changes here to persist
			//They should now
			//But now I want to show the user info as updated
			//I'll call the getUserInfo Method
			String logins = "SELECT USERNAME, PASSWORD FROM EMPLOYEE WHERE EMPLOYEEID = ?";
			String user = "";
			String pass = "";
			PreparedStatement bad = con.prepareStatement(logins);
			bad.setInt(1, employeeId);
			ResultSet rs = bad.executeQuery();
			while(rs.next()) {
				user = rs.getString("USERNAME");
				pass = rs.getString("PASSWORD");
			}
			//System.out.println(user);
			//System.out.println(pass);
			getUserInfo(user,pass);
			//System.out.println("Passed the point");
			
	    }
	    catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	}

	@Override
	public List<Reimbursement> getUserReimbursements(int employeeId) {
		List<Reimbursement> userReimbursement = new ArrayList<Reimbursement>();
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEEID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int rId  = rs.getInt("REIMBURSEMENTID");
				int eId  = rs.getInt("EMPLOYEEID");
				String status = rs.getString("STATUS");
				String description = rs.getString("DESCRIPTION");
				String amount = rs.getString("AMOUNT");
				Blob pic = rs.getBlob("PIC");
				userReimbursement.add(new Reimbursement(rId,eId,status,description,amount,pic));
			}
						
		}
		catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
		System.out.println(userReimbursement);
		return userReimbursement;
	}
	
	@Override
	public void setUserReimbursement(int employeeId, String description, double amount) {//I'm ignoring the pic stuff for now
		
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO REIMBURSEMENT (EMPLOYEEID, DESCRIPTION, AMOUNT) VALUES(?,?,?)";
			String commit = "COMMIT";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			pstmt.setString(2, description);
			pstmt.setDouble(3, amount);
			pstmt.execute();
			Statement s = con.createStatement();
			s.execute(commit);
			//I need to try this out when I get back
		}
		catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	}

}
