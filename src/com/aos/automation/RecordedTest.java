package com.aos.automation;

import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;

public class RecordedTest extends UnitTestClassBase {

    public RecordedTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new RecordedTest();
        globalSetup(RecordedTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException, ReportException { 

        Browser browser = BrowserFactory.launch(BrowserType.EDGE_CHROMIUM);

        browser.navigate("https://www.advantageonlineshopping.com/#/category/Tablets/3");

        Link userMenuLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("My account My orders Sign out ")
                .tagName("A").build());
        userMenuLink.click();

        EditField usernameEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("username")
                .tagName("INPUT")
                .type("text").build());
        usernameEditField.setValue("test");

        WebElement passwordWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .innerText("Password")
                .tagName("LABEL").build());
        passwordWebElement.click();

        EditField passwordEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("password")
                .tagName("INPUT")
                .type("password").build());
        passwordEditField.setSecure("664d3cb861fc3124e4c337ff3868");

        Button signInBtnButton = browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("button")
                .name("SIGN IN")
                .tagName("BUTTON").build());
        signInBtnButton.click();

        WebElement signInResultMessageWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("LABEL")
                .innerText("Incorrect user name or password.").build());
        com.hp.lft.report.Reporter.startReportingContext("Validate the properties of signInResultMessage", com.hp.lft.report.ReportContextInfo.verificationMode());
        Verify.areEqual("LABEL", signInResultMessageWebElement.getTagName(), "Verification", "Verify property: tagName");
        Verify.areEqual("Incorrect user name or password.", signInResultMessageWebElement.getInnerText(), "Verification", "Verify property: innerText");
        com.hp.lft.report.Reporter.endReportingContext();

    }

}