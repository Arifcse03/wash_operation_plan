package mnj.mfg.model.lov.views;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Aug 06 12:06:30 PKT 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CustomerLOVImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public CustomerLOVImpl() {
    }

    /**
     * Returns the variable value for p_Custmer.
     * @return variable value for p_Custmer
     */
    public String getp_Custmer() {
        return (String)ensureVariableManager().getVariableValue("p_Custmer");
    }

    /**
     * Sets <code>value</code> for variable p_Custmer.
     * @param value value to bind as p_Custmer
     */
    public void setp_Custmer(String value) {
        ensureVariableManager().setVariableValue("p_Custmer", value);
    }
}
