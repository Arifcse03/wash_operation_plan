package mnj.mfg.view.backing_bean.Main;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import mnj.ont.model.services.AppModuleImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class backingBean {
    private RichPopup myPopup;
    private RichTable obTable;
    // private RichInputText orgId;
    private RichInputText saleOrderID;
    private RichInputText orgID;
    private RichTable operationsTable;
    private RichInputListOfValues headerWashBind;
    private RichInputListOfValues headerStyleBind;
    private RichTable chemicalTable;
    private RichTable subProcessTable;
    private RichTable searchPageTable;
    private RichInputText headerId;
    private RichInputListOfValues color;
    private RichInputText season;
    private RichInputText buyerId;
    private RichOutputText stylenew;
    private RichOutputText seasonnew;
    private RichOutputText colornew;
    private RichOutputText washnew;
    private RichTable livevostyleTable;
    private RichInputText style;
    private RichInputText color_n;
    private RichInputText wash;


    public backingBean() {
        super();
    }
   
   
 
    
    
    public ApplicationModule getAppM(){
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContainer.findDataControl("AppModuleDataControl"); // Name of application module in datacontrolBinding.cpx
        AppModuleImpl appM = (AppModuleImpl)dc.getDataProvider();
        return appM;
    }
    AppModuleImpl am = (AppModuleImpl)this.getAppM();
    
    
    
    

    public void editPopupFetchListener(PopupFetchEvent popupFetchEvent) {


        setWhereClause();

        if (popupFetchEvent.getLaunchSourceClientId().contains("cbInsert")) {
            System.out.println("Insert event called......!");
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding =
                bindings.getOperationBinding("CreateInsert");
            operationBinding.execute();
        }
    }

    public void editDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            callPopulate();
            AdfFacesContext.getCurrentInstance().addPartialTarget(obTable);

        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            ;
        }
    }

    public void editPopupCancelListener(PopupCanceledEvent popupCanceledEvent) {

    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setSaleOrderID(RichInputText saleOrderID) {
        this.saleOrderID = saleOrderID;
        setOrderIdS(saleOrderID);
    }

    public RichInputText getSaleOrderID() {
        return saleOrderID;
    }

    public void setOrgID(RichInputText orgID) {
        this.orgID = orgID;

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("orgID", orgID.getValue());
    }

    public RichInputText getOrgID() {
        return orgID;
    }

    public void setMyPopup(RichPopup myPopup) {
        this.myPopup = myPopup;
    }

    public RichPopup getMyPopup() {
        return myPopup;
    }

    public void setObTable(RichTable obTable) {
        this.obTable = obTable;
    }

    public RichTable getObTable() {
        return obTable;
    }


    public void PopLinesAction(ActionEvent actionEvent) {
        // Add event code here...
        oracle.jbo.domain.Number saleOrderId =
            (oracle.jbo.domain.Number)actionEvent.getComponent().getAttributes().get("OrderId");
        System.out.println("button Action Simple=========>>...." +
                           saleOrderId);

        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getMyPopup().show(hints);
    }

    public void setWhereClause() {

        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        OperationBinding operationBinding =
            bindings.getOperationBinding("populateOrderLines");
        operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            List errors = operationBinding.getErrors();
            System.out.println(errors.get(0));
        }


    }


    public void callPopulate() {

        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        OperationBinding operationBinding =
            bindings.getOperationBinding("findSelLines");
        operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }

    } //end of callPopulate method

    public void setOrderIdS(RichInputText id) {

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("orderHeaderIdS", id.getValue());
    }


    ///// Pop - Up for Operations


    public void editPopupFetchListenerOperations(PopupFetchEvent popupFetchEvent) {
        // Add event code here...setPopUpWhereClause

        OperationBinding operationBinding =
            executeOperation("setPopUpWhereClauseOperations");
        operationBinding.execute();
    }


    public void editDialogListenerOperations(DialogEvent dialogEvent) {
        // Add event code here...
        if (dialogEvent.getOutcome().name().equals("ok")) {
            OperationBinding operationBinding =
                executeOperation("populateOperations");
            operationBinding.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(operationsTable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(chemicalTable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(subProcessTable); // Bind of Table where you are populating data

        }

    }


    public oracle.binding.OperationBinding executeOperation(String operation) {
        oracle.binding.OperationBinding createParam =
            getBindingsCont().getOperationBinding(operation);
        return createParam;

    }

    /*****Generic Method to Get BindingContainer**/
    public oracle.binding.BindingContainer getBindingsCont() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void setOperationsTable(RichTable operationsTable) {
        this.operationsTable = operationsTable;
    }

    public RichTable getOperationsTable() {
        return operationsTable;
    }

    public void setHeaderWashBind(RichInputListOfValues headerWashBind) {
        this.headerWashBind = headerWashBind;

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("Wash", headerWashBind.getValue());

    }

    public RichInputListOfValues getHeaderWashBind() {
        return headerWashBind;
    }

    public void setHeaderStyleBind(RichInputListOfValues headerStyleBind) {
        this.headerStyleBind = headerStyleBind;

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("Style", headerStyleBind.getValue());

    }

    public RichInputListOfValues getHeaderStyleBind() {
        return headerStyleBind;
    }

    public void setChemicalTable(RichTable chemicalTable) {
        this.chemicalTable = chemicalTable;
    }

    public RichTable getChemicalTable() {
        return chemicalTable;
    }

    public void setSubProcessTable(RichTable subProcessTable) {
        this.subProcessTable = subProcessTable;
    }

    public RichTable getSubProcessTable() {
        return subProcessTable;
    }

    // Fill Stns Pop - Up

    public void editPopupFetchListenerStn(PopupFetchEvent popupFetchEvent) {
        // Add event code here...setPopUpWhereClause

        ;
    }


    public void editDialogListenerRec(DialogEvent dialogEvent) {
        // Add event code here...
        if (dialogEvent.getOutcome().name().equals("ok")) {
            OperationBinding operationBinding =
                executeOperation("populateBundlesStn");
            operationBinding.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(obTable); // Bind of Table where you are populating data
        }

    }


    // End Fill Pop - Up

    public void VersionCreation(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("In Version Creation");
        OperationBinding operationBinding =
            executeOperation("VersionCreation");
        operationBinding.execute();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        int value = Integer.parseInt(methodReturnValue.toString());
        //     return value;

        if (value == 1) {

            /* Message Printing */

            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message =
                new FacesMessage("Version Created Scuccesfully");
            context.addMessage(null, message);


            /* End Message */
        }

        if (value > 1) {

            /* Message Printing */

            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("Version Not Created");
            context.addMessage(null, message);


            /* End Message */
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(searchPageTable); // Bind of Table where you are populating data

    }

    public void setSearchPageTable(RichTable searchPageTable) {
        this.searchPageTable = searchPageTable;
    }

    public RichTable getSearchPageTable() {
        return searchPageTable;
    }

    
    public void CreateJob(ActionEvent actionEvent) {
        // Add event code here...
        
        
        ViewObject headerVo  = am.getHederVO1();
        String jobName ;
        try{
            jobName =    headerVo.getCurrentRow().getAttribute("JobName").toString();
        }
        catch(NullPointerException e){
           jobName =null ;
        }
        if (jobName != null ){
            
            FacesMessage fm = new FacesMessage("Job Already Created !");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            return;
        }
        
        
        
        initCreateJob(String.valueOf(getHeaderId().getValue()));
    }

    public void initCreateJob(String HeaderId) {


        OperationBinding operationBinding = executeOperation("createJob");

        operationBinding.getParamsMap().put("HeaderId", HeaderId);
        operationBinding.execute();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
        }

        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    

    }

    public void setHeaderId(RichInputText headerId) {
        this.headerId = headerId;
    }

    public RichInputText getHeaderId() {
        return headerId;
    }

    public void CreateMaterial(ActionEvent actionEvent) {
        // Add event code here...
        //initBOM(0, String.valueOf(getHeaderId().getValue()));
        initBOM("0", String.valueOf(getHeaderId().getValue()));
    }
    
    public void initBOM(String invID, String ratioID) {


        OperationBinding operationBinding = executeOperation("callBOM");

        operationBinding.getParamsMap().put("inventoryID", invID);
        operationBinding.getParamsMap().put("HeaderID", ratioID);


        //invoke method
        operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }

//    public void initBOM(String invID, String HeaderID) {
//
//        OperationBinding operationBinding = executeOperation("callBOM");
//
//        operationBinding.getParamsMap().put("inventoryID", invID);
//        operationBinding.getParamsMap().put("HeaderId", HeaderID);
//
//
//        //invoke method
//        operationBinding.execute();
//        if (!operationBinding.getErrors().isEmpty()) {
//            System.out.println("if errors-->");
//            // List errors = operationBinding.getErrors();
//        }
//        //optional
//        Object methodReturnValue = operationBinding.getResult();
//        String message = null;
//        if (methodReturnValue != null) {
//            message = methodReturnValue.toString();
//        } else {
//            message = "Failed! .";
//        }
//        FacesMessage fm = new FacesMessage(message);
//        fm.setSeverity(FacesMessage.SEVERITY_INFO);
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, fm);
//    }

    public void routingAction(ActionEvent actionEvent) {
        // Add event code here...

        initRouting("0", String.valueOf(getHeaderId().getValue()));
    }

    public void initRouting(String invID, String ratioID) {

        OperationBinding operationBinding =
            executeOperation("callCreateRouting");

        operationBinding.getParamsMap().put("inventoryID", invID);
        operationBinding.getParamsMap().put("HeaderId", ratioID);


        //invoke method
        operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }

    public void CreateRequisition(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding =
            executeOperation("CreateRequisition");
        operationBinding.execute();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);

    }

    public void PopulateSTN(ActionEvent actionEvent) {
        // Add event code here...

        System.out.println("Going In method");

        OperationBinding operationBinding = executeOperation("Populate");
        operationBinding.execute();

        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("Record Fetched...");
        context.addMessage(null, message);

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors -->");
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(obTable);

    }

    public void save(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding =
            executeOperation("checkduplication");


        operationBinding.getParamsMap().put("HeaderId",
                                            getHeaderId().getValue());
        operationBinding.getParamsMap().put("BuyerId",
                                            getBuyerId().getValue());
        operationBinding.getParamsMap().put("Style",
                                           getStyle().getValue());
        operationBinding.getParamsMap().put("Season", getSeason().getValue());
        operationBinding.getParamsMap().put("Wash",
                                            getWash().getValue());
        operationBinding.getParamsMap().put("Color", getColor_n().getValue());
        operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
        }
        
