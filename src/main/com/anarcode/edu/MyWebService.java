package main.com.anarcode.edu;

public class MyWebService implements IWebService {
    @Override
    public void notifyError() {
        System.out.println("Web service notified!");
    }
}
