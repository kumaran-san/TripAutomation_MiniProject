//Main method of the Project

package TripAutomationProject;
public class MiniProject 
{

    public static void main(String[] args) throws InterruptedException 
    {
        MiniProjectUtilities miniProject = new MiniProjectUtilities();
//      Invoking the methods from the MiniProjectUtilities
        miniProject.setupDriver();
        miniProject.navigateToOffersLink();
        miniProject.validatePageTitle();
        miniProject.validateBannerText();
        miniProject.captureScreenshot();
        miniProject.navigateToHolidayLink();
        miniProject.searchButton();
        miniProject.listHolidayPackages();
        miniProject.quitBrowser();
}
}