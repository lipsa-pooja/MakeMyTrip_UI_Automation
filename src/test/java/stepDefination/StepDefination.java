package stepDefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.org.driverFactory.DriverFactory;
import com.org.pages.BookingPage;
import com.org.pages.HomePage;
import com.org.pages.SearchResultPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/***
 * Required Step Defination Package.
 * @author lipsa
 *
 */

public class StepDefination {
	HomePage homepage = new HomePage(DriverFactory.getDriver());
	SearchResultPage searchResultpage;
	BookingPage bookingpage;

	@Given("Login to url  {string}")
	public void login_to_url(String url) {
		homepage.lauchAppUrl(url);
	}

	@Given("click on Login or CreateAccount Btn")
	public void click_on_login_or_create_account_btn() {
		homepage.clickOnLoginAccountBtn();
	}

	@Given("login to the application")
	public void enter_user_name_and_pass_word(DataTable dataTable) {

		List<Map<String, String>> userList = dataTable.asMaps();
		String username = userList.get(0).get("username");
		String password = userList.get(0).get("password");

		homepage.loginToHomepage(username, password);
	}

	@When("click on {string} radiobutton")
	public void click_on_round_trip_radiobutton(String roundtripbtn) {
		homepage.clickOnRoundTripBtn(roundtripbtn);
	}

	@When("Enter Flight from {string} to {string}")
	public void enter_flight_from_to(String fromcity, String tocity) {
		homepage.enterFlightFromAndTo(fromcity, tocity);
	}

	@When("enter return date as {string}")
	@When("enter depature date as {string}")
	public void enter_date_as(String reqDate) {
		homepage.SelectFromAndToDate(reqDate);
	}

	@When("enter  adult as {string} and  enter childern as {string}")
	public void enter_adult_and_childern_info(String noOfAdult, String noOfChile) {
		homepage.SelectTravellerInfo(noOfAdult, noOfChile);
	}

	@When("click on apply button")
	public void click_on_apply_button() {
		homepage.travellerApplyBtn();
	}

	@Then("click on search button")
	public void click_on_search_button() {
		searchResultpage = homepage.clickOnSearchBtn();
	}

	@Then("Verify result page appeared with Flight details from {string} to {string}")
	public void verify_result_page_appeared_with_flight_details_from_to(String fromCity, String toCity) {
		Assert.assertTrue("Required Header in Search Page is not appearing correctly.",
				searchResultpage.validateSearchResultHeader(fromCity, toCity));
	}

	@When("Select the Popular Filters option as {string}")
	public void select_the_popular_filters_option_as(String reqOption) {
		searchResultpage.selectRequiredFilterOption(reqOption);
	}

	@When("Click on the Book Now option")
	public void click_on_the_book_now_option() {
		searchResultpage.clickOnBookNowBtn();
	}

	@Then("Verify Fare Details page appeared")
	public void verify_fare_details_page_appeared() {
		Assert.assertTrue("Required fare details screen is not appearing",
				searchResultpage.validateFareDetailsSection());
	}

	@When("Click on the Continue button on Fare details screen")
	public void click_on_the_continue_button_on_fare_details_screen() {
		bookingpage = searchResultpage.clickOnContinueBtn();
	}

	@Then("Verify Review your booking page appeared in different tab")
	public void verify_review_your_booking_page_appeared_in_different_tab() {
		Assert.assertTrue("Required Reveiw Booking page is not appearing on New Tab",
				bookingpage.verifyBookPageOpenInNewtab());
	}

	@Then("Fare summary section appeared on the page")
	public void fare_summary_section_appeared_on_the_page() {
		Assert.assertTrue("Required Fare summary section is not appearing on Booking page",
				bookingpage.validateFareSummarySection());
	}

}
