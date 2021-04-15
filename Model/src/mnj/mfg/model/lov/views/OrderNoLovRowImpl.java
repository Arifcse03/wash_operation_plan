package mnj.mfg.model.lov.views;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Aug 06 12:03:56 PKT 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OrderNoLovRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        OrderNumber {
            public Object get(OrderNoLovRowImpl obj) {
                return obj.getOrderNumber();
            }

            public void put(OrderNoLovRowImpl obj, Object value) {
                obj.setOrderNumber((Number)value);
            }
        }
        ,
        HeaderId {
            public Object get(OrderNoLovRowImpl obj) {
                return obj.getHeaderId();
            }

            public void put(OrderNoLovRowImpl obj, Object value) {
                obj.setHeaderId((Number)value);
            }
        }
        ,
        OrgId {
            public Object get(OrderNoLovRowImpl obj) {
                return obj.getOrgId();
            }

            public void put(OrderNoLovRowImpl obj, Object value) {
                obj.setOrgId((Number)value);
            }
        }
        ,
        OrderedQuantity {
            public Object get(OrderNoLovRowImpl obj) {
                return obj.getOrderedQuantity();
            }

            public void put(OrderNoLovRowImpl obj, Object value) {
                obj.setOrderedQuantity((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(OrderNoLovRowImpl object);

        public abstract void put(OrderNoLovRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int ORDERNUMBER = AttributesEnum.OrderNumber.index();
    public static final int HEADERID = AttributesEnum.HeaderId.index();
    public static final int ORGID = AttributesEnum.OrgId.index();
    public static final int ORDEREDQUANTITY = AttributesEnum.OrderedQuantity.index();

    /**
     * This is the default constructor (do not remove).
     */
    public OrderNoLovRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute OrderNumber.
     * @return the OrderNumber
     */
    public Number getOrderNumber() {
        return (Number) getAttributeInternal(ORDERNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute OrderNumber.
     * @param value value to set the  OrderNumber
     */
    public void setOrderNumber(Number value) {
        setAttributeInternal(ORDERNUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute HeaderId.
     * @return the HeaderId
     */
    public Number getHeaderId() {
        return (Number) getAttributeInternal(HEADERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute HeaderId.
     * @param value value to set the  HeaderId
     */
    public void setHeaderId(Number value) {
        setAttributeInternal(HEADERID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute OrgId.
     * @return the OrgId
     */
    public Number getOrgId() {
        return (Number) getAttributeInternal(ORGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute OrgId.
     * @param value value to set the  OrgId
     */
    public void setOrgId(Number value) {
        setAttributeInternal(ORGID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute OrderedQuantity.
     * @return the OrderedQuantity
     */
    public Number getOrderedQuantity() {
        return (Number) getAttributeInternal(ORDEREDQUANTITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute OrderedQuantity.
     * @param value value to set the  OrderedQuantity
     */
    public void setOrderedQuantity(Number value) {
        setAttributeInternal(ORDEREDQUANTITY, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}