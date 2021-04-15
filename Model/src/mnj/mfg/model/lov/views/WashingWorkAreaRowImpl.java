package mnj.mfg.model.lov.views;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Aug 07 16:31:43 PKT 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class WashingWorkAreaRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        InvOrg {
            public Object get(WashingWorkAreaRowImpl obj) {
                return obj.getInvOrg();
            }

            public void put(WashingWorkAreaRowImpl obj, Object value) {
                obj.setInvOrg((Number)value);
            }
        }
        ,
        InvOrgName {
            public Object get(WashingWorkAreaRowImpl obj) {
                return obj.getInvOrgName();
            }

            public void put(WashingWorkAreaRowImpl obj, Object value) {
                obj.setInvOrgName((String)value);
            }
        }
        ,
        OuId {
            public Object get(WashingWorkAreaRowImpl obj) {
                return obj.getOuId();
            }

            public void put(WashingWorkAreaRowImpl obj, Object value) {
                obj.setOuId((Number)value);
            }
        }
        ,
        LedgerId {
            public Object get(WashingWorkAreaRowImpl obj) {
                return obj.getLedgerId();
            }

            public void put(WashingWorkAreaRowImpl obj, Object value) {
                obj.setLedgerId((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(WashingWorkAreaRowImpl object);

        public abstract void put(WashingWorkAreaRowImpl object, Object value);

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
    public static final int INVORG = AttributesEnum.InvOrg.index();
    public static final int INVORGNAME = AttributesEnum.InvOrgName.index();
    public static final int OUID = AttributesEnum.OuId.index();
    public static final int LEDGERID = AttributesEnum.LedgerId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public WashingWorkAreaRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute InvOrg.
     * @return the InvOrg
     */
    public Number getInvOrg() {
        return (Number) getAttributeInternal(INVORG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute InvOrg.
     * @param value value to set the  InvOrg
     */
    public void setInvOrg(Number value) {
        setAttributeInternal(INVORG, value);
    }

    /**
     * Gets the attribute value for the calculated attribute InvOrgName.
     * @return the InvOrgName
     */
    public String getInvOrgName() {
        return (String) getAttributeInternal(INVORGNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute InvOrgName.
     * @param value value to set the  InvOrgName
     */
    public void setInvOrgName(String value) {
        setAttributeInternal(INVORGNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute OuId.
     * @return the OuId
     */
    public Number getOuId() {
        return (Number) getAttributeInternal(OUID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute OuId.
     * @param value value to set the  OuId
     */
    public void setOuId(Number value) {
        setAttributeInternal(OUID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LedgerId.
     * @return the LedgerId
     */
    public Number getLedgerId() {
        return (Number) getAttributeInternal(LEDGERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LedgerId.
     * @param value value to set the  LedgerId
     */
    public void setLedgerId(Number value) {
        setAttributeInternal(LEDGERID, value);
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
