package test.com.anarcode.edu;

import main.com.anarcode.edu.*;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void addingTwoNumbersWritesTheNumbersToALog() {
        MockLogger mockLogger = new MockLogger();

        Calculator calculator = new Calculator(new MyParser(), new MyAdder(), mockLogger, new MockWebService());

        calculator.add("2,3");
        assertEquals("5", mockLogger.getLastLog());
    }

    @Test
    public void throwingAnErrorInLoggingCallsWebService() {
        NauseousLogger errorLogger = new NauseousLogger();

        MockWebService webService = new MockWebService();
        Calculator calculator = new Calculator(new MyParser(), new MyAdder(), errorLogger, webService);

        calculator.add("2,3");
        assertEquals(true, webService.wasNotified());

    }

    @Test
    public void fileLoggerWrite_writesToFile() {
        FileLogger fileLogger = new FileLogger("output.txt");

        fileLogger.write("Output");

        try {
            BufferedReader br = new BufferedReader(new FileReader("output.txt"));
            assertEquals("Output", br.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class MockLogger implements ILogger {


        private String lastLog;

        public String getLastLog() {
            return lastLog;
        }

        @Override
        public void write(String s) {
            lastLog = s;
        }
    }

    private class NauseousLogger implements ILogger{


        @Override
        public void write(String s) throws Exception {
            throw new Exception();
        }
    }

    private class MockWebService implements IWebService{

        private boolean notified;

        public MockWebService() {
            this.notified = false;
        }

        @Override
        public void notifyError() {
            this.notified = true;
        }

        public boolean wasNotified() {
            return notified;
        }
    }
}
