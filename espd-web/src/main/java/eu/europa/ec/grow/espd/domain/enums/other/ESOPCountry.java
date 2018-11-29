package eu.europa.ec.grow.espd.domain.enums.other;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

public enum ESOPCountry {
	ENGLISH_GB(Country.GB, Language.ENGLISH),
	ENGLISH_US(Country.US, Language.ENGLISH),
	ITALIAN(Country.IT, Language.ITALIAN),
	BULGARIAN(Country.BG, Language.BULGARIAN),
	CZECH(Country.CZ, Language.CZECH),
	DANISH(Country.DK, Language.DANISH),
	GERMAN(Country.DE, Language.GERMAN),
	ESTONIAN(Country.EE, Language.ESTONIAN),
	GREEK(Country.GR, Language.GREEK),
	SPANISH(Country.ES, Language.SPANISH),
	FRENCH(Country.FR, Language.FRENCH),
	CROATIAN(Country.HR, Language.CROATIAN),
	LATVIAN(Country.LV, Language.LATVIAN),
	LITHUANIAN(Country.LT, Language.LITHUANIAN),
	HUNGARIAN(Country.HU, Language.HUNGARIAN),
	MALTESE(Country.MT, Language.MALTESE),
	DUTCH(Country.NL, Language.DUTCH),
	POLISH(Country.PL, Language.POLISH),
	PORTUGUESE(Country.PT, Language.PORTUGUESE),
	ROMANIAN(Country.RO, Language.ROMANIAN),
	SLOVAK(Country.SK, Language.SLOVAK),
	SLOVENIAN(Country.SI,Language.SLOVENIAN),
	FINNISH(Country.FI, Language.FINNISH),
	SWEDISH(Country.SE, Language.SWEDISH),
	NORWEGIAN(Country.NO, Language.NORWEGIAN),
	ICELANDIC(Country.IS, Language.ICELANDIC);

	private Country country;
	private Language language;

	public static final List<ESOPCountry> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final Map<String, ESOPCountry> BY_CODE = new HashMap<>(VALUES.size());
	static {
		for (ESOPCountry c : VALUES) {
			BY_CODE.put(c.getIso2Code().toLowerCase(), c);
		}
	}

	ESOPCountry(Country country, Language language) {
		this.country = country;
		this.language = language;
	}

	public String getIso2Code() {
		return country.getIso2Code();
	}

	public Language getLanguage() {
		return language;
	}

	public Country getCountry() {
		return country;
	}

	public static ESOPCountry findByCode(String iso2code) {
		return BY_CODE.get(trimToEmpty(iso2code).toLowerCase());
	}
}

