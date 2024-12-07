import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Open Browser and navigate
WebUI.openBrowser('')
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
WebUI.maximizeWindow()

// Wait for the Login Page to Load and input data + login
WebUI.waitForElementVisible(findTestObject('Page_Login/input_Username'), 10)
WebUI.setText(findTestObject('Page_Login/input_Username'), 'Admin')
WebUI.setText(findTestObject('Page_Login/input_Password'), 'admin123')
WebUI.click(findTestObject('Page_Login/button_Login'))

// Validate Successful Login
WebUI.waitForElementVisible(findTestObject('Page_Dashboard/header_Dashboard'), 10)
boolean isDashboardVisible = WebUI.verifyElementPresent(findTestObject('Page_Dashboard/header_Dashboard'), 10, FailureHandling.STOP_ON_FAILURE)
if (isDashboardVisible) {
    WebUI.comment('Login successful. Dashboard is visible.')
} else {
    WebUI.comment('Login failed. Dashboard is not visible.')
}

// Close Browser
WebUI.closeBrowser()