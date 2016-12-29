package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import bean.Status;
import dao.StatusDao;
import util.DBConnection;

public class StatusDaoImpl implements StatusDao {

	@Override
	public void addStatus(Status status) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_status (statusContent,userID,publishTime) "
				+ "values (?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status.getStatusContent());
			pstmt.setInt(2, status.getUserID());
			pstmt.setTimestamp(3, new Timestamp(status.getPublishTime().getTime()));
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public List<Status> findAllStatus() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_status order by publishTime Desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Status> statuss = new ArrayList<Status>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Status status = new Status();
				status.setStatusID(rs.getInt(1));
				status.setStatusContent(rs.getString(2));
				status.setUserID(rs.getInt(3));
				status.setPublishTime(rs.getDate(4));
				statuss.add(status);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return statuss;
	}

	@Override
	public List<Status> findStatusByUserID(int userID) {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_status where userID=? order by publishTime Desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Status> statuss = new ArrayList<Status>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Status status = new Status();
				status.setStatusID(rs.getInt(1));
				status.setStatusContent(rs.getString(2));
				status.setUserID(rs.getInt(3));
				status.setPublishTime(rs.getDate(4));
				statuss.add(status);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return statuss;
	}

}
