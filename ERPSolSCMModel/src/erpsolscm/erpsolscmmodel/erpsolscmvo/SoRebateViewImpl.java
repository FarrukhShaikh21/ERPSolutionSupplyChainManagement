package erpsolscm.erpsolscmmodel.erpsolscmvo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;

import erpsolscm.erpsolscmmodel.erpsolscmvo.common.SoRebateView;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Nov 28 11:03:05 PKT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SoRebateViewImpl extends ViewObjectImpl implements SoRebateView {
    /**
     * This is the default constructor (do not remove).
     */
    public SoRebateViewImpl() {
    }
    
    public void doSuperviseSalesRebate() {
        getDBTransaction().commit();
        CallableStatement cs=this.getDBTransaction().createCallableStatement("begin ?:=Pkg_Sales_Rebate.FUNC_SUBMIT_SO_REBATE('"+this.getCurrentRow().getAttribute("RebateId")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); END;", 1);
        System.out.println("begin ?:=Pkg_Sales_Rebate.FUNC_SUBMIT_SO_REBATE('"+this.getCurrentRow().getAttribute("RebateId")+"'); END;");
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

    /**
     * Returns the variable value for P_ADF_SAME_RATE.
     * @return variable value for P_ADF_SAME_RATE
     */
    public String getP_ADF_SAME_RATE() {
        return (String) ensureVariableManager().getVariableValue("P_ADF_SAME_RATE");
    }

    /**
     * Sets <code>value</code> for variable P_ADF_SAME_RATE.
     * @param value value to bind as P_ADF_SAME_RATE
     */
    public void setP_ADF_SAME_RATE(String value) {
        ensureVariableManager().setVariableValue("P_ADF_SAME_RATE", value);
    }
}

