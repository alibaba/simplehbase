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
import com.alipay.simplehbase.util.Util;
import com.alipay.simplehbase.util.XmlUtil;

/**
 * HBaseTableConfig parser.
 * 
 * @author xinzhi
 * */
public class HBaseTableConfigParser {

    /** log. */
    private static Logger log = Logger.getLogger(HBaseTableConfigParser.class);

    /**
     * Parse HBaseTableSchema.
     * 
     * <pre>
     * Only parse static config data, not runtime config data.
     * </pre>
     * */
    public static void parseTableSchema(String filePath,
            HBaseTableSchema tableSchema,
            List<HBaseColumnSchema> hbaseColumnSchemas) {

        Util.checkEmptyString(filePath);
        Util.checkNull(tableSchema);
        Util.checkNull(hbaseColumnSchemas);

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
     * Parse config map.
     * */
    public static void parseConfigMap(String filePath,
            Map<String, String> configMap) {

        Util.checkEmptyString(filePath);
        Util.checkNull(configMap);

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
     * Parse HBaseQuery.
     * */
    public static List<HBaseQuery> parseHBaseQuery(String filePath) {
        Util.checkEmptyString(filePath);

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
     * Find top level node.
     * */
    private static Node findTopLevelNode(String filePath, String nodeName) {
        Util.checkEmptyString(filePath);
        Util.checkEmptyString(nodeName);

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
