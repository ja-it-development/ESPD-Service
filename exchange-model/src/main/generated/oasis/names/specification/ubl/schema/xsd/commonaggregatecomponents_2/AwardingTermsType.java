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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BindingOnBuyerIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FollowupContractIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LowTendersDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrizeDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrizeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TechnicalCommitteeDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeightingAlgorithmCodeType;
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
 * <p>Java class for AwardingTermsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AwardingTermsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WeightingAlgorithmCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TechnicalCommitteeDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LowTendersDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrizeIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrizeDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FollowupContractIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BindingOnBuyerIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AwardingCriterion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TechnicalCommitteePerson" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AwardingTermsType", propOrder = {
    "weightingAlgorithmCode",
    "description",
    "technicalCommitteeDescription",
    "lowTendersDescription",
    "prizeIndicator",
    "prizeDescription",
    "paymentDescription",
    "followupContractIndicator",
    "bindingOnBuyerIndicator",
    "awardingCriterion",
    "technicalCommitteePerson"
})
public class AwardingTermsType
    implements Serializable, Equals, HashCode, ToString
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "WeightingAlgorithmCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WeightingAlgorithmCodeType weightingAlgorithmCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "TechnicalCommitteeDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<TechnicalCommitteeDescriptionType> technicalCommitteeDescription;
    @XmlElement(name = "LowTendersDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<LowTendersDescriptionType> lowTendersDescription;
    @XmlElement(name = "PrizeIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PrizeIndicatorType prizeIndicator;
    @XmlElement(name = "PrizeDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PrizeDescriptionType> prizeDescription;
    @XmlElement(name = "PaymentDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PaymentDescriptionType> paymentDescription;
    @XmlElement(name = "FollowupContractIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FollowupContractIndicatorType followupContractIndicator;
    @XmlElement(name = "BindingOnBuyerIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BindingOnBuyerIndicatorType bindingOnBuyerIndicator;
    @XmlElement(name = "AwardingCriterion")
    protected List<AwardingCriterionType> awardingCriterion;
    @XmlElement(name = "TechnicalCommitteePerson")
    protected List<PersonType> technicalCommitteePerson;

    /**
     * Gets the value of the weightingAlgorithmCode property.
     * 
     * @return
     *     possible object is
     *     {@link WeightingAlgorithmCodeType }
     *     
     */
    public WeightingAlgorithmCodeType getWeightingAlgorithmCode() {
        return weightingAlgorithmCode;
    }

    /**
     * Sets the value of the weightingAlgorithmCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightingAlgorithmCodeType }
     *     
     */
    public void setWeightingAlgorithmCode(WeightingAlgorithmCodeType value) {
        this.weightingAlgorithmCode = value;
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
     * Gets the value of the technicalCommitteeDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the technicalCommitteeDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechnicalCommitteeDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TechnicalCommitteeDescriptionType }
     * 
     * 
     */
    public List<TechnicalCommitteeDescriptionType> getTechnicalCommitteeDescription() {
        if (technicalCommitteeDescription == null) {
            technicalCommitteeDescription = new ArrayList<TechnicalCommitteeDescriptionType>();
        }
        return this.technicalCommitteeDescription;
    }

    /**
     * Gets the value of the lowTendersDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lowTendersDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLowTendersDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LowTendersDescriptionType }
     * 
     * 
     */
    public List<LowTendersDescriptionType> getLowTendersDescription() {
        if (lowTendersDescription == null) {
            lowTendersDescription = new ArrayList<LowTendersDescriptionType>();
        }
        return this.lowTendersDescription;
    }

    /**
     * Gets the value of the prizeIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link PrizeIndicatorType }
     *     
     */
    public PrizeIndicatorType getPrizeIndicator() {
        return prizeIndicator;
    }

    /**
     * Sets the value of the prizeIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrizeIndicatorType }
     *     
     */
    public void setPrizeIndicator(PrizeIndicatorType value) {
        this.prizeIndicator = value;
    }

    /**
     * Gets the value of the prizeDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prizeDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrizeDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrizeDescriptionType }
     * 
     * 
     */
    public List<PrizeDescriptionType> getPrizeDescription() {
        if (prizeDescription == null) {
            prizeDescription = new ArrayList<PrizeDescriptionType>();
        }
        return this.prizeDescription;
    }

    /**
     * Gets the value of the paymentDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentDescriptionType }
     * 
     * 
     */
    public List<PaymentDescriptionType> getPaymentDescription() {
        if (paymentDescription == null) {
            paymentDescription = new ArrayList<PaymentDescriptionType>();
        }
        return this.paymentDescription;
    }

    /**
     * Gets the value of the followupContractIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link FollowupContractIndicatorType }
     *     
     */
    public FollowupContractIndicatorType getFollowupContractIndicator() {
        return followupContractIndicator;
    }

    /**
     * Sets the value of the followupContractIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link FollowupContractIndicatorType }
     *     
     */
    public void setFollowupContractIndicator(FollowupContractIndicatorType value) {
        this.followupContractIndicator = value;
    }

    /**
     * Gets the value of the bindingOnBuyerIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link BindingOnBuyerIndicatorType }
     *     
     */
    public BindingOnBuyerIndicatorType getBindingOnBuyerIndicator() {
        return bindingOnBuyerIndicator;
    }

    /**
     * Sets the value of the bindingOnBuyerIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link BindingOnBuyerIndicatorType }
     *     
     */
    public void setBindingOnBuyerIndicator(BindingOnBuyerIndicatorType value) {
        this.bindingOnBuyerIndicator = value;
    }

    /**
     * Gets the value of the awardingCriterion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the awardingCriterion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAwardingCriterion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AwardingCriterionType }
     * 
     * 
     */
    public List<AwardingCriterionType> getAwardingCriterion() {
        if (awardingCriterion == null) {
            awardingCriterion = new ArrayList<AwardingCriterionType>();
        }
        return this.awardingCriterion;
    }

    /**
     * Gets the value of the technicalCommitteePerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the technicalCommitteePerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechnicalCommitteePerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getTechnicalCommitteePerson() {
        if (technicalCommitteePerson == null) {
            technicalCommitteePerson = new ArrayList<PersonType>();
        }
        return this.technicalCommitteePerson;
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
            WeightingAlgorithmCodeType theWeightingAlgorithmCode;
            theWeightingAlgorithmCode = this.getWeightingAlgorithmCode();
            strategy.appendField(locator, this, "weightingAlgorithmCode", buffer, theWeightingAlgorithmCode);
        }
        {
            List<DescriptionType> theDescription;
            theDescription = (((this.description!= null)&&(!this.description.isEmpty()))?this.getDescription():null);
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            List<TechnicalCommitteeDescriptionType> theTechnicalCommitteeDescription;
            theTechnicalCommitteeDescription = (((this.technicalCommitteeDescription!= null)&&(!this.technicalCommitteeDescription.isEmpty()))?this.getTechnicalCommitteeDescription():null);
            strategy.appendField(locator, this, "technicalCommitteeDescription", buffer, theTechnicalCommitteeDescription);
        }
        {
            List<LowTendersDescriptionType> theLowTendersDescription;
            theLowTendersDescription = (((this.lowTendersDescription!= null)&&(!this.lowTendersDescription.isEmpty()))?this.getLowTendersDescription():null);
            strategy.appendField(locator, this, "lowTendersDescription", buffer, theLowTendersDescription);
        }
        {
            PrizeIndicatorType thePrizeIndicator;
            thePrizeIndicator = this.getPrizeIndicator();
            strategy.appendField(locator, this, "prizeIndicator", buffer, thePrizeIndicator);
        }
        {
            List<PrizeDescriptionType> thePrizeDescription;
            thePrizeDescription = (((this.prizeDescription!= null)&&(!this.prizeDescription.isEmpty()))?this.getPrizeDescription():null);
            strategy.appendField(locator, this, "prizeDescription", buffer, thePrizeDescription);
        }
        {
            List<PaymentDescriptionType> thePaymentDescription;
            thePaymentDescription = (((this.paymentDescription!= null)&&(!this.paymentDescription.isEmpty()))?this.getPaymentDescription():null);
            strategy.appendField(locator, this, "paymentDescription", buffer, thePaymentDescription);
        }
        {
            FollowupContractIndicatorType theFollowupContractIndicator;
            theFollowupContractIndicator = this.getFollowupContractIndicator();
            strategy.appendField(locator, this, "followupContractIndicator", buffer, theFollowupContractIndicator);
        }
        {
            BindingOnBuyerIndicatorType theBindingOnBuyerIndicator;
            theBindingOnBuyerIndicator = this.getBindingOnBuyerIndicator();
            strategy.appendField(locator, this, "bindingOnBuyerIndicator", buffer, theBindingOnBuyerIndicator);
        }
        {
            List<AwardingCriterionType> theAwardingCriterion;
            theAwardingCriterion = (((this.awardingCriterion!= null)&&(!this.awardingCriterion.isEmpty()))?this.getAwardingCriterion():null);
            strategy.appendField(locator, this, "awardingCriterion", buffer, theAwardingCriterion);
        }
        {
            List<PersonType> theTechnicalCommitteePerson;
            theTechnicalCommitteePerson = (((this.technicalCommitteePerson!= null)&&(!this.technicalCommitteePerson.isEmpty()))?this.getTechnicalCommitteePerson():null);
            strategy.appendField(locator, this, "technicalCommitteePerson", buffer, theTechnicalCommitteePerson);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AwardingTermsType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AwardingTermsType that = ((AwardingTermsType) object);
        {
            WeightingAlgorithmCodeType lhsWeightingAlgorithmCode;
            lhsWeightingAlgorithmCode = this.getWeightingAlgorithmCode();
            WeightingAlgorithmCodeType rhsWeightingAlgorithmCode;
            rhsWeightingAlgorithmCode = that.getWeightingAlgorithmCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "weightingAlgorithmCode", lhsWeightingAlgorithmCode), LocatorUtils.property(thatLocator, "weightingAlgorithmCode", rhsWeightingAlgorithmCode), lhsWeightingAlgorithmCode, rhsWeightingAlgorithmCode)) {
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
            List<TechnicalCommitteeDescriptionType> lhsTechnicalCommitteeDescription;
            lhsTechnicalCommitteeDescription = (((this.technicalCommitteeDescription!= null)&&(!this.technicalCommitteeDescription.isEmpty()))?this.getTechnicalCommitteeDescription():null);
            List<TechnicalCommitteeDescriptionType> rhsTechnicalCommitteeDescription;
            rhsTechnicalCommitteeDescription = (((that.technicalCommitteeDescription!= null)&&(!that.technicalCommitteeDescription.isEmpty()))?that.getTechnicalCommitteeDescription():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "technicalCommitteeDescription", lhsTechnicalCommitteeDescription), LocatorUtils.property(thatLocator, "technicalCommitteeDescription", rhsTechnicalCommitteeDescription), lhsTechnicalCommitteeDescription, rhsTechnicalCommitteeDescription)) {
                return false;
            }
        }
        {
            List<LowTendersDescriptionType> lhsLowTendersDescription;
            lhsLowTendersDescription = (((this.lowTendersDescription!= null)&&(!this.lowTendersDescription.isEmpty()))?this.getLowTendersDescription():null);
            List<LowTendersDescriptionType> rhsLowTendersDescription;
            rhsLowTendersDescription = (((that.lowTendersDescription!= null)&&(!that.lowTendersDescription.isEmpty()))?that.getLowTendersDescription():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lowTendersDescription", lhsLowTendersDescription), LocatorUtils.property(thatLocator, "lowTendersDescription", rhsLowTendersDescription), lhsLowTendersDescription, rhsLowTendersDescription)) {
                return false;
            }
        }
        {
            PrizeIndicatorType lhsPrizeIndicator;
            lhsPrizeIndicator = this.getPrizeIndicator();
            PrizeIndicatorType rhsPrizeIndicator;
            rhsPrizeIndicator = that.getPrizeIndicator();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "prizeIndicator", lhsPrizeIndicator), LocatorUtils.property(thatLocator, "prizeIndicator", rhsPrizeIndicator), lhsPrizeIndicator, rhsPrizeIndicator)) {
                return false;
            }
        }
        {
            List<PrizeDescriptionType> lhsPrizeDescription;
            lhsPrizeDescription = (((this.prizeDescription!= null)&&(!this.prizeDescription.isEmpty()))?this.getPrizeDescription():null);
            List<PrizeDescriptionType> rhsPrizeDescription;
            rhsPrizeDescription = (((that.prizeDescription!= null)&&(!that.prizeDescription.isEmpty()))?that.getPrizeDescription():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "prizeDescription", lhsPrizeDescription), LocatorUtils.property(thatLocator, "prizeDescription", rhsPrizeDescription), lhsPrizeDescription, rhsPrizeDescription)) {
                return false;
            }
        }
        {
            List<PaymentDescriptionType> lhsPaymentDescription;
            lhsPaymentDescription = (((this.paymentDescription!= null)&&(!this.paymentDescription.isEmpty()))?this.getPaymentDescription():null);
            List<PaymentDescriptionType> rhsPaymentDescription;
            rhsPaymentDescription = (((that.paymentDescription!= null)&&(!that.paymentDescription.isEmpty()))?that.getPaymentDescription():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "paymentDescription", lhsPaymentDescription), LocatorUtils.property(thatLocator, "paymentDescription", rhsPaymentDescription), lhsPaymentDescription, rhsPaymentDescription)) {
                return false;
            }
        }
        {
            FollowupContractIndicatorType lhsFollowupContractIndicator;
            lhsFollowupContractIndicator = this.getFollowupContractIndicator();
            FollowupContractIndicatorType rhsFollowupContractIndicator;
            rhsFollowupContractIndicator = that.getFollowupContractIndicator();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "followupContractIndicator", lhsFollowupContractIndicator), LocatorUtils.property(thatLocator, "followupContractIndicator", rhsFollowupContractIndicator), lhsFollowupContractIndicator, rhsFollowupContractIndicator)) {
                return false;
            }
        }
        {
            BindingOnBuyerIndicatorType lhsBindingOnBuyerIndicator;
            lhsBindingOnBuyerIndicator = this.getBindingOnBuyerIndicator();
            BindingOnBuyerIndicatorType rhsBindingOnBuyerIndicator;
            rhsBindingOnBuyerIndicator = that.getBindingOnBuyerIndicator();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bindingOnBuyerIndicator", lhsBindingOnBuyerIndicator), LocatorUtils.property(thatLocator, "bindingOnBuyerIndicator", rhsBindingOnBuyerIndicator), lhsBindingOnBuyerIndicator, rhsBindingOnBuyerIndicator)) {
                return false;
            }
        }
        {
            List<AwardingCriterionType> lhsAwardingCriterion;
            lhsAwardingCriterion = (((this.awardingCriterion!= null)&&(!this.awardingCriterion.isEmpty()))?this.getAwardingCriterion():null);
            List<AwardingCriterionType> rhsAwardingCriterion;
            rhsAwardingCriterion = (((that.awardingCriterion!= null)&&(!that.awardingCriterion.isEmpty()))?that.getAwardingCriterion():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "awardingCriterion", lhsAwardingCriterion), LocatorUtils.property(thatLocator, "awardingCriterion", rhsAwardingCriterion), lhsAwardingCriterion, rhsAwardingCriterion)) {
                return false;
            }
        }
        {
            List<PersonType> lhsTechnicalCommitteePerson;
            lhsTechnicalCommitteePerson = (((this.technicalCommitteePerson!= null)&&(!this.technicalCommitteePerson.isEmpty()))?this.getTechnicalCommitteePerson():null);
            List<PersonType> rhsTechnicalCommitteePerson;
            rhsTechnicalCommitteePerson = (((that.technicalCommitteePerson!= null)&&(!that.technicalCommitteePerson.isEmpty()))?that.getTechnicalCommitteePerson():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "technicalCommitteePerson", lhsTechnicalCommitteePerson), LocatorUtils.property(thatLocator, "technicalCommitteePerson", rhsTechnicalCommitteePerson), lhsTechnicalCommitteePerson, rhsTechnicalCommitteePerson)) {
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
            WeightingAlgorithmCodeType theWeightingAlgorithmCode;
            theWeightingAlgorithmCode = this.getWeightingAlgorithmCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "weightingAlgorithmCode", theWeightingAlgorithmCode), currentHashCode, theWeightingAlgorithmCode);
        }
        {
            List<DescriptionType> theDescription;
            theDescription = (((this.description!= null)&&(!this.description.isEmpty()))?this.getDescription():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            List<TechnicalCommitteeDescriptionType> theTechnicalCommitteeDescription;
            theTechnicalCommitteeDescription = (((this.technicalCommitteeDescription!= null)&&(!this.technicalCommitteeDescription.isEmpty()))?this.getTechnicalCommitteeDescription():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "technicalCommitteeDescription", theTechnicalCommitteeDescription), currentHashCode, theTechnicalCommitteeDescription);
        }
        {
            List<LowTendersDescriptionType> theLowTendersDescription;
            theLowTendersDescription = (((this.lowTendersDescription!= null)&&(!this.lowTendersDescription.isEmpty()))?this.getLowTendersDescription():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lowTendersDescription", theLowTendersDescription), currentHashCode, theLowTendersDescription);
        }
        {
            PrizeIndicatorType thePrizeIndicator;
            thePrizeIndicator = this.getPrizeIndicator();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "prizeIndicator", thePrizeIndicator), currentHashCode, thePrizeIndicator);
        }
        {
            List<PrizeDescriptionType> thePrizeDescription;
            thePrizeDescription = (((this.prizeDescription!= null)&&(!this.prizeDescription.isEmpty()))?this.getPrizeDescription():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "prizeDescription", thePrizeDescription), currentHashCode, thePrizeDescription);
        }
        {
            List<PaymentDescriptionType> thePaymentDescription;
            thePaymentDescription = (((this.paymentDescription!= null)&&(!this.paymentDescription.isEmpty()))?this.getPaymentDescription():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "paymentDescription", thePaymentDescription), currentHashCode, thePaymentDescription);
        }
        {
            FollowupContractIndicatorType theFollowupContractIndicator;
            theFollowupContractIndicator = this.getFollowupContractIndicator();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "followupContractIndicator", theFollowupContractIndicator), currentHashCode, theFollowupContractIndicator);
        }
        {
            BindingOnBuyerIndicatorType theBindingOnBuyerIndicator;
            theBindingOnBuyerIndicator = this.getBindingOnBuyerIndicator();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bindingOnBuyerIndicator", theBindingOnBuyerIndicator), currentHashCode, theBindingOnBuyerIndicator);
        }
        {
            List<AwardingCriterionType> theAwardingCriterion;
            theAwardingCriterion = (((this.awardingCriterion!= null)&&(!this.awardingCriterion.isEmpty()))?this.getAwardingCriterion():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "awardingCriterion", theAwardingCriterion), currentHashCode, theAwardingCriterion);
        }
        {
            List<PersonType> theTechnicalCommitteePerson;
            theTechnicalCommitteePerson = (((this.technicalCommitteePerson!= null)&&(!this.technicalCommitteePerson.isEmpty()))?this.getTechnicalCommitteePerson():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "technicalCommitteePerson", theTechnicalCommitteePerson), currentHashCode, theTechnicalCommitteePerson);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}