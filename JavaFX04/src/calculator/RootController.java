package calculator;

import java.net.URL;
import java.util.ResourceBundle;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RootController implements Initializable {
	
	@FXML Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	@FXML Button btnDiv, btnMul, btnMin, btnPlu, btnDot, btnEq, btnClear;
	@FXML Label result, formula;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btn0.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn0.getText());
			} else {
				result.setText(result.getText()+btn0.getText());
			}
		});
		btn1.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn1.getText());
			} else {
				result.setText(result.getText()+btn1.getText());
			}
		});
		btn2.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn2.getText());
			} else {
				result.setText(result.getText()+btn2.getText());
			}
		});
		btn3.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn3.getText());
			} else {
				result.setText(result.getText()+btn3.getText());
			}
		});
		btn4.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn4.getText());
			} else {
				result.setText(result.getText()+btn4.getText());
			}
		});
		btn5.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn5.getText());
			} else {
				result.setText(result.getText()+btn5.getText());
			}
		});
		btn6.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn6.getText());
			} else {
				result.setText(result.getText()+btn6.getText());
			}
		});
		btn7.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn7.getText());
			} else {
				result.setText(result.getText()+btn7.getText());
			}
		});
		btn8.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn8.getText());
			} else {
				result.setText(result.getText()+btn8.getText());
			}
		});
		btn9.setOnAction(event-> {
			if (result.getText().equals("0")) {
				result.setText(btn9.getText());
			} else {
				result.setText(result.getText()+btn9.getText());
			}
		});
		btnPlu.setOnAction(event->{
			formula.setText(formula.getText()+result.getText()+"+");
			result.setText("");
		});
		btnMin.setOnAction(event->{
			formula.setText(formula.getText()+result.getText()+"-");
			result.setText("");
		});
		btnMul.setOnAction(event->{
			formula.setText(formula.getText()+result.getText()+"*");
			result.setText("");
		});
		btnDiv.setOnAction(event->{
			formula.setText(formula.getText()+result.getText()+"/");
			result.setText("");
		});
		btnDot.setOnAction(event-> {
			result.setText(result.getText()+".");
		});
		btnClear.setOnAction(event->{
			formula.setText("");
			result.setText("");
		});
		
		btnEq.setOnAction(event->{
			// javascript의 eval함수를 사용하고 싶어서 구글링했더니 사용하는 방법이 있어서 eval을 사용했습니다.
			// 출처: https://unikys.tistory.com/226 [All-round programmer]
			formula.setText(formula.getText()+result.getText());
			result.setText("");
			
			ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("js");
		    try {
		    	double res = Double.parseDouble(String.valueOf(engine.eval(formula.getText())));
		    	/*
		    	 * double res = (double)(engine.eval(formula.getText())를 하니까 에러가 나서
		    	 * engine.eval()을 string으로 바꾼 후 double로 변환했습니다.
		    	 */
		    	result.setText(Double.toString(res));
		    } catch(Exception e) {
		    	e.printStackTrace();
		    }

		});
		
	}
}
