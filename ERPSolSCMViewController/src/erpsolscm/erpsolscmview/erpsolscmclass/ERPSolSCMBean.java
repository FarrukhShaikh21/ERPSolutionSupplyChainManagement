package erpsolscm.erpsolscmview.erpsolscmclass;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;

import erpsolglob.erpsolglobview.erpclass.ERPSolGlobalViewBean;

import java.math.BigDecimal;

import java.sql.CallableStatement;

import java.sql.SQLException;
import java.sql.Types;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import oracle.adf.model.AttributeBinding;

import oracle.binding.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.model.binding.DCIteratorBindingDef;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class ERPSolSCMBean {
    public ERPSolSCMBean() {
        super();
    }

    String ERPSolStrUserCode;
    String ERPSolStrUserLocationCode;
    String ERPSolStrUserRegionCode;
    String ERPSolStrUserStoreCode;
    String ERPSolScanType="B";
    String ERPSolProductId;
    String ERPSolSalesOrderId;
    RichPopup ERPSolImeiPopup;
    String ERPSolImeiBox;
    RichInputText ERPSolImeiBoxText;
    RichInputText ERPSolRebateImeiBoxText;
    String ERPSolImeiString;
    String ERPSolReportName;
    String ERPSolSaleretid;
    String ERPIteratorName;
    
    public void doSetERPSolSCMSessionGlobals() {
        System.out.println("glob user code"+getERPSolStrUserCode());
        if (getERPSolStrUserCode().length()==0) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users Defaults are not defined properly. Please Check"));
           throw new JboException("Users Defaults are not defined properly. Please Check");
       }
        try {
            ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_CODE", getERPSolStrUserCode().toString());
            ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_REGION", getERPSolStrUserCode().toString());
            ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_LOCATION",getERPSolStrUserLocationCode().toString());
            ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_STORE", getERPSolStrUserStoreCode().toString());
            ADFContext.getCurrent().getPageFlowScope().put("GLOB_COMPANY_CODE", "D");
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users Defaults are not defined properly. Please Check"));
        }
    }


    public void setERPSolStrUserCode(String ERPSolStrUserCode) {
        this.ERPSolStrUserCode = ERPSolStrUserCode;
    }

    public String getERPSolStrUserCode() {
        return ERPSolStrUserCode;
    }

    public void setERPSolStrUserLocationCode(String ERPSolStrUserLocationCode) {
        this.ERPSolStrUserLocationCode = ERPSolStrUserLocationCode;
    }

    public String getERPSolStrUserLocationCode() {
        return ERPSolStrUserLocationCode;
    }

    public void setERPSolStrUserRegionCode(String ERPSolStrUserRegionCode) {
        this.ERPSolStrUserRegionCode = ERPSolStrUserRegionCode;
    }

    public String getERPSolStrUserRegionCode() {
        return ERPSolStrUserRegionCode;
    }

    public void setERPSolStrUserStoreCode(String ERPSolStrUserStoreCode) {
        this.ERPSolStrUserStoreCode = ERPSolStrUserStoreCode;
    }

    public String getERPSolStrUserStoreCode() {
        return ERPSolStrUserStoreCode;
    }
    
    
        
    public List<SelectItem> doERPSolGetAutoSuggestedSalesPersonByLoc(String pStringValues) {
        
            List<SelectItem> ResultList=new ArrayList<SelectItem>();
            BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
            AttributeBinding ERPLocationId =(AttributeBinding)ERPSolbc.getControlBinding("Locationid");
            ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "SoSalesPersonsByLocAutoSuggestRO",
                                                                "LOCATIONID ='"+ERPLocationId.getInputValue()+"'AND UPPER(CONCAT(Salespersonid,name))", "Name", "Salespersonid", 10,"ERPSolSCMAppModuleDataControl");
            return ResultList;
        
    }
    
    public List<SelectItem> doERPSolGetAutoSuggestedLocationValues(String pStringValues) {
    //public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "AllLocationsAutoSuggestRO",
                                                            "UPPER(CONCAT(Locationid,Location_Description))", "LocationDescription", "Locationid", 10,"ERPSolSCMAppModuleDataControl");
        return ResultList;
        
    }
         
    public List<SelectItem> doERPSolGetAutoSuggestedStoreValues(String pStringValues) {
//public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPLocid =(AttributeBinding)ERPSolbc.getControlBinding("Locationid");
        System.out.println("c");
//        String ERPLocid=""+ERPSolib.getCurrentRow().getAttribute("Locationid");
        System.out.println("d");
        System.out.println(ERPLocid.getInputValue());//ERPSolGlobalViewBean.
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "AllStoresAutoSuggestRO",
                                                            "LOCATIONID='"+ERPLocid.getInputValue()+"' AND EXISTS(SELECT NULL FROM SYS_USER_STORE SUS WHERE SUS.STOREID=AllStores.STOREID AND SUS.ACESS='Y' AND SUS.USERID='"+ERPSolGlobClassModel.doGetUserCode()+"') AND UPPER(CONCAT(STOREID,STORE_NAME))", "StoreName", "Storeid", 10,"ERPSolSCMAppModuleDataControl");
        return ResultList;
        
    }
    
    public List<SelectItem> doERPSolGetAutoSuggestedCustomerValues(String pStringValues) {
    //public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPLocid =(AttributeBinding)ERPSolbc.getControlBinding("Locationid");
        System.out.println("c");
//        ERPSolbc.set
        System.out.println("d");
        System.out.println(ERPLocid);//ERPSolGlobalViewBean.
        System.out.println("myname");
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "AllCustomersAutoSuggestRO",
                                                            "LOCATIONID='"+ERPLocid.getInputValue()+"' AND EXISTS(SELECT NULL FROM SYS_USER_CUSTOMER SUC WHERE SUC.CUSTOMERID=AllCustomers.CUSTOMERID  AND SUC.USERID='"+ERPSolGlobClassModel.doGetUserCode()+"')  AND UPPER(CONCAT(CUSTOMERID,CUSTOMER_NAME))", "CustomerName", "Customerid", 10,"ERPSolSCMAppModuleDataControl");
        return ResultList;
        
    }   

    public List<SelectItem> doERPSolGetAutoSuggestedSalesPersonValues(String pStringValues) {
    //public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPCustomerId =(AttributeBinding)ERPSolbc.getControlBinding("Customerid");
        System.out.println("c");
//        String ERPCustomerId=""+ERPSolib.getCurrentRow().getAttribute("Customerid");
        System.out.println("d");
        System.out.println(ERPCustomerId);//ERPSolGlobalViewBean.
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "SoSalesPersonsAutoSuggestRO",
                                                            "SALESPERSONID IN (SELECT ASP.SALESPERSONID from ALL_CUSTOMER_SALESPERSON ASP WHERE ASP.CUSTOMERID='"+ERPCustomerId.getInputValue()+"') AND UPPER(CONCAT(Salespersonid,name))", "Name", "Salespersonid", 10,"ERPSolSCMAppModuleDataControl");
        return ResultList;
        
    }   
   
    public List<SelectItem> doERPSolGetAutoSuggestedSupplierValues(String pStringValues) {
    //public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
//        Attribute ERPSolib =(Attribute)ERPSolbc.get("SoSalesOrderViewCRUDIterator");
        System.out.println("c");
        AttributeBinding ERPLocid =(AttributeBinding)ERPSolbc.getControlBinding("Locationid");
        System.out.println("d");
        System.out.println(ERPLocid.getInputValue());//ERPSolGlobalViewBean.
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "PuSuppliersAutoSuggestRO",
                                                            "LOCATIONID='"+ERPLocid.getInputValue()+"' AND UPPER(CONCAT(SUPPLIERID,SUPP_NAME))", "SuppName", "Supplierid", 10,"ERPSolSCMAppModuleDataControl");
        return ResultList;
        
    }   
     
    
    public List<SelectItem> doERPSolGetAutoSuggestedModelValues(String pStringValues) {
    //public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        AttributeBinding ERPDivision =null;
        String StrERPDivision=null;
        try {
            ERPDivision = (AttributeBinding) ERPSolbc.getControlBinding("Divid");
            StrERPDivision=""+(ERPDivision.getInputValue()==null?"":ERPDivision.getInputValue()) ;
            
        } catch (Exception e) {
            // TODO: Add catch code
            StrERPDivision="";
        }
        System.out.println(StrERPDivision);
        System.out.println("ac");
        String ERPSolDIVWhere="";
        if (StrERPDivision.length()>0) {
           System.out.println("ab");
           ERPSolDIVWhere="DIVID= '"+StrERPDivision+"' AND ";
       }
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "InItemsAutoSuggestRO",ERPSolDIVWhere+" UPPER(CONCAT(Productid,Model_No))", "ModelNo", "Productid", 10,"ERPSolSCMAppModuleDataControl");
        return ResultList;
        
    }   
    public void doERPSolDialogConfirm(DialogEvent erpsolde) {
        if (erpsolde.getOutcome()==DialogEvent.Outcome.yes) {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("doSuperviseSaleOrder");
            binding.execute();
            List ERPSolerrors = binding.getErrors();
            if (ERPSolerrors.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Transaction Is Supervised." ));
            }
        }
    }

    public void doERPSolDialogSaleReturnConfirm(DialogEvent erpsolde) {
        if (erpsolde.getOutcome()==DialogEvent.Outcome.yes) {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("doSuperviseSalesReturn");
            binding.execute();
            List ERPSolerrors = binding.getErrors();
            if (ERPSolerrors.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Transaction Is Supervised." ));
            }
        }
    }
    public void doERPSolDialogSaleReturnMemoConfirm(DialogEvent erpsolde) {
        if (erpsolde.getOutcome()==DialogEvent.Outcome.yes) {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("doSuperviseSalesReturnMemo");
            binding.execute();
            List ERPSolerrors = binding.getErrors();
            if (ERPSolerrors.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Transaction Is Supervised." ));
            }
        }
    }   
    
    public void doERPSolDialogImeiEntryConfirm(DialogEvent erpsolde) {
        if (erpsolde.getOutcome()==DialogEvent.Outcome.yes) {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("doSuperviseImeiEntry");
            binding.execute();
            List ERPSolerrors = binding.getErrors();
            if (ERPSolerrors.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Transaction Is Supervised." ));
            }
        }
    }   

    public void doERPSoRebatelDialogConfirm(DialogEvent erpsolde) {
        if (erpsolde.getOutcome()==DialogEvent.Outcome.yes) {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("doSuperviseSalesRebate");
            binding.execute();
            List ERPSolerrors = binding.getErrors();
            if (ERPSolerrors.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(    "Transaction Is Supervised." ));
            }
        }
    }
    public void doERPSolPickDialogConfirm(DialogEvent erpsolde) {
        if (erpsolde.getOutcome()==DialogEvent.Outcome.yes) {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("doReadyForWarehouse");
            binding.execute();
            List ERPSolerrors = binding.getErrors();
            if (ERPSolerrors.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(    "Transaction Is Ready For Warehouse." ));
           }
        }
    }
    
    public void setERPSolImeiPopup(RichPopup ERPSolImeiPopup) {
        this.ERPSolImeiPopup = ERPSolImeiPopup;
    }

    public RichPopup getERPSolImeiPopup() {
        return ERPSolImeiPopup;
    }

    public String DoShowERPSolImeiPopup() {
        RichPopup.PopupHints ERPSolHints=new RichPopup.PopupHints();
        getERPSolImeiPopup().show(ERPSolHints);
        return null;
    }
    public void erpSolSoImeiBox(ValueChangeEvent erpvce) {
        if (erpvce.getNewValue()==null) {
            return ;
        }
        System.out.println("1so");
        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("2so");
        DCDataControl dc = bc.getDataControl();
        System.out.println("3");
        String ERPSolPlsql="begin ?:=PKG_SALE_ORDER.FUNC_IMEI_BOX_VALIDATION('"+getERPSolSalesOrderId()+"','"+erpvce.getNewValue()+"','"+getERPSolScanType()+"','"+getERPSolProductId()+"'); end;";
        System.out.println("4");
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        System.out.println("5");
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     System.out.println("6");
                     cs.registerOutParameter(1, Types.VARCHAR);
                     System.out.println("7");
                     cs.executeUpdate();
                     System.out.println("8");
                     ERPSolPlsql=cs.getString(1);
                     System.out.println("9");
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                         
                         erpsoldbt.commit();
                     dc.getApplicationModule().findViewObject("SoSalesOrderImeiSCANCRUD").executeQuery();
//                         dc.getApplicationModule().findViewObject("SoSalesOrderViewCRUD").getCurrentRow().setAttribute("txtIMEIAndBox", null);
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                //                throw new JboException(ERPSolPlsql);
                     }
                 } catch (SQLException e) {
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
    System.out.println("hello");
        setERPSolImeiBox(null);
        getERPSolImeiBoxText().setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolImeiBoxText());
        System.out.println("5435");    
        
    }

    public void doERPSolScanRebateImei2(ValueChangeEvent erpvcevt) {
        System.out.println(erpvcevt.getNewValue()+ " get new value");
        System.out.println("one");
    }

    public void doERPSolScanRebateImei(ValueChangeEvent erpvce) {
        System.out.println(erpvce.getNewValue()+ " get new value");
        System.out.println("1");
        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("2");
        DCDataControl dc = bc.getDataControl();
        System.out.println("3");
        String ERPSolPlsql="begin ?:=PKG_SALES_REBATE.FUNC_IMEI_VALIDATION('"+getERPSolSalesOrderId()+"','"+erpvce.getNewValue()+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); end;";
        System.out.println("4");
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        System.out.println("5");
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     System.out.println("6");
                     cs.registerOutParameter(1, Types.VARCHAR);
                     System.out.println("7");
                     cs.executeUpdate();
                     System.out.println("8");
                     ERPSolPlsql=cs.getString(1);
                     System.out.println("9");
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                         
                         erpsoldbt.commit();
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                     }
                 } catch (SQLException e) {
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
        
        dc.getApplicationModule().findViewObject("SoRebateImeDetCRUD").executeQuery();
    }


    public void setERPSolScanType(String ERPSolScanType) {
        this.ERPSolScanType = ERPSolScanType;
    }

    public String getERPSolScanType() {
        return ERPSolScanType;
    }

    public void setERPSolProductId(String ERPSolProductId) {
        this.ERPSolProductId = ERPSolProductId;
    }

    public String getERPSolProductId() {
        return ERPSolProductId;
    }

    public void setERPSolSalesOrderId(String ERPSolSalesOrderId) {
        this.ERPSolSalesOrderId = ERPSolSalesOrderId;
    }

    public String getERPSolSalesOrderId() {
        return ERPSolSalesOrderId;
    }

    public void setERPSolImeiBox(String ERPSolImeiBox) {
        this.ERPSolImeiBox = ERPSolImeiBox;
    }

    public String getERPSolImeiBox() {
        return ERPSolImeiBox;
    }

    public void setERPSolImeiBoxText(RichInputText ERPSolImeiBoxText) {
        this.ERPSolImeiBoxText = ERPSolImeiBoxText;
    }

    public RichInputText getERPSolImeiBoxText() {
        return ERPSolImeiBoxText;
    }

    public void setERPSolRebateImeiBoxText(RichInputText ERPSolRebateImeiBoxText) {
        this.ERPSolRebateImeiBoxText = ERPSolRebateImeiBoxText;
    }

    public RichInputText getERPSolRebateImeiBoxText() {
        return ERPSolRebateImeiBoxText;
    }

    public void setERPSolImeiString(String ERPSolImeiString) {
        this.ERPSolImeiString = ERPSolImeiString;
    }

    public String getERPSolImeiString() {
        return null;
    }
    public String doGenerateSoRebateDetail() {
     
        System.out.println("1");
        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("2");
        DCDataControl dc = bc.getDataControl();
        System.out.println("3");
        String ERPSolPlsql="begin ?:=PKG_SALES_REBATE.FUNC_MAKE_PRODUCT_FROM_IMEI('"+getERPSolSalesOrderId()+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); end;";
        System.out.println("4");
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        System.out.println("5");
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     System.out.println("6");
                     cs.registerOutParameter(1, Types.VARCHAR);
                     System.out.println("7");
                     cs.executeUpdate();
                     System.out.println("8");
                     ERPSolPlsql=cs.getString(1);
                     System.out.println("9");
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                         
                         erpsoldbt.commit();
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                     }
                 } catch (SQLException e) {
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
        
        
           
        return "ACT-BACK-FROM-REBATE-IMEI";
    }
    
    public void erpSolSaleReturnBOX(ValueChangeEvent erpvce) {
        if (erpvce.getNewValue()==null) {
            return ;
        }
        doInserterpSolSaleReturnImeiBox(erpvce.getNewValue().toString(),"B");
        System.out.println("5435");    
    }

    public void erpSolSaleReturnMemoBOX(ValueChangeEvent erpvce) {
        if (erpvce.getNewValue()==null) {
            return ;
        }
        doInserterpSolSaleReturnMemoImeiBox(erpvce.getNewValue().toString(),"B");
        System.out.println("5435");    
    }
    
    public void erpSolSaleReturnIMEI(ValueChangeEvent erpvce) {
        if (erpvce.getNewValue()==null) {
            return ;
        }
        doInserterpSolSaleReturnImeiBox(erpvce.getNewValue().toString(),"I");
    //        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolImeiBoxText());
        System.out.println("5435");    
        
    }  

    public void erpSolSaleReturnMemoIMEI(ValueChangeEvent erpvce) {
        if (erpvce.getNewValue()==null) {
            return ;
        }
        doInserterpSolSaleReturnMemoImeiBox(erpvce.getNewValue().toString(),"I");
    //        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolImeiBoxText());
        System.out.println("5435");    
        
    }    
    
    public void doInserterpSolSaleReturnImeiBox(String pImeiBox, String pValueType) {
        if (pImeiBox==null) {
            return ;
        }
        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        DCDataControl dc = bc.getDataControl();
        String ERPSolPlsql="begin ?:=Pkg_Sale_Order.FUNC_SRET_IMEI_BOX_VALIDATION('"+getERPSolSaleretid()+"','"+pImeiBox+"','"+pValueType+"','"+getERPSolProductId()+"'); end;";
        System.out.println(ERPSolPlsql);
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     cs.registerOutParameter(1, Types.VARCHAR);
                     cs.executeUpdate();
                     ERPSolPlsql=cs.getString(1);
                    System.out.println(ERPSolPlsql);
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                         System.out.println("comong");
                         erpsoldbt.commit();
                     dc.getApplicationModule().findViewObject("SrimeiViewBySrdetlinesseqCRUD").executeQuery();
    //                         dc.getApplicationModule().findViewObject("SoSalesOrderViewCRUD").getCurrentRow().setAttribute("txtIMEIAndBox", null);
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                //                throw new JboException(ERPSolPlsql);
                     }
                 } catch (SQLException e) {
                e.printStackTrace();
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
        
    }
    
    public void doInserterpSolSaleReturnMemoImeiBox(String pImeiBox, String pValueType) {
        if (pImeiBox==null) {
            return ;
        }
        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        DCDataControl dc = bc.getDataControl();
        String ERPSolPlsql="begin ?:=Pkg_Sale_Order.FUNC_SRME_IMEI_BOX_VALIDATION('"+getERPSolSaleretid()+"','"+pImeiBox+"','"+pValueType+"','"+getERPSolProductId()+"'); end;";
        System.out.println(ERPSolPlsql);
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     cs.registerOutParameter(1, Types.VARCHAR);
                     cs.executeUpdate();
                     ERPSolPlsql=cs.getString(1);
                    System.out.println(ERPSolPlsql);
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                         System.out.println("comong");
                         erpsoldbt.commit();
                     dc.getApplicationModule().findViewObject("SrimeiMemoByReturnmemolineseqCRUD").executeQuery();
    //                         dc.getApplicationModule().findViewObject("SoSalesOrderViewCRUD").getCurrentRow().setAttribute("txtIMEIAndBox", null);
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                //                throw new JboException(ERPSolPlsql);
                     }
                 } catch (SQLException e) {
                e.printStackTrace();
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
        
    }    
    public String doERPSolExecuteReport() {
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
        DCIteratorBinding ib=(DCIteratorBinding)bc.get("SysProgramDetROIterator");
        ApplicationModule am=ib.getViewObject().getApplicationModule();
        ViewObject vo=am.findViewObject("QVOReport");
        if (vo!=null) {
            vo.remove();
       }
        
        vo=am.createViewObjectFromQueryStmt("QVOReport", "select PARAMETER_VALUE FROM so_sales_parameter a where a.Parameter_Id='REPORT_SERVER_URL'");
        vo.executeQuery();
        String pReportUrl=vo.first().getAttribute(0).toString();
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOReport", "select PATH PATH FROM SYSTEM a where a.PROJECTID='SO' ");
        vo.executeQuery();
        String pReportPath=vo.first().getAttribute(0).toString()+"REPORTS\\\\";
        System.out.println(pReportPath);
        pReportPath=pReportPath+ERPSolReportName;
        
 
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPCompanyid       =(AttributeBinding)ERPSolbc.getControlBinding("Companyid");
        AttributeBinding ERPRegionid        =(AttributeBinding)ERPSolbc.getControlBinding("Regionid");
        AttributeBinding ERPLocationid      =(AttributeBinding)ERPSolbc.getControlBinding("Locationid");
        AttributeBinding ERPDivid           =(AttributeBinding)ERPSolbc.getControlBinding("Divid");
        AttributeBinding ERPStoreid         =(AttributeBinding)ERPSolbc.getControlBinding("Storeid");
        AttributeBinding ERPCustomerid      =(AttributeBinding)ERPSolbc.getControlBinding("Customerid");
        AttributeBinding ERPSalespersonid   =(AttributeBinding)ERPSolbc.getControlBinding("Salespersonid");
        AttributeBinding ERPProductgroup    =(AttributeBinding)ERPSolbc.getControlBinding("Productgroup");
        AttributeBinding ERPProductid       =(AttributeBinding)ERPSolbc.getControlBinding("Productid");
        AttributeBinding ERPFromDate        =(AttributeBinding)ERPSolbc.getControlBinding("txtFromDate");
        AttributeBinding ERPToDate          =(AttributeBinding)ERPSolbc.getControlBinding("txtToDate");
        AttributeBinding ERPTerritoryId     =(AttributeBinding)ERPSolbc.getControlBinding("txtSalesTerritoryId");
        String reportParameter="";
        reportParameter="COMPANY="+ (ERPCompanyid.getInputValue()==null?"":ERPCompanyid.getInputValue());
        reportParameter+="&P_REGID="+(ERPRegionid.getInputValue()==null?"":ERPRegionid.getInputValue());
        reportParameter+="&P_DIVID="+(ERPDivid.getInputValue()==null?"":ERPDivid.getInputValue());
        reportParameter+="&P_LOCID="+(ERPLocationid.getInputValue()==null?"":ERPLocationid.getInputValue());
        reportParameter+="&P_STORE="+(ERPStoreid.getInputValue()==null?"":ERPStoreid.getInputValue());
        reportParameter+="&CUSTID="+(ERPCustomerid.getInputValue()==null?"":ERPCustomerid.getInputValue());
        reportParameter+="&salepersonid="+(ERPSalespersonid.getInputValue()==null?"":ERPSalespersonid.getInputValue());
        reportParameter+="&GROUPID="+(ERPProductgroup.getInputValue()==null?"":ERPProductgroup.getInputValue());
        reportParameter+="&p_productid="+(ERPProductid.getInputValue()==null?"":ERPProductid.getInputValue());
        reportParameter+="&FROM_DATE="+(ERPFromDate.getInputValue()==null?"":doERPSolGetFormatDate(""+ERPFromDate.getInputValue() ) );
        reportParameter+="&TO_DATE="+(ERPToDate.getInputValue()==null?"":doERPSolGetFormatDate(""+ERPToDate.getInputValue())  );
        reportParameter+="&P_Territory_Id="+(ERPTerritoryId.getInputValue()==null?"":ERPTerritoryId.getInputValue() );
        reportParameter+="&USER="+ERPSolGlobClassModel.doGetUserCode();
        pReportUrl=pReportUrl.replace("<P_REPORT_PATH>", pReportPath);
        pReportUrl=pReportUrl.replace("<P_REPORT_PARAMETERS>", reportParameter);
        
        System.out.println(pReportPath);
        System.out.println(reportParameter);
        System.out.println(pReportUrl);
        
        doErpSolOpenReportTab(pReportUrl);
        return null;
    }

    public String doERPSolExecuteSalesInvoice() {
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
//        DCIteratorBinding ib=(DCIteratorBinding)bc.get("SoSalesOrderViewCRUDIterator");
        DCIteratorBinding ib=(DCIteratorBinding)bc.get(getERPIteratorName());
        ApplicationModule am=ib.getViewObject().getApplicationModule();
        ViewObject vo=am.findViewObject("QVOSaleInvoice");
        if (vo!=null) {
            vo.remove();
       }
        
        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select PARAMETER_VALUE FROM so_sales_parameter a where a.Parameter_Id='REPORT_SERVER_URL'");
        vo.executeQuery();
        String pReportUrl=vo.first().getAttribute(0).toString();
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select PATH PATH FROM SYSTEM a where a.PROJECTID='SO' ");
        vo.executeQuery();
        String pReportPath=vo.first().getAttribute(0).toString()+"REPORTS\\\\";
        System.out.println(pReportPath);
        pReportPath=pReportPath+"SALE_INVOICE";
        vo.executeQuery();    
        
        
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPSalesorderid       =(AttributeBinding)ERPSolbc.getControlBinding("Salesorderid");
        AttributeBinding ERPCompanyid       =(AttributeBinding)ERPSolbc.getControlBinding("Companyid");
        System.out.println("select ISSUENO  FROM IN_ISSUED_ITEMS a where a.Issuedoctypeid='SO' and a.Source_Doc_Ref='"+ERPSalesorderid.getInputValue()+"'");
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select ISSUENO  FROM IN_ISSUED_ITEMS a where a.Issuedoctypeid='SO' and a.Source_Doc_Ref='"+ERPSalesorderid.getInputValue()+"'");
        
        vo.executeQuery();
        
        String reportParameter="";
        String ERPSolIssueno=vo.first().getAttribute(0).toString();
        reportParameter="COMPANY="+ (ERPCompanyid.getInputValue()==null?"":ERPCompanyid.getInputValue());
        reportParameter+="&ISSUE_NO="+ERPSolIssueno;
        reportParameter+="&USER="+ERPSolGlobClassModel.doGetUserCode();
        pReportUrl=pReportUrl.replace("<P_REPORT_PATH>", pReportPath);
        pReportUrl=pReportUrl.replace("<P_REPORT_PARAMETERS>", reportParameter);
        
        System.out.println(pReportPath);
        System.out.println(reportParameter);
        System.out.println(pReportUrl);
        
        doErpSolOpenReportTab(pReportUrl);
        return null;
    }

    public String doERPSolExecuteDeliveryOrder() {
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
//        DCIteratorBinding ib=(DCIteratorBinding)bc.get("SoSalesOrderViewCRUDIterator");
        DCIteratorBinding ib=(DCIteratorBinding)bc.get(getERPIteratorName());

        ApplicationModule am=ib.getViewObject().getApplicationModule();
        ViewObject vo=am.findViewObject("QVOSaleInvoice");
        if (vo!=null) {
            vo.remove();
       }
        
        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select PARAMETER_VALUE FROM so_sales_parameter a where a.Parameter_Id='REPORT_SERVER_URL'");
        vo.executeQuery();
        String pReportUrl=vo.first().getAttribute(0).toString();
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select PATH PATH FROM SYSTEM a where a.PROJECTID='SO' ");
        vo.executeQuery();
        String pReportPath=vo.first().getAttribute(0).toString()+"REPORTS\\\\";
        System.out.println(pReportPath);
        pReportPath=pReportPath+"delivery_order_fullpage";
        vo.executeQuery();    
        
        
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPSalesorderid       =(AttributeBinding)ERPSolbc.getControlBinding("Salesorderid");
        AttributeBinding ERPCompanyid       =(AttributeBinding)ERPSolbc.getControlBinding("Companyid");
        System.out.println("select ISSUENO  FROM IN_ISSUED_ITEMS a where a.Issuedoctypeid='SO' and a.Source_Doc_Ref='"+ERPSalesorderid.getInputValue()+"'");
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select ISSUENO  FROM IN_ISSUED_ITEMS a where a.Issuedoctypeid='SO' and a.Source_Doc_Ref='"+ERPSalesorderid.getInputValue()+"'");
        
        vo.executeQuery();
        
        String reportParameter="";
        String ERPSolIssueno=vo.first().getAttribute(0).toString();
        reportParameter="COMPANY="+ (ERPCompanyid.getInputValue()==null?"":ERPCompanyid.getInputValue());
        reportParameter+="&STANO="+ERPSolIssueno;
        reportParameter+="&USER="+ERPSolGlobClassModel.doGetUserCode();
        pReportUrl=pReportUrl.replace("<P_REPORT_PATH>", pReportPath);
        pReportUrl=pReportUrl.replace("<P_REPORT_PARAMETERS>", reportParameter);
        
        System.out.println(pReportPath);
        System.out.println(reportParameter);
        System.out.println(pReportUrl);
        
        doErpSolOpenReportTab(pReportUrl);
        return null;
    }
  
    public String doERPSolExecuteWarehouse() {
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
//        DCIteratorBinding ib=(DCIteratorBinding)bc.get("SoSalesOrderViewCRUDIterator");
        DCIteratorBinding ib=(DCIteratorBinding)bc.get(getERPIteratorName());
        ApplicationModule am=ib.getViewObject().getApplicationModule();
        ViewObject vo=am.findViewObject("QVOSaleInvoice");
        if (vo!=null) {
            vo.remove();
       }
        
        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select PARAMETER_VALUE FROM so_sales_parameter a where a.Parameter_Id='REPORT_SERVER_URL'");
        vo.executeQuery();
        String pReportUrl=vo.first().getAttribute(0).toString();
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select PATH PATH FROM SYSTEM a where a.PROJECTID='SO' ");
        vo.executeQuery();
        String pReportPath=vo.first().getAttribute(0).toString()+"REPORTS\\\\";
        System.out.println(pReportPath);
        pReportPath=pReportPath+"WAREHOUSE";
        vo.executeQuery();    
        
        
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPSalesorderid       =(AttributeBinding)ERPSolbc.getControlBinding("Salesorderid");
        AttributeBinding ERPCompanyid       =(AttributeBinding)ERPSolbc.getControlBinding("Companyid");
//        System.out.println("select ISSUENO  FROM IN_ISSUED_ITEMS a where a.Issuedoctypeid='SO' and a.Source_Doc_Ref='"+ERPSalesorderid.getInputValue()+"'");
//        vo.remove();
//        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select ISSUENO  FROM IN_ISSUED_ITEMS a where a.Issuedoctypeid='SO' and a.Source_Doc_Ref='"+ERPSalesorderid.getInputValue()+"'");
        
        vo.executeQuery();
        
        String reportParameter="";
        
        reportParameter="COMPANY="+ (ERPCompanyid.getInputValue()==null?"":ERPCompanyid.getInputValue());
        reportParameter+="&SO_ID="+ERPSalesorderid.getInputValue();
        reportParameter+="&USER="+ERPSolGlobClassModel.doGetUserCode();
        pReportUrl=pReportUrl.replace("<P_REPORT_PATH>", pReportPath);
        pReportUrl=pReportUrl.replace("<P_REPORT_PARAMETERS>", reportParameter);
        
        System.out.println(pReportPath);
        System.out.println(reportParameter);
        System.out.println(pReportUrl);
        
        doErpSolOpenReportTab(pReportUrl);
        return null;
    }
    
    public String doERPSolExecuteSaleReturn() {
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
        DCIteratorBinding ib=(DCIteratorBinding)bc.get("SoSalesReturnCRUDIterator");
        ApplicationModule am=ib.getViewObject().getApplicationModule();
        ViewObject vo=am.findViewObject("QVOSaleReturn");
        if (vo!=null) {
            vo.remove();
       }
        
        vo=am.createViewObjectFromQueryStmt("QVOSaleReturn", "select PARAMETER_VALUE FROM so_sales_parameter a where a.Parameter_Id='REPORT_SERVER_URL'");
        vo.executeQuery();
        String pReportUrl=vo.first().getAttribute(0).toString();
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOSaleReturn", "select PATH PATH FROM SYSTEM a where a.PROJECTID='SO' ");
        vo.executeQuery();
        String pReportPath=vo.first().getAttribute(0).toString()+"REPORTS\\\\";
        System.out.println(pReportPath);
        pReportPath=pReportPath+"SALE_RETURN";
        vo.executeQuery();    
        
        
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPSalesretid       =(AttributeBinding)ERPSolbc.getControlBinding("Salesretid");
        AttributeBinding ERPCompanyid       =(AttributeBinding)ERPSolbc.getControlBinding("Companyid");
    //        System.out.println("select ISSUENO  FROM IN_ISSUED_ITEMS a where a.Issuedoctypeid='SO' and a.Source_Doc_Ref='"+ERPSalesorderid.getInputValue()+"'");
    //        vo.remove();
    //        vo=am.createViewObjectFromQueryStmt("QVOSaleInvoice", "select ISSUENO  FROM IN_ISSUED_ITEMS a where a.Issuedoctypeid='SO' and a.Source_Doc_Ref='"+ERPSalesorderid.getInputValue()+"'");
        
        vo.executeQuery();
        
        String reportParameter="";
        
        reportParameter="COMPANY="+ (ERPCompanyid.getInputValue()==null?"":ERPCompanyid.getInputValue());
        reportParameter+="&P_SALESRETID="+ERPSalesretid.getInputValue();
        reportParameter+="&USER="+ERPSolGlobClassModel.doGetUserCode();
        pReportUrl=pReportUrl.replace("<P_REPORT_PATH>", pReportPath);
        pReportUrl=pReportUrl.replace("<P_REPORT_PARAMETERS>", reportParameter);
        
        System.out.println(pReportPath);
        System.out.println(reportParameter);
        System.out.println(pReportUrl);
        
        doErpSolOpenReportTab(pReportUrl);
        return null;
    }
    
    public String doERPSolExecuteSaleRebate() {
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
        DCIteratorBinding ib=(DCIteratorBinding)bc.get("SoRebateCRUDIterator");
        ApplicationModule am=ib.getViewObject().getApplicationModule();
        ViewObject vo=am.findViewObject("QVOSaleRebate");
        if (vo!=null) {
            vo.remove();
       }
        
        vo=am.createViewObjectFromQueryStmt("QVOSaleRebate", "select PARAMETER_VALUE FROM so_sales_parameter a where a.Parameter_Id='REPORT_SERVER_URL'");
        vo.executeQuery();
        String pReportUrl=vo.first().getAttribute(0).toString();
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOSaleRebate", "select PATH PATH FROM SYSTEM a where a.PROJECTID='SO' ");
        vo.executeQuery();
        String pReportPath=vo.first().getAttribute(0).toString()+"REPORTS\\\\";
        System.out.println(pReportPath);
        pReportPath=pReportPath+"SALE_REBATE";
        vo.executeQuery();    
        
        
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPRebateId       =(AttributeBinding)ERPSolbc.getControlBinding("RebateId");
        
        vo.executeQuery();
        
        String reportParameter="";
        
        reportParameter="COMPANY=D";
        reportParameter+="&P_SALESRETID="+ERPRebateId.getInputValue();
        reportParameter+="&USER="+ERPSolGlobClassModel.doGetUserCode();
        pReportUrl=pReportUrl.replace("<P_REPORT_PATH>", pReportPath);
        pReportUrl=pReportUrl.replace("<P_REPORT_PARAMETERS>", reportParameter);
        
        System.out.println(pReportPath);
        System.out.println(reportParameter);
        System.out.println(pReportUrl);
        
        doErpSolOpenReportTab(pReportUrl);
        return null;
    }
    
    public void setERPSolReportName(String ERPSolReportName) {
        this.ERPSolReportName = ERPSolReportName;
    }

    public String getERPSolReportName() {
        return ERPSolReportName;
    }
  
    public void doErpSolOpenReportTab(String url) {
    ExtendedRenderKitService erks =
    Service.getRenderKitService(FacesContext.getCurrentInstance(), ExtendedRenderKitService.class);
    StringBuilder strb = new StringBuilder("window.open('" + url + "');");
    erks.addScript(FacesContext.getCurrentInstance(), strb.toString());
    }  
    
    public String doERPSolGetFormatDate(String pDate) {
     
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String fromDate="";
        try {
            Date dt = sdf.parse(pDate);
            sdf=new SimpleDateFormat("dd-MMM-yyyy");
            fromDate=sdf.format(dt).toUpperCase();
            return fromDate;
        }
        catch (NullPointerException npe) {
            System.out.println("null parseexception");
        }
        catch (ParseException e) {
            System.out.println("parseexception");
        }
        /////////////
           
        return null;
    }
  
    public void handleEnterEventIMEI(ClientEvent ce) {
    String value = (String) ce.getParameters().get("fvalue");
    System.out.println(value);

        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        DCDataControl dc = bc.getDataControl();
        String ERPSolPlsql="begin ?:=PKG_SALE_ORDER.FUNC_IMEI_BOX_VALIDATION('"+getERPSolSalesOrderId()+"','"+value+"','I','"+getERPSolProductId()+"'); end;";
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     cs.registerOutParameter(1, Types.VARCHAR);
                     cs.executeUpdate();
                     ERPSolPlsql=cs.getString(1);
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                     erpsoldbt.commit();
                     dc.getApplicationModule().findViewObject("SoSalesOrderImeiSCANCRUD").executeQuery();
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                     }
                 } catch (SQLException e) {
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
//        setERPSolImeiBox(null);
//        getERPSolImeiBoxText().setValue(null);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolImeiBoxText());
        

//        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
//        DCIteratorBinding ib=(DCIteratorBinding)bc.get("SoSalesOrderViewCRUDIterator");
//        ViewObject ERPSolvo=ib.getViewObject();
//        Row ERPsolrow=ERPSolvo.createRow();
//        ERPsolrow.setAttribute("ImeiNo", message);
//        ERPSolvo.insertRow(ERPsolrow);
    }
  
    public void handleEnterEventBox(ClientEvent ce) {
    String value ;
    try {
           value = ce.getParameters().get("fvalue").toString().toUpperCase();
        if (value.length()==0) {
                return;
           }
       } catch (Exception e) {
            // TODO: Add catch code
            return ;
        }
    

        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        DCDataControl dc = bc.getDataControl();
        String ERPSolPlsql="begin ?:=PKG_SALE_ORDER.FUNC_IMEI_BOX_VALIDATION('"+getERPSolSalesOrderId()+"','"+value+"','B','"+getERPSolProductId()+"'); end;";
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     cs.registerOutParameter(1, Types.VARCHAR);
                     cs.executeUpdate();
                     ERPSolPlsql=cs.getString(1);
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                     erpsoldbt.commit();
                     dc.getApplicationModule().findViewObject("SoSalesOrderImeiSCANCRUD").executeQuery();
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                     }
                 } catch (SQLException e) {
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
    //        setERPSolImeiBox(null);
    //        getERPSolImeiBoxText().setValue(null);
    //        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolImeiBoxText());
        

    //        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
    //        DCIteratorBinding ib=(DCIteratorBinding)bc.get("SoSalesOrderViewCRUDIterator");
    //        ViewObject ERPSolvo=ib.getViewObject();
    //        Row ERPsolrow=ERPSolvo.createRow();
    //        ERPsolrow.setAttribute("ImeiNo", message);
    //        ERPSolvo.insertRow(ERPsolrow);
    }


    public void setERPSolSaleretid(String ERPSolSaleretid) {
        this.ERPSolSaleretid = ERPSolSaleretid;
    }

    public String getERPSolSaleretid() {
        return ERPSolSaleretid;
    }

    public static void main(String[] args) {
        BigDecimal fcurr=new BigDecimal(2250);
       BigDecimal discount=new BigDecimal(7.5);
       discount=((fcurr.multiply(discount)).divide(new BigDecimal(100)));
       System.out.println(Math.round(discount.doubleValue()) ); 
    
   }
    public String ERPSolGoToBack() {
    if (ERPSolGlobalViewBean.doIsERPSolTransactionDirty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please Save/Undo Changes."));
            return null;
       }
    return "ERPSOLBACK";
    }

    
    public List<SelectItem> doERPSolGetAutoSuggestedSOUnsubmitDoc(String pStringValues) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        DCIteratorBinding ERPSolIB=(DCIteratorBinding)ERPSolbc.get("VwSoSalesReportROIterator");
        ApplicationModule ERPSolAM=ERPSolIB.getViewObject().getApplicationModule();
        System.out.println("b");
        String ERPLocid=ERPSolGlobClassModel.doGetUserLocationCode();
        AttributeBinding ERPDocType =(AttributeBinding)ERPSolbc.getControlBinding("txtDoctypeId");
        ViewObject vo=ERPSolAM.findViewObject("VWDocumentIdForUnsubmitAutoSuggestRO");
        vo.setNamedWhereClauseParam("P_ADF_DOCTYPEID", ERPDocType.getInputValue());
        vo.setNamedWhereClauseParam("P_ADF_LOCATIONID", ERPLocid);
        vo.executeQuery();
        System.out.println("d");
        System.out.println(ERPLocid);//ERPSolGlobalViewBean.
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "VWDocumentIdForUnsubmitAutoSuggestRO",
                                                            " UPPER(CONCAT(DOCUMENT_ID,CUSTOMER_NAME))", "DocumentId", "Description", 10);
        return ResultList;
        
    }    
    public void doERPSolDialogQuestion(DialogEvent erpsolde) {
        if (erpsolde.getOutcome()==DialogEvent.Outcome.yes) {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit");
            binding.execute();
            
        }
    }


    public void setERPIteratorName(String ERPIteratorName) {
        this.ERPIteratorName = ERPIteratorName;
    }

    public String getERPIteratorName() {
        return ERPIteratorName;
    }
}
