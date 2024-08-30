package jp.co.f1.jdbc.ch04;

import java.util.ArrayList;

public class InsertProgram1 {

	// 配列宣言
	private static ArrayList<String> isbnList = null;	// isbn情報格納用のリスト
	private static ArrayList<String> titleList = null;	// title情報格納用のリスト
 	private static ArrayList<Integer> priceList = null;	// price情報格納用のリスト
 
 	public static void main(String[] args) {
 		try{
 			// DAOオブジェクト化
 			SampleDAO1 objDao = new SampleDAO1();
 
 			// 書籍情報を取得するメソッドをDAOから呼び出す
 			isbnList = objDao.selectIsbnAll();	// isbn情報全て取得メソッド呼び出し
 			titleList = objDao.selectTitleAll();	// title情報全て取得メソッド呼び出し
 			priceList = objDao.selectPriceAll();	// price情報全て取得メソッド呼び出し
 
 			// 取得した書籍情報を表示
 			System.out.println("■登録SQL発行前の書籍一覧表示■");
 			display();
 
 			// 書籍情報を登録するメソッドをDAOから呼び出す
 			int rowsCount = objDao.insertBook("00008", "Strutsテキスト", 2000);
 			if(rowsCount > 0){
 				System.out.println(rowsCount + "件のレコードを登録しました。\n");
 			}
 
 			// 書籍情報を取得するメソッドをDAOから呼び出す
 			isbnList = objDao.selectIsbnAll();	// ISBN情報全て取得メソッド呼び出し
 			titleList = objDao.selectTitleAll();	// Title情報全て取得メソッド呼び出し
 			priceList = objDao.selectPriceAll();	// Price情報全て取得メソッド呼び出し
 
 			// 取得した書籍情報を表示
 			System.out.println("■登録SQL発行後の書籍一覧表示■");
 			display();
 
 		}catch(Exception e){
 			System.out.println("エラーが発生しました。" + e);
 		}
 	}
 
 	public static void display() {
 		for(int i=0;i<isbnList.size();i++){
 			System.out.print("ISBN→"  + isbnList.get(i)  + "\t");
 			System.out.print("Title→" + titleList.get(i) + "\t");
 			System.out.print("Price→" + priceList.get(i) + "\n");
 		}
 		System.out.println();
 	}
 
 }