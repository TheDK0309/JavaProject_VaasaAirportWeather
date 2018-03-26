package test;

public class info {
	String time;
	String temp;
	String windspeed;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getWindspeed() {
		return windspeed;
	}
	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
	}
	public String toString(){
		return " Time: " + time +", "+ "Temperature: " +temp +", "+ "Wind Speed: " +windspeed +"\n";
	}
	public info(String time,String temp,String windspeed){
		this.time=time;
		this.temp=temp;
		this.windspeed=windspeed;
	}
}
