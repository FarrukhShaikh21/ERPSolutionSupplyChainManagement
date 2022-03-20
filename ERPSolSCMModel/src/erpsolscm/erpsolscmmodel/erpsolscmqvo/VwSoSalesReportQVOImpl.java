package erpsolscm.erpsolscmmodel.erpsolscmqvo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;

import erpsolscm.erpsolscmmodel.erpsolscmqvo.common.VwSoSalesReportQVO;

import java.sql.CallableStatement;

import java.sql.SQLException;
import java.sql.Types;

import oracle.jbo.JboException;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Feb 03 18:37:31 PKT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VwSoSalesReportQVOImpl extends ViewObjectImpl implements VwSoSalesReportQVO {
    /**
     * This is the default constructor (do not remove).
     */
    public VwSoSalesReportQVOImpl() {
    }
    
    public void doSetERPSolSCMReportDefault() {
        ViewObject vo=getApplicationModule().findViewObject("QvoSaleLoc");
        if (vo!=null) {
            vo.remove();
       }
        vo=getApplicationModule().createViewObjectFromQueryStmt("QvoSaleLoc", "select locationid, location_description from all_locations where locationid='"+ERPSolGlobClassModel.doGetUserLocationCode()+"'");
        vo.executeQuery();;
        this.first().setAttribute("Locationid", vo.first().getAttribute(0));
        this.first().setAttribute("txtLocationName", vo.first().getAttribute(1));
        this.first().setAttribute("Companyid", ERPSolGlobClassModel.doGetUserCompanyCode());
//        this.first().setAttribute("txtFromDate", this.first().getAttribute("txtDefaultDate"));
//        this.first().setAttribute("txtToDate", this.first().getAttribute("txtDefaultDate"));
        vo.remove();
    }
    
    public void doSetERPSolSODocumentUnsubmit() {
        CallableStatement cs=this.getDBTransaction().createCallableStatement("begin ?:=PKG_SALE_ORDER.FUNC_UNSUBMIT_SO_DOCUMENT('"+this.first().getAttribute("txtDoctypeId")+"','"+this.first().getAttribute("txtDocumentID")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); END;", 1);
        System.out.println("begin ?:=PKG_SALE_ORDER.FUNC_UNSUBMIT_SO_DOCUMENT('"+this.first().getAttribute("txtDoctypeId")+"','"+this.first().getAttribute("txtDocumentID")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); END;");
        try {
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.executeUpdate();
            
//            if (!cs.getString(1).equals("ERPSOLSUCCESS")) {
                JboException jboex=new JboException(cs.getString(1));
                jboex.setSeverity(JboException.SEVERITY_WARNING); 
                throw new JboException(jboex);
//           }
//            this.getDBTransaction().commit();
        } catch (SQLException e) {
        //            this.getCurrentRow().setAttribute("Submit", "N");
            this.getDBTransaction().commit();
            System.out.println(e.getMessage()+ "this is message");
            throw new JboException("Unable to supervise ");
        }
        finally{
            try {
                cs.close();
                System.out.println("closing----");
            } catch (SQLException e) {
            }
        }

        
    }
}

