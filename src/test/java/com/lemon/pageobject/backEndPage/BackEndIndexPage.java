package com.lemon.pageobject.backEndPage;

import com.lemon.base.BasePage;
import org.openqa.selenium.By;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/26 10:57
 */
public class BackEndIndexPage extends BasePage {
    //借款管理按钮
    By loanItemBy = By.xpath("//div[@id='_easyui_tree_15']//span[text()='借款管理']");

    public void clickLoanItem(){
        click(loanItemBy,"点击借款管理");
    }
}
