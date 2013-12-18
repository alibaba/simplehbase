package com.alipay.simplehbase.hql;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alipay.simplehbase.hql.node.DynamicNodeHandler;
import com.alipay.simplehbase.hql.node.StatementNodeHandler;
import com.alipay.simplehbase.hql.node.binary.IsEqualNodeHandler;
import com.alipay.simplehbase.hql.node.binary.IsGreaterEqualNodeHandler;
import com.alipay.simplehbase.hql.node.binary.IsGreaterThanNodeHandler;
import com.alipay.simplehbase.hql.node.binary.IsLessEqualNodeHandler;
import com.alipay.simplehbase.hql.node.binary.IsLessThanNodeHandler;
import com.alipay.simplehbase.hql.node.binary.IsNotEqualNodeHandler;
import com.alipay.simplehbase.hql.node.text.CDATASectionNodeHandler;
import com.alipay.simplehbase.hql.node.text.CommentNodeHandler;
import com.alipay.simplehbase.hql.node.text.TextNodeHandler;
import com.alipay.simplehbase.hql.node.unary.IsEmptyNodeHandler;
import com.alipay.simplehbase.hql.node.unary.IsNotEmptyNodeHandler;
import com.alipay.simplehbase.hql.node.unary.IsNotNullNodeHandler;
import com.alipay.simplehbase.hql.node.unary.IsNotPropertyAvailableNodeHandler;
import com.alipay.simplehbase.hql.node.unary.IsNullNodeHandler;
import com.alipay.simplehbase.hql.node.unary.IsPropertyAvailableNodeHandler;
import com.alipay.simplehbase.util.Util;

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

        register(HQLNodeType.IsPropertyAvailable,
                new IsPropertyAvailableNodeHandler());
        register(HQLNodeType.IsNotPropertyAvailable,
                new IsNotPropertyAvailableNodeHandler());

        register(HQLNodeType.IsEqual, new IsEqualNodeHandler());
        register(HQLNodeType.IsNotEqual, new IsNotEqualNodeHandler());

        register(HQLNodeType.IsGreaterThan, new IsGreaterThanNodeHandler());
        register(HQLNodeType.IsGreaterEqual, new IsGreaterEqualNodeHandler());

        register(HQLNodeType.IsLessThan, new IsLessThanNodeHandler());
        register(HQLNodeType.IsLessEqual, new IsLessEqualNodeHandler());

    }

    public static HQLNode parse(Node node) {

        Util.checkNull(node);

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
