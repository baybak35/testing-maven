package package1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logTest1 {

	public static void main(String[] args) {
		
		Logger log = LogManager.getLogger(logTest1.class.getName());
		log.debug("I am logging");
		//When each Selenium action is performed like click(), sendKeys(), getTest()
		
		log.info("Object is present");
		//When operation is successfully completed. ex: After loading page 
		
		log.debug("starting");
		
		if(0>2) {
			log.info("object is present");
		}else {
			log.error("object is not present");
		}
	}

}
