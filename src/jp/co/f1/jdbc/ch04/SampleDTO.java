package jp.co.f1.jdbc.ch04;

public class SampleDTO {

	private String isbn;	// isbn
	private String title;	// タイトル
	private int price;	// 価格

	// コンストラクタ
 	public SampleDTO() {
 		// 初期化処理
 		isbn  = null;
 		title = null;
 		price = 0;
 	}
 
 	// isbnのゲッターメソッド
 	// フィールド変数isbnで管理された値を返す
 	public String getIsbn() {
 		return isbn;
 	}
 
 	// isbnのセッターメソッド
 	// 引数に受け取った値をフィールド変数isbnに格納する
 	public void setIsbn(String isbn) {
 		this.isbn = isbn;
 	}
 
 	// titleのゲッターメソッド
 	// フィールド変数titleで管理された値を返す
 	public String getTitle() {
 		return title;
 	}
 
 	// titleのセッターメソッド
 	// 引数に受け取った値をフィールド変数titleに格納する
 	public void setTitle(String title) {
 		this.title = title;
 	}
 
 	// priceのゲッターメソッド
 	// フィールド変数priceで管理された値を返す
 	public int getPrice() {
 		return price;
 	}
 
 	// priceのセッターメソッド
 	// 引数に受け取った値をフィールド変数priceに格納する
 	public void setPrice(int price) {
 		this.price = price;
 	}
 
 }