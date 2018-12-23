package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ManagerDAOImpl implements ManagerDAO {

	@Override
	public void setUserReimbursementStatus(String status, int rId) {
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "UPDATE REIMBURSEMENT SET STATUS = ? WHERE REIMBURSEMENTID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, rId);
			pstmt.execute();
		}
		catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
		
		
	}

	@Override
	public List<Reimbursement> getAllReimbursementsOfMyUnderlings(int employeeId) {
		List<Reimbursement> underlingReimbursement = new ArrayList<Reimbursement>();
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT R.*, E.MANAGERID, E.FIRSTNAME FROM REIMBURSEMENT R INNER JOIN EMPLOYEE E ON R.EMPLOYEEID = E.EMPLOYEEID WHERE E.MANAGERID=?";
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
				underlingReimbursement.add(new Reimbursement(rId,eId,status,description,amount,pic));
			}
		}
		catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
		System.out.println(underlingReimbursement);
		return underlingReimbursement;
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByUser(int userId, int underlingId) {
		List<Reimbursement> underlingTargetReimbursement = new ArrayList<Reimbursement>();
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT R.*, E.MANAGERID, E.FIRSTNAME FROM REIMBURSEMENT R INNER JOIN EMPLOYEE E ON R.EMPLOYEEID = E.EMPLOYEEID WHERE E.MANAGERID=? AND E.EMPLOYEEID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, underlingId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int rId  = rs.getInt("REIMBURSEMENTID");
				int eId  = rs.getInt("EMPLOYEEID");
				String status = rs.getString("STATUS");
				String description = rs.getString("DESCRIPTION");
				String amount = rs.getString("AMOUNT");
				Blob pic = rs.getBlob("PIC");
				underlingTargetReimbursement.add(new Reimbursement(rId,eId,status,description,amount,pic));
			}
		}
		catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
		System.out.println(underlingTargetReimbursement);
		return underlingTargetReimbursement;
	}

	@Override
	public List<Employee> getEmployees(int userId) {
		List<Employee> underlingEmployees = new ArrayList<Employee>();
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT EMPLOYEEID, FIRSTNAME, LASTNAME, EMAIL, PHONE FROM EMPLOYEE WHERE MANAGERID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String eId  = rs.getString("EMPLOYEEID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				underlingEmployees.add(new Employee(firstname, lastname, email, phone, eId));
			}
		}
		catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
		System.out.println(underlingEmployees);
		return underlingEmployees;
	}

	@Override
	public void setOtherUserAndPass(String user, String pass, int boss) {
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO EMPLOYEE(USERNAME, PASSWORD, MANAGERID) VALUES(?,?,?)";
			String commit = "COMMIT";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			pstmt.setInt(3, boss);
			pstmt.execute();
			Statement s = con.createStatement();
			s.execute(commit);
		}
		catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }		
	}

}
