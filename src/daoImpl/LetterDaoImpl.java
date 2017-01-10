package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Letter;
import dao.LetterDao;
import util.DBConnection;

public class LetterDaoImpl implements LetterDao {

	@Override
	public void addLetter(Letter letter) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_letter (sendUserID,receiveUserID,letterContent,letterSendTime) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, letter.getSendUserID());
			pstmt.setInt(2, letter.getReceiveUserID());
			pstmt.setString(3, letter.getLetterContent());
			pstmt.setTimestamp(4, new Timestamp(letter.getLetterSendTime().getTime()));
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public Letter findLetter(int letterID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_letter where letterID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Letter letter = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, letterID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				letter = new Letter();
				letter.setLetterID(rs.getInt(1));
				letter.setSendUserID(rs.getInt(2));
				letter.setReceiveUserID(rs.getInt(3));
				letter.setLetterContent(rs.getString(4));
				letter.setLetterRead(rs.getInt(5));
				letter.setLetterSendTime(rs.getDate(6));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return letter;
	}

	@Override
	public List<Letter> findAllLetter(int receiveUserID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_letter where receiveUserID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Letter> letters = new ArrayList<Letter>();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, receiveUserID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Letter letter = new Letter();
				letter.setLetterID(rs.getInt(1));
				letter.setSendUserID(rs.getInt(2));
				letter.setReceiveUserID(rs.getInt(3));
				letter.setLetterContent(rs.getString(4));
				letter.setLetterRead(rs.getInt(5));
				letter.setLetterSendTime(rs.getDate(6));
				letters.add(letter);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return letters;
	}

	@Override
	public List<Letter> findAllLetterNotRead(int receiveUserID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_letter where receiveUserID=? and letterRead = 0";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Letter> letters = new ArrayList<Letter>();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, receiveUserID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Letter letter = new Letter();
				letter.setLetterID(rs.getInt(1));
				letter.setSendUserID(rs.getInt(2));
				letter.setReceiveUserID(rs.getInt(3));
				letter.setLetterContent(rs.getString(4));
				letter.setLetterRead(rs.getInt(5));
				letter.setLetterSendTime(rs.getDate(6));
				letters.add(letter);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return letters;
	}

	@Override
	public void modifyLetterToRead(int letterID) {
		Connection conn = DBConnection.getConnection();
		String sql = "update tb_letter set letterRead = 1 where letterID = ?;";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, letterID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}
	
}
