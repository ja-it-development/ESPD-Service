//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.11 at 11:41:57 AM CET 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CandidateStatementType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EvidenceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for EvidenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EvidenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EvidenceTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CandidateStatement" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EvidenceIssuingParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Language" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceType", propOrder = {
    "id",
    "evidenceTypeCode",
    "description",
    "candidateStatement",
    "evidenceIssuingParty",
    "documentReference",
    "language"
})
public class EvidenceType
    implements Serializable, Equals, HashCode, ToString
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "EvidenceTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EvidenceTypeCodeType evidenceTypeCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "CandidateStatement", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<CandidateStatementType> candidateStatement;
    @XmlElement(name = "EvidenceIssuingParty")
    protected PartyType evidenceIssuingParty;
    @XmlElement(name = "DocumentReference")
    protected DocumentReferenceType documentReference;
    @XmlElement(name = "Language")
    protected LanguageType language;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Gets the value of the evidenceTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link EvidenceTypeCodeType }
     *     
     */
    public EvidenceTypeCodeType getEvidenceTypeCode() {
        return evidenceTypeCode;
    }

    /**
     * Sets the value of the evidenceTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EvidenceTypeCodeType }
     *     
     */
    public void setEvidenceTypeCode(EvidenceTypeCodeType value) {
        this.evidenceTypeCode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Gets the value of the candidateStatement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the candidateStatement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCandidateStatement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CandidateStatementType }
     * 
     * 
     */
    public List<CandidateStatementType> getCandidateStatement() {
        if (candidateStatement == null) {
            candidateStatement = new ArrayList<CandidateStatementType>();
        }
        return this.candidateStatement;
    }

    /**
     * Gets the value of the evidenceIssuingParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getEvidenceIssuingParty() {
        return evidenceIssuingParty;
    }

    /**
     * Sets the value of the evidenceIssuingParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setEvidenceIssuingParty(PartyType value) {
        this.evidenceIssuingParty = value;
    }

    /**
     * Gets the value of the documentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getDocumentReference() {
        return documentReference;
    }

    /**
     * Sets the value of the documentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setDocumentReference(DocumentReferenceType value) {
        this.documentReference = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link LanguageType }
     *     
     */
    public LanguageType getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguageType }
     *     
     */
    public void setLanguage(LanguageType value) {
        this.language = value;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            IDType theID;
            theID = this.getID();
            strategy.appendField(locator, this, "id", buffer, theID);
        }
        {
            EvidenceTypeCodeType theEvidenceTypeCode;
            theEvidenceTypeCode = this.getEvidenceTypeCode();
            strategy.appendField(locator, this, "evidenceTypeCode", buffer, theEvidenceTypeCode);
        }
        {
            List<DescriptionType> theDescription;
            theDescription = (((this.description!= null)&&(!this.description.isEmpty()))?this.getDescription():null);
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            List<CandidateStatementType> theCandidateStatement;
            theCandidateStatement = (((this.candidateStatement!= null)&&(!this.candidateStatement.isEmpty()))?this.getCandidateStatement():null);
            strategy.appendField(locator, this, "candidateStatement", buffer, theCandidateStatement);
        }
        {
            PartyType theEvidenceIssuingParty;
            theEvidenceIssuingParty = this.getEvidenceIssuingParty();
            strategy.appendField(locator, this, "evidenceIssuingParty", buffer, theEvidenceIssuingParty);
        }
        {
            DocumentReferenceType theDocumentReference;
            theDocumentReference = this.getDocumentReference();
            strategy.appendField(locator, this, "documentReference", buffer, theDocumentReference);
        }
        {
            LanguageType theLanguage;
            theLanguage = this.getLanguage();
            strategy.appendField(locator, this, "language", buffer, theLanguage);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof EvidenceType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EvidenceType that = ((EvidenceType) object);
        {
            IDType lhsID;
            lhsID = this.getID();
            IDType rhsID;
            rhsID = that.getID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsID), LocatorUtils.property(thatLocator, "id", rhsID), lhsID, rhsID)) {
                return false;
            }
        }
        {
            EvidenceTypeCodeType lhsEvidenceTypeCode;
            lhsEvidenceTypeCode = this.getEvidenceTypeCode();
            EvidenceTypeCodeType rhsEvidenceTypeCode;
            rhsEvidenceTypeCode = that.getEvidenceTypeCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "evidenceTypeCode", lhsEvidenceTypeCode), LocatorUtils.property(thatLocator, "evidenceTypeCode", rhsEvidenceTypeCode), lhsEvidenceTypeCode, rhsEvidenceTypeCode)) {
                return false;
            }
        }
        {
            List<DescriptionType> lhsDescription;
            lhsDescription = (((this.description!= null)&&(!this.description.isEmpty()))?this.getDescription():null);
            List<DescriptionType> rhsDescription;
            rhsDescription = (((that.description!= null)&&(!that.description.isEmpty()))?that.getDescription():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            List<CandidateStatementType> lhsCandidateStatement;
            lhsCandidateStatement = (((this.candidateStatement!= null)&&(!this.candidateStatement.isEmpty()))?this.getCandidateStatement():null);
            List<CandidateStatementType> rhsCandidateStatement;
            rhsCandidateStatement = (((that.candidateStatement!= null)&&(!that.candidateStatement.isEmpty()))?that.getCandidateStatement():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "candidateStatement", lhsCandidateStatement), LocatorUtils.property(thatLocator, "candidateStatement", rhsCandidateStatement), lhsCandidateStatement, rhsCandidateStatement)) {
                return false;
            }
        }
        {
            PartyType lhsEvidenceIssuingParty;
            lhsEvidenceIssuingParty = this.getEvidenceIssuingParty();
            PartyType rhsEvidenceIssuingParty;
            rhsEvidenceIssuingParty = that.getEvidenceIssuingParty();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "evidenceIssuingParty", lhsEvidenceIssuingParty), LocatorUtils.property(thatLocator, "evidenceIssuingParty", rhsEvidenceIssuingParty), lhsEvidenceIssuingParty, rhsEvidenceIssuingParty)) {
                return false;
            }
        }
        {
            DocumentReferenceType lhsDocumentReference;
            lhsDocumentReference = this.getDocumentReference();
            DocumentReferenceType rhsDocumentReference;
            rhsDocumentReference = that.getDocumentReference();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "documentReference", lhsDocumentReference), LocatorUtils.property(thatLocator, "documentReference", rhsDocumentReference), lhsDocumentReference, rhsDocumentReference)) {
                return false;
            }
        }
        {
            LanguageType lhsLanguage;
            lhsLanguage = this.getLanguage();
            LanguageType rhsLanguage;
            rhsLanguage = that.getLanguage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "language", lhsLanguage), LocatorUtils.property(thatLocator, "language", rhsLanguage), lhsLanguage, rhsLanguage)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            IDType theID;
            theID = this.getID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theID), currentHashCode, theID);
        }
        {
            EvidenceTypeCodeType theEvidenceTypeCode;
            theEvidenceTypeCode = this.getEvidenceTypeCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "evidenceTypeCode", theEvidenceTypeCode), currentHashCode, theEvidenceTypeCode);
        }
        {
            List<DescriptionType> theDescription;
            theDescription = (((this.description!= null)&&(!this.description.isEmpty()))?this.getDescription():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            List<CandidateStatementType> theCandidateStatement;
            theCandidateStatement = (((this.candidateStatement!= null)&&(!this.candidateStatement.isEmpty()))?this.getCandidateStatement():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "candidateStatement", theCandidateStatement), currentHashCode, theCandidateStatement);
        }
        {
            PartyType theEvidenceIssuingParty;
            theEvidenceIssuingParty = this.getEvidenceIssuingParty();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "evidenceIssuingParty", theEvidenceIssuingParty), currentHashCode, theEvidenceIssuingParty);
        }
        {
            DocumentReferenceType theDocumentReference;
            theDocumentReference = this.getDocumentReference();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentReference", theDocumentReference), currentHashCode, theDocumentReference);
        }
        {
            LanguageType theLanguage;
            theLanguage = this.getLanguage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "language", theLanguage), currentHashCode, theLanguage);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}