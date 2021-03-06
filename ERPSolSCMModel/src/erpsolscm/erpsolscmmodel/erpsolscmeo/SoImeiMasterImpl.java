package erpsolscm.erpsolscmmodel.erpsolscmeo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;
import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobalsEntityImpl;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jun 01 10:48:43 PKT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SoImeiMasterImpl extends ERPSolGlobalsEntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ImeiMasterSno,
        Dated,
        Locationid,
        Request,
        Submit,
        Createdby,
        CreatedDate,
        Modifiedby,
        ModifiedDate,
        Storeid,
        Pending,
        Reason,
        DocType,
        AuditStatus,
        SoImeiDetail;
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

    public static final int IMEIMASTERSNO = AttributesEnum.ImeiMasterSno.index();
    public static final int DATED = AttributesEnum.Dated.index();
    public static final int LOCATIONID = AttributesEnum.Locationid.index();
    public static final int REQUEST = AttributesEnum.Request.index();
    public static final int SUBMIT = AttributesEnum.Submit.index();
    public static final int CREATEDBY = AttributesEnum.Createdby.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int MODIFIEDBY = AttributesEnum.Modifiedby.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int STOREID = AttributesEnum.Storeid.index();
    public static final int PENDING = AttributesEnum.Pending.index();
    public static final int REASON = AttributesEnum.Reason.index();
    public static final int DOCTYPE = AttributesEnum.DocType.index();
    public static final int AUDITSTATUS = AttributesEnum.AuditStatus.index();
    public static final int SOIMEIDETAIL = AttributesEnum.SoImeiDetail.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SoImeiMasterImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("erpsolscm.erpsolscmmodel.erpsolscmeo.SoImeiMaster");
    }

    /**
     * Gets the attribute value for ImeiMasterSno, using the alias name ImeiMasterSno.
     * @return the value of ImeiMasterSno
     */
    public Integer getImeiMasterSno() {
        return (Integer) getAttributeInternal(IMEIMASTERSNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImeiMasterSno.
     * @param value value to set the ImeiMasterSno
     */
    public void setImeiMasterSno(Integer value) {
        setAttributeInternal(IMEIMASTERSNO, value);
    }

    /**
     * Gets the attribute value for Dated, using the alias name Dated.
     * @return the value of Dated
     */
    public Date getDated() {
        return (Date) getAttributeInternal(DATED);
    }

    /**
     * Sets <code>value</code> as the attribute value for Dated.
     * @param value value to set the Dated
     */
    public void setDated(Date value) {
        setAttributeInternal(DATED, value);
    }

    /**
     * Gets the attribute value for Locationid, using the alias name Locationid.
     * @return the value of Locationid
     */
    public String getLocationid() {
        return (String) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Locationid.
     * @param value value to set the Locationid
     */
    public void setLocationid(String value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for Request, using the alias name Request.
     * @return the value of Request
     */
    public String getRequest() {
        return (String) getAttributeInternal(REQUEST);
    }

    /**
     * Sets <code>value</code> as the attribute value for Request.
     * @param value value to set the Request
     */
    public void setRequest(String value) {
        setAttributeInternal(REQUEST, value);
    }

    /**
     * Gets the attribute value for Submit, using the alias name Submit.
     * @return the value of Submit
     */
    public String getSubmit() {
        return (String) getAttributeInternal(SUBMIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Submit.
     * @param value value to set the Submit
     */
    public void setSubmit(String value) {
        setAttributeInternal(SUBMIT, value);
    }

    /**
     * Gets the attribute value for Createdby, using the alias name Createdby.
     * @return the value of Createdby
     */
    public String getCreatedby() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Createdby.
     * @param value value to set the Createdby
     */
    public void setCreatedby(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the value of CreatedDate
     */
    public Date getCreatedDate() {
        return (Date) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Date value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for Modifiedby, using the alias name Modifiedby.
     * @return the value of Modifiedby
     */
    public String getModifiedby() {
        return (String) getAttributeInternal(MODIFIEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Modifiedby.
     * @param value value to set the Modifiedby
     */
    public void setModifiedby(String value) {
        setAttributeInternal(MODIFIEDBY, value);
    }

    /**
     * Gets the attribute value for ModifiedDate, using the alias name ModifiedDate.
     * @return the value of ModifiedDate
     */
    public Date getModifiedDate() {
        return (Date) getAttributeInternal(MODIFIEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ModifiedDate.
     * @param value value to set the ModifiedDate
     */
    public void setModifiedDate(Date value) {
        setAttributeInternal(MODIFIEDDATE, value);
    }

    /**
     * Gets the attribute value for Storeid, using the alias name Storeid.
     * @return the value of Storeid
     */
    public String getStoreid() {
        return (String) getAttributeInternal(STOREID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Storeid.
     * @param value value to set the Storeid
     */
    public void setStoreid(String value) {
        setAttributeInternal(STOREID, value);
    }

    /**
     * Gets the attribute value for Pending, using the alias name Pending.
     * @return the value of Pending
     */
    public String getPending() {
        return (String) getAttributeInternal(PENDING);
    }

    /**
     * Sets <code>value</code> as the attribute value for Pending.
     * @param value value to set the Pending
     */
    public void setPending(String value) {
        setAttributeInternal(PENDING, value);
    }

    /**
     * Gets the attribute value for Reason, using the alias name Reason.
     * @return the value of Reason
     */
    public String getReason() {
        return (String) getAttributeInternal(REASON);
    }

    /**
     * Sets <code>value</code> as the attribute value for Reason.
     * @param value value to set the Reason
     */
    public void setReason(String value) {
        setAttributeInternal(REASON, value);
    }

    /**
     * Gets the attribute value for DocType, using the alias name DocType.
     * @return the value of DocType
     */
    public String getDocType() {
        return (String) getAttributeInternal(DOCTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DocType.
     * @param value value to set the DocType
     */
    public void setDocType(String value) {
        setAttributeInternal(DOCTYPE, value);
    }

    /**
     * Gets the attribute value for AuditStatus, using the alias name AuditStatus.
     * @return the value of AuditStatus
     */
    public String getAuditStatus() {
        return (String) getAttributeInternal(AUDITSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for AuditStatus.
     * @param value value to set the AuditStatus
     */
    public void setAuditStatus(String value) {
        setAttributeInternal(AUDITSTATUS, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getSoImeiDetail() {
        return (RowIterator) getAttributeInternal(SOIMEIDETAIL);
    }


    /**
     * @param imeiMasterSno key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer imeiMasterSno) {
        return new Key(new Object[] { imeiMasterSno });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    @Override
    protected void create(AttributeList attributeList) {
        // TODO Implement this method
        setERPSolPKColumnName("ImeiMasterSno");
        setERPSolPKSeqName("SO_IMEI_MASTER_SEQ");
        setLocationid(ERPSolGlobClassModel.doGetUserLocationCode());
        setStoreid(ERPSolGlobClassModel.doGetUserStoreCode());
    //        setERPISGenertePK("NO");
    //        SequenceImpl seq = new SequenceImpl("SO_SALES_ORDER_SEQ", getDBTransaction());
    //        setSalesorderseq(seq.getSequenceNumber());
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }
}

