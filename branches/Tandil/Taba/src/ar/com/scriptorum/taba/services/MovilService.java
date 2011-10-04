package ar.com.scriptorum.taba.services;

import android.app.PendingIntent;
import android.telephony.SmsManager;

public class MovilService extends AbstractService {

	SmsManager smsManager = SmsManager.getDefault();
	
	public boolean sendNews(String news) {
		// TODO this method will be intended to periodically send news messages
		// -regarding travel progress, like position, time spent, remaining time
		// to travel completion, remaining distance, whatever- to configured 
		// telephones

		String destinationAddress = "destinationAddress";
		String scAddress = "scAddress";
		PendingIntent deliveryIntent = null;
		PendingIntent sentIntent = null;
		smsManager.sendTextMessage(destinationAddress, scAddress, news, sentIntent, deliveryIntent);
		
		return true;
		
	}
}
