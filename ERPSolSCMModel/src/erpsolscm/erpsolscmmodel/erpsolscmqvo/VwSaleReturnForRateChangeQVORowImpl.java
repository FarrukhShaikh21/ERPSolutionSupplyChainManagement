package erpsolscm.erpsolscmmodel.erpsolscmqvo;

import erpsolscm.erpsolscmmodel.erpsolscmqvo.common.VwSaleReturnForRateChangeQVORow;

import java.math.BigDecimal;

import java.sql.CallableStatement;

import java.sql.SQLException;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Aug 26 09:28:59 PKT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VwSaleReturnForRateChangeQVORowImpl extends ViewRowImpl implements VwSaleReturnForRateChangeQVORow {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Salesretid,
        Customerid,
        CustomerName,
        ReturnDate,
        Productid,
        ProductName,
        ActUnitPriceBcurr,
        FcurrDefaultDiscountAmount,
        DiscountPercentage,
        txtNewRate;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int SALESRETID = AttributesEnum.Salesretid.index();
    public static final int CUSTOMERID = AttributesEnum.Customerid.index();
    public static final int CUSTOMERNAME = AttributesEnum.CustomerName.index();
    public static final int RETURNDATE = AttributesEnum.ReturnDate.index();
    public static final int PRODUCTID = AttributesEnum.Productid.index();
    public static final int PRODUCTNAME = AttributesEnum.ProductName.index();
    public static final int ACTUNITPRICEBCURR = AttributesEnum.ActUnitPriceBcurr.index();
    public static final int FCURRDEFAULTDISCOUNTAMOUNT = AttributesEnum.FcurrDefaultDiscountAmount.index();
    public static final int DISCOUNTPERCENTAGE = AttributesEnum.DiscountPercentage.index();
    public static final int TXTNEWRATE = AttributesEnum.txtNewRate.index();

    /**
     * This is the default constructor (do not remove).
     */
    public VwSaleReturnForRateChangeQVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute Salesretid.
     * @return the Salesretid
     */
    public String getSalesretid() {
        return (String) getAttributeInternal(SALESRETID);
    }

    /**
     * Gets the attribute value for the calculated attribute Customerid.
     * @return the Customerid
     */
    public String getCustomerid() {
        return (String) getAttributeInternal(CUSTOMERID);
    }

    /**
     * Gets the attribute value for the calculated attribute CustomerName.
     * @return the CustomerName
     */
    public String getCustomerName() {
        return (String) getAttributeInternal(CUSTOMERNAME);
    }

    /**
     * Gets the attribute value for the calculated attribute ReturnDate.
     * @return the ReturnDate
     */
    public String getReturnDate() {
        return (String) getAttributeInternal(RETURNDATE);
    }

    /**
     * Gets the attribute value for the calculated attribute Productid.
     * @return the Productid
     */
    public String getProductid() {
        return (String) getAttributeInternal(PRODUCTID);
    }

    /**
     * Gets the attribute value for the calculated attribute ProductName.
     * @return the ProductName
     */
    public String getProductName() {
        return (String) getAttributeInternal(PRODUCTNAME);
    }

    /**
     * Gets the attribute value for the calculated attribute ActUnitPriceBcurr.
     * @return the ActUnitPriceBcurr
     */
    public BigDecimal getActUnitPriceBcurr() {
        return (BigDecimal) getAttributeInternal(ACTUNITPRICEBCURR);
    }

    /**
     * Gets the attribute value for the calculated attribute FcurrDefaultDiscountAmount.
     * @return the FcurrDefaultDiscountAmount
     */
    public BigDecimal getFcurrDefaultDiscountAmount() {
        return (BigDecimal) getAttributeInternal(FCURRDEFAULTDISCOUNTAMOUNT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute FcurrDefaultDiscountAmount.
     * @param value value to set the  FcurrDefaultDiscountAmount
     */
    public void setFcurrDefaultDiscountAmount(BigDecimal value) {
        setAttributeInternal(FCURRDEFAULTDISCOUNTAMOUNT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DiscountPercentage.
     * @return the DiscountPercentage
     */
    public BigDecimal getDiscountPercentage() {
        return (BigDecimal) getAttributeInternal(DISCOUNTPERCENTAGE);
    }

    /**
     * Gets the attribute value for the calculated attribute txtNewRate.
     * @return the txtNewRate
     */
    public BigDecimal gettxtNewRate() {
        return (BigDecimal) getAttributeInternal(TXTNEWRATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute txtNewRate.
     * @param value value to set the  txtNewRate
     */
    public void settxtNewRate(BigDecimal value) {
        setAttributeInternal(TXTNEWRATE, value);
        Integer val=value.multiply(getDiscountPercentage()).divide(new BigDecimal(100)).intValue();
        setFcurrDefaultDiscountAmount(new BigDecimal(val) );  
        }
    public void doUpdateSaleReturnProductRate() {
        
        String plsql="BEGIN UPDATE SO_SALES_RETURN_LINES sol set ";
        plsql+="DEFAULT_DISCOUNT_AMOUNT="+getFcurrDefaultDiscountAmount()+",";
        plsql+="FCURR_DEFAULT_DISCOUNT_AMOUNT="+getFcurrDefaultDiscountAmount()+",";
        plsql+="RET_DISCOUNT_AMOUNT="+getFcurrDefaultDiscountAmount()+",";
        plsql+="ACT_UNIT_PRICE_FCURR="+gettxtNewRate()+",";
        plsql+="ACT_UNIT_PRICE_BCURR="+gettxtNewRate();
        plsql+=" WHERE Productid='"+getProductid()+"' AND SALESRETID='"+getSalesretid()+"' ; COMMIT; END;";
        CallableStatement erpcs=getDBTransaction().createCallableStatement(plsql, 1);
        try {
            erpcs.executeUpdate();
        } catch (SQLException e) {
        }
        finally{
            try {
                erpcs.close();
            } catch (SQLException e) {
            }
        }
    }
}

