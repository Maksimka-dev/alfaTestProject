package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static configs.ConfigReader.CONF_CAP;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int MAX_RETRY = Integer.parseInt(CONF_CAP.retryCount()) - 1;

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY) {
            count++;
            return true;
        }
        return false;
    }
}
