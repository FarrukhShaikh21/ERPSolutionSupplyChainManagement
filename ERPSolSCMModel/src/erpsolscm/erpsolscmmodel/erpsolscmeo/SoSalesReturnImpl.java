package erpsolscm.erpsolscmmodel.erpsolscmeo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;
import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobalsEntityImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Nov 27 09:59:59 PKT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SoSalesReturnImpl extends ERPSolGlobalsEntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Salesretid,
        ReturnDate,
        Customerid,
        Locationid,
        Salespersonid,
        Salesterritoryid,
        Createdby,
        Posted,
        CreatedDate,
        Modifiedby,
        PostedBy,
        ModifiedDate,
        Companyid,
        Deptid,
        Invoiceid,
        GlvoucherNo,
        PostToIntFace,
        PostToGl,
        DocTypeId,
        ArPosted,
        StPercent,
        ReturnType,
        Pid,
        Remarks,
        RemarksNarr,
        SedPercent,
        ExtraTaxPercent,
        OldInvoiceid,
        Storeid,
        GrnRef,
        Catid,
        IsAuto,
        IsMigrated,
        MigratedDate,
        RebateId,
        LocCurrcode,
        ExchangeRate,
        ReferenceTransId,
        ReferenceTransType,
        Submit,
        SymptomDate,
        EbsCustomerId,
        EbsSalespersonId,
        EbsLocationId,
        EbsStoreId,
        Supplierid,
        ConsignmentNo,
        Salesretseq,
        txtCustomerName,
        txtSalesPersonName,
        txtSupplierName,
        txtStoreName,
        ManualRefNo,
        Divid,
        SoSalesReturnLines,
        Srimei,
        AllCustomers,
        SoSalesPersons,
        PuSuppliers,
        AllStores;
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
    public static final int RETURNDATE = AttributesEnum.ReturnDate.index();
    public static final int CUSTOMERID = AttributesEnum.Customerid.index();
    public static final int LOCATIONID = AttributesEnum.Locationid.index();
    public static final int SALESPERSONID = AttributesEnum.Salespersonid.index();
    public static final int SALESTERRITORYID = AttributesEnum.Salesterritoryid.index();
    public static final int CREATEDBY = AttributesEnum.Createdby.index();
    public static final int POSTED = AttributesEnum.Posted.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int MODIFIEDBY = AttributesEnum.Modifiedby.index();
    public static final int POSTEDBY = AttributesEnum.PostedBy.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int COMPANYID = AttributesEnum.Companyid.index();
    public static final int DEPTID = AttributesEnum.Deptid.index();
    public static final int INVOICEID = AttributesEnum.Invoiceid.index();
    public static final int GLVOUCHERNO = AttributesEnum.GlvoucherNo.index();
    public static final int POSTTOINTFACE = AttributesEnum.PostToIntFace.index();
    public static final int POSTTOGL = AttributesEnum.PostToGl.index();
    public static final int DOCTYPEID = AttributesEnum.DocTypeId.index();
    public static final int ARPOSTED = AttributesEnum.ArPosted.index();
    public static final int STPERCENT = AttributesEnum.StPercent.index();
    public static final int RETURNTYPE = AttributesEnum.ReturnType.index();
    public static final int PID = AttributesEnum.Pid.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int REMARKSNARR = AttributesEnum.RemarksNarr.index();
    public static final int SEDPERCENT = AttributesEnum.SedPercent.index();
    public static final int EXTRATAXPERCENT = AttributesEnum.ExtraTaxPercent.index();
    public static final int OLDINVOICEID = AttributesEnum.OldInvoiceid.index();
    public static final int STOREID = AttributesEnum.Storeid.index();
    public static final int GRNREF = AttributesEnum.GrnRef.index();
    public static final int CATID = AttributesEnum.Catid.index();
    public static final int ISAUTO = AttributesEnum.IsAuto.index();
    public static final int ISMIGRATED = AttributesEnum.IsMigrated.index();
    public static final int MIGRATEDDATE = AttributesEnum.MigratedDate.index();
    public static final int REBATEID = AttributesEnum.RebateId.index();
    public static final int LOCCURRCODE = AttributesEnum.LocCurrcode.index();
    public static final int EXCHANGERATE = AttributesEnum.ExchangeRate.index();
    public static final int REFERENCETRANSID = AttributesEnum.ReferenceTransId.index();
    public static final int REFERENCETRANSTYPE = AttributesEnum.ReferenceTransType.index();
    public static final int SUBMIT = AttributesEnum.Submit.index();
    public static final int SYMPTOMDATE = AttributesEnum.SymptomDate.index();
    public static final int EBSCUSTOMERID = AttributesEnum.EbsCustomerId.index();
    public static final int EBSSALESPERSONID = AttributesEnum.EbsSalespersonId.index();
    public static final int EBSLOCATIONID = AttributesEnum.EbsLocationId.index();
    public static final int EBSSTOREID = AttributesEnum.EbsStoreId.index();
    public static final int SUPPLIERID = AttributesEnum.Supplierid.index();
    public static final int CONSIGNMENTNO = AttributesEnum.ConsignmentNo.index();
    public static final int SALESRETSEQ = AttributesEnum.Salesretseq.index();
    public static final int TXTCUSTOMERNAME = AttributesEnum.txtCustomerName.index();
    public static final int TXTSALESPERSONNAME = AttributesEnum.txtSalesPersonName.index();
    public static final int TXTSUPPLIERNAME = AttributesEnum.txtSupplierName.index();
    public static final int TXTSTORENAME = AttributesEnum.txtStoreName.index();
    public static final int MANUALREFNO = AttributesEnum.ManualRefNo.index();
    public static final int DIVID = AttributesEnum.Divid.index();
    public static final int SOSALESRETURNLINES = AttributesEnum.SoSalesReturnLines.index();
    public static final int SRIMEI = AttributesEnum.Srimei.index();
    public static final int ALLCUSTOMERS = AttributesEnum.AllCustomers.index();
    public static final int SOSALESPERSONS = AttributesEnum.SoSalesPersons.index();
    public static final int PUSUPPLIERS = AttributesEnum.PuSuppliers.index();
    public static final int ALLSTORES = AttributesEnum.AllStores.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SoSalesReturnImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("erpsolscm.erpsolscmmodel.erpsolscmeo.SoSalesReturn");
    }


    /**
     * Gets the attribute value for Salesretid, using the alias name Salesretid.
     * @return the value of Salesretid
     */
    public String getSalesretid() {
        return (String) getAttributeInternal(SALESRETID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Salesretid.
     * @param value value to set the Salesretid
     */
    public void setSalesretid(String value) {
        setAttributeInternal(SALESRETID, value);
    }

    /**
     * Gets the attribute value for ReturnDate, using the alias name ReturnDate.
     * @return the value of ReturnDate
     */
    public Date getReturnDate() {
        return (Date) getAttributeInternal(RETURNDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReturnDate.
     * @param value value to set the ReturnDate
     */
    public void setReturnDate(Date value) {
        setAttributeInternal(RETURNDATE, value);
    }

    /**
     * Gets the attribute value for Customerid, using the alias name Customerid.
     * @return the value of Customerid
     */
    public String getCustomerid() {
        return (String) getAttributeInternal(CUSTOMERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Customerid.
     * @param value value to set the Customerid
     */
    public void setCustomerid(String value) {
        setAttributeInternal(CUSTOMERID, value);
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
     * Gets the attribute value for Salespersonid, using the alias name Salespersonid.
     * @return the value of Salespersonid
     */
    public String getSalespersonid() {
        return (String) getAttributeInternal(SALESPERSONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Salespersonid.
     * @param value value to set the Salespersonid
     */
    public void setSalespersonid(String value) {
        setAttributeInternal(SALESPERSONID, value);
    }

    /**
     * Gets the attribute value for Salesterritoryid, using the alias name Salesterritoryid.
     * @return the value of Salesterritoryid
     */
    public String getSalesterritoryid() {
        return (String) getAttributeInternal(SALESTERRITORYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Salesterritoryid.
     * @param value value to set the Salesterritoryid
     */
    public void setSalesterritoryid(String value) {
        setAttributeInternal(SALESTERRITORYID, value);
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
     * Gets the attribute value for Posted, using the alias name Posted.
     * @return the value of Posted
     */
    public String getPosted() {
        return (String) getAttributeInternal(POSTED);
    }

    /**
     * Sets <code>value</code> as the attribute value for Posted.
     * @param value value to set the Posted
     */
    public void setPosted(String value) {
        setAttributeInternal(POSTED, value);
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
     * Gets the attribute value for PostedBy, using the alias name PostedBy.
     * @return the value of PostedBy
     */
    public String getPostedBy() {
        return (String) getAttributeInternal(POSTEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for PostedBy.
     * @param value value to set the PostedBy
     */
    public void setPostedBy(String value) {
        setAttributeInternal(POSTEDBY, value);
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
     * Gets the attribute value for Companyid, using the alias name Companyid.
     * @return the value of Companyid
     */
    public String getCompanyid() {
        return (String) getAttributeInternal(COMPANYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Companyid.
     * @param value value to set the Companyid
     */
    public void setCompanyid(String value) {
        setAttributeInternal(COMPANYID, value);
    }

    /**
     * Gets the attribute value for Deptid, using the alias name Deptid.
     * @return the value of Deptid
     */
    public String getDeptid() {
        return (String) getAttributeInternal(DEPTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Deptid.
     * @param value value to set the Deptid
     */
    public void setDeptid(String value) {
        setAttributeInternal(DEPTID, value);
    }

    /**
     * Gets the attribute value for Invoiceid, using the alias name Invoiceid.
     * @return the value of Invoiceid
     */
    public String getInvoiceid() {
        return (String) getAttributeInternal(INVOICEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Invoiceid.
     * @param value value to set the Invoiceid
     */
    public void setInvoiceid(String value) {
        setAttributeInternal(INVOICEID, value);
    }

    /**
     * Gets the attribute value for GlvoucherNo, using the alias name GlvoucherNo.
     * @return the value of GlvoucherNo
     */
    public String getGlvoucherNo() {
        return (String) getAttributeInternal(GLVOUCHERNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for GlvoucherNo.
     * @param value value to set the GlvoucherNo
     */
    public void setGlvoucherNo(String value) {
        setAttributeInternal(GLVOUCHERNO, value);
    }

    /**
     * Gets the attribute value for PostToIntFace, using the alias name PostToIntFace.
     * @return the value of PostToIntFace
     */
    public String getPostToIntFace() {
        return (String) getAttributeInternal(POSTTOINTFACE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PostToIntFace.
     * @param value value to set the PostToIntFace
     */
    public void setPostToIntFace(String value) {
        setAttributeInternal(POSTTOINTFACE, value);
    }

    /**
     * Gets the attribute value for PostToGl, using the alias name PostToGl.
     * @return the value of PostToGl
     */
    public String getPostToGl() {
        return (String) getAttributeInternal(POSTTOGL);
    }

    /**
     * Sets <code>value</code> as the attribute value for PostToGl.
     * @param value value to set the PostToGl
     */
    public void setPostToGl(String value) {
        setAttributeInternal(POSTTOGL, value);
    }

    /**
     * Gets the attribute value for DocTypeId, using the alias name DocTypeId.
     * @return the value of DocTypeId
     */
    public String getDocTypeId() {
        return (String) getAttributeInternal(DOCTYPEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DocTypeId.
     * @param value value to set the DocTypeId
     */
    public void setDocTypeId(String value) {
        setAttributeInternal(DOCTYPEID, value);
    }

    /**
     * Gets the attribute value for ArPosted, using the alias name ArPosted.
     * @return the value of ArPosted
     */
    public String getArPosted() {
        return (String) getAttributeInternal(ARPOSTED);
    }

    /**
     * Sets <code>value</code> as the attribute value for ArPosted.
     * @param value value to set the ArPosted
     */
    public void setArPosted(String value) {
        setAttributeInternal(ARPOSTED, value);
    }

    /**
     * Gets the attribute value for StPercent, using the alias name StPercent.
     * @return the value of StPercent
     */
    public BigDecimal getStPercent() {
        return (BigDecimal) getAttributeInternal(STPERCENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for StPercent.
     * @param value value to set the StPercent
     */
    public void setStPercent(BigDecimal value) {
        setAttributeInternal(STPERCENT, value);
    }

    /**
     * Gets the attribute value for ReturnType, using the alias name ReturnType.
     * @return the value of ReturnType
     */
    public String getReturnType() {
        return (String) getAttributeInternal(RETURNTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReturnType.
     * @param value value to set the ReturnType
     */
    public void setReturnType(String value) {
        setAttributeInternal(RETURNTYPE, value);
    }

    /**
     * Gets the attribute value for Pid, using the alias name Pid.
     * @return the value of Pid
     */
    public Integer getPid() {
        return (Integer) getAttributeInternal(PID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Pid.
     * @param value value to set the Pid
     */
    public void setPid(Integer value) {
        setAttributeInternal(PID, value);
    }

    /**
     * Gets the attribute value for Remarks, using the alias name Remarks.
     * @return the value of Remarks
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for RemarksNarr, using the alias name RemarksNarr.
     * @return the value of RemarksNarr
     */
    public String getRemarksNarr() {
        return (String) getAttributeInternal(REMARKSNARR);
    }

    /**
     * Sets <code>value</code> as the attribute value for RemarksNarr.
     * @param value value to set the RemarksNarr
     */
    public void setRemarksNarr(String value) {
        setAttributeInternal(REMARKSNARR, value);
    }

    /**
     * Gets the attribute value for SedPercent, using the alias name SedPercent.
     * @return the value of SedPercent
     */
    public BigDecimal getSedPercent() {
        return (BigDecimal) getAttributeInternal(SEDPERCENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for SedPercent.
     * @param value value to set the SedPercent
     */
    public void setSedPercent(BigDecimal value) {
        setAttributeInternal(SEDPERCENT, value);
    }

    /**
     * Gets the attribute value for ExtraTaxPercent, using the alias name ExtraTaxPercent.
     * @return the value of ExtraTaxPercent
     */
    public BigDecimal getExtraTaxPercent() {
        return (BigDecimal) getAttributeInternal(EXTRATAXPERCENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExtraTaxPercent.
     * @param value value to set the ExtraTaxPercent
     */
    public void setExtraTaxPercent(BigDecimal value) {
        setAttributeInternal(EXTRATAXPERCENT, value);
    }

    /**
     * Gets the attribute value for OldInvoiceid, using the alias name OldInvoiceid.
     * @return the value of OldInvoiceid
     */
    public String getOldInvoiceid() {
        return (String) getAttributeInternal(OLDINVOICEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OldInvoiceid.
     * @param value value to set the OldInvoiceid
     */
    public void setOldInvoiceid(String value) {
        setAttributeInternal(OLDINVOICEID, value);
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
     * Gets the attribute value for GrnRef, using the alias name GrnRef.
     * @return the value of GrnRef
     */
    public String getGrnRef() {
        return (String) getAttributeInternal(GRNREF);
    }

    /**
     * Sets <code>value</code> as the attribute value for GrnRef.
     * @param value value to set the GrnRef
     */
    public void setGrnRef(String value) {
        setAttributeInternal(GRNREF, value);
    }

    /**
     * Gets the attribute value for Catid, using the alias name Catid.
     * @return the value of Catid
     */
    public String getCatid() {
        return (String) getAttributeInternal(CATID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Catid.
     * @param value value to set the Catid
     */
    public void setCatid(String value) {
        setAttributeInternal(CATID, value);
    }

    /**
     * Gets the attribute value for IsAuto, using the alias name IsAuto.
     * @return the value of IsAuto
     */
    public String getIsAuto() {
        return (String) getAttributeInternal(ISAUTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for IsAuto.
     * @param value value to set the IsAuto
     */
    public void setIsAuto(String value) {
        setAttributeInternal(ISAUTO, value);
    }

    /**
     * Gets the attribute value for IsMigrated, using the alias name IsMigrated.
     * @return the value of IsMigrated
     */
    public String getIsMigrated() {
        return (String) getAttributeInternal(ISMIGRATED);
    }

    /**
     * Sets <code>value</code> as the attribute value for IsMigrated.
     * @param value value to set the IsMigrated
     */
    public void setIsMigrated(String value) {
        setAttributeInternal(ISMIGRATED, value);
    }

    /**
     * Gets the attribute value for MigratedDate, using the alias name MigratedDate.
     * @return the value of MigratedDate
     */
    public Date getMigratedDate() {
        return (Date) getAttributeInternal(MIGRATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for MigratedDate.
     * @param value value to set the MigratedDate
     */
    public void setMigratedDate(Date value) {
        setAttributeInternal(MIGRATEDDATE, value);
    }

    /**
     * Gets the attribute value for RebateId, using the alias name RebateId.
     * @return the value of RebateId
     */
    public String getRebateId() {
        return (String) getAttributeInternal(REBATEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RebateId.
     * @param value value to set the RebateId
     */
    public void setRebateId(String value) {
        setAttributeInternal(REBATEID, value);
    }

    /**
     * Gets the attribute value for LocCurrcode, using the alias name LocCurrcode.
     * @return the value of LocCurrcode
     */
    public String getLocCurrcode() {
        return (String) getAttributeInternal(LOCCURRCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LocCurrcode.
     * @param value value to set the LocCurrcode
     */
    public void setLocCurrcode(String value) {
        setAttributeInternal(LOCCURRCODE, value);
    }

    /**
     * Gets the attribute value for ExchangeRate, using the alias name ExchangeRate.
     * @return the value of ExchangeRate
     */
    public BigDecimal getExchangeRate() {
        return (BigDecimal) getAttributeInternal(EXCHANGERATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExchangeRate.
     * @param value value to set the ExchangeRate
     */
    public void setExchangeRate(BigDecimal value) {
        setAttributeInternal(EXCHANGERATE, value);
    }

    /**
     * Gets the attribute value for ReferenceTransId, using the alias name ReferenceTransId.
     * @return the value of ReferenceTransId
     */
    public String getReferenceTransId() {
        return (String) getAttributeInternal(REFERENCETRANSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReferenceTransId.
     * @param value value to set the ReferenceTransId
     */
    public void setReferenceTransId(String value) {
        setAttributeInternal(REFERENCETRANSID, value);
    }

    /**
     * Gets the attribute value for ReferenceTransType, using the alias name ReferenceTransType.
     * @return the value of ReferenceTransType
     */
    public String getReferenceTransType() {
        return (String) getAttributeInternal(REFERENCETRANSTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReferenceTransType.
     * @param value value to set the ReferenceTransType
     */
    public void setReferenceTransType(String value) {
        setAttributeInternal(REFERENCETRANSTYPE, value);
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
     * Gets the attribute value for SymptomDate, using the alias name SymptomDate.
     * @return the value of SymptomDate
     */
    public Date getSymptomDate() {
        return (Date) getAttributeInternal(SYMPTOMDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for SymptomDate.
     * @param value value to set the SymptomDate
     */
    public void setSymptomDate(Date value) {
        setAttributeInternal(SYMPTOMDATE, value);
    }

    /**
     * Gets the attribute value for EbsCustomerId, using the alias name EbsCustomerId.
     * @return the value of EbsCustomerId
     */
    public String getEbsCustomerId() {
        return (String) getAttributeInternal(EBSCUSTOMERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EbsCustomerId.
     * @param value value to set the EbsCustomerId
     */
    public void setEbsCustomerId(String value) {
        setAttributeInternal(EBSCUSTOMERID, value);
    }

    /**
     * Gets the attribute value for EbsSalespersonId, using the alias name EbsSalespersonId.
     * @return the value of EbsSalespersonId
     */
    public String getEbsSalespersonId() {
        return (String) getAttributeInternal(EBSSALESPERSONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EbsSalespersonId.
     * @param value value to set the EbsSalespersonId
     */
    public void setEbsSalespersonId(String value) {
        setAttributeInternal(EBSSALESPERSONID, value);
    }

    /**
     * Gets the attribute value for EbsLocationId, using the alias name EbsLocationId.
     * @return the value of EbsLocationId
     */
    public String getEbsLocationId() {
        return (String) getAttributeInternal(EBSLOCATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EbsLocationId.
     * @param value value to set the EbsLocationId
     */
    public void setEbsLocationId(String value) {
        setAttributeInternal(EBSLOCATIONID, value);
    }

    /**
     * Gets the attribute value for EbsStoreId, using the alias name EbsStoreId.
     * @return the value of EbsStoreId
     */
    public String getEbsStoreId() {
        return (String) getAttributeInternal(EBSSTOREID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EbsStoreId.
     * @param value value to set the EbsStoreId
     */
    public void setEbsStoreId(String value) {
        setAttributeInternal(EBSSTOREID, value);
    }

    /**
     * Gets the attribute value for Supplierid, using the alias name Supplierid.
     * @return the value of Supplierid
     */
    public String getSupplierid() {
        return (String) getAttributeInternal(SUPPLIERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Supplierid.
     * @param value value to set the Supplierid
     */
    public void setSupplierid(String value) {
        setAttributeInternal(SUPPLIERID, value);
    }

    /**
     * Gets the attribute value for ConsignmentNo, using the alias name ConsignmentNo.
     * @return the value of ConsignmentNo
     */
    public String getConsignmentNo() {
        return (String) getAttributeInternal(CONSIGNMENTNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for ConsignmentNo.
     * @param value value to set the ConsignmentNo
     */
    public void setConsignmentNo(String value) {
        setAttributeInternal(CONSIGNMENTNO, value);
    }

    /**
     * Gets the attribute value for Salesretseq, using the alias name Salesretseq.
     * @return the value of Salesretseq
     */
    public Integer getSalesretseq() {
        return (Integer) getAttributeInternal(SALESRETSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for Salesretseq.
     * @param value value to set the Salesretseq
     */
    public void setSalesretseq(Integer value) {
        setAttributeInternal(SALESRETSEQ, value);
    }

    /**
     * Gets the attribute value for txtCustomerName, using the alias name txtCustomerName.
     * @return the value of txtCustomerName
     */
    public String gettxtCustomerName() {
        return (String) getAttributeInternal(TXTCUSTOMERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for txtCustomerName.
     * @param value value to set the txtCustomerName
     */
    public void settxtCustomerName(String value) {
        setAttributeInternal(TXTCUSTOMERNAME, value);
    }

    /**
     * Gets the attribute value for txtSalesPersonName, using the alias name txtSalesPersonName.
     * @return the value of txtSalesPersonName
     */
    public String gettxtSalesPersonName() {
        return (String) getAttributeInternal(TXTSALESPERSONNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for txtSalesPersonName.
     * @param value value to set the txtSalesPersonName
     */
    public void settxtSalesPersonName(String value) {
        setAttributeInternal(TXTSALESPERSONNAME, value);
    }

    /**
     * Gets the attribute value for txtSupplierName, using the alias name txtSupplierName.
     * @return the value of txtSupplierName
     */
    public String gettxtSupplierName() {
        return (String) getAttributeInternal(TXTSUPPLIERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for txtSupplierName.
     * @param value value to set the txtSupplierName
     */
    public void settxtSupplierName(String value) {
        setAttributeInternal(TXTSUPPLIERNAME, value);
    }

    /**
     * Gets the attribute value for txtStoreName, using the alias name txtStoreName.
     * @return the value of txtStoreName
     */
    public String gettxtStoreName() {
        return (String) getAttributeInternal(TXTSTORENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for txtStoreName.
     * @param value value to set the txtStoreName
     */
    public void settxtStoreName(String value) {
        setAttributeInternal(TXTSTORENAME, value);
    }

    /**
     * Gets the attribute value for ManualRefNo, using the alias name ManualRefNo.
     * @return the value of ManualRefNo
     */
    public String getManualRefNo() {
        return (String) getAttributeInternal(MANUALREFNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for ManualRefNo.
     * @param value value to set the ManualRefNo
     */
    public void setManualRefNo(String value) {
        setAttributeInternal(MANUALREFNO, value);
    }

    /**
     * Gets the attribute value for Divid, using the alias name Divid.
     * @return the value of Divid
     */
    public String getDivid() {
        return (String) getAttributeInternal(DIVID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Divid.
     * @param value value to set the Divid
     */
    public void setDivid(String value) {
        setAttributeInternal(DIVID, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getSoSalesReturnLines() {
        return (RowIterator) getAttributeInternal(SOSALESRETURNLINES);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getSrimei() {
        return (RowIterator) getAttributeInternal(SRIMEI);
    }


    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public AllCustomersImpl getAllCustomers() {
        return (AllCustomersImpl) getAttributeInternal(ALLCUSTOMERS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setAllCustomers(AllCustomersImpl value) {
        setAttributeInternal(ALLCUSTOMERS, value);
    }


    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public SoSalesPersonsImpl getSoSalesPersons() {
        return (SoSalesPersonsImpl) getAttributeInternal(SOSALESPERSONS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setSoSalesPersons(SoSalesPersonsImpl value) {
        setAttributeInternal(SOSALESPERSONS, value);
    }


    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getPuSuppliers() {
        return (EntityImpl) getAttributeInternal(PUSUPPLIERS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setPuSuppliers(EntityImpl value) {
        setAttributeInternal(PUSUPPLIERS, value);
    }


    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getAllStores() {
        return (EntityImpl) getAttributeInternal(ALLSTORES);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setAllStores(EntityImpl value) {
        setAttributeInternal(ALLSTORES, value);
    }


    /**
     * @param salesretseq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer salesretseq) {
        return new Key(new Object[] { salesretseq });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    @Override
    protected void create(AttributeList attributeList) {
        // TODO Implement this method
        setERPSolPKColumnName("Salesretseq");
        setERPSolPKSeqName("SO_SALES_RETURN_SEQ");
        setLocationid(ERPSolGlobClassModel.doGetUserLocationCode());
        setStoreid(ERPSolGlobClassModel.doGetUserStoreCode());
        setCompanyid(ERPSolGlobClassModel.doGetUserCompanyCode());
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
        if (operation==DML_INSERT) {
            String pkValue=" salesreturn_id('"+ERPSolGlobClassModel.doGetUserCompanyCode()+"','"+ERPSolGlobClassModel.doGetUserLocationCode()+"','"+getDeptid()+"',TO_DATE('"+getReturnDate()+"','YYYY-MM-DD'))";
            String result= ERPSolGlobClassModel.doGetERPSolPrimaryKeyValueModel(getDBTransaction(), pkValue, "dual", null, null);
            populateAttributeAsChanged(SALESRETID, result);
        }
        else if (operation==DML_UPDATE) {
            if (getSubmit().equals("Y")) {
                populateAttributeAsChanged(POSTEDBY, ERPSolGlobClassModel.doGetUserCode());
           }
        }        
        super.doDML(operation, e);
    }
}

