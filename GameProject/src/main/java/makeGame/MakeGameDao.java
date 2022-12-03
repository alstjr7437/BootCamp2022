package makeGame;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.BoardDto;

public class MakeGameDao {
	private Connection getConnection() throws Exception {
	      //1-1. Context 객체 얻기
	      Context initCtx = new InitialContext(); 
	      //1-2. "java:comp/env"에 해당하는 객체를 찾아서 envCtx에 삽입
	      Context envCtx = (Context)initCtx.lookup("java:comp/env");
	      //1-3. "jdbc/joypark"에 해당되는 객체를 찾아서 ds에 삽입
	      DataSource ds = (DataSource)envCtx.lookup("jdbc/alstjr");
	      //1-4. 커넥션 풀로 부터 커넥션 객체를 얻어냄
	      Connection con = ds.getConnection();
	      return con;
	}
	
	public void insert(MakeGameDto dto) {
		String sql = "INSERT INTO makegame VALUES(null, ?, ?, ?, ?, 0, SYSDATE())";
		
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		)
		{   
			pstmt.setString(1,  dto.getMtitle());
			pstmt.setString(2,  dto.getMtag());
			pstmt.setString(3,  dto.getMfile());
			pstmt.setString(4, dto.getMwriter());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(int mnum, String mtitle, String mtag) {
		String sql = "UPDATE makegame SET mtitle = ?, mtag = ? WHERE mnum =?";
		
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		)
		{
			pstmt.setString(1, mtitle);
			pstmt.setString(2, mtag);
			pstmt.setInt(3,  mnum);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//게시판 보기
		public ArrayList<MakeGameDto> list(int page, int numOfRecords) {
			//배열 만들기
			ArrayList<MakeGameDto> dtos = new ArrayList<MakeGameDto>();
			String sql = "select * from makegame order by bnum desc limit ?, ?";
			try (
				Connection con = getConnection();					//커넥션 얻기
				PreparedStatement pstmt = con.prepareStatement(sql);
			) {
				pstmt.setInt(1, (page-1)*numOfRecords);
				pstmt.setInt(2, numOfRecords);
				try(ResultSet rs = pstmt.executeQuery();)
				{
					while(rs.next()) {
						//1. 레코드셋에서 데이터를 가져온다.
						int mnum = rs.getInt("mnum");
						String mtitle = rs.getString("mtitle");
						String mtag = rs.getString("mtag");
						String mfile = rs.getString("mfile");
						String mwriter = rs.getString("mwriter");
						int mview = rs.getInt("mview");
						Date mdate = rs.getDate("mdate");
						//2. 그 데이터들로 Dto를 만든다.
						MakeGameDto dto = new MakeGameDto(mnum, mtitle, mtag, mfile, mwriter, mview, mdate);
						//3. 그 Dto를 배열(ArrayList)에 추가한다.
						dtos.add(dto);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		return dtos;
		}
		
		public int recordCount() {
			int count = 0;
			String sql = "select count(bnum) from makegame";
			
			try (	Connection con = getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
				){
					rs.next();
					count = rs.getInt(1);
			} catch (Exception e) {	
				e.printStackTrace();
			}
			return count;
		}
		
		public MakeGameDto selectOne(int mnum) {
			String sql = "select * from makegame where mnum = ?";
			MakeGameDto dto = new MakeGameDto();
			
			try (	Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					)
			{	pstmt.setInt(1, mnum);
			
				try(ResultSet rs = pstmt.executeQuery();)
				{
					rs.next();
					
					dto.setMnum(mnum);
					dto.setMtitle(rs.getString("mtitle"));
					dto.setMtag(rs.getString("mtag"));
					dto.setMfile(rs.getString("mfile"));
					dto.setMwriter(rs.getString("mwriter"));
					dto.setMdate(rs.getDate("mdate"));
					dto.setMview(rs.getInt("mview"));
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
		}
		public int view(int mnum) {
			int view = 0;
			String sql = "select mview from makegame where mnum = "+ mnum;
			
			try (	Connection con = getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
				){
					rs.next();
					view = rs.getInt(1);
			} catch (Exception e) {	
				e.printStackTrace();
			}
			return view;
		}
		
		public int viewUpdate(int view, int num) {
			//SQL문(업데이트로 조회수 변경하기)
			String sql = "update makegame set mview = ? where mnum = ?";
			try (
				Connection con = getConnection();						//커넥션 얻기
				PreparedStatement pstmt = con.prepareStatement(sql);	//sql문 실행
			) {
				//조회수를 위한 view와 고유번호를 위한 num 가져가기
				pstmt.setInt(1, view);
				pstmt.setInt(2, num);
				//조회수 업데이트 하기
				return pstmt.executeUpdate();	
			} catch(Exception e) {
				e.printStackTrace();
			}
			//데이터베이스 오류시
			return -1;
		}
}