//        ViewObject vo = am.getLineVOStyleDetail1();
//        ViewObject h=am.getHederVO1();
//        h.clearCache();
//        vo.executeQuery();

    }

    public void setColor(RichInputListOfValues color) {
        this.color = color;

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("Color", color.getValue());
    }

    public RichInputListOfValues getColor() {
        return color;
    }

    public void setSeason(RichInputText season) {
        this.season = season;

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("Season", season.getValue());
    }

    public RichInputText getSeason() {
        return season;
    }

    public void setBuyerId(RichInputText buyerId) {
        this.buyerId = buyerId;

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("BuyerId", buyerId.getValue());
    }

    public RichInputText getBuyerId() {
        return buyerId;
    }

    public void DeleteHeader(ActionEvent actionEvent) {
        // Add event code here...
        BindingContext bindingContext1 = BindingContext.getCurrent();
        DCDataControl dc1 =
            bindingContext1.findDataControl("AppModuleDataControl"); //
        ApplicationModule am = dc1.getApplicationModule();
        ViewObject var_vo = am.findViewObject("HederVO1");

        ViewObject vo1 = am.findViewObject("LineVOStyleDetail1");
        ViewObject vo2 = am.findViewObject("DetailRecipesVO1");

        System.out.println("Row Count Lines at STN's = " + vo1.getRowCount());
        System.out.println("Row Count Lines at Recipes = " +
                           vo2.getRowCount());

        if (vo1.getRowCount() > 0 || vo2.getRowCount() > 0) {

            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message =
                new FacesMessage("Please Delete Child Record First!!");
            context.addMessage(null, message);

        } else {

            OperationBinding operationBinding =
                executeOperation("Delete_Header");
            operationBinding.execute();


            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("Record Deleted..");
            context.addMessage(null, message);

        }
    }

    public void FetchRecipe(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding =
            executeOperation("populateOperations");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(operationsTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(chemicalTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(subProcessTable);
    }

    public void DeleteStyleDetail(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding =
            executeOperation("DeleteStyleDetail");
        operationBinding.execute();
         AdfFacesContext.getCurrentInstance().addPartialTarget(livevostyleTable);
    }

    public void CallPost(ActionEvent actionEvent) {
        // Add event code here...
        initCallPost(String.valueOf(getHeaderId().getValue()));
    }

    public void initCallPost(String HeaderId) {


        OperationBinding operationBinding = executeOperation("CallPost");

        operationBinding.getParamsMap().put("HeaderId", HeaderId);
        operationBinding.execute();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
        }

        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);

    }

    public void CallCompletion(ActionEvent actionEvent) {
        // Add event code here...
        initCallCompletion(String.valueOf(getHeaderId().getValue()));
    }

    public void initCallCompletion(String HeaderId) {

        OperationBinding operationBinding = executeOperation("CallCompletion");

        operationBinding.getParamsMap().put("HeaderId", HeaderId);
        operationBinding.execute();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
        }

        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);

    }

    public void subProcessPopulate(DialogEvent dialogEvent) {
        
       
        // Add event code here...

        if (dialogEvent.getOutcome().name().equals("ok")) {
            
           
            
            ViewObject subProcessPopUpVo = am.getSubProcessPopUpVO1();
            ViewObject subProcessVo = am.getSubProcessVO1();
            Row subProcessRow;
            Row[] subprocessPopUpVoRows =
                subProcessPopUpVo.getAllRowsInRange();
            String checkBox;
            for (Row r : subprocessPopUpVoRows) {
               
              
                try {
                    checkBox = r.getAttribute("CheckBox").toString();
                } catch (Exception e) {

                    checkBox = "n";
                }
                
               
                

                if (checkBox.equals("y")) {
                    
                  
                    subProcessRow = subProcessVo.createRow();
                    subProcessRow.setAttribute("SubProcess",
                                               r.getAttribute("SubProcess"));
                }


            }
            
            AdfFacesContext.getCurrentInstance().addPartialTarget(subProcessTable);
            
        }
    }

    public void subProcessPopUpFetchListener(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
        
        
        ViewObject supprocessPopUpVo = am.getSubProcessPopUpVO1();
        deselectAllRows(supprocessPopUpVo);
    }

    private void deselectAllRows(ViewObject popUpVo) {
        
        
        Row[] rows = popUpVo.getAllRowsInRange();
        for(Row r : rows){
            r.setAttribute("CheckBox", null);
        }
        
       
    }


    public void setStylenew(RichOutputText stylenew) {
        this.stylenew = stylenew;
    }

    public RichOutputText getStylenew() {
        return stylenew;
    }

    public void setSeasonnew(RichOutputText seasonnew) {
        this.seasonnew = seasonnew;
    }

    public RichOutputText getSeasonnew() {
        return seasonnew;
    }

    public void setColornew(RichOutputText colornew) {
        this.colornew = colornew;
    }

    public RichOutputText getColornew() {
        return colornew;
    }

    public void setWashnew(RichOutputText washnew) {
        this.washnew = washnew;
    }

    public RichOutputText getWashnew() {
        return washnew;
    }

    public void setLivevostyleTable(RichTable livevostyleTable) {
        this.livevostyleTable = livevostyleTable;
    }

    public RichTable getLivevostyleTable() {
        return livevostyleTable;
    }

    public void setStyle(RichInputText style) {
        this.style = style;
    }

    public RichInputText getStyle() {
        return style;
    }

    public void setColor_n(RichInputText color_n) {
        this.color_n = color_n;
    }

    public RichInputText getColor_n() {
        return color_n;
    }

    public void setWash(RichInputText wash) {
        this.wash = wash;
    }

    public RichInputText getWash() {
        return wash;
    }
}
