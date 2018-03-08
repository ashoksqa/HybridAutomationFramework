package webApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class VisitsPage extends PublishPage { // Next Extends : QueriesPage

	private String addVisitBtn_loc = xpath
			+ "/html/body/app-root/app-visits/div/div/div/div/div/div[1]/div[2]/button[2]";
	private String okBtn_Popup_VisitsPage_loc = xpath + "/html/body/app-root/app-visits/div[1]/div[2]/div/div/div";
	private String successMsg_Popup_VisitsPage_loc = xpath + "/html/body/app-root/app-visits/div[1]/div[2]/div/p";

	private String selectSlot_AddVisit_ViitsPage_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/ul[2]/li[2]/select";

	private String speciality_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/ul[1]/li[1]";

	private String selectDoctor_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/ul[2]/li[1]";

	private String selectDate_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/ul[1]/li[2]/owl-date-time/div/div[1]/input";
	private String selectDateXpathStartValue_loc = "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/ul[1]/li[2]/owl-date-time/div/div[3]/div/div[2]/table/tbody/tr[";

	private String selectStatus_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/ul[1]/li[3]";

	private String amount_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/ul[2]/li[3]";

	private String firstName_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[2]/div[1]/ul[1]/li[1]";
	private String lastName_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[2]/div[1]/ul[2]/li[1]";
	private String email_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[2]/div[1]/ul[2]/li[3]";
	private String phoneNumber_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[2]/div[1]/ul[1]/li[3]";
	private String DOB_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[2]/div[1]/ul[2]/li[2]/owl-date-time/div/div[1]";
	private String DOB_XpathStartValue_loc = "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[2]/div[1]/ul[2]/li[2]/owl-date-time/div/div[3]/div/div[2]/table/tbody/tr[";
	private String remarks_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[2]/div[2]/ul/li";
	private String tag_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[2]/div[3]/ul/li/tag-input/div/div/tag-input-form/form/input";
	private String submitBtn_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[2]/div[4]/button[1]";

	private String slotError_loc = xpath
			+ "/html/body/app-root/app-visits/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/ul[2]/li[2]/span";

	private String visitsCalendarStartXpath_VisitsPage_loc = "/html/body/app-root/app-visits/div/div/app-dashboard/div/div[4]/owl-date-time/div/div[2]/div/div[2]/table/tbody/tr[";

	String listXpath_VisitsPage_loc = "/html/body/app-root/app-visits/div/div/div/div/div/div[2]/table[2]/tbody/tr";
	private String nameStartXpath_VisitsPage = xpath
			+ "/html/body/app-root/app-visits/div/div/div/div/div/div[2]/table[2]/tbody/tr[";

	public void click_AddVisit_VisitsPage(WebDriver driver) {
		super.click(driver,addVisitBtn_loc, waitTime);
	}

	public void okBtn_Popup_VisitsPage(WebDriver driver) {
		super.click(driver,okBtn_Popup_VisitsPage_loc, waitTime);
		super.sleep(3000);
	}

	public String getSuccessMsg_Popup_VisitsPage(WebDriver driver) {
		String successMsg = super.getTextOptional(driver,successMsg_Popup_VisitsPage_loc, waitTime);
		return successMsg;
	}

	public String slotSelection_Visits_VisitsPage(WebDriver driver) {
		super.sleep(1000);
		String slotTime = "Empty";

		super.click(driver,selectSlot_AddVisit_ViitsPage_loc, waitTime);

		int count = super.getDropDownListCount(driver,selectSlot_AddVisit_ViitsPage_loc);
		for (int slotOption = Trow + 1; slotOption <= count; slotOption++) {
			String slotOption_locator = selectSlot_AddVisit_ViitsPage_loc + "/option[" + slotOption + "]";
			boolean a = super.getAttributeValue_Boolean(driver,slotOption_locator, "disabled", waitTime);
			if (a) {
				System.out.println("Disable status is :" + a);
			} else {
				System.out.println("disable is null now - clicking now");
				slotTime = super.getAttributeValue_String(driver,slotOption_locator, "text", waitTime);
				System.out.println("Slot Time is : " + slotTime);
				super.click(driver,slotOption_locator, waitTime);
				break;
			}
		}
		return slotTime;
	}

	public String addVisit_VisitsPage(WebDriver driver,int specialityOption, int doctorOption, int statusOption,
			String amount_addVisit_VisitsPage, String firstName_addVisit_VisitsPage,
			String lastName_addVisit_VisitsPage, String emailId_addVisit_VisitsPage,
			String phoneNumber_addVisit_VisitsPage, String remarks_addVisit_VisitsPage,
			String tagName_addVisit_VisitsPage) {
		String visitDate = "";
		String slotTime = "Empty";
		int NextDate = 0;
		String NDate = "Empty";
		String NMonth = "Empty";

		super.selectDropDownValue(driver,speciality_loc, specialityOption);
		super.selectDropDownValue(driver,selectDoctor_loc, doctorOption);
		super.selectDateFromCalender(driver,selectDate_loc, selectDateXpathStartValue_loc, super.getTodayDate(),
				"owl-calendar-invalid");
		super.selectDropDownValue(driver,selectStatus_loc, statusOption);
		slotTime = this.slotSelection_Visits_VisitsPage(driver);
		super.setText_ByActions(driver,amount_loc, amount_addVisit_VisitsPage, waitTime);
		super.setText_ByActions(driver,firstName_loc, firstName_addVisit_VisitsPage, waitTime);
		super.setText_ByActions(driver,lastName_loc, lastName_addVisit_VisitsPage, waitTime);
		super.setText_ByActions(driver,email_loc, emailId_addVisit_VisitsPage, waitTime);
		super.setText_ByActions(driver,phoneNumber_loc, phoneNumber_addVisit_VisitsPage, waitTime);
		super.selectDateFromCalender(driver,DOB_loc, DOB_XpathStartValue_loc, super.getTodayDate(), "owl-calendar-invalid");
		super.setText_ByActions(driver,remarks_loc, remarks_addVisit_VisitsPage, waitTime);
		super.setText_ByActions(driver,tag_loc, tagName_addVisit_VisitsPage, waitTime);
		super.kepad_Enter_Web(driver,tag_loc, waitTime);
		super.click(driver,submitBtn_loc, waitTime);
		super.sleep(1000);
		String slotError = super.getTextOptional(driver,slotError_loc, 0).toLowerCase().replaceAll("\\s+", "");
		System.out.println("Slot error 1 is : " + slotError);
		String expectedSlotError = super.pvd("slotValidationMsg_VisitsPage").toLowerCase().replaceAll("\\s+", "");
		if (slotError.equals(expectedSlotError)) {
			super.sleep(1000);
			slotTime = this.slotSelection_Visits_VisitsPage(driver);
			super.click(driver,submitBtn_loc, waitTime);
		}
		visitDate = NMonth + super.locatorSeparator + super.getTodayDate() + super.locatorSeparator + slotTime;

		slotError = super.getTextOptional(driver,slotError_loc, 0).toLowerCase().replaceAll("\\s+", "");
		System.out.println("Slot error 2 is : " + slotError);
		if (slotError.equals(expectedSlotError)) {
			for (int i = 1; i <= 15; i++) {
				System.out.println("loop i is " + i);
				int d = super.convertStrToInt(super.getTodayDate());
				NextDate = d + i;

				if (NextDate > super.currentMonthDays()) {
					NextDate = NextDate - super.currentMonthDays();
					NMonth = "NextMonth";
					NDate = super.convertIntToStr(NextDate);
					System.out.println("NDate" + NDate);
				} else {
					NDate = super.convertIntToStr(NextDate);
					System.out.println("NDate" + NDate);
				}
				super.selectDateFromCalender(driver,selectDate_loc, selectDateXpathStartValue_loc, NDate,
						"owl-calendar-invalid");
				super.sleep(1000);
				slotTime = this.slotSelection_Visits_VisitsPage(driver);
				super.click(driver,submitBtn_loc, waitTime);
				slotError = super.getTextOptional(driver,slotError_loc, 0).toLowerCase().replaceAll("\\s+", "");
				System.out.println("Slot error 3 is : " + slotError);
				if (slotError.equals(expectedSlotError)) {
					System.out.println("Invalid Slot Selected");
				} else {
					visitDate = NMonth + super.locatorSeparator + NDate + super.locatorSeparator + slotTime;
					break;
				}
			}
		}
		System.out.println("visitDate is :" + visitDate);
		return visitDate;
	}

	public void selectDateFromVisitsCalender(WebDriver driver,String NextMonth_Y_N, String dateToBeSeected,
			String invalidDate_OR_Outfocused_ClassNameContains) {
		String outputDateValue = null;
		String clsName = null;
		if (NextMonth_Y_N.equals("N")) {
			outerloop: for (int i = 1; i <= 6; i++) {
				for (int j = 1; j <= 7; j++) {
					String loc = xpath + visitsCalendarStartXpath_VisitsPage_loc + i + "]/td[" + j + "]";
					try {
						outputDateValue = this.getAttributeValue_String(driver,loc, "innerText", waitTime).split("\n")[0];
						clsName = this.getAttributeValue_String(driver,loc, "className", waitTime);
					} catch (Exception e) {
						System.out.println(e);
					}
					if (clsName.contains(invalidDate_OR_Outfocused_ClassNameContains)) {
						System.out.println("Invalid Date");
					} else if (outputDateValue.equals(dateToBeSeected)) {
						this.click(driver,loc, waitTime);
						break outerloop;
					}
				}
			}
		} else {

			outerloop: for (int i = 1; i <= 6; i++) {
				for (int j = 1; j <= 7; j++) {
					String loc = xpath + visitsCalendarStartXpath_VisitsPage_loc + i + "]/td[" + j + "]";
					try {
						outputDateValue = this.getAttributeValue_String(driver,loc, "innerText", waitTime).split("\n")[0];
						clsName = this.getAttributeValue_String(driver,loc, "className", waitTime);
					} catch (Exception e) {
						System.out.println(e);
					}
					if (outputDateValue.equals(dateToBeSeected)
							&& clsName.contains(invalidDate_OR_Outfocused_ClassNameContains)) {
						this.click(driver,loc, waitTime);
						break outerloop;
					}
				}
			}

		}
		super.sleep(3000);
	}

	public void verifyData_BySelectingDateInCalender_VisitsPage(WebDriver driver,String methodName, String visit_Month_Date_Time,
			String Name, String phoneNumber, String doctorName, String visitStatus, String amount) throws IOException {

		String month = visit_Month_Date_Time.split(locatorSeparator)[0];
		String vDate = visit_Month_Date_Time.split(locatorSeparator)[1];
		String slotTime = visit_Month_Date_Time.split(locatorSeparator)[2];
		if (month.equals("NextMonth")) {
			this.selectDateFromVisitsCalender(driver,"Y", vDate, "owl-calendar-outFocus");
		} else {
			this.selectDateFromVisitsCalender(driver,"N", vDate, "owl-calendar-outFocus");
		}
		if (super.listCount(driver,listXpath_VisitsPage_loc) > 1) {

			for (int i = 1; i <= 50; i++) {
				String nameXpath = nameStartXpath_VisitsPage + i + "]/td[2]";

				if (super.getText(driver,nameXpath, waitTime).equals(Name)) {
					String locator = xpath
							+ "/html/body/app-root/app-visits/div/div/div/div/div/div[2]/table[2]/tbody/tr[" + i
							+ "]/td[";
					super.assertEquals_Text(driver,methodName, "Name", super.getTextOptional(driver,locator + 2 + "]", waitTime),
							Name);
					super.assertEquals_Text(driver,methodName, "PhoneNumber",
							super.getTextOptional(driver,locator + 3 + "]", waitTime), phoneNumber);
					super.assertEquals_Text(driver,methodName, "DoctorName",
							super.getTextOptional(driver,locator + 4 + "]", waitTime), doctorName);
					super.assertEquals_Text(driver,methodName, "SlotTime", super.getText(driver,locator + 5 + "]", waitTime),
							slotTime.replaceAll("\\s+", ""));
					super.assertEquals_Text(driver,methodName, "VisitStatus", super.getText(driver,locator + 6 + "]", waitTime),
							visitStatus);
					super.assertEquals_Text(driver,methodName, "Amount", super.getText(driver,locator + 7 + "]", waitTime),
							"Rs." + amount + ".00");
					break;

				}
			}

		} else {
			String locator = xpath + "/html/body/app-root/app-visits/div/div/div/div/div/div[2]/table[2]/tbody/tr/td[";
			super.assertEquals_Text(driver,methodName, "Name", super.getTextOptional(driver,locator + 2 + "]", waitTime), Name);
			super.assertEquals_Text(driver,methodName, "PhoneNumber", super.getTextOptional(driver,locator + 3 + "]", waitTime),
					phoneNumber_addVisit_HomePage);
			super.assertEquals_Text(driver,methodName, "DoctorName", super.getTextOptional(driver,locator + 4 + "]", waitTime),
					doctorName);
			super.assertEquals_Text(driver,methodName, "SlotTime", super.getText(driver,locator + 5 + "]", waitTime),
					slotTime.replaceAll("\\s+", ""));
			super.assertEquals_Text(driver,methodName, "VisitStatus", super.getText(driver,locator + 6 + "]", waitTime), visitStatus);
			super.assertEquals_Text(driver,methodName, "Amount", super.getText(driver,locator + 7 + "]", waitTime),
					"Rs." + amount + ".00");
		}

	}

}
