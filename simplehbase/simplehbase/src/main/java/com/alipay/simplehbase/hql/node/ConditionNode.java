package com.alipay.simplehbase.hql.node;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.util.StringUtil;

/**
 * @author xinzhi
 */
abstract public class ConditionNode extends PrependNode {

    protected ConditionNode(HQLNodeType hqlNodeType) {
        super(hqlNodeType);
    }

    /**
     * isConditionSatisfied.
     * */
    abstract protected boolean isConditionSatisfied(Map<String, Object> para,
            @Nullable SimpleHbaseRuntimeSetting runtimeSetting);

    @Override
    final public void applyParaMap(Map<String, Object> para, StringBuilder sb,
            Map<Object, Object> context,
            @Nullable SimpleHbaseRuntimeSetting runtimeSetting) {
        if (isConditionSatisfied(para, runtimeSetting)) {
            //if this is dynamic node's child node, when the first time isConditionSatisfied to be true,
            //use dynamic node's non-empty prepend value to override this node's prepend value.
            String prepend = getPrependValue();

            HQLNode parent = this.getParent();
            if (parent != null
                    && parent.getHqlNodeType() == HQLNodeType.Dynamic
                    && !context.containsKey(parent)) {

                context.put(parent, "override prepend once");

                String parentPrepend = ((DynamicNode) parent).getPrependValue();
                if (StringUtil.isNotEmptyString(parentPrepend)) {
                    prepend = parentPrepend;
                }
            }

            if (prepend != null) {
                sb.append(BlankSpace);
                sb.append(prepend);
            }

            for (HQLNode hqlNode : subNodeList) {
                hqlNode.applyParaMap(para, sb, context, runtimeSetting);
            }
        }
    }
}
