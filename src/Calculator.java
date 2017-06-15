import java.awt.*;
import javax.swing.*;
import javafx.scene.control.Button;

public class Calculator {
	
	private JPanel windowContent; 
	private GridBagLayout gb;
	private JTextField displayField;
	private JFrame frame;
    private JButton[] buttons;
    private GridBagConstraints constr;
	private String[] buttonNames;
	
	public static void main(String[] args){
		Calculator hc = new Calculator();
		hc.go();
	}
	public void go(){
		windowContent = new JPanel();
		 gb = new GridBagLayout();
		 windowContent.setLayout(gb);
		 CalculatorEngine calculatorEngine = new CalculatorEngine(this);
		constr = new GridBagConstraints();

		constr.gridx=0;
		constr.gridy=0;
		constr.gridheight =2;
		constr.gridwidth= 5;
		constr.fill= constr.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.anchor=constr.CENTER;
		constr.ipady=20;
		constr.insets=new Insets(3, 3, 3, 3);
		
		displayField = new JTextField();
		gb.setConstraints(displayField,constr);
		windowContent.add(displayField);
		
		String[] buttonNames = {"MC","MR","MS","M+","M-","<","CE","C","+-",
						"sqr","7", "8", "9", "/", "^", "4", "5", "6","*",
						"1/x","1", "2", "3", "-", "=", "0", ".", "+"};
		
		//Settings buttons
		buttons = new JButton[buttonNames.length];
		
		//adding buttons and action listeners
		for(int i = 0; i < buttonNames.length; i++) {
			buttons[i] = new JButton(buttonNames[i]);
			buttons[i].addActionListener(calculatorEngine);
		}
		constr.ipady=0;
		addComponent(windowContent, buttons[0], 2, 0, 1, 1);
		addComponent(windowContent, buttons[1], 2, 1, 1, 1);		
		addComponent(windowContent, buttons[2], 2, 2, 1, 1);
		addComponent(windowContent, buttons[3], 2, 3, 1, 1);
		
		//add the second button row
		addComponent(windowContent, buttons[4], 2, 4, 1, 1);
		addComponent(windowContent, buttons[5], 3, 0, 1, 1);		
		addComponent(windowContent, buttons[6], 3, 1, 1, 1);
		addComponent(windowContent, buttons[7], 3, 2, 1, 1);
		
		//add the third button row
		addComponent(windowContent, buttons[8], 3, 3, 1, 1);
		addComponent(windowContent, buttons[9], 3, 4, 1, 1);		
		addComponent(windowContent, buttons[10], 4, 0, 1, 1);
		addComponent(windowContent, buttons[11], 4, 1, 1, 1);
		
		//add the fourth button row
		addComponent(windowContent, buttons[12], 4, 2, 1, 1);
		addComponent(windowContent, buttons[13], 4, 3, 1, 1);		
		addComponent(windowContent, buttons[14], 4, 4, 1, 1);
		addComponent(windowContent, buttons[15], 5, 0, 1, 1);

		addComponent(windowContent, buttons[16], 5, 1, 1, 1);
		
		//add the second button row
		addComponent(windowContent, buttons[17], 5, 2, 1, 1);
		addComponent(windowContent, buttons[18], 5, 3, 1, 1);		
		addComponent(windowContent, buttons[19], 5, 4, 1, 1);
		addComponent(windowContent, buttons[20], 6, 0, 1, 1);
		
		//add the third button row
		addComponent(windowContent, buttons[21], 6, 1, 1, 1);
		addComponent(windowContent, buttons[22], 6, 2, 1, 1);		
		addComponent(windowContent, buttons[23], 6, 3, 1, 1);
		addComponent(windowContent, buttons[24], 6, 4, 1, 2);
		
		//add the fourth button row
		addComponent(windowContent, buttons[25], 7, 0, 2, 1);
		addComponent(windowContent, buttons[26], 7, 2, 1, 1);		
		addComponent(windowContent, buttons[27], 7, 3, 1, 1);
	
		//CalculatorEngineMsg calcEngine = new CalculatorEngineMsg();
		//buttons[0].addActionListener(calcEngine);
		
		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(windowContent);
		// Set the size of the window big enough
		// to accommodate all controls
		frame.pack();
		// Display the window
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void addComponent(Container container, Component component, int row,
			int column, int width, int height) {
		constr.fill = GridBagConstraints.BOTH;
		constr.anchor = GridBagConstraints.CENTER;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.gridx = column;
		constr.gridy = row;
		constr.gridheight = height;
		constr.gridwidth = width;
		gb.setConstraints(component, constr);
		container.add(component);
	} //end method addComponent
	public void setDisplayValue(String val){
		displayField.setText(val);
		}
	public String getDisplayValue() {
		return displayField.getText();
		}
}
