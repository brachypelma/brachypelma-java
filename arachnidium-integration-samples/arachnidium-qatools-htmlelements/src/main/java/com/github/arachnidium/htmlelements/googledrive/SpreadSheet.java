package com.github.arachnidium.htmlelements.googledrive;

import org.openqa.selenium.By;

import com.github.arachnidium.core.Handle;
import com.github.arachnidium.model.support.HowToGetByFrames;
import com.github.arachnidium.model.support.annotations.ExpectedURL;

/**
 * Overrides some annotations of the superclass
 */
@ExpectedURL(regExp = "docs.google.com/spreadsheets/")
@ExpectedURL(regExp = "/spreadsheets/")
public class SpreadSheet<T extends Handle> extends AnyDocument<T> {

	protected SpreadSheet(T handle, HowToGetByFrames path, By by) {
		super(handle, path, by);
	}

}
