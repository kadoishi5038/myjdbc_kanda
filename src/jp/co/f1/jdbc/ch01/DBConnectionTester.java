package jp.co.f1.jdbc.ch01;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionTester {

	//接続用の情報をフィールドに定数として定義
	public static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	public static String URL = "jdbc:mariadb://localhost/mybookdb";
 	public static String USER = "root";
 	public static String PASSWD = "root123";
 
 	public static void main(String[] args) {
 
 		try{
 			Class.forName(RDB_DRIVE);
 			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
 			
 			//接続成功メッセージとコネクション情報の表示
 			System.out.println("JDBCデータベース接続成功");
 			System.out.println("con = " + con);
 
 			con.close();
 
 		}catch(Exception e){
 			System.out.println("JDBCデータベース接続エラー:" + e);
 		}
 	}
 }