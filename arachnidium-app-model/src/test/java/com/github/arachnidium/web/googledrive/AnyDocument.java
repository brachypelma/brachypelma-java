package com.github.arachnidium.web.googledrive;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.arachnidium.core.Handle;
import com.github.arachnidium.model.common.FunctionalPart;
import com.github.arachnidium.model.common.Static;
import com.github.arachnidium.model.support.annotations.classdeclaration.IfBrowserURL;
import com.github.arachnidium.model.support.annotations.classdeclaration.TimeOut;

@IfBrowserURL(regExp = "docs.google.com/document/")
@IfBrowserURL(regExp = "/document/")
@TimeOut(timeOut = 10)
public abstract class AnyDocument<T extends Handle> extends FunctionalPart<T> {
	
	@Static
	public ShareDocumentSettings<?> shareDocumentSettings;
	@Static
	public LogOut<?> logOut;
	
	@FindBy(xpath=".//*[@id='docs-titlebar-share-client-button']/div")
	private WebElement shareButton;
	
	protected AnyDocument(T handle) {
		super(handle);
		load();
	}
	
	@InteractiveMethod
	public void clickShareButton(){
		shareButton.click();
	}

}