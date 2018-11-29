package eu.europa.ec.grow.espd.domain;

/**
 * Created by Mula on 28/08/2018.
 */
public class Visitor {
	private Integer integrationState;
	private String role;
	private String countryCode;
	private boolean hasRequestXML;
	private boolean hasResponseXml;

	public Visitor(Integer integrationState, String role, String language, boolean hasReqXml, boolean hasRespXml) {
		this.hasRequestXML = hasReqXml;
		this.hasResponseXml = hasRespXml;
		this.integrationState = integrationState;
		this.countryCode = language;
		this.role = role;
	}

	public boolean hasRequestXML() {
		return hasRequestXML;
	}

	public boolean hasResponseXML() {
		return hasResponseXml;
	}

	public Integer getIntegrationState() {
		return integrationState;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getRole() {
		return role;
	}

}
