package com.alipay.simplehbase.client;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.log4j.Logger;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * SimpleHbaseClient的工厂类。
 * 
 * <pre>
 * 通过该工厂类的工厂方法，可以给原有的client增加以下功能。
 * simpleHbase的普通日志。
 * simpleHbase的性能日志。
 * simpleHbase的异常转换。
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: SimpleHbaseClientFactory.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class SimpleHbaseClientFactory {

    /**
     * 封装SimpleHbaseClient。
     * 
     * @param simpleHbaseClient simpleHbaseClient。
     * @return 封装后的SimpleHbaseClient。
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

        /** log。 */
        private static Logger     log       = Logger.getLogger(ClientInvocationHandler.class);

        /** 性能日志。 */
        private static Logger     digestLog = Logger.getLogger("simplehbase.digest");

        /**
         * SimpleHbaseClient。
         * */
        private SimpleHbaseClient simpleHbaseClient;

        /**
         * ClientInvocationHandler。
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
         * 构建日志字符串。
         * 
         * @param method method。
         * @param args args。
         * @param result result。
         * @param ex 异常。
         * @return 日志字符串。
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
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                sb.append("ex=" + sw + "\n");
            } else {
                sb.append("result=" + result + "\n");
            }

            sb.append("-------------invoke detail---------------\n");
            return sb.toString();
        }
    }

}
