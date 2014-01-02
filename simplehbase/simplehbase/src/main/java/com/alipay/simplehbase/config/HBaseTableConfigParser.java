package com.alipay.simplehbase.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

        Node hbaseTableSchemaNode = XmlUtil.findTopLevelNode(filePath,
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
     * Parse simplehbase private config map.
     * */
    public static void parseConfigMap(String filePath,
            Map<String, String> configMap) {

        Util.checkEmptyString(filePath);
        Util.checkNull(configMap);

        Node configMapNode = XmlUtil.findTopLevelNode(filePath, "configMap");
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
        Node statementsNode = XmlUtil.findTopLevelNode(filePath, "statements");
        return parseHBaseQueryList(statementsNode);
    }

    /**
     * Parse HBaseQuery.
     * */
    public static List<HBaseQuery> parseHBaseQueryWithRawHQL(String hql,
            String id) {

        Util.checkEmptyString(hql);
        String content = "<SimpleHbase><statements><statement id=\"" + id
                + "\">";
        content = content + hql;
        content = content + "</statement></statements></SimpleHbase>";

        Node statementsNode = XmlUtil.findTopLevelNodeInString(content,
                "statements");

        return parseHBaseQueryList(statementsNode);
    }

    private static List<HBaseQuery> parseHBaseQueryList(Node statementsNode) {
        List<HBaseQuery> hbaseQueries = new ArrayList<HBaseQuery>();
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
}
