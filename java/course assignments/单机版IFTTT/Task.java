package tracelessspring;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.internet.ParseException;
import javax.swing.*;

public class Task {
	private String taskname;
	private int clockoremail;
	private String date;
	private String time;
	private String receiveemail;
	private String emailkey;
	private int weibooremail;
	private String idoremail;
	private String weibokey;
	private String weiboemailcontent;

	
	
	public Task(String taskname,int clockoremail,String date,String time,String receiveemail,String emailkey,
			int weibooremail,String idoremail,String weibokey,String weiboemailcontent){
		this.taskname=taskname;
		this.clockoremail=clockoremail;
		this.date=date;
		this.time=time;
		this.receiveemail=receiveemail;
		this.emailkey=emailkey;
		this.weibooremail=weibooremail;
		this.idoremail=idoremail;
		this.weibokey=weibokey;
		this.weiboemailcontent=weiboemailcontent;
	}

	
	public void set_taskname(String taskname){
		this.taskname=taskname;
	}
	
	public void set_clockoremail(int clockoremail){
		this.clockoremail=clockoremail;
	}
	
	public void set_date(String date){
		this.date=date;
	}
	
	public void set_time(String time){
		this.time=time;
	}
	
	public void set_receiveemail(String receiveemail){
		this.receiveemail=receiveemail;
	}
	
	public void set_emailkey(String emailkey){
		this.emailkey=emailkey;
	}
	
	public void set_weibooremail(int weibooremail){
		this.weibooremail=weibooremail;
	}
	
	public void set_idoremail(String idoremail){
		this.idoremail=idoremail;
	}
	
	public void set_weibokey(String weibokey){
		this.weibokey=weibokey;
	}
	
	public void set_weiboemailcontent(String weiboemailcontent){
		this.weiboemailcontent=weiboemailcontent;
	}
	
	
	
	public String get_taskname(){
		return taskname;
	}
	
	public int get_clockoremail(){
		return clockoremail;
	}
	
	public String get_date(){
		return date;
	}
	
	public String get_time(){
		return time;
	}
	
	public String get_receiveemail(){
		return receiveemail;
	}
	
	public String get_emailkey(){
		return emailkey;
	}
	
	public int get_weibooremail(){
		return weibooremail;
	}
	
	public String get_idoremail(){
		return idoremail;
	}
	
	public String get_weibokey(){
		return weibokey;
	}
	
	public String get_weiboemailcontent(){
		return weiboemailcontent;
	}
	
	
	
	public static Date String2Date(String day,String time) throws java.text.ParseException{
		Date new_date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		new_date=sf.parse(day+" "+time);
		//System.out.println("destination_time="+new_date);
		return new_date;
	}
	
	public static Date get_current_time(){
		Date date=new Date();
		return date;
	}
	
	public boolean is_equal1(String date,String time,Date current_time) throws java.text.ParseException{
		Date destination_time=String2Date(date,time);
		
		System.out.println("start_time"+current_time);
		System.out.println("distination_time="+destination_time);
		
		if(destination_time.getYear()==current_time.getYear()&&destination_time.getMonth()==current_time.getMonth()
				&&destination_time.getDay()==current_time.getDay()&&destination_time.getHours()==current_time.getHours()
				&&destination_time.getMinutes()==current_time.getMinutes())    //指定到秒的话程序多个任务一起运行的时候基本跑不动
			return true;
		else
			return false;
	}
	
}