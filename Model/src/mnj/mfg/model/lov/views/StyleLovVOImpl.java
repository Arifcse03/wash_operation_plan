package mnj.mfg.model.lov.views;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Oct 31 14:35:16 BDT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class StyleLovVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public StyleLovVOImpl() {
    }

    /**
     * Returns the bind variable value for P_Org.
     * @return bind variable value for P_Org
     */
    public String getP_Org() {
        return (String)getNamedWhereClauseParam("P_Org");
    }

    /**
     * Sets <code>value</code> for bind variable P_Org.
     * @param value value to bind as P_Org
     */
    public void setP_Org(String value) {
        setNamedWhereClauseParam("P_Org", value);
    }
}