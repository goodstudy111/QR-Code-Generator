package qrCodeGenerator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class qrCode {
	public static void main(String[] args) throws Exception {
		// ask the user for the string
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the text you want to convert into QRCode:  ");
		
		// grab the user's string
		String codeData = scanner.nextLine();
		
		/*
		 * // print the data for now
		 * System.out.println(codeData);
		*/
		
		// create the qrcode using the library
		createQrCode(codeData);
	}
	
	// create the qr code with the string passed
	public static void createQrCode(String codeData) throws Exception {
		String name = "data";
		Random random = new Random();
		int i = random.nextInt(1000);
		name = name + i;
		
		// get the bytes output
		ByteArrayOutputStream out = QRCode.from(codeData).to(ImageType.JPG).stream();
		
		// create a new file in the desktop
		File file = new File(System.getProperty("user.home") + "\\Desktop" + "\\" + name + ".jpg");
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(out.toByteArray());
		fos.flush();
		
		System.out.println("QRCode has been Created in Desktop with name: " + name);
	}
}
