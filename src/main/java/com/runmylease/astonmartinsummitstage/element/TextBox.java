package com.runmylease.astonmartinsummitstage.element;

import com.runmylease.astonmartinsummitstage.base.BaseElement;
import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {

    public TextBox(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void sendText(String text) {
        CustomLogger.info(this.getElementName() + ".sendText(): " + text);
        findElement(this.getLocator()).sendKeys(text);
    }
}
