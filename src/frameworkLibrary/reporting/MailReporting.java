package frameworkLibrary.reporting;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import frameworkLibrary.Config;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailReporting extends Config {
	TestNGCustomReportListener tg = new TestNGCustomReportListener();

	public void sendMail(String s) throws Exception {

		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication(gmailUserId, gmailPassword);

					}

				});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("capillarymqa@gmail.com"));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(gmailUsersInCC));

			// Add the subject link
			message.setSubject("Automation Suite " + dateWithTime);

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setContent(s, "text/html");
			
			// Create object to add multimedia type content
						BodyPart messageBodyPart3 = new MimeBodyPart();

						// Set the body of email
						messageBodyPart3.setContent("\n <strong> Please find the attachment for complete report.For better results please download and open the file.</strong>","text/html");
						
						

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			// String filename = Dir+"/test-output/custom-report.html";

			// Create data source and pass the filename
			DataSource source = new FileDataSource(customReportFilename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
			System.out.println("File name is"+customReportFilename);

			// set the file
			messageBodyPart2.setFileName(customReportFilename);
System.out.println("File name is"+customReportFilename);
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			multipart.addBodyPart(messageBodyPart3);
			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

	public void htmlMail() throws Exception {

		StringBuilder email = new StringBuilder();
		email.append("Please find the below Mobile Automation report merchant wise \n");
		email.append("    ");

		try {
			File in = new File(customReportFilename);
			Document doc = Jsoup.parse(in, null);

			Elements tableElements = doc.select("table");

			Elements tableHeaderEles = tableElements.select("thead tr th");
			System.out.println("headers");
			for (int i = 0; i < tableHeaderEles.size(); i++) {
				System.out.println(tableHeaderEles.get(i).text());
			}
			System.out.println();

			Elements tableRowElements = tableElements.select(":not(thead) tr");
			System.out.println("Run Count is : " + super.getRunCount());
			
			
			email.append("<html><head><style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style></head><body><table >");
			email.append("<tr style=\"color:White;background-color:rgb(119, 103, 0);\"><th style=\"border: 1px solid #009;padding: .25em .5em;\">Merchant Name</th>"
							+ "<th style=\"border: 1px solid #009;padding: .25em .5em;\">Passed</th><th style=\"border: 1px solid #009;padding: .25em .5em;\">Failed</th><th style=\"border: 1px solid #009;padding: .25em .5em;\">Skipped</th><th style=\"border: 1px solid #009;padding: .25em .5em;\">Start Time </th><th style=\"border: 1px solid #009;padding: .25em .5em;\">End Time </th><th style=\"border: 1px solid #009;padding: .25em .5em;\">Execution Time<br/>(hh:mm:ss)</th></tr>");
			for (int i = 0; i < super.getRunCount() + 2; i++) {
				Element row = tableRowElements.get(i);
				System.out.println("row");
				Elements rowItems = row.select("td");
				System.out.println(rowItems.size());
				email.append("<tr>");
				for (int j = 0; j < rowItems.size() - 2; j++) {

					// email.append("<td>");
					email.append("<th style=\"border:1px solid #009;padding: .25em .5em;\">" + rowItems.get(j).text()
							+ "</th>");

					// email.append(rowItems.get(j).text());

					// email.append("</td>");

					System.out.println(rowItems.get(j).text());
					
				}
				// email.append("</th>");
				// email.append("</tr>");
				// email.append("</table></body></html>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		email.append("");
		
		sendMail(email.toString());

	}

}