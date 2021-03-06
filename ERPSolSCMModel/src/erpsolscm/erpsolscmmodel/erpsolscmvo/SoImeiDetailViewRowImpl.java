package erpsolscm.erpsolscmmodel.erpsolscmvo;

import erpsolscm.erpsolscmmodel.erpsolscmeo.SoImeiDetailImpl;

import java.math.BigDecimal;

import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Date;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jun 02 11:53:07 PKT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SoImeiDetailViewRowImpl extends ViewRowImpl {
    public static final int ENTITY_SOIMEIDETAIL = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ImeiDetailSno,
        ImeiMasterSno,
        Itemid,
        Imei,
        RestrictImei,
        ForceAllow,
        IsAvailable,
        AllowSo,
        AllowSr,
        Generate,
        Createdby,
        CreatedDate,
        Modifiedby,
        ModifiedDate,
        PreviousItemid,
        Reason,
        StopCustomer,
        IsJobCard,
        SprDebitAmount,
        AllowSrWr,
        AllowInc,
        RestrictReason,
        RestrictReasonId,
        txtModelNo,
        SoImeiMasterView,
        InItemsView,
        AccInItemsView,
        AccVwGetItemInfoByIMEIQVO;
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
    public static final int IMEIDETAILSNO = AttributesEnum.ImeiDetailSno.index();
    public static final int IMEIMASTERSNO = AttributesEnum.ImeiMasterSno.index();
    public static final int ITEMID = AttributesEnum.Itemid.index();
    public static final int IMEI = AttributesEnum.Imei.index();
    public static final int RESTRICTIMEI = AttributesEnum.RestrictImei.index();
    public static final int FORCEALLOW = AttributesEnum.ForceAllow.index();
    public static final int ISAVAILABLE = AttributesEnum.IsAvailable.index();
    public static final int ALLOWSO = AttributesEnum.AllowSo.index();
    public static final int ALLOWSR = AttributesEnum.AllowSr.index();
    public static final int GENERATE = AttributesEnum.Generate.index();
    public static final int CREATEDBY = AttributesEnum.Createdby.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int MODIFIEDBY = AttributesEnum.Modifiedby.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int PREVIOUSITEMID = AttributesEnum.PreviousItemid.index();
    public static final int REASON = AttributesEnum.Reason.index();
    public static final int STOPCUSTOMER = AttributesEnum.StopCustomer.index();
    public static final int ISJOBCARD = AttributesEnum.IsJobCard.index();
    public static final int SPRDEBITAMOUNT = AttributesEnum.SprDebitAmount.index();
    public static final int ALLOWSRWR = AttributesEnum.AllowSrWr.index();
    public static final int ALLOWINC = AttributesEnum.AllowInc.index();
    public static final int RESTRICTREASON = AttributesEnum.RestrictReason.index();
    public static final int RESTRICTREASONID = AttributesEnum.RestrictReasonId.index();
    public static final int TXTMODELNO = AttributesEnum.txtModelNo.index();
    public static final int SOIMEIMASTERVIEW = AttributesEnum.SoImeiMasterView.index();
    public static final int INITEMSVIEW = AttributesEnum.InItemsView.index();
    public static final int ACCINITEMSVIEW = AttributesEnum.AccInItemsView.index();
    public static final int ACCVWGETITEMINFOBYIMEIQVO = AttributesEnum.AccVwGetItemInfoByIMEIQVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SoImeiDetailViewRowImpl() {
    }

    /**
     * Gets SoImeiDetail entity object.
     * @return the SoImeiDetail
     */
    public SoImeiDetailImpl getSoImeiDetail() {
        return (SoImeiDetailImpl) getEntity(ENTITY_SOIMEIDETAIL);
    }

    /**
     * Gets the attribute value for IMEI_DETAIL_SNO using the alias name ImeiDetailSno.
     * @return the IMEI_DETAIL_SNO
     */
    public Integer getImeiDetailSno() {
        return (Integer) getAttributeInternal(IMEIDETAILSNO);
    }

    /**
     * Sets <code>value</code> as attribute value for IMEI_DETAIL_SNO using the alias name ImeiDetailSno.
     * @param value value to set the IMEI_DETAIL_SNO
     */
    public void setImeiDetailSno(Integer value) {
        setAttributeInternal(IMEIDETAILSNO, value);
        
    }

    /**
     * Gets the attribute value for IMEI_MASTER_SNO using the alias name ImeiMasterSno.
     * @return the IMEI_MASTER_SNO
     */
    public Integer getImeiMasterSno() {
        return (Integer) getAttributeInternal(IMEIMASTERSNO);
    }

    /**
     * Sets <code>value</code> as attribute value for IMEI_MASTER_SNO using the alias name ImeiMasterSno.
     * @param value value to set the IMEI_MASTER_SNO
     */
    public void setImeiMasterSno(Integer value) {
        setAttributeInternal(IMEIMASTERSNO, value);
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
     * Gets the attribute value for IMEI using the alias name Imei.
     * @return the IMEI
     */
    public String getImei() {
        return (String) getAttributeInternal(IMEI);
    }

    /**
     * Sets <code>value</code> as attribute value for IMEI using the alias name Imei.
     * @param value value to set the IMEI
     */
    public void setImei(String value) {
        setAttributeInternal(IMEI, value);
        getAccVwGetItemInfoByIMEIQVO().setNamedWhereClauseParam("P_ADF_IMEI", value);
        getAccVwGetItemInfoByIMEIQVO().executeQuery();
        setPreviousItemid(getAccVwGetItemInfoByIMEIQVO().first().getAttribute("Itemid").toString());
        setItemid(getAccVwGetItemInfoByIMEIQVO().first().getAttribute("Itemid").toString());
        setIsAvailable(getAccVwGetItemInfoByIMEIQVO().first().getAttribute("IsAvailable").toString());
    }

    /**
     * Gets the attribute value for RESTRICT_IMEI using the alias name RestrictImei.
     * @return the RESTRICT_IMEI
     */
    public String getRestrictImei() {
        return (String) getAttributeInternal(RESTRICTIMEI);
    }

    /**
     * Sets <code>value</code> as attribute value for RESTRICT_IMEI using the alias name RestrictImei.
     * @param value value to set the RESTRICT_IMEI
     */
    public void setRestrictImei(String value) {
        setAttributeInternal(RESTRICTIMEI, value);
    }

    /**
     * Gets the attribute value for FORCE_ALLOW using the alias name ForceAllow.
     * @return the FORCE_ALLOW
     */
    public String getForceAllow() {
        return (String) getAttributeInternal(FORCEALLOW);
    }

    /**
     * Sets <code>value</code> as attribute value for FORCE_ALLOW using the alias name ForceAllow.
     * @param value value to set the FORCE_ALLOW
     */
    public void setForceAllow(String value) {
        setAttributeInternal(FORCEALLOW, value);
    }

    /**
     * Gets the attribute value for IS_AVAILABLE using the alias name IsAvailable.
     * @return the IS_AVAILABLE
     */
    public String getIsAvailable() {
        return (String) getAttributeInternal(ISAVAILABLE);
    }

    /**
     * Sets <code>value</code> as attribute value for IS_AVAILABLE using the alias name IsAvailable.
     * @param value value to set the IS_AVAILABLE
     */
    public void setIsAvailable(String value) {
        setAttributeInternal(ISAVAILABLE, value);
    }

    /**
     * Gets the attribute value for ALLOW_SO using the alias name AllowSo.
     * @return the ALLOW_SO
     */
    public String getAllowSo() {
        return (String) getAttributeInternal(ALLOWSO);
    }

    /**
     * Sets <code>value</code> as attribute value for ALLOW_SO using the alias name AllowSo.
     * @param value value to set the ALLOW_SO
     */
    public void setAllowSo(String value) {
        setAttributeInternal(ALLOWSO, value);
    }

    /**
     * Gets the attribute value for ALLOW_SR using the alias name AllowSr.
     * @return the ALLOW_SR
     */
    public String getAllowSr() {
        return (String) getAttributeInternal(ALLOWSR);
    }

    /**
     * Sets <code>value</code> as attribute value for ALLOW_SR using the alias name AllowSr.
     * @param value value to set the ALLOW_SR
     */
    public void setAllowSr(String value) {
        setAttributeInternal(ALLOWSR, value);
    }

    /**
     * Gets the attribute value for GENERATE using the alias name Generate.
     * @return the GENERATE
     */
    public String getGenerate() {
        return (String) getAttributeInternal(GENERATE);
    }

    /**
     * Sets <code>value</code> as attribute value for GENERATE using the alias name Generate.
     * @param value value to set the GENERATE
     */
    public void setGenerate(String value) {
        setAttributeInternal(GENERATE, value);
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
     * Gets the attribute value for PREVIOUS_ITEMID using the alias name PreviousItemid.
     * @return the PREVIOUS_ITEMID
     */
    public String getPreviousItemid() {
        return (String) getAttributeInternal(PREVIOUSITEMID);
    }

    /**
     * Sets <code>value</code> as attribute value for PREVIOUS_ITEMID using the alias name PreviousItemid.
     * @param value value to set the PREVIOUS_ITEMID
     */
    public void setPreviousItemid(String value) {
        setAttributeInternal(PREVIOUSITEMID, value);
    }

    /**
     * Gets the attribute value for REASON using the alias name Reason.
     * @return the REASON
     */
    public String getReason() {
        return (String) getAttributeInternal(REASON);
    }

    /**
     * Sets <code>value</code> as attribute value for REASON using the alias name Reason.
     * @param value value to set the REASON
     */
    public void setReason(String value) {
        setAttributeInternal(REASON, value);
    }

    /**
     * Gets the attribute value for STOP_CUSTOMER using the alias name StopCustomer.
     * @return the STOP_CUSTOMER
     */
    public String getStopCustomer() {
        return (String) getAttributeInternal(STOPCUSTOMER);
    }

    /**
     * Sets <code>value</code> as attribute value for STOP_CUSTOMER using the alias name StopCustomer.
     * @param value value to set the STOP_CUSTOMER
     */
    public void setStopCustomer(String value) {
        setAttributeInternal(STOPCUSTOMER, value);
    }

    /**
     * Gets the attribute value for IS_JOB_CARD using the alias name IsJobCard.
     * @return the IS_JOB_CARD
     */
    public String getIsJobCard() {
        return (String) getAttributeInternal(ISJOBCARD);
    }

    /**
     * Sets <code>value</code> as attribute value for IS_JOB_CARD using the alias name IsJobCard.
     * @param value value to set the IS_JOB_CARD
     */
    public void setIsJobCard(String value) {
        setAttributeInternal(ISJOBCARD, value);
    }

    /**
     * Gets the attribute value for SPR_DEBIT_AMOUNT using the alias name SprDebitAmount.
     * @return the SPR_DEBIT_AMOUNT
     */
    public BigDecimal getSprDebitAmount() {
        return (BigDecimal) getAttributeInternal(SPRDEBITAMOUNT);
    }

    /**
     * Sets <code>value</code> as attribute value for SPR_DEBIT_AMOUNT using the alias name SprDebitAmount.
     * @param value value to set the SPR_DEBIT_AMOUNT
     */
    public void setSprDebitAmount(BigDecimal value) {
        setAttributeInternal(SPRDEBITAMOUNT, value);
    }

    /**
     * Gets the attribute value for ALLOW_SR_WR using the alias name AllowSrWr.
     * @return the ALLOW_SR_WR
     */
    public String getAllowSrWr() {
        return (String) getAttributeInternal(ALLOWSRWR);
    }

    /**
     * Sets <code>value</code> as attribute value for ALLOW_SR_WR using the alias name AllowSrWr.
     * @param value value to set the ALLOW_SR_WR
     */
    public void setAllowSrWr(String value) {
        setAttributeInternal(ALLOWSRWR, value);
    }

    /**
     * Gets the attribute value for ALLOW_INC using the alias name AllowInc.
     * @return the ALLOW_INC
     */
    public String getAllowInc() {
        return (String) getAttributeInternal(ALLOWINC);
    }

    /**
     * Sets <code>value</code> as attribute value for ALLOW_INC using the alias name AllowInc.
     * @param value value to set the ALLOW_INC
     */
    public void setAllowInc(String value) {
        setAttributeInternal(ALLOWINC, value);
    }

    /**
     * Gets the attribute value for RESTRICT_REASON using the alias name RestrictReason.
     * @return the RESTRICT_REASON
     */
    public String getRestrictReason() {
        return (String) getAttributeInternal(RESTRICTREASON);
    }

    /**
     * Sets <code>value</code> as attribute value for RESTRICT_REASON using the alias name RestrictReason.
     * @param value value to set the RESTRICT_REASON
     */
    public void setRestrictReason(String value) {
        setAttributeInternal(RESTRICTREASON, value);
    }

    /**
     * Gets the attribute value for RESTRICT_REASON_ID using the alias name RestrictReasonId.
     * @return the RESTRICT_REASON_ID
     */
    public BigDecimal getRestrictReasonId() {
        return (BigDecimal) getAttributeInternal(RESTRICTREASONID);
    }

    /**
     * Sets <code>value</code> as attribute value for RESTRICT_REASON_ID using the alias name RestrictReasonId.
     * @param value value to set the RESTRICT_REASON_ID
     */
    public void setRestrictReasonId(BigDecimal value) {
        setAttributeInternal(RESTRICTREASONID, value);
    }

    /**
     * Gets the attribute value for TXT_MODEL_NO using the alias name txtModelNo.
     * @return the TXT_MODEL_NO
     */
    public String gettxtModelNo() {
        return (String) getAttributeInternal(TXTMODELNO);
    }

    /**
     * Sets <code>value</code> as attribute value for TXT_MODEL_NO using the alias name txtModelNo.
     * @param value value to set the TXT_MODEL_NO
     */
    public void settxtModelNo(String value) {
        setAttributeInternal(TXTMODELNO, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link SoImeiMasterView.
     */
    public Row getSoImeiMasterView() {
        return (Row) getAttributeInternal(SOIMEIMASTERVIEW);
    }

    /**
     * Sets the master-detail link SoImeiMasterView between this object and <code>value</code>.
     */
    public void setSoImeiMasterView(Row value) {
        setAttributeInternal(SOIMEIMASTERVIEW, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link InItemsView.
     */
    public Row getInItemsView() {
        return (Row) getAttributeInternal(INITEMSVIEW);
    }

    /**
     * Sets the master-detail link InItemsView between this object and <code>value</code>.
     */
    public void setInItemsView(Row value) {
        setAttributeInternal(INITEMSVIEW, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> AccInItemsView.
     */
    public RowSet getAccInItemsView() {
        return (RowSet) getAttributeInternal(ACCINITEMSVIEW);
    }

    /**
     * Gets the view accessor <code>RowSet</code> AccVwGetItemInfoByIMEIQVO.
     */
    public RowSet getAccVwGetItemInfoByIMEIQVO() {
        return (RowSet) getAttributeInternal(ACCVWGETITEMINFOBYIMEIQVO);
    }
}

