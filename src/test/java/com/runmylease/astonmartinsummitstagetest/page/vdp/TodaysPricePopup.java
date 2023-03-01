package com.runmylease.astonmartinsummitstagetest.page.vdp;

import com.runmylease.astonmartinsummitstage.base.BaseForm;
import com.runmylease.astonmartinsummitstage.element.Button;
import com.runmylease.astonmartinsummitstage.element.Label;
import org.openqa.selenium.By;

public class TodaysPricePopup extends BaseForm {

    private static Label preOwnedVehicleLbL
            = new Label(By.xpath("//h2[contains(@class,'section-header_title__ULLsx')]"), "preOwnedVehicleLbL");

    private static Label preOwnedVehiclePageLbL
            = new Label(By.xpath("//*[@id='newVehiclesCatalog']/div/div[1]/h2"), "preOwnedVehiclePageLbL");

    private static Label priceDetailsLbL
            = new Label(By.xpath("//h3[contains(@class,'price-details_title__aWkWW')]"), "priceDetailsLbL");




    private static Button vdpFirstCarBtn
            = new Button(By.xpath("//div[@class='car-card-grid_descriptionContainer__HOPoN'][1]"), "vdpFirstCarBtn");

    private static Button todaysPriceBtn
            = new Button(By.xpath("//button[contains(@class, 'get_todays_price_button_qwe')]"), "todaysPriceBtn");

    private static Label todaysPriceElemLbL
            = new Label(By.xpath("//label[contains(@class,'styles_label__6RFdJ')]"), "todaysPriceElemLbL");







    public TodaysPricePopup(){
        super(preOwnedVehicleLbL, "preOwnedVehicleLbL");
    }

    public boolean isPreOwnedVehiclePageOpen(){
        return preOwnedVehiclePageLbL.isPreOwnedVehiclePageDisplayed();
    }

    public TodaysPricePopup openVDPFirstCar() {
        vdpFirstCarBtn.clickForOpenVDP();
        return this;
    }

    public boolean isVDPFistCarOpen() {
        return priceDetailsLbL.isDisplayed();
    }



    public TodaysPricePopup openTodaysPrice() {
        todaysPriceBtn.click();
        return this;
    }


}

