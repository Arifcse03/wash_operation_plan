package mnj.mfg.model.lov.views;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Dec 28 16:38:59 PKT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RecipeVersionVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        HeaderId {
            public Object get(RecipeVersionVORowImpl obj) {
                return obj.getHeaderId();
            }

            public void put(RecipeVersionVORowImpl obj, Object value) {
                obj.setHeaderId((Number)value);
            }
        }
        ,
        DocNumber {
            public Object get(RecipeVersionVORowImpl obj) {
                return obj.getDocNumber();
            }

            public void put(RecipeVersionVORowImpl obj, Object value) {
                obj.setDocNumber((String)value);
            }
        }
        ,
        StnNo {
            public Object get(RecipeVersionVORowImpl obj) {
                return obj.getStnNo();
            }

            public void put(RecipeVersionVORowImpl obj, Object value) {
                obj.setStnNo((String)value);
            }
        }
        ,
        VersionNo {
            public Object get(RecipeVersionVORowImpl obj) {
                return obj.getVersionNo();
            }

            public void put(RecipeVersionVORowImpl obj, Object value) {
                obj.setVersionNo((Number)value);
            }
        }
        ,
        VersionNumber {
            public Object get(RecipeVersionVORowImpl obj) {
                return obj.getVersionNumber();
            }

            public void put(RecipeVersionVORowImpl obj, Object value) {
                obj.setVersionNumber((String)value);
            }
        }
        ,
        SelectVersion {
            public Object get(RecipeVersionVORowImpl obj) {
                return obj.getSelectVersion();
            }

            public void put(RecipeVersionVORowImpl obj, Object value) {
                obj.setSelectVersion((String)value);
            }
        }
        ,
        NewFillOperationPopUp {
            public Object get(RecipeVersionVORowImpl obj) {
                return obj.getNewFillOperationPopUp();
            }

            public void put(RecipeVersionVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(RecipeVersionVORowImpl object);

        public abstract void put(RecipeVersionVORowImpl object, Object value);

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


    public static final int HEADERID = AttributesEnum.HeaderId.index();
    public static final int DOCNUMBER = AttributesEnum.DocNumber.index();
    public static final int STNNO = AttributesEnum.StnNo.index();
    public static final int VERSIONNO = AttributesEnum.VersionNo.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();
    public static final int SELECTVERSION = AttributesEnum.SelectVersion.index();
    public static final int NEWFILLOPERATIONPOPUP = AttributesEnum.NewFillOperationPopUp.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RecipeVersionVORowImpl() {
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
     * Gets the attribute value for the calculated attribute DocNumber.
     * @return the DocNumber
     */
    public String getDocNumber() {
        return (String) getAttributeInternal(DOCNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DocNumber.
     * @param value value to set the  DocNumber
     */
    public void setDocNumber(String value) {
        setAttributeInternal(DOCNUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute StnNo.
     * @return the StnNo
     */
    public String getStnNo() {
        return (String) getAttributeInternal(STNNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StnNo.
     * @param value value to set the  StnNo
     */
    public void setStnNo(String value) {
        setAttributeInternal(STNNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute VersionNo.
     * @return the VersionNo
     */
    public Number getVersionNo() {
        return (Number) getAttributeInternal(VERSIONNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute VersionNo.
     * @param value value to set the  VersionNo
     */
    public void setVersionNo(Number value) {
        setAttributeInternal(VERSIONNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute VersionNumber.
     * @return the VersionNumber
     */
    public String getVersionNumber() {
        return (String) getAttributeInternal(VERSIONNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute VersionNumber.
     * @param value value to set the  VersionNumber
     */
    public void setVersionNumber(String value) {
        setAttributeInternal(VERSIONNUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SelectVersion.
     * @return the SelectVersion
     */
    public String getSelectVersion() {
        return (String) getAttributeInternal(SELECTVERSION);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SelectVersion.
     * @param value value to set the  SelectVersion
     */
    public void setSelectVersion(String value) {
        setAttributeInternal(SELECTVERSION, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link NewFillOperationPopUp.
     */
    public RowIterator getNewFillOperationPopUp() {
        return (RowIterator)getAttributeInternal(NEWFILLOPERATIONPOPUP);
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