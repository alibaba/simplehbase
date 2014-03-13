package com.alipay.simplehbase.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alipay.simplehbase.hql.HBaseQuery;
import com.alipay.simplehbase.hql.HQLNodeParser;

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
    public static void parseTableSchema(InputStream inputStream,
            HBaseTableSchema tableSchema,
            List<HBaseColumnSchema> hbaseColumnSchemas) {

        Util.checkNull(inputStream);
        Util.checkNull(tableSchema);
        Util.checkNull(hbaseColumnSchemas);

        Node hbaseTableSchemaNode = XmlUtil.findTopLevelNode(inputStream,
                "HBaseTableSchema");

        tableSchema.setTableName(XmlUtil.getAttr(hbaseTableSchemaNode,
                "tableName"));
        tableSchema.setDefaultFamily(XmlUtil.getAttr(hbaseTableSchemaNode,
                "defaultFamily"));
        tableSchema.setRowKeyHandlerName(XmlUtil.getAttr(hbaseTableSchemaNode,
                "rowKeyHandlerName"));

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
     * Parse HBaseQuery.
     * */
    public static List<HBaseQuery> parseHBaseQuery(InputStream inputStream) {
        Util.checkNull(inputStream);
        Node statementsNode = XmlUtil.findTopLevelNode(inputStream,
                "statements");
        return parseHBaseQueryList(statementsNode);
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
