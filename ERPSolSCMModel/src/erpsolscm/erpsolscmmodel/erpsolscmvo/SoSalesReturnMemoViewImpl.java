package erpsolscm.erpsolscmmodel.erpsolscmvo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;

import erpsolscm.erpsolscmmodel.erpsolscmvo.common.SoSalesReturnMemoView;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed May 18 09:30:39 PKT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SoSalesReturnMemoViewImpl extends ViewObjectImpl implements SoSalesReturnMemoView {
    /**
     * This is the default constructor (do not remove).
     */
    public SoSalesReturnMemoViewImpl() {
    }

    public void doSuperviseSalesReturnMemo() {
        
        CallableStatement cs=this.getDBTransaction().createCallableStatement("begin ?:=pkg_sale_order.func_submit_sales_return_memo('"+this.getCurrentRow().getAttribute("Salesretid")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); END;", 1);
    //        System.out.println("begin ?:=Pkg_Sales_Rebate.FUNC_SUBMIT_SALES_RETURN('"+this.getCurrentRow().getAttribute("Salesretid")+"'); END;");
        try {
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.executeUpdate();
            this.getCurrentRow().refresh(Row.REFRESH_WITH_DB_FORGET_CHANGES);
            
            if (!cs.getString(1).equals("ERPSOLSUCCESS")) {
    //               this.getCurrentRow().setAttribute("Posted", "N");
               this.getDBTransaction().commit();
                throw new JboException("Unable to supervise due to "+cs.getString(1));
               
           }
            this.getCurrentRow().setAttribute("Posted", "Y");
            this.getDBTransaction().commit();
        } catch (SQLException e) {
    //            this.getCurrentRow().setAttribute("Posted", "N");
            this.getDBTransaction().commit();
            System.out.println(e.getMessage()+ "this is message");
            throw new JboException("Unable to supervise ");
        }
        finally{
            try {
                cs.close();
            } catch (SQLException e) {
            }
        }
    }    
}

