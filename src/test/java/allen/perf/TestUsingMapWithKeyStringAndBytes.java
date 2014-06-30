package allen.perf;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

/**
 * @author xinzhi
 */
public class TestUsingMapWithKeyStringAndBytes {

    private static Log                 log       = LogFactory
                                                         .getLog(TestUsingMapWithKeyStringAndBytes.class);

    private static int                 keySize   = 50;
    private static int                 keyLength = 20;
    private static String[]            stringKeyList;
    private static byte[][]            bytesKeyList;
    private static Map<String, String> stringMap = new HashMap<String, String>();

    private static Map<byte[], byte[]> bytesMap  = new TreeMap<byte[], byte[]>(
                                                         Bytes.BYTES_COMPARATOR);
    static {
        stringKeyList = new String[keySize];
        bytesKeyList = new byte[keySize][];

        Random r = new Random();
        for (int i = 0; i < keySize; i++) {

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < keyLength; j++) {
                char c = (char) ('a' + r.nextInt(26));
                sb.append(c);
            }

            String key = sb.toString();
            stringKeyList[i] = key;
            bytesKeyList[i] = Bytes.toBytes(key);

            stringMap.put(key, key);
            bytesMap.put(Bytes.toBytes(key), Bytes.toBytes(key));
        }

    }

    private int[] getTestIndexForKey(int loop) {
        Random r = new Random();
        int[] indices = new int[loop];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = r.nextInt(keyLength);
        }
        return indices;
    }

    @Test
    public void usingMapWithKeyStringAndBytes() {
        Object obj = null;
        int loop = 1000000;
        int[] indices = getTestIndexForKey(loop);

        StringBuilder sb = new StringBuilder();
        sb.append("loop=" + loop + " ");

        long start = System.currentTimeMillis();
        for (int i = 0; i < indices.length; i++) {
            byte[] bytesKey = bytesKeyList[indices[i]];
            String stringKey = Bytes.toString(bytesKey);
            obj = stringMap.get(stringKey);
        }
        long end = System.currentTimeMillis();
        long consumeTime = end - start;
        sb.append("get from string map avgtime=" + consumeTime * 1.0 / loop
                + " ");

        start = System.currentTimeMillis();
        for (int i = 0; i < indices.length; i++) {
            byte[] bytesKey = bytesKeyList[indices[i]];
            obj = bytesMap.get(bytesKey);
        }
        end = System.currentTimeMillis();
        consumeTime = end - start;
        sb.append("get from bytes map avgtime=" + consumeTime * 1.0 / loop
                + " ");

        log.info(sb);

        log.info(obj);

    }

}
