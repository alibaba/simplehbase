package com.alipay.simplehbase.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.hql.HBaseQuery;
import com.alipay.simplehbase.hql.HQLNodeParser;
import com.alipay.simplehbase.util.StringUtil;
import com.alipay.simplehbase.util.XmlUtil;

/**
 * HBaseTableConfig的配置解析器。
 * 
 * @author xinzhi
 * @version $Id: HBaseTableConfigParser.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class HBaseTableConfigParser {

    /** log. */
    private static Logger log = Logger.getLogger(HBaseTableConfigParser.class);

    /**
     * 解析HBaseTableSchema。
     * 
     * <pre>
     * 该步只解析config，不解析runtime。
     * </pre>
     * */
    public static void parseTableSchema(String filePath,
            HBaseTableSchema tableSchema,
            List<HBaseColumnSchema> hbaseColumnSchemas) {
        Node hbaseTableSchemaNode = findTopLevelNode(filePath,
                "HBaseTableSchema");

        tableSchema.setTableName(XmlUtil.getAttr(hbaseTableSchemaNode,
                "tableName"));
        tableSchema.setDefaultFamily(XmlUtil.getAttr(hbaseTableSchemaNode,
                "defaultFamily"));

        NodeList nodeList = hbaseTableSchemaNode.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node columnNode = nodeList.item(i);
            if (!columnNode.getNodeName().equals("HBaseColumnSchema")) {
                continue;
            }
            HBaseColumnSchema columnSchema = new HBaseColumnSchema();
            columnSchema.setFamily(XmlUtil.getAttr(columnNode, "family"));
            columnSchema.setQualifier(XmlUtil.getAttr(columnNode, "qualifier"));
            columnSchema.setTypeName(XmlUtil.getAttr(columnNode, "typeName"));
            columnSchema.setTypeHandlerName(XmlUtil.getAttr(columnNode,
                    "handler"));

            hbaseColumnSchemas.add(columnSchema);
        }

    }

    /**
     * 解析configMap。
     * */
    public static void parseConfigMap(String filePath,
            Map<String, String> configMap) {

        Node configMapNode = findTopLevelNode(filePath, "configMap");
        if (configMapNode == null) {
            return;
        }

        NodeList nodeList = configMapNode.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node configNode = nodeList.item(i);
            if (!configNode.getNodeName().equals("config")) {
                continue;
            }
            String key = XmlUtil.getAttr(configNode, "key");
            String value = XmlUtil.getAttr(configNode, "value");
            if (StringUtil.isNotEmptyString(key)
                    && StringUtil.isNotEmptyString(value)) {
                configMap.put(key, value);
            }
        }
    }

    /**
     * 解析HBaseQuery。
     * */
    public static List<HBaseQuery> parseHBaseQuery(String filePath) {
        List<HBaseQuery> hbaseQueries = new ArrayList<HBaseQuery>();
        Node statementsNode = findTopLevelNode(filePath, "statements");
        if (statementsNode == null) {
            return hbaseQueries;
        }

        NodeList nodeList = statementsNode.getChildNodes();
        if (nodeList == null || nodeList.getLength() == 0) {
            return hbaseQueries;
        }

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (!node.getNodeName().equals("statement")) {
                continue;
            }

            String id = XmlUtil.getAttr(node, "id");
            HBaseQuery hbaseQuery = new HBaseQuery(id,
                    HQLNodeParser.parse(node));
            hbaseQueries.add(hbaseQuery);
        }

        return hbaseQueries;

    }

    /**
     * 查找顶级的Node。
     * */
    private static Node findTopLevelNode(String filePath, String nodeName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringElementContentWhitespace(true);
            dbf.setIgnoringComments(true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filePath));
            Node rootNode = doc.getDocumentElement();
            NodeList childNodes = rootNode.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i).getNodeName().equals(nodeName)) {
                    return childNodes.item(i);
                }
            }
        } catch (Exception e) {
            log.error("parse error.", e);
            throw new SimpleHBaseException("parse error.", e);
        }

        return null;
    }

}
