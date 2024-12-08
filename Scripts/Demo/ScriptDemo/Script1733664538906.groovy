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

// Open Browser and Navigate to URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

// Input Credentials
WebUI.setText(findTestObject('Page_OrangeHRM/input_Username_username'), 'Admin')
WebUI.setEncryptedText(findTestObject('Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')

// Click Login Button
WebUI.click(findTestObject('Page_OrangeHRM/button_Login'))

// Wait for Dashboard to Load and Verify Login
try {
    WebUI.waitForElementVisible(findTestObject('Page_OrangeHRM/label_Dashboard'), 10, FailureHandling.STOP_ON_FAILURE)
    boolean isDashboardPresent = WebUI.verifyTextPresent('Dashboard', false, FailureHandling.CONTINUE_ON_FAILURE)
    
    if (isDashboardPresent) {
        WebUI.comment('Login successful. Dashboard is displayed.')
    } else {
        WebUI.comment('Login failed. Dashboard is not displayed.')
    }
} catch (Exception e) {
    WebUI.comment("Error during login verification: " + e.getMessage())
}

// Close Browser
WebUI.closeBrowser()