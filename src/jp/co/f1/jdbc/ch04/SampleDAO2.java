package jp.co.f1.jdbc.ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SampleDAO2 {

	//接続用の情報をフィールドに定数として定義
	private static final String RDB_DRIVE="org.mariadb.jdbc.Driver";
 	private static final String URL="jdbc:mariadb://localhost/mybookdb";
 	private static final String USER="root";
 	private static final String PASSWD="root123";
 
 	// データベース接続を行うメソッド
 	// データベース接続用定義を基にデータベースへ接続し、戻り値としてコネクション情報を返す
 	private static Connection getConnection(){
 		try{
 			Class.forName(RDB_DRIVE);
 			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
 			return con;
 		}catch(Exception e){
 			throw new IllegalStateException(e);
 		}
 	}
 
 	// データベースから全ての書籍情報の検索を行うメソッド
 	// テーブルに登録された全てのデータをArrayList<SampleDTO>型オブジェクトへ格納し、戻り値として返す
 	public ArrayList<SampleDTO> selectAll(){
 
 		// 変数宣言
 		Connection con = null;	// DBコネクション
 		Statement smt = null;	// SQLステートメント
 
 		// 配列宣言
 		ArrayList<SampleDTO> list = new ArrayList<SampleDTO>();
 
 		// SQL文作成
 		String sql = "SELECT * FROM bookinfo ORDER BY isbn";
 
 		try{
 			// DBに接続
 			con = SampleDAO2.getConnection();
 			smt = con.createStatement();
 
 			// SQL文発行
 			ResultSet rs = smt.executeQuery(sql);
 
 			// 検索結果をArrayListに格納
 			while(rs.next()){
 				SampleDTO objDto = new SampleDTO();
 				objDto.setIsbn(rs.getString("isbn"));
 				objDto.setTitle(rs.getString("title"));
 				objDto.setPrice(rs.getInt("price"));
 				list.add(objDto);
 			}
 
 		}catch(SQLException e){
 			System.out.println("Errorが発生しました！\n"+e);
 		}finally{
 			// リソースの開放
 			if(smt != null){
 				try{smt.close();}catch(SQLException ignore){}
 			}
 			if(con != null){
 				try{con.close();}catch(SQLException ignore){}
 			}
 		}
 		return list;
 	}
 
 	// 書籍情報を登録するメソッド
 	// 引数に渡された書籍情報をデータベースへ登録し、戻り値として登録件数を返す
 	public int insertBook(SampleDTO book){
 		// 変数宣言
 		Connection con = null;	// DBコネクション
 		Statement smt = null;	// SQLステートメント
 
 		int rowsCount = 0;
 
 		// SQL文
 		String sql = "INSERT INTO bookinfo(isbn,title,price) " +
 				"VALUES('" + book.getIsbn() + "','" + book.getTitle() + "'," + book.getPrice() + ")";
 
 		try{
 			// DBに接続
 			con = SampleDAO2.getConnection();
 			smt = con.createStatement();
 
 			// SQL文発行
 			rowsCount = smt.executeUpdate(sql);
 
 		}catch(SQLException e){
 			System.out.println("Errorが発生しました！\n"+ e +"\n");
 		}finally{
 			// リソースの開放
 			if(smt != null){
 				try{smt.close();}catch(SQLException ignore){}
 			}
 			if(con != null){
  				try{con.close();}catch(SQLException ignore){}
  			}
  		}
  		return rowsCount;
  	}
  
  }