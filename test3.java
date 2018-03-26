package test;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.net.MalformedURLException; 
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;

public class test3 extends JFrame implements ActionListener  {
	 
	private JPanel topan=new JPanel(); //top pannel that contains buttons and textfield
	//components of the top panels:
	private JTextField txtValue1 = new JTextField(10);
	private JTextField txtValue2 = new JTextField(10);
	private JTextField txtValue3 = new JTextField(10);
	private JButton btn = new JButton("Generate");
	private JLabel lblResult= new JLabel();
	private JTextArea lblResult1= new JTextArea();
	drawingChart myChart; //creating object from drawingChart class
	public test3(){ //GUI initializing
		
		setTitle("GUI Demo");
		setLayout(new BorderLayout()); //setting the layout of the GUI
		//Adding components to the frame's panel
		topan.add(new JLabel("Date:"));
		topan.add(txtValue1);
		topan.add(new JLabel("Month:"));
		topan.add(txtValue2);
		topan.add(new JLabel("Year:"));
		topan.add(txtValue3);
		topan.add(btn);
		topan.add(lblResult);
		lblResult1=new JTextArea();  
		lblResult1.setBounds(20,75,250,200); 
		topan.add(lblResult1);
		setSize(1000, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
        add(topan,BorderLayout.NORTH); //putting top panel to the top of the GUI window
        //Adding myChart object to the center of the frame:
        myChart = new drawingChart();
		myChart.setSize(1000, 600);
		getContentPane().add(myChart,BorderLayout.CENTER);
        btn.addActionListener(this); //calling the action after pressing the button
     }
	
	public void actionPerformed(ActionEvent evt) {
		//the text field receives the input date, month , year from the user and add it to the URL string , 
		String date=txtValue1.getText();
		String month=txtValue2.getText();		
		String year=txtValue3.getText();
		//which the method redraw in class drawing charts will receive them as argument
		myChart.redraw(year,month,date);
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//calling the frame drawn from above
				 test3 frame = new test3();
			        frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
