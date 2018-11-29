package eu.europa.ec.grow.espd.service;

import eu.europa.ec.grow.espd.domain.Visitor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.input.ReaderInputStream;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j

@Service("ESOPDBConnector")
public class ESOPDBConnector {

	private static final String DATASOURCE_JNDI_NAME = "com/bs/esop/ds/DataSource";

	private static final String TABLE_NAME = "T_MDL_ESPD_INTEGRATION";

	private static final String VISITOR_QUERY = "select INTEGRATION_STATE, ROLE, LANGUAGE, case when ESPD_FILE_REQUEST is null then 0 else 1 end HAS_REQ_XML, case when ESPD_FILE_RESPONSE is null then 0 else 1 end HAS_RESP_XML from T_MDL_ESPD_INTEGRATION where VISITOR_ID = ?";
	private static final String STATUS_UPDATE_QUERY = "update " + TABLE_NAME + " set INTEGRATION_STATE = ? where VISITOR_ID = ?";
	private static final String REQUEST_XML_DOC_RETRIEVE_QUERY = "select ESPD_FILE_REQUEST from " + TABLE_NAME + " where VISITOR_ID = ?";
	private static final String XMLs_DOC_RETRIEVE_QUERY = "select ESPD_FILE_REQUEST, ESPD_FILE_RESPONSE from " + TABLE_NAME + " where VISITOR_ID = ?";
	private static final String RETURN_URL_QUERY = "select RETURN_URL from " + TABLE_NAME + " where VISITOR_ID = ?";
	private static final String REQUEST_XML_UPDATE_QUERY = "update " + TABLE_NAME + " set ESPD_FILE_REQUEST = ? where VISITOR_ID = ?";
	private static final String RESPONSE_XML_UPDATE_QUERY = "update " + TABLE_NAME + " set ESPD_FILE_RESPONSE = ? where VISITOR_ID = ?";

	public Visitor getVisitor(String visitorId) throws SQLException {
		DataSource ds = getDataSource();
		if (ds != null) {
			Connection conn = null;
			PreparedStatement stm = null;
			ResultSet rs = null;
			try {
				conn = ds.getConnection();
				stm = conn.prepareStatement(VISITOR_QUERY);
				stm.setString(1, visitorId);
				rs = stm.executeQuery();
				if (rs.next()) {
					String role = rs.getString("ROLE");
					String language = rs.getString("LANGUAGE");
					Integer integrationState = rs.getInt("INTEGRATION_STATE");
					if (rs.wasNull())
						integrationState = null;
					boolean hasReqXML = (rs.getInt("HAS_REQ_XML") == 1);
					boolean hasRespXML = (rs.getInt("HAS_RESP_XML") == 1);
					return new Visitor(integrationState, role, language, hasReqXML, hasRespXML);
				}
			} finally {
				closeDBOperation(conn, stm, rs);
			}
		}
		log.warn("User not found");
		return null;
	}

	public void updateStatus(String visitorId, int status) throws SQLException {
		DataSource ds = getDataSource();
		if (ds != null) {
			Connection conn = null;
			PreparedStatement stm = null;
			try {
				conn = ds.getConnection();
				stm = conn.prepareStatement(STATUS_UPDATE_QUERY);
				stm.setInt(1, status);
				stm.setString(2, visitorId);
				int updates = stm.executeUpdate();
				if (updates != 1) {
					log.warn("Unable to update integration status");
				}
			} finally {
				closeDBOperation(conn, stm, null);
			}


		}
	}

