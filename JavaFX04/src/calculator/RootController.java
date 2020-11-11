package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RootController implements Initializable {
	
	@FXML Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	@FXML Button btnDiv, btnMul, btnMin, btnPlu, btnDou, btnEq, btnClear;
	@FXML Label result;
	
	double op1, op2;
	String operator;
	
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
		btnDiv.setOnAction(event-> {
			op1 = Double.parseDouble(result.getText());
			result.setText(result.getText()+"/");
			operator = "/";
		});
		btnMul.setOnAction(event-> {
			op1 = Double.parseDouble(result.getText());
			result.setText(result.getText()+"*");
			operator = "*";
		});
		btnMin.setOnAction(event-> {
			op1 = Double.parseDouble(result.getText());
			result.setText(result.getText()+"-");
			operator = "-";
		});
		btnPlu.setOnAction(event-> {
			op1 = Double.parseDouble(result.getText());
			result.setText(result.getText()+"+");
			operator = "+";
		});
		btnDou.setOnAction(event-> {
			result.setText(result.getText()+".");
		});
		btnClear.setOnAction(event-> {
			op1 = 0;
			op2 = 0;
			operator = "";
			result.setText("0");
		});
		btnEq.setOnAction(event-> {
			StringTokenizer st = new StringTokenizer(result.getText(), operator);
			while (st.hasMoreTokens()) {
				op2 = Double.parseDouble(st.nextToken());
			}
			if (operator.equals("/")) {
				result.setText(Double.toString(op1/op2));
			} else if (operator.equals("-")) {
				result.setText(Double.toString(op1-op2));
			} else if (operator.equals("+")) {
				result.setText(Double.toString(op1+op2));
			} else if (operator.equals("*")) {
				result.setText(Double.toString(op1*op2));
			}
		});
		
	}
}
