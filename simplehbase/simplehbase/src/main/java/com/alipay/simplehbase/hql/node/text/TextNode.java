package com.alipay.simplehbase.hql.node.text;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;
/**
 * @author xinzhi
 */
public class TextNode extends BaseTextNode {

    protected TextNode() {
        super(HQLNodeType.Text);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
            Map<Object, Object> context) {
        if (getTextValue() != null) {
            sb.append(BlankSpace);
            sb.append(getTextValue());
        }
    }
}
