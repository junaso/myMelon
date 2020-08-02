package kr.co.mymelon.mediagroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class MediagroupDAO {

	// @Component어노테이션으로 자동생성된
	// 객체를 사용하려면 객체간에 서로 연결이 되어야 한다
	@Autowired
	private DBOpen dbopen;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuilder sql = null;
	ArrayList<MediagroupDTO> list = null;

	public MediagroupDAO() {
		System.out.println("---MediagroupDAO()객체 생성됨");
	}

	public int create(MediagroupDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" INSERT INTO mediagroup(mediagroupno, title)");
			sql.append(" VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), ?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTitle());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("미디어그룹등록실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}// create() end

	public ArrayList<MediagroupDTO> list() {
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mediagroupno, title");
			sql.append(" FROM mediagroup");
			sql.append(" ORDER BY mediagroupno DESC");

			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<MediagroupDTO>();
				do {
					MediagroupDTO dto = new MediagroupDTO();
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					dto.setTitle(rs.getString("title"));
					list.add(dto);
				} while (rs.next());
			} // if end

		} catch (Exception e) {
			System.out.println("미디어그룹목록실패: " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}

		return list;
	}// list() end

	public int delete(MediagroupDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" DELETE FROM mediagroup");
			sql.append(" WHERE mediagroupno = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getMediagroupno());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}// delete() end

	public MediagroupDTO update(int mediagroupno) {
		MediagroupDTO dto = new MediagroupDTO();
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mediagroupno, title");
			sql.append(" FROM mediagroup");
			sql.append(" WHERE mediagroupno = ? ");

			pstmt=con.prepareStatement(sql.toString());
		      pstmt.setInt(1, mediagroupno);
		      rs=pstmt.executeQuery();
		      if(rs.next()){
		          dto.setMediagroupno(rs.getInt("mediagroupno"));
		          dto.setTitle(rs.getString("title"));
		      }else{
		          dto=null;
		      }//if end
		} catch (Exception e) {
			System.out.println("미디어그룹수정실패: " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}

		return dto;

	}// list() end
	
	public int updateproc(MediagroupDTO dto) {
	    int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE mediagroup ");
			sql.append(" SET title = ? ");
			sql.append(" WHERE mediagroupno = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTitle());
			pstmt.setInt(2, dto.getMediagroupno());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("미디어그룹수정등록실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}// list() end

}// class end
