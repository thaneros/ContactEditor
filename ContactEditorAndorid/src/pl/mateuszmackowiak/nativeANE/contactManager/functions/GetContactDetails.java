package pl.mateuszmackowiak.nativeANE.contactManager.functions;

import pl.mateuszmackowiak.nativeANE.contactManager.ContactEditorContext;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class GetContactDetails implements FREFunction {

	private static final String TAG = "ContactEditor";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		
		Log.d(TAG, "Entering GetContactDetails.call()");
		
		int recordId;
		try {
			recordId = args[0].getAsInt();
			if( ((ContactEditorContext) context).getDetailedContact(recordId) != null )
				context.dispatchStatusEventAsync("DETAILED_CONTACT_UPDATED", Integer.toString(recordId));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		Log.d(TAG, "Exiting GetContactDetails.call()");
		
		return null;
	}

}
