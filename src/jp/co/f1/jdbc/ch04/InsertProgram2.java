package jp.co.f1.jdbc.ch04;

import java.util.ArrayList;

public class InsertProgram2 {

	// 配列宣言
	private static ArrayList<SampleDTO>bookList = null;	// SampleDTO型のオブジェクトを格納するArrayList

	public static void main(String[] args) {
		try{
			// DAOオブジェクト化
			SampleDAO2 objDao = new SampleDAO2();

			// 書籍情報を取得するメソッドをDAOから呼び出す
			bookList = objDao.selectAll();	// 全ての情報を取得メソッド呼び出し

			// 取得した書籍情報を表示
			System.out.println("■登録SQL発行前の書籍一覧表示■");
			display();

			SampleDTO bookDto = new SampleDTO();
			bookDto.setIsbn("00009");
			bookDto.setTitle("Ruby入門テキスト");
			bookDto.setPrice(2500);

			// 書籍情報を登録するメソッドをDAOから呼び出す
			int rowsCount = objDao.insertBook(bookDto);
			if(rowsCount > 0){
				System.out.println(rowsCount + "件のレコードを登録しました。\n");
			}

			// 書籍情報を取得するメソッドをDAOから呼び出す
			bookList = objDao.selectAll();	// 全ての情報を取得メソッド呼び出し

			// 取得した書籍情報を表示
			System.out.println("■登録SQL発行後の書籍一覧表示■");
			display();

		}catch(Exception e){
			System.out.println("エラーが発生しました。" + e);
		}
	}

	public static void display() {
		for(int i=0;i<bookList.size();i++){
			SampleDTO bookDto = bookList.get(i);
			System.out.print("ISBN→"  + bookDto.getIsbn()  + "\t");
			System.out.print("Title→" + bookDto.getTitle() + "\t");
			System.out.print("Price→" + bookDto.getPrice() + "\n");
		}
		System.out.println();
	}

}