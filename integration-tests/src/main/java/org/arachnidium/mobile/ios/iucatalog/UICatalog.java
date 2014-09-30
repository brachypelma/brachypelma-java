package org.arachnidium.mobile.ios.iucatalog;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.support.FindBy;
import org.arachnidium.model.mobile.ios.iOSNativeContent;
import org.arachnidium.core.MobileScreen;

public class UICatalog extends iOSNativeContent {
	@FindBy(name = "UICatalog")
	private MobileElement backToMe;
	
	public UICatalog(MobileScreen context) {
		super(context);
		load();
	}
	
	@InteractiveMethod
	public void selectItem(String item){
		TouchAction touchAction = new TouchAction((MobileDriver) getWrappedDriver());
		touchAction.tap(getNamedTextField(item));
		touchActionsPerformer.performTouchAction(touchAction);
	}
	
	@InteractiveMethod
	public void backToMe(){
		backToMe.click();
	}
	
}
