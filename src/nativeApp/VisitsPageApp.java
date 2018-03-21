package nativeApp;

import java.io.IOException;

import io.appium.java_client.AppiumDriver;

public class VisitsPageApp extends PublishPageApp { // Next Extends : QueriesPageApp

		protected String firstName_AVHA = "AfnAVHA_" + super.randomString(3);
		protected String lastName_AVHA = "LnAVHA_" + super.randomString(3);
		protected String emailId_AVHA = "EmailAVHA_" + super.randomString(3) + "@" + super.randomString(3)
				+ super.randomString(3);
		protected String amount_AVHA = super.randomNumString(3);
		protected String phoneNumber_AVHA = "4" + super.randomNumString(8);
		protected String city_AVHA = "CityAVHA_" + super.randomString(6);
		protected String area_AVHA = "AreaAVHA_" + super.randomString(6);
		protected String remarks_AVHA = "RemarksAVHA_" + super.randomString(4);
		protected String tagName_AVHA = "TagAVHA_" + super.randomString(4);
	
	
	public String addVisit_LeadsPageApp(AppiumDriver<?> driver, String testName, int specialityOption, int doctorOption,
			int statusOption, String amount_addVisit, String firstName_addVisit, String lastName_addVisit,
			String gender_M_F, String phoneNumber_addVisit, String emailId_addVisit, String remarks_addVisit)
			throws IOException {
		String NMonth = "Empty";
		String slotTime = "Empty";
		String slotDate = "Empty";
		this.click_AddVisitFromFooter_HomePageApp(driver);
		super.sleep(2000);
		super.selectDropDownValueApp(driver, id + "doctor_speciality", locator_iOS, specialityOption);
		super.selectDropDownValueApp(driver, id + "select_doctor", locator_iOS, doctorOption);

		super.selectDateFromCalendarApp(driver, id + "appointment_date", locator_iOS, "",
				super.convertStrToInt(super.getTodayDate()));
		for (int i = 1; i <= 15; i++) {
			slotTime = slotSelection_VisitsPageApp(driver);
			if (slotTime.length() <= 0) {
				int d = super.convertStrToInt(super.getTodayDate()) + i;
				if (d > super.currentMonthDays()) {
					NMonth = "NextMonth";
					super.selectDateFromCalendarApp(driver, id + "appointment_date", locator_iOS, "N", d);
				} else {
					super.selectDateFromCalendarApp(driver, id + "appointment_date", locator_iOS, "", d);
				}

			} else {
				slotDate = super.getTextOptional(driver, id + "appointment_date", locator_iOS, waitTime);
				break;

			}

		}

		super.selectDropDownValueApp(driver, id + "appointment_status", locator_iOS, statusOption);
		super.setText(driver, id + "amount_paid", locator_iOS, amount_addVisit, waitTime);
		super.keypadNext(driver);
		// super.scrollDown_Mobile(driver, 4);
		super.setText(driver, id + "appointment_firstname", locator_iOS, firstName_addVisit, waitTime);
		super.keypadNext(driver);
		super.setText(driver, id + "appointment_lastname", locator_iOS, lastName_addVisit, waitTime);
		super.keypadClose(driver);
		super.scrollDown_Mobile(driver, 4);
		super.setText(driver, id + "appointment_phone", locator_iOS, phoneNumber_addVisit, waitTime);
		super.keypadNext(driver);
		super.setText(driver, id + "appointment_email", locator_iOS, emailId_addVisit, waitTime);
		super.keypadNext(driver);
		super.setText(driver, id + "appointment_add_remarks", locator_iOS, remarks_addVisit, waitTime);
		super.keypadClose(driver);
		if (gender_M_F.equals("M") || gender_M_F.equals("Male")) {
			super.click(driver, id + "appointmentMale", locator_iOS, waitTime);
		} else if (gender_M_F.equals("F") || gender_M_F.equals("Female")) {
			super.click(driver, id + "appointmentFemale", locator_iOS, waitTime);
		}
		super.selectDateFromCalendarApp(driver, id + "appointment_dob", locator_iOS, " ",
				super.convertStrToInt(super.getTodayDate()));
		super.click(driver, id + "add_appointment", locator_iOS, waitTime);
		super.assertEquals_Text(driver, testName, "Appoint Booked Succesfully",
				super.getTextOptional(driver, id + "snackbar_text", locator_iOS, waitTime), "Appointment Booked..!");

		String visitDate = NMonth + super.locatorSeparator
				+ super.convertIntToStr(super.convertStrToInt(slotDate.substring(0, 2))) + super.locatorSeparator
				+ slotTime;
		System.out.println("slotDateAndTime : " + visitDate);
		return visitDate;
	}

	public String slotSelection_VisitsPageApp(AppiumDriver<?> driver) throws IOException {
		super.sleep(1000);
		String slotTime = "Empty";
		String AndLoc = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView";

		super.click(driver, id + "appointment_time", locator_iOS, waitTime);
		int size = super.getTextOptional(driver, AndLoc, locator_iOS, 4).length();
		if (super.getTextOptional(driver, id + "title_txt", locator_iOS, 4).equals("SELECT TIME")) {
			if (size <= 0) {
				super.click(driver, id + "back_button", locator_iOS, waitTime);
			}
		}
		if (super.getTextOptional(driver, id + "title_txt", locator_iOS, 4).equals("SELECT TIME") && size > 0) {
			for (int i = 1; i <= 10; i++) {
				String AndroidSlot_loc = xpath
						+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout["
						+ i + "]/android.widget.TextView";
				String slotName = super.getTextOptional(driver, AndroidSlot_loc, locator_iOS, waitTime);
				System.out.println("Slot Name is : " + slotName);

				String t = "";
				int tm = super.convertStrToInt(slotName.split(":")[0]);
				int mt = super.convertStrToInt(slotName.split(":")[1].substring(0, 2));
				String amPM = slotName.split(":")[1].substring(2, 4);

				if (amPM.equals("PM") && tm == 10 && mt >= 45) {
					t = "OutOfTime";
				}

				if (slotName.contains("Available")) {
					super.click(driver, AndroidSlot_loc, locator_iOS, waitTime);
					break;

				} else if (slotName.isEmpty() || t.equals("OutOfTime")) {
					super.click(driver, id + "back_button", locator_iOS, waitTime);
					break;
				} else {
					System.out.println("Slot Already Booked OR Not Available : " + slotName);
				}

				if (i % 7 == 0) {
					i = 1;
					super.scrollDown_Mobile(driver, 2);
				}

			}
		}

		slotTime = super.getTextOptional(driver, id + "appointment_time", locator_iOS, waitTime);

		return slotTime;
	}
}
