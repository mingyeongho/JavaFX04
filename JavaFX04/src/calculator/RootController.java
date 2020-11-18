package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RootController implements Initializable {
	
	@FXML Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	@FXML Button btnDiv, btnMul, btnMin, btnPlu, btnDot, btnEq, btnClear;
	@FXML Label result, formula;
	
	double op1, op2;
	String operator = "";
	
	Vector<Double> operands = new Vector<Double>();
	Vector<String> operators = new Vector<String>();
	
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
			
			if (operator.equals("")) {
				result.setText(result.getText()+btn4.getText());
			} else {
				result.setText(result.getText() + btn4.getText());
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
			operands.add(Double.parseDouble(result.getText()));
			operators.add("+");
			formula.setText(formula.getText()+result.getText()+"+");
			result.setText("");
		});
		btnMin.setOnAction(event->{
			operands.add(Double.parseDouble(result.getText()));
			operators.add("-");
			formula.setText(formula.getText()+result.getText()+"-");
			result.setText("");
		});
		btnMul.setOnAction(event->{
			operands.add(Double.parseDouble(result.getText()));
			operators.add("*");
			formula.setText(formula.getText()+result.getText()+"*");
			result.setText("");
		});
		btnDiv.setOnAction(event->{
			operands.add(Double.parseDouble(result.getText()));
			operators.add("/");
			formula.setText(formula.getText()+result.getText()+"/");
			result.setText("");
		});
		btnDot.setOnAction(event-> {
			result.setText(result.getText()+".");
		});
		btnClear.setOnAction(event->{
			operands.clear();
			operators.clear();
			formula.setText("");
			result.setText("");
		});
		/*
		 * operator[0] : operand[0] operand[1]
		 * operator[1] : operand[1] operand[2]
		 * operator[2] : operand[2] operand[3]
		 */
		// 2 + 4 * 2 + 2 = 12
		// 2 + 8 + 2 
		// operator[0] = '+'
		// operator[1] = '*'
		// operator[2] = '+'
		btnEq.setOnAction(event->{
			
			
			operands.clear();
			operators.clear();
		});
		
	}
}
