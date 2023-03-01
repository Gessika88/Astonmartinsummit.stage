package com.runmylease.astonmartinsummitstage.base;


import com.runmylease.astonmartinsummitstage.util.CustomLogger;

public abstract class BaseForm {

    private BaseElement element;
    private String formName;

    public BaseForm() {
    }

    public BaseForm(BaseElement element, String formName){
        this.element = element;
        this.formName = formName;
    }

    public String getFormName() {
        CustomLogger.info(" getFormName()");
        return formName;
    }

    public boolean isPageOpened() {
        CustomLogger.info(this.getFormName() + " :isPageOpened()");
        return element.isDisplayed();
    }
}
