package com.alipay.simplehbase.hql;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.alipay.simplehbase.hql.handler.*;

/**
 * HQLNodeParser¡£
 * 
 * 
 * @author xinzhi
 * @version $Id: HQLNodeParser.java 2013-09-11 ÉÏÎç11:27:31 xinzhi $
 * */
public class HQLNodeParser {

    private static Map<HQLNodeType, HQLNodeHandler> hsqlNodeHandlers = new HashMap<HQLNodeType, HQLNodeHandler>();

    private static void register(HQLNodeType hqlNodeType,
            HQLNodeHandler hqlNodeHandler) {
        hsqlNodeHandlers.put(hqlNodeType, hqlNodeHandler);
    }

    static {
        register(HQLNodeType.Statement, new StatementNodeHandler());

        register(HQLNodeType.Text, new TextNodeHandler());
        register(HQLNodeType.Comment, new CommentNodeHandler());
        register(HQLNodeType.CDATASection, new CDATASectionNodeHandler());

        register(HQLNodeType.Dynamic, new DynamicNodeHandler());

        register(HQLNodeType.IsNull, new IsNullNodeHandler());
        register(HQLNodeType.IsNotNull, new IsNotNullNodeHandler());

        register(HQLNodeType.IsEmpty, new IsEmptyNodeHandler());
        register(HQLNodeType.IsNotEmpty, new IsNotEmptyNodeHandler());

        register(HQLNodeType.IsEqual, new IsEqualNodeHandler());
        register(HQLNodeType.IsNotEqual, new IsNotEqualNodeHandler());

    }

    public static HQLNode parse(Node node) {

        HQLNodeType hqlNodeType = HQLNodeType.findHQLNodeType(node);
        HQLNodeHandler hqlNodeHandler = hsqlNodeHandlers.get(hqlNodeType);
        HQLNode hqlNode = hqlNodeHandler.handle(node);
        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node subNode = nodeList.item(i);
            HQLNode subHqlNode = parse(subNode);
            subHqlNode.setParent(hqlNode);
            hqlNode.addSubHQLNode(subHqlNode);
        }

        return hqlNode;
    }
}
