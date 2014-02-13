package com.alipay.simplehbase.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.log4j.Logger;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.ExceptionUtil;

/**
 * SimpleHbaseClient's factory.
 * 
 * <pre>
 * Using method of this class, we can add following function to SimpleHbaseClient.
 * SimpleHbase's log.
 * SimpleHbase's performance digest log.
 * SimpleHbase's exception transform.
 * </pre>
 * 
 * @author xinzhi
 * */
public class SimpleHbaseClientFactory {

    /**
     * Encapsulate SimpleHbaseClient.
     * 
     * @param simpleHbaseClient simpleHbaseClient.
     * @return encapsulated SimpleHbaseClient.
     * */
    public static SimpleHbaseClient getSimpleHbaseClient(
            SimpleHbaseClient simpleHbaseClient) {
        Object proxy = Proxy.newProxyInstance(
                SimpleHbaseClient.class.getClassLoader(),
                new Class[] { SimpleHbaseClient.class },
                new ClientInvocationHandler(simpleHbaseClient));
        return (SimpleHbaseClient) proxy;
    }

    private static class ClientInvocationHandler implements InvocationHandler {
        /** log. */
        private static Logger     log       = Logger.getLogger(ClientInvocationHandler.class);

        /** performance digest log. */
        private static Logger     digestLog = Logger.getLogger("simplehbase.digest");

        /**
         * SimpleHbaseClient.
         * */
        private SimpleHbaseClient simpleHbaseClient;

        /**
         * ClientInvocationHandler.
         * */
        public ClientInvocationHandler(SimpleHbaseClient simpleHbaseClient) {
            this.simpleHbaseClient = simpleHbaseClient;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {

            Object result = null;
            Exception ex = null;

            long start = System.currentTimeMillis();
            try {
                result = method.invoke(simpleHbaseClient, args);
            } catch (Exception e) {
                ex = e;
            } finally {
                long end = System.currentTimeMillis();
                digestLog.info(simpleHbaseClient.getClass().getName() + ","
                        + method.getName() + "," + (ex == null ? "Y" : "N")
                        + "," + (end - start));
            }

            if (log.isDebugEnabled()) {
                log.debug(buildLogInfo(method, args, result, ex));
            }

            if (ex != null) {
                if (ex instanceof SimpleHBaseException) {
                    throw ex;
                } else {
                    throw new SimpleHBaseException(ex);
                }
            }

            return result;
        }

        /**
         * Construct log string.
         * 
         * @param method method.
         * @param args args.
         * @param result result.
         * @param ex exception.
         * @return log string.
         * */
        private String buildLogInfo(Method method, Object[] args,
                Object result, Exception ex) {
            StringBuilder sb = new StringBuilder();

            sb.append("invoke detail.\n");
            sb.append("-------------invoke detail---------------\n");
            sb.append("simpleHbaseClient=" + simpleHbaseClient + "\n");
            sb.append("method=" + method + "\n");

            if (args == null) {
                sb.append("args=null\n");
            } else {
                sb.append("args size=" + args.length + "\n");
                for (int i = 0; i < args.length; i++) {
                    sb.append("args[" + i + "]=" + args[i] + "\n");
                }
            }

            if (ex != null) {
                sb.append("ex=" + ExceptionUtil.getExceptionMsg(ex) + "\n");
            } else {
                sb.append("result=" + result + "\n");
            }

            sb.append("-------------invoke detail---------------\n");
            return sb.toString();
        }
    }

}
