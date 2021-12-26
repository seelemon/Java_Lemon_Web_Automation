package day05;

import org.apache.log4j.Logger;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/24 9:28
 */
public class LogTest {

    public static Logger log = Logger.getLogger(LogTest.class);
    public static void main(String[] args) {
        log.info("what a pity!");
    }
}
