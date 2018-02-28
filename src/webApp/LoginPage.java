package webApp;

public class LoginPage extends DataPage { // Next Extends : HomePage

	protected String large_BlogContent = "Blogging is the great Internet equalizer. Anyone can opine, dish, complain, and philosophize free of charge, but the true test is whether your blog gets read. Many physicians have discovered that blogging is a great way to build community with others in healthcare, share their opinions and successes, and vent (without using patient names, mind you). Some of them have drawn a crowd of readers with great writing, stimulating discussions, or winning personalities. We read lots of physician bloggers and think you should, too. Here are 9 stellar ones to add to your blog roll.\r\n"
			+ "\r\n" + "KevinMd\r\n" + "http://www.kevinmd.com\r\n" + "\r\n"
			+ "Dubbed \"social media's leading physician voice,\" the Medpage Today-sponsored brainchild of physician Kevin Pho is one of the most beloved health blogs in cyberspace. On a daily basis, Pho and his doctor peers load up KevinMd with smart, opinionated takes on some of the biggest healthcare issues affecting patients and the medical community.\r\n"
			+ "\r\n" + "Medinnovation\r\n" + "http://medinnovationblog.blogspot.com/\r\n" + "\r\n"
			+ "Richard Reece, a pathologist, editor, author, and speaker, frequently blogs about medical innovations and hot healthcare issues such as Medicare reform and ACOs vs. HMOs. We find the blog stays true to its subtitle: \"Where health reform, medical innovation, and physician practices meet.\"\r\n"
			+ "\r\n" + "Dr. David's Blog: Musings of a Pediatric Oncologist\r\n"
			+ "http://doctordavidsblog.blogspot.com/\r\n" + "\r\n"
			+ "David Loeb, also known as \"Doctor David,\" uses his visually appealing blog space for informal postings on pediatric oncology, cancer research, cancer treatments, and breaking medical news.\r\n"
			+ "\r\n" + "Family Webicine\r\n" + "http://blogs.webmd.com/all-ears/\r\n" + "\r\n"
			+ "Rod Moser, a North Carolina-based primary-care physician assistant with more than 35 years of clinical experience in adult and pediatric health, runs this blog full of lively posts on topics such as \"medical marijuana and teenagers\" and medical consultations.\r\n"
			+ "\r\n" + "Dr. Leslie Greenberg\r\n" + "http://drlesliegreenberg.com\r\n" + "\r\n"
			+ "Looking for a second opinion? Family physician Leslie Greenberg, of Wichita, Kan., dishes advice on everything from coping with a hoarse voice to bone density to whether you need the chicken pox vaccine.\r\n"
			+ "\r\n" + "db's Medical Rants\r\n" + "http://www.medrants.com/\r\n" + "\r\n"
			+ "Robert M. Centor, who notes that \"db\" stands both for Dr. Bob and \"da boss,\" is an academic general internist at the Alabama School of Medicine and the associate dean for the Huntsville Regional Medical Campus of UASOM. He uses his off-the-cuff, oftentimes funny doctor's blog as a sounding board for ethical debates and daily musings.\r\n"
			+ "\r\n" + "MomMD\r\n" + "http://www.mommd.com/blogs/\r\n" + "\r\n"
			+ "This site dedicated to \"supporting women in medicine\" offers practical advice on health- and career-related issues like \"taking the pulse of your medical practice,\" as well as discussions of issues women docs face, such as family planning and career choices.\r\n"
			+ "\r\n" + "The Doctor Weighs In\r\n" + "http://www.thedoctorweighsin.com/\r\n" + "\r\n"
			+ "True to its name, this blog is loaded with long, meaty postings by physicians and medical students, who weigh in on clinical and nonclinical issues. The blog, founded by internist and emergency physician Patricia Salber, features everything from personal accounts of patients struggling though cancer to the long-term impact of healthcare policies.\r\n"
			+ "\r\n" + "Dr. Wes\r\n" + "http://drwes.blogspot.com/\r\n" + "\r\n"
			+ "Heart doc Westby G. Fisher offers readers \"musings from the life of an internist, cardiologist, and cardiac electrophysiologist.\" And if you like reading long, opinionated posts, you'll definitely get more than a simple musing here, with detailed takes on everything from Obamacare to pacemakers.\r\n"
			+ "\r\n"
			+ "Be sure to check out Physicians Practice's own physician bloggers on our blog Practice Notes, www.physicianspractice.com/blog.\r\n"
			+ "\r\n"
			+ "Marisa Torrieri is associate editor for Physicians Practice. She can be reached at marisa.torrieri@ubm.com.\r\n"
			+ "\r\n" + "This article originally appeared in the April 2011 issue of Physicians Practice.\r\n" + "";
	protected String doctorFullName = "Dr Ramesh Ramesh";

	public void openSiteUrl() {
		String r=super.pvd("runIn");
		super.getPage("siteUrl"+r);

	}

	public String login(String userId, String password) {
		String uid = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[1]/div[2]/input";
		String pwd = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[2]/div[2]/input";
		String submitBtn = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[3]/button";
		super.setText(uid, userId, waitTime);
		super.setText(pwd, password, waitTime);
		super.click(submitBtn, waitTime);
		super.sleep(9000);
		doctorFullName = super.getText(xpath + "/html/body/app-root/app-home/div/div/div/app-header/div/label",
				waitTime).substring(6);
		System.out.println("Doctor Full Name Is :" + doctorFullName);
		return doctorFullName;
	}

	// --------Reusable Methods ------------//

}
