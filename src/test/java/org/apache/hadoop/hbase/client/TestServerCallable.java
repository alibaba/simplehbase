package org.apache.hadoop.hbase.client;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.apache.hadoop.hbase.HConstants;
import org.junit.Test;

/**
 * @author xinzhi.zhang
 * */
public class TestServerCallable {
    protected int  callTimeout;
    protected long startTime, endTime;
    final long     pause      = 1000;
    final int      numRetries = 10;

    public void beforeCall() {
        this.startTime = System.currentTimeMillis();
    }

    public void afterCall() {
        this.endTime = System.currentTimeMillis();
    }

    public void shouldRetry(Throwable throwable) throws IOException {
        if (this.callTimeout != HConstants.DEFAULT_HBASE_CLIENT_OPERATION_TIMEOUT)
            if (throwable instanceof SocketTimeoutException
                    || (this.endTime - this.startTime > this.callTimeout)) {
                throw new RuntimeException();
            } else {
                this.callTimeout = ((int) (this.endTime - this.startTime));
            }
    }

    public String withRetries() throws IOException, RuntimeException {

        for (int tries = 0; tries < numRetries; tries++) {
            try {
                printTime("before beforeCall");
                beforeCall();
                printTime("after beforeCall");

                return call();
            } catch (Throwable t) {
                printTime("before shouldRetry");
                shouldRetry(t);
                printTime("after shouldRetry");
                if (tries == numRetries - 1) {
                    throw new RuntimeException(tries + "");
                }
            } finally {
                printTime("before afterCall");
                afterCall();
                printTime("after afterCall");
            }
            try {
                Thread.sleep(ConnectionUtils.getPauseTime(pause, tries));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException("Giving up after tries=" + tries, e);
            }
        }
        return null;
    }

    private String call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //ignore.
        }
        throw new RuntimeException();
    }

    private void printTime(String msg) {
        System.out.println(msg + "\ncallTimeout=" + callTimeout
                + "\nstartTime=" + startTime + "\nendTime=" + endTime
                + "\nthis.endTime - this.startTime ="
                + (this.endTime - this.startTime) + "\n");
    }

    @Test(expected = RuntimeException.class)
    public void test() throws Exception {
        TestServerCallable testServerCallable = new TestServerCallable();
        testServerCallable.callTimeout = 5000;
        testServerCallable.withRetries();
    }
}