	public InputStream getRequestXMLDocInputStream(String visitorId) throws SQLException {
		DataSource ds = getDataSource();
		if (ds != null) {
			Connection conn = null;
			PreparedStatement stm = null;
			ResultSet rs = null;
			try {
				conn = ds.getConnection();
				stm = conn.prepareStatement(REQUEST_XML_DOC_RETRIEVE_QUERY);
				stm.setString(1, visitorId);
				rs = stm.executeQuery();
				if (rs.next()) {
					Clob xmlClob = rs.getClob("ESPD_FILE_REQUEST");
					return new ReaderInputStream(xmlClob.getCharacterStream(), "UTF-8");
				}
			} finally {
				closeDBOperation(conn, stm, rs);
			}
		}
		log.warn("cannot retrieve XML document for visitor id " + visitorId);
		return null;
	}

	/**
	 * @return a 2-elemens array with request and response XML input streams
	 */
	public InputStream[] getXMLsDocInputStream(String visitorId) throws SQLException {
		DataSource ds = getDataSource();
		if (ds != null) {
			Connection conn = null;
			PreparedStatement stm = null;
			ResultSet rs = null;
			try {
				conn = ds.getConnection();
				stm = conn.prepareStatement(XMLs_DOC_RETRIEVE_QUERY);
				stm.setString(1, visitorId);
				rs = stm.executeQuery();
				if (rs.next()) {
					Clob reqXmlClob = rs.getClob("ESPD_FILE_REQUEST");
					Clob respXmlClob = rs.getClob("ESPD_FILE_RESPONSE");
					InputStream [] XMLs = new InputStream[2];
					XMLs[0] = new ReaderInputStream(reqXmlClob.getCharacterStream(), "UTF-8");
					XMLs[1] = new ReaderInputStream(respXmlClob.getCharacterStream(), "UTF-8");
					return XMLs;
				}
			} finally {
				closeDBOperation(conn, stm, rs);
			}
		}
		log.warn("cannot retrieve XML document for visitor id " + visitorId);
		return null;
	}

	public String getReturnUrl(String visitorId) throws SQLException {
		DataSource ds = getDataSource();
		if (ds != null) {
			Connection conn = null;
			PreparedStatement stm = null;
			ResultSet rs = null;
			try {
				conn = ds.getConnection();
				stm = conn.prepareStatement(RETURN_URL_QUERY);
				stm.setString(1, visitorId);
				rs = stm.executeQuery();
				if (rs.next()) {
					String returnUrl = rs.getString("RETURN_URL");
					return returnUrl;
				}
			} finally {
				closeDBOperation(conn, stm, rs);
			}
		}
		log.warn("cannot retrieve return URL document for visitor id " + visitorId);
		return null;
	}

	public void setXMLDoc(String visitorId, boolean isCA, byte[] XmlDocUTF8) throws SQLException {
		DataSource ds = getDataSource();
		if (ds != null) {
			Connection conn = null;
			PreparedStatement stm = null;
			ResultSet rs = null;
			try {
				conn = ds.getConnection();
				stm = conn.prepareStatement(isCA ? REQUEST_XML_UPDATE_QUERY : RESPONSE_XML_UPDATE_QUERY);
				InputStreamReader is = new InputStreamReader(new ByteArrayInputStream(XmlDocUTF8), "UTF-8");
				stm.setClob(1, is);
				stm.setString(2, visitorId);
				rs = stm.executeQuery();
				int updates = stm.executeUpdate();
				if (updates == 1) {
					//...
					return;
				}
			} catch (UnsupportedEncodingException e) {
				log.warn("Unable encoding", e);
				throw new SQLException(e);
			} finally {
				closeDBOperation(conn, stm, rs);
			}
			log.warn("cannot update XML document for visitor id " + visitorId);
		}
	}


	private synchronized DataSource getDataSource() throws SQLException {
		DataSource dataSource = null;
		try {
			Context context = new InitialContext();
			dataSource = (javax.sql.DataSource) context.lookup(DATASOURCE_JNDI_NAME);
		} catch (NamingException e) {
			log.error("Unable to connect to DB", e);
			throw new SQLException(e);
		}
		return dataSource;
	}

	private void closeDBOperation(Connection conn, PreparedStatement stm, ResultSet rs) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (stm != null)
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}


}
