package com.github.arachnidium.tutorial.app_modeling.web.annotated_pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.github.arachnidium.core.Handle;
import com.github.arachnidium.model.common.FunctionalPart;
import com.github.arachnidium.model.support.annotations.rootelements.RootElement;

@RootElement(chain = {@FindBy(id = "someIdForAnotherService_or_Component")}) /**<--It is the demonstration of the ability
to define the default root element for the whole page object. All declared elements will be found from this element 
instead of WebDriver. We can define it as a chain of searches*/
@RootElement(chain = {@FindBy(xpath = ".//*[@class='gb_sa gb_O']")}) /**We can define it as a set of possible element
chains. Declaration is applied to subclasses till they are annotated by @RootElement with 
another values. Also if the class is going to be instantiated by {@link FunctionalPart#getPart(Class, By)}
then the given By-strategy will be used instead of declared by annotations*/

/**it is the example which demonstrates how to implement a child page object*/
public class AccountOptions<S extends Handle> extends FunctionalPart<S> { /** <==
	 * Here I demonstrate something that is supposed to be used by the web and 
	 * mobile testing 
	 */
	
	protected AccountOptions(S handle) {
		super(handle);
	}
	
	@FindAll({@FindBy(xpath = ".//*[@class='gbmpalb']/a"),
		@FindBy(xpath = ".//*[@class='gb_Ba']/div[2]/a")})
	private WebElement quitButton;
	
	@FindAll({@FindBy(xpath = ".//*[@class='gb_Xb gb_V']"),
		@FindBy(xpath = ".//*[@class='gbmpala']/a")})
	private WebElement addAccountButton;

	
	
	@InteractiveMethod /**<-- This annotations is useful for methods which simulate
	some interaction. By default the presence of it means that Webdriver should be focused
	on the window/context and switched to the required frame if currently this content is 
	placed inside iframe. All this will have been done before the annotated method
	will be invoked*/
	public void quit(){
		quitButton.click();
	}
	
	@InteractiveMethod
	public void addAccount(){
		addAccountButton.click();
	}	
	
	//Some more actions could be implemented here
	//.......

}
