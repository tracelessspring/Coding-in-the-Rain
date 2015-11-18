package tracelessspring;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;

public class Send_Weibo_Message {
	
	public void send_weibo(String message){
	//public static void main(String[] args) {
		String access_token = "2.00hVAlNEWXsLnC924be2fa2eQTf4rC";
		String statuses = message;
		Timeline tm = new Timeline(access_token);
		try {
			Status status = tm.updateStatus(statuses);
			Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}	
	}

}
