package com.runmylease.astonmartinsummitstage.base;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstage.util.FrameUtil;
import org.openqa.selenium.By;

public abstract class BaseFrame extends BaseForm{

    private By frameLocator;

    public BaseFrame(BaseElement element, By frameLocator, String formName) {
        super(element, formName);
        this.frameLocator = frameLocator;
    }

    public void switchToThisFrame() {
        CustomLogger.info(this.getFormName() + " :switchToThisFrame()");
        FrameUtil.switchToFrame(frameLocator);
    }

    public void leaveFrame() {
        CustomLogger.info(this.getFormName() + " :leaveFrame()");
        FrameUtil.leaveFrame();
    }
}

