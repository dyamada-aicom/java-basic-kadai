package kadai_026;

import java.util.HashMap;
import java.util.Scanner;

public class Jyanken_Chapter26 {
	
	//じゃんけん手キーとじゃんけんの手を紐づけたHashMap
	HashMap<String, String> handShape = new HashMap<>();{
		handShape.put("r", "グー"); 
		handShape.put("s", "チョキ"); 
		handShape.put("p", "パー");
	}
	//勝敗判定キーとその時出力する内容
	HashMap<String, String> resultConsole = new HashMap<>();{
		resultConsole.put("win", "自分の勝ちです"); 
		resultConsole.put("lose", "自分の負けです"); 
		resultConsole.put("draw", "あいこです");
	}
	
	
	//自分の手を入力するメソッド
	public String getMyChoice(){
		//scannerのオブジェクト生成
		Scanner scanner = new Scanner(System.in);
		//ダイアログ表示
		System.out.println("グーはrockのr");
		System.out.println("チョキはscissorsのs");
		System.out.println("パーはpaperのp");
		System.out.print("自分のじゃんけんの手を入力しましょう：");
		
		String input = "";
		
		//inputがrspのどれかになるまで入力受付を繰り返し
		do {
			input = scanner.next();	
		}while(!(input.equals("r") || input.equals("s") || input.equals("p")) );
		
		
		scanner.close();
		//inputを返す
		return input; 
	}
	
	//相手の手を乱数で決定するメソッド
	public String getRandom() {
		//0～2の擬似乱数
		int rand = (int) Math.floor(Math.random() * 3);
		
		//乱数の値によって戻り値を指定
		switch(rand) {
		case 0 -> { return "r"; }
		case 1 -> { return "s"; }	
		case 2 -> { return "p"; }
		default ->{ return ""; }
		}
	}

	//じゃんけんを行うメソッド
	public void playGame(final String me,final String enemy) {
		//双方の手を出力
		System.out.println("自分の手は" + handShape.get(me) +
							",対戦相手の手は" + handShape.get(enemy));
	
		//勝敗判定のキー　自分の勝ちならwin,自分の負けならlose,あいこはdraw
		String result = "";
		
		//判定して勝敗判定キー変更
		switch(me) {
		case "r" -> {
			switch(enemy) {
			case "r" -> {result = "draw"; }
			case "s" -> {result = "win";  }
			case "p" -> {result = "lose"; }
			}
		}
		
		case "s" -> {
			switch(enemy) {
			case "r" -> {result = "lose"; }
			case "s" -> {result = "draw"; }
			case "p" -> {result = "win";  }
			}
		}
		
		case "p" -> {
			switch(enemy) {
			case "r" -> {result = "win";  }
			case "s" -> {result = "lose"; }
			case "p" -> {result = "draw"; }
			}
		}
		default ->{System.out.println("エラーです");}
		}
		
		//勝敗判定キーに応じた結果出力
		System.out.println(resultConsole.get(result));
		
	}

	
}