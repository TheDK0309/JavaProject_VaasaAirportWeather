package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class tempInfo {
	ArrayList<info> info = new ArrayList<info>();
	ArrayList<String> time1=new ArrayList<String>(); //creating array list for the time in a day
	ArrayList<Double> temp1=new ArrayList<Double>(); //creating array list for the temperature
	List<String> windspeed1=new ArrayList<String>(); //creating array list for the wind speed
	String address;	//the String address of the URL
	//getters and setters
	public ArrayList<String> getTime1() {
		return time1;
	}
	public void setTime1(ArrayList<String> time1) {
		this.time1 = time1;
	}
	public ArrayList<Double> getTemp1() {
		return temp1;
	}
	public void setTemp1(ArrayList<Double> temp1) {
		this.temp1 = temp1;
	}
	
	
	//constructor of the class, receives year, month,date from user and add it to the corresponindg places in the string
	public tempInfo(String year,String month,String date) {
		address = "https://www.wunderground.com/history/airport/EFVA/"+year+"/"+month+"/"+date+"/DailyHistory.html?req_city=Vaasa+Airport&req_state=&req_statename=Finland&reqdb.zip=00000&reqdb.magic=&reqdb.wmo=&format=1";
		pulldata();
	}
	//method to read data from the URL and take the value that needed
	private void pulldata(){
		try (InputStream in = new URL(address).openStream();
				BufferedReader rin = new BufferedReader(new InputStreamReader(in))) {
					String line;
					rin.readLine(); //read to skip the first line due to unneccessary
					rin.readLine();
					while((line = rin.readLine()) != null) {
						String[] details = line.split(","); // split string when encounter ","
						          
		                time1.add(details[0]); //first position(column) is the time, add them to the time array list
		                temp1.add(Double.parseDouble(details[1]));//second position is the temperature, add them to temperature array list
		                windspeed1.add(details[7]); //8th position is the wind speed, add them to the wind speed array list
		            }
					//display the array lists's infomation as logs
					System.out.println("Time:"+time1);
	                System.out.println("Temperature: "+temp1);
	                System.out.println("Windspedd"+windspeed1);		
		}
		
			catch (MalformedURLException e) {
				System.out.println("Malformed URL: " + e.getMessage());
			}
			catch (IOException e) {
				System.out.println("I/O Error: " + e.getMessage());
			}
		
	
		
	}
//method to calculate the average temperature of a day
	public double ave(){
		double ave=0;
		for(int i=0;i<temp1.size();i++){
			ave+=temp1.get(i);
		}
		ave=ave/temp1.size();
		return ave;
	}
	
}


