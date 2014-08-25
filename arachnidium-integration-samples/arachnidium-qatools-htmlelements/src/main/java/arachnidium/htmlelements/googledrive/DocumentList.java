package arachnidium.htmlelements.googledrive;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.arachnidium.core.Handle;
import org.arachnidium.model.common.FunctionalPart;
import org.arachnidium.model.support.annotations.classdeclaration.IfBrowserDefaultPageIndex;
import org.arachnidium.model.support.annotations.classdeclaration.IfBrowserURL;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

@IfBrowserURL(regExp = "drive.google.com/drive/")
@IfBrowserURL(regExp = "drive.google.com")
@IfBrowserDefaultPageIndex(index = 0)
public class DocumentList<S extends Handle> extends FunctionalPart<S> {

	@FindAll({@FindBy(className = "treedoclistview-root-node-name"),
		@FindBy(xpath = ".//*[contains(@class,'goog-listitem-container')]")})
	private List<Button> sections;

	@FindBys({@FindBy(className = "doclist-name-wrapper"), @FindBy(tagName = "a")})
	private List<Link> documents;

	protected DocumentList(S handle) {
		super(handle);
		// (!!!)
		HtmlElementLoader.populatePageObject(this,
						driverEncapsulation.getWrappedDriver());
	}

	@InteractiveMethod
	public void choseSection(int sectionNum) {
		sections.get(0).click();
	}

	@InteractiveMethod
	public void clickOnDoc(String name) {
		List<Link> areFound = new ArrayList<Link>();
		documents
				.forEach((document) -> {
					if (document.getText().equals(name)) {
						document.click();
						areFound.add(document);
					}
				});
		if (areFound.size() == 0) {
			throw new NoSuchElementException("There is no document named "
					+ name);
		}
	}

}