package main.com.anarcode.edu;

import java.util.List;

public class Calculator {
    private ParserInterface parser;
    private OperationInterface operation;
    private ILogger logger;
    private IWebService webService;

    public Calculator(ParserInterface parser, OperationInterface operation, ILogger logger, IWebService webService) {
        this.parser = parser;
        this.operation = operation;
        this.logger = logger;
        this.webService = webService;
    }

    public int add(String s) {
        List<Integer> values = parser.parse(s);
        Integer operate = operation.operate(values);
        try {
            logger.write(operate.toString());
        } catch (Exception e) {
            webService.notifyError();
        }
        return operate;
    }
}
