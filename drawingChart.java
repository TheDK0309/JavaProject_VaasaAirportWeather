package test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
public class drawingChart extends JPanel {
	//attributes creation
	private tempInfo tempinfo;
	private String year;
	private String month;
	private String date;
	//constructor
	public drawingChart(String year,String month,String date) {
	
		super();
		this.year=year;
		this.month=month;
		this.date=date;
		tempinfo =new tempInfo(year,month,date);
		
	}
	//default constuctor
	public drawingChart(){	
		super();
	}
	// method to redraw the chart if the user input new values
	public void redraw(String year,String month,String date){
		this.year=year;
		this.month=month;
		this.date=date;
		tempinfo =new tempInfo(year,month,date);
		
		repaint();
		
	}
	//drawing the coordinate lines and the rectangular charts
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = this.getWidth(); //window's width
		int height = this.getHeight();//window's height
		setBackground(Color.white);
		g.setColor(Color.black);
		if (tempinfo != null) //if the information are not null , draw the following string of average temperature
			g.drawString("Average temperature: "+String.valueOf(tempinfo.ave()), height/20, width/10);
		//drawing lines and the value of the temperatures as Y coord
		g.drawLine(width/10, height/2, width-width/10, height/2);
		g.drawString("0", (width/10)-30,height/2);
		g.drawString("1", (width/10)-30,(height/2)-25 );
		g.drawString("2", (width/10)-30,(height/2)-50 );
		g.drawString("3", (width/10)-30,(height/2)-75 );
		g.drawString("4", (width/10)-30,(height/2)-100 );
		g.drawString("+Inf", (width/10)-30,(height/2)-125 );
		
		g.drawString("-1", (width/10)-30,(height/2)+25 );
		g.drawString("-2", (width/10)-30,(height/2)+50 );
		g.drawString("-3", (width/10)-30,(height/2)+75 );
		g.drawString("-4", (width/10)-30,(height/2)+100 );
		g.drawString("-Inf", (width/10)-30,(height/2)+125 );
		if(year!=null && date!=null && month!=null){
			ArrayList<String> time= tempinfo.getTime1();
			ArrayList<Double> temp= tempinfo.getTemp1();
			for(int i=0;i<10;i++){ //due to the large ammount of datas, draw only the first 10 values
				g.setColor(Color.BLACK);
				g.drawString(time.get(i),(width/10)+(width*i/12),(height/2)+175); //draw the string of times as X coord's value
				int fre=temp.get(i).intValue(); //value of temperature as integer
				int width1 = 40;//width of the rectangles
				int startX = (width/10)+(width*i/12); //start X coord
				int startY; //start Y coord
				int height1; //height of the rectangles
				int h=fre;
				//because temperatures have negative and positive value, we
				if(fre<0){//if the temperatures are negative values
					if(fre<-4) h=-5; //if the temperatures are lower then -4, draw a 5 unit height rectangle, but they have their original values

					height1=-25*h;
					startY = (height/2)+10;
					g.setColor(Color.BLACK);
					g.fillRect(startX,startY-10 , width1, height1); //draw the rectangles
					g.drawString(String.valueOf(fre),startX,height1+10+startY);//draw the value corresponding above the rectangles
		
				
				}else
				if(fre>0){ //if the temperatures are positive values
					if(fre>4){//if the temperatures are higher then 4, draw a 5 unit height rectangle, but they have their original values
						h=5;
					}
					height1=25*h;
					startY = (height/2)-height1;
					g.setColor(Color.BLACK);
					g.fillRect(startX,startY , width1, height1); //rectangles drawing
					g.drawString(String.valueOf(fre),startX,(height/2)-height1-10);//draw the value corresponding above the rectangles

				}
				
			}
			
		}
		
	}
	
}

