package erpsolscm.erpsolscmmodel.erpsolscmvo;

import erpsolscm.erpsolscmmodel.erpsolscmeo.SoRebateDetailImpl;

import java.math.BigDecimal;

import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Date;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jun 15 13:53:27 PKT 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SoRebateDetailViewRowImpl extends ViewRowImpl {

    public static final int ENTITY_SOREBATEDETAIL = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        RebateId,
        SalesQty,
        RebateQty,
        PreviousRate,
        CurrentRate,
        Createdby,
        CreatedDate,
        Modifiedby,
        ModifiedDate,
        GenerateSo,
        Itemid,
        Productid,
        IsError,
        ErrorDesc,
        Discount,
        AddDiscount,
        FcurrPreviousRate,
        FcurrCurrentRate,
        GrouppId,
        SaleDate,
        Rebateseq,
        Rebatedetailseq,
        ManualRate,
        SoRebateView,
        AccInItemsView;
        static AttributesEnum[] vals = null;
        ;
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

    public static final int REBATEID = AttributesEnum.RebateId.index();
    public static final int SALESQTY = AttributesEnum.SalesQty.index();
    public static final int REBATEQTY = AttributesEnum.RebateQty.index();
    public static final int PREVIOUSRATE = AttributesEnum.PreviousRate.index();
    public static final int CURRENTRATE = AttributesEnum.CurrentRate.index();
    public static final int CREATEDBY = AttributesEnum.Createdby.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int MODIFIEDBY = AttributesEnum.Modifiedby.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int GENERATESO = AttributesEnum.GenerateSo.index();
    public static final int ITEMID = AttributesEnum.Itemid.index();
    public static final int PRODUCTID = AttributesEnum.Productid.index();
    public static final int ISERROR = AttributesEnum.IsError.index();
    public static final int ERRORDESC = AttributesEnum.ErrorDesc.index();
    public static final int DISCOUNT = AttributesEnum.Discount.index();
    public static final int ADDDISCOUNT = AttributesEnum.AddDiscount.index();
    public static final int FCURRPREVIOUSRATE = AttributesEnum.FcurrPreviousRate.index();
    public static final int FCURRCURRENTRATE = AttributesEnum.FcurrCurrentRate.index();
    public static final int GROUPPID = AttributesEnum.GrouppId.index();
    public static final int SALEDATE = AttributesEnum.SaleDate.index();
    public static final int REBATESEQ = AttributesEnum.Rebateseq.index();
    public static final int REBATEDETAILSEQ = AttributesEnum.Rebatedetailseq.index();
    public static final int MANUALRATE = AttributesEnum.ManualRate.index();
    public static final int SOREBATEVIEW = AttributesEnum.SoRebateView.index();
    public static final int ACCINITEMSVIEW = AttributesEnum.AccInItemsView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SoRebateDetailViewRowImpl() {
    }

    /**
     * Gets SoRebateDetail entity object.
     * @return the SoRebateDetail
     */
    public SoRebateDetailImpl getSoRebateDetail() {
        return (SoRebateDetailImpl) getEntity(ENTITY_SOREBATEDETAIL);
    }

    /**
     * Gets the attribute value for REBATE_ID using the alias name RebateId.
     * @return the REBATE_ID
     */
    public String getRebateId() {
        return (String) getAttributeInternal(REBATEID);
    }

    /**
     * Sets <code>value</code> as attribute value for REBATE_ID using the alias name RebateId.
     * @param value value to set the REBATE_ID
     */
    public void setRebateId(String value) {
        setAttributeInternal(REBATEID, value);
    }

    /**
     * Gets the attribute value for SALES_QTY using the alias name SalesQty.
     * @return the SALES_QTY
     */
    public BigDecimal getSalesQty() {
        return (BigDecimal) getAttributeInternal(SALESQTY);
    }

    /**
     * Sets <code>value</code> as attribute value for SALES_QTY using the alias name SalesQty.
     * @param value value to set the SALES_QTY
     */
    public void setSalesQty(BigDecimal value) {
        setAttributeInternal(SALESQTY, value);
    }

    /**
     * Gets the attribute value for REBATE_QTY using the alias name RebateQty.
     * @return the REBATE_QTY
     */
    public BigDecimal getRebateQty() {
        return (BigDecimal) getAttributeInternal(REBATEQTY);
    }

    /**
     * Sets <code>value</code> as attribute value for REBATE_QTY using the alias name RebateQty.
     * @param value value to set the REBATE_QTY
     */
    public void setRebateQty(BigDecimal value) {
        setAttributeInternal(REBATEQTY, value);
    }

    /**
     * Gets the attribute value for PREVIOUS_RATE using the alias name PreviousRate.
     * @return the PREVIOUS_RATE
     */
    public BigDecimal getPreviousRate() {
        return (BigDecimal) getAttributeInternal(PREVIOUSRATE);
    }

    /**
     * Sets <code>value</code> as attribute value for PREVIOUS_RATE using the alias name PreviousRate.
     * @param value value to set the PREVIOUS_RATE
     */
    public void setPreviousRate(BigDecimal value) {
        setAttributeInternal(PREVIOUSRATE, value);
    }

    /**
     * Gets the attribute value for CURRENT_RATE using the alias name CurrentRate.
     * @return the CURRENT_RATE
     */
    public BigDecimal getCurrentRate() {
        return (BigDecimal) getAttributeInternal(CURRENTRATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CURRENT_RATE using the alias name CurrentRate.
     * @param value value to set the CURRENT_RATE
     */
    public void setCurrentRate(BigDecimal value) {
        setAttributeInternal(CURRENTRATE, value);
    }

    /**
     * Gets the attribute value for CREATEDBY using the alias name Createdby.
     * @return the CREATEDBY
     */
    public String getCreatedby() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATEDBY using the alias name Createdby.
     * @param value value to set the CREATEDBY
     */
    public void setCreatedby(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CREATED_DATE using the alias name CreatedDate.
     * @return the CREATED_DATE
     */
    public Date getCreatedDate() {
        return (Date) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATED_DATE using the alias name CreatedDate.
     * @param value value to set the CREATED_DATE
     */
    public void setCreatedDate(Date value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for MODIFIEDBY using the alias name Modifiedby.
     * @return the MODIFIEDBY
     */
    public String getModifiedby() {
        return (String) getAttributeInternal(MODIFIEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for MODIFIEDBY using the alias name Modifiedby.
     * @param value value to set the MODIFIEDBY
     */
    public void setModifiedby(String value) {
        setAttributeInternal(MODIFIEDBY, value);
    }

    /**
     * Gets the attribute value for MODIFIED_DATE using the alias name ModifiedDate.
     * @return the MODIFIED_DATE
     */
    public Date getModifiedDate() {
        return (Date) getAttributeInternal(MODIFIEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for MODIFIED_DATE using the alias name ModifiedDate.
     * @param value value to set the MODIFIED_DATE
     */
    public void setModifiedDate(Date value) {
        setAttributeInternal(MODIFIEDDATE, value);
    }

    /**
     * Gets the attribute value for GENERATE_SO using the alias name GenerateSo.
     * @return the GENERATE_SO
     */
    public String getGenerateSo() {
        return (String) getAttributeInternal(GENERATESO);
    }

    /**
     * Sets <code>value</code> as attribute value for GENERATE_SO using the alias name GenerateSo.
     * @param value value to set the GENERATE_SO
     */
    public void setGenerateSo(String value) {
        setAttributeInternal(GENERATESO, value);
    }

    /**
     * Gets the attribute value for ITEMID using the alias name Itemid.
     * @return the ITEMID
     */
    public String getItemid() {
        return (String) getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as attribute value for ITEMID using the alias name Itemid.
     * @param value value to set the ITEMID
     */
    public void setItemid(String value) {
        setAttributeInternal(ITEMID, value);
    }

    /**
     * Gets the attribute value for PRODUCTID using the alias name Productid.
     * @return the PRODUCTID
     */
    public String getProductid() {
        return (String) getAttributeInternal(PRODUCTID);
    }

    /**
     * Sets <code>value</code> as attribute value for PRODUCTID using the alias name Productid.
     * @param value value to set the PRODUCTID
     */
    public void setProductid(String value) {
        setAttributeInternal(PRODUCTID, value);
    }

    /**
     * Gets the attribute value for IS_ERROR using the alias name IsError.
     * @return the IS_ERROR
     */
    public String getIsError() {
        return (String) getAttributeInternal(ISERROR);
    }

    /**
     * Sets <code>value</code> as attribute value for IS_ERROR using the alias name IsError.
     * @param value value to set the IS_ERROR
     */
    public void setIsError(String value) {
        setAttributeInternal(ISERROR, value);
    }

    /**
     * Gets the attribute value for ERROR_DESC using the alias name ErrorDesc.
     * @return the ERROR_DESC
     */
    public String getErrorDesc() {
        return (String) getAttributeInternal(ERRORDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for ERROR_DESC using the alias name ErrorDesc.
     * @param value value to set the ERROR_DESC
     */
    public void setErrorDesc(String value) {
        setAttributeInternal(ERRORDESC, value);
    }

    /**
     * Gets the attribute value for DISCOUNT using the alias name Discount.
     * @return the DISCOUNT
     */
    public BigDecimal getDiscount() {
        return (BigDecimal) getAttributeInternal(DISCOUNT);
    }

    /**
     * Sets <code>value</code> as attribute value for DISCOUNT using the alias name Discount.
     * @param value value to set the DISCOUNT
     */
    public void setDiscount(BigDecimal value) {
        setAttributeInternal(DISCOUNT, value);
    }

    /**
     * Gets the attribute value for ADD_DISCOUNT using the alias name AddDiscount.
     * @return the ADD_DISCOUNT
     */
    public BigDecimal getAddDiscount() {
        return (BigDecimal) getAttributeInternal(ADDDISCOUNT);
    }

    /**
     * Sets <code>value</code> as attribute value for ADD_DISCOUNT using the alias name AddDiscount.
     * @param value value to set the ADD_DISCOUNT
     */
    public void setAddDiscount(BigDecimal value) {
        setAttributeInternal(ADDDISCOUNT, value);
    }

    /**
     * Gets the attribute value for FCURR_PREVIOUS_RATE using the alias name FcurrPreviousRate.
     * @return the FCURR_PREVIOUS_RATE
     */
    public BigDecimal getFcurrPreviousRate() {
        return (BigDecimal) getAttributeInternal(FCURRPREVIOUSRATE);
    }

    /**
     * Sets <code>value</code> as attribute value for FCURR_PREVIOUS_RATE using the alias name FcurrPreviousRate.
     * @param value value to set the FCURR_PREVIOUS_RATE
     */
    public void setFcurrPreviousRate(BigDecimal value) {
        setAttributeInternal(FCURRPREVIOUSRATE, value);
    }

    /**
     * Gets the attribute value for FCURR_CURRENT_RATE using the alias name FcurrCurrentRate.
     * @return the FCURR_CURRENT_RATE
     */
    public BigDecimal getFcurrCurrentRate() {
        return (BigDecimal) getAttributeInternal(FCURRCURRENTRATE);
    }

    /**
     * Sets <code>value</code> as attribute value for FCURR_CURRENT_RATE using the alias name FcurrCurrentRate.
     * @param value value to set the FCURR_CURRENT_RATE
     */
    public void setFcurrCurrentRate(BigDecimal value) {
        setAttributeInternal(FCURRCURRENTRATE, value);
    }

    /**
     * Gets the attribute value for GROUPP_ID using the alias name GrouppId.
     * @return the GROUPP_ID
     */
    public Integer getGrouppId() {
        return (Integer) getAttributeInternal(GROUPPID);
    }

    /**
     * Sets <code>value</code> as attribute value for GROUPP_ID using the alias name GrouppId.
     * @param value value to set the GROUPP_ID
     */
    public void setGrouppId(Integer value) {
        setAttributeInternal(GROUPPID, value);
    }

    /**
     * Gets the attribute value for SALE_DATE using the alias name SaleDate.
     * @return the SALE_DATE
     */
    public Date getSaleDate() {
        return (Date) getAttributeInternal(SALEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for SALE_DATE using the alias name SaleDate.
     * @param value value to set the SALE_DATE
     */
    public void setSaleDate(Date value) {
        setAttributeInternal(SALEDATE, value);
    }

    /**
     * Gets the attribute value for REBATESEQ using the alias name Rebateseq.
     * @return the REBATESEQ
     */
    public Integer getRebateseq() {
        return (Integer) getAttributeInternal(REBATESEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for REBATESEQ using the alias name Rebateseq.
     * @param value value to set the REBATESEQ
     */
    public void setRebateseq(Integer value) {
        setAttributeInternal(REBATESEQ, value);
    }

    /**
     * Gets the attribute value for REBATEDETAILSEQ using the alias name Rebatedetailseq.
     * @return the REBATEDETAILSEQ
     */
    public Integer getRebatedetailseq() {
        return (Integer) getAttributeInternal(REBATEDETAILSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for REBATEDETAILSEQ using the alias name Rebatedetailseq.
     * @param value value to set the REBATEDETAILSEQ
     */
    public void setRebatedetailseq(Integer value) {
        setAttributeInternal(REBATEDETAILSEQ, value);
    }

    /**
     * Gets the attribute value for MANUAL_RATE using the alias name ManualRate.
     * @return the MANUAL_RATE
     */
    public BigDecimal getManualRate() {
        return (BigDecimal) getAttributeInternal(MANUALRATE);
    }

    /**
     * Sets <code>value</code> as attribute value for MANUAL_RATE using the alias name ManualRate.
     * @param value value to set the MANUAL_RATE
     */
    public void setManualRate(BigDecimal value) {
        setAttributeInternal(MANUALRATE, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link SoRebateView.
     */
    public Row getSoRebateView() {
        return (Row) getAttributeInternal(SOREBATEVIEW);
    }

    /**
     * Sets the master-detail link SoRebateView between this object and <code>value</code>.
     */
    public void setSoRebateView(Row value) {
        setAttributeInternal(SOREBATEVIEW, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> AccInItemsView.
     */
    public RowSet getAccInItemsView() {
        return (RowSet) getAttributeInternal(ACCINITEMSVIEW);
    }
    @Override
    public boolean isAttributeUpdateable(int i) {
        // TODO Implement this method
        if (getSoRebateView().getAttribute("Posted").toString().equals("Y")) {
            return false;
       }
        return super.isAttributeUpdateable(i);
    }
}

