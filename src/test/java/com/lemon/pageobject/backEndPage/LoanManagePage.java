package com.lemon.pageobject.backEndPage;

import com.lemon.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import sun.security.pkcs11.wrapper.CK_AES_CTR_PARAMS;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/25 21:56
 */
public class LoanManagePage extends BasePage {
    //切换iframe页面
    By loanManageIFrameBy = By.id("mainFrame");
    //加标按钮
    By addLoanBy = By.xpath("//span[text()='加标']");
    //查找用户名输入框
    By findUserBy = By.xpath("//input[@placeholder='输入手机号码进行查找']");
    //借款人用户名选择
    By optionUser = By.xpath("//div[text()='小蜜蜂133008524']");
    //贷款标题输入框
    By loanTileBy = By.xpath("//td//input[@name='Title']");
    //年利率利息输入框
    By loanRateBy = By.xpath("//td//input[@name='LoanRate']");
    //借款期限输入框
    By loanTermBy = By.xpath("//td//input[@name='LoanTerm']");
    //借款额度输入框
    By loanAmountBy = By.xpath("//td//input[@name='Amount']");
    //竞标期限输入框
    By bidingDaysBy = By.xpath("//td//input[@name='BiddingDays']");
    //加标提交按钮
    By submitBy = By.xpath("//span[text()='提交']");
    //风控评测入口
    By riskEvaluationBy = By.xpath("//span[text()='风控评测']");
    //评估价值输入框
    By valueAmountBy = By.xpath("//input[@name='EvaluAmount']");
    //项目录入入口
    By itemEnteringBy = By.xpath("//span[text()='项目录入']");
    //籍贯输入框
    By nativePlaceBy = By.xpath("//td//input[@name='Native']");
    //职业输入框
    By professionBy = By.xpath("//td//input[@name='Profession']");
    //年龄输入框
    By ageBy = By.xpath("//td//input[@name='Age']");
    //选择审核项目
    By optionItemBy = By.xpath("//div[text()='18770636562']");
    //审核项目
    By auditBy = By.xpath("//span[text()='审核']");
    //审核通过
    By auditPass = By.xpath("//span[text()='审核通过']");

    public void addLoan(String phone,String tile,String rate,String term,String amount,String days,String valueAmount,String nativeBy,String profession,String age){
        switchToIframe(loanManageIFrameBy,"切换借款管理页面");
        click(addLoanBy,"后台借款管理页面-点击加标按钮");
        sendKeys(findUserBy,phone,"后台借款管理页面-输入用户手机号");
        keyboard(findUserBy, Keys.ARROW_DOWN,"键盘向下键");
        keyboard(findUserBy,Keys.ENTER,"键盘确定键");
        sendKeys(loanTileBy,tile,"后台借款管理页面-输入借款标题");
        sendKeys(loanRateBy,rate,"后台借款管理页面-输入年利息利率");
        sendKeys(loanTermBy,term,"后台借款管理页面-输入借款期限");
        sendKeys(loanAmountBy,amount,"后台借款管理页面-输入借款金额");
        sendKeys(bidingDaysBy,days,"后台借款管理页面-输入竞标天数");
        click(riskEvaluationBy,"后台借款管理页面-点击风控评测");
        sendKeys(valueAmountBy,valueAmount,"后台借款管理页面-输入评估价值");
        click(itemEnteringBy,"后台借款管理页面-点击项目录入");
        sendKeys(nativePlaceBy,nativeBy,"后台借款管理页面-输入籍贯");
        sendKeys(professionBy,profession,"后台借款管理页面-输入职业");
        sendKeys(ageBy,age,"后台借款管理页面-输入年龄");
        click(submitBy,"后台借款管理页面-点击提交按钮");
    }

    public void auditItem(String tile){
        for(int i=0;i<3;i++){
            click(By.xpath("//div[text()='"+tile+"']"),"后台借款管理页面-选择审核项目");
            click(auditBy,"后台借款管理页面-点击审核项目");
            click(auditPass,"后台借款管理页面-点击审核通过");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
