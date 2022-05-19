package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotClass {
	
public static Robot rb;
public static StringSelection filepath;

public static void fileUpload_RobotClass() throws AWTException, InterruptedException {
	rb = new Robot();
	filepath = new StringSelection("C:\\Users\\Admin\\git\\FinalProjectRepository\\com.supermarketProject\\src\\main\\resources\\button.jpg");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	rb.keyPress(KeyEvent.VK_CONTROL);
	Thread.sleep(3000);
	rb.keyPress(KeyEvent.VK_V);
	rb.keyRelease(KeyEvent.VK_CONTROL);
	Thread.sleep(3000);
	rb.keyRelease(KeyEvent.VK_V);
	rb.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	rb.keyRelease(KeyEvent.VK_ENTER);
}
}
