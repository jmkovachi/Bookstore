package org.csci4050.bookstore.Bookstore.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.csci4050.bookstore.Bookstore.constants.EnvConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * More information on authenticating with RDS can be found in this tutorial:
 * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/UsingWithRDS.IAMDBAuth.Connecting.Java.html
 * Most of the configuration code in this class is taken or modified from the tutorial. IAM authentication, however,
 * is not used here.
 */
@Configuration
public class JDBCConfig {

    private static final String INSTANCE_HOSTNAME = getHostName();
    private static final String JDBC_URL = getJDBCURL();

    // modify this variable to switch back and forth from dev to prod DB
    private static final String RUN_ENV = EnvConstants.DEV;

    private static final String DB_USER = "group6";
    private static final String DB_PASSWORD = "groupNumber6";
    private static final int INSTANCE_PORT = 3306;

    private static final String SSL_CERTIFICATE = "rds-ca-2015-us-east-2.pem";

    private static final String KEY_STORE_TYPE = "JKS";
    private static final String KEY_STORE_PROVIDER = "SUN";
    private static final String KEY_STORE_FILE_PREFIX = "sys-connect-via-ssl-test-cacerts";
    private static final String KEY_STORE_FILE_SUFFIX = ".jks";
    private static final String DEFAULT_KEY_STORE_PASSWORD = "changeit";

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        try {
            return getDataSource();
        } catch (final Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Bean
    public Connection connection() {
        try {
            return dataSource.getConnection();
        } catch (final SQLException sqlE) {
            System.out.println(sqlE.toString());
            return null;
        }
    }

    /**
     * This method returns a mysql datasource
     * @return data source
     * @throws Exception
     */
    private DataSource getDataSource() throws Exception {
        final MysqlDataSource dataSource = new MysqlDataSource();
        if (RUN_ENV.equals(EnvConstants.PROD)) {
            setSslProperties();
            dataSource.setVerifyServerCertificate(true);
            dataSource.setUseSSL(true);
        } else {
            dataSource.setUseSSL(false);
        }
        dataSource.setDatabaseName("bookstoreDB");
        dataSource.setUser(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setURL(JDBC_URL);
        return dataSource;
    }

    /**
     * This method sets the SSL properties which specify the key store file, its type and password:
     * @throws Exception
     */
    private static void setSslProperties() throws Exception {
        System.setProperty("javax.net.ssl.trustStore", createKeyStoreFile());
        System.setProperty("javax.net.ssl.trustStoreType", KEY_STORE_TYPE);
        System.setProperty("javax.net.ssl.trustStorePassword", DEFAULT_KEY_STORE_PASSWORD);
    }

    /**
     * This method returns the path of the Key Store File needed for the SSL verification during the IAM Database Authentication to
     * the db instance.
     * @return path of Key Store file
     * @throws Exception
     */
    private static String createKeyStoreFile() throws Exception {
        return createKeyStoreFile(createCertificate()).getPath();
    }

    /**
     *  This method generates the SSL certificate
     * @return X509 certificate
     * @throws Exception
     */
    private static X509Certificate createCertificate() throws Exception {
        final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        final URL url = new File(SSL_CERTIFICATE).toURI().toURL();

        try (final InputStream certInputStream = url.openStream()) {
            return (X509Certificate) certFactory.generateCertificate(certInputStream);
        }
    }

    /**
     * This method creates the Key Store File
     * @param rootX509Certificate - the SSL certificate to be stored in the KeyStore
     * @return
     * @throws Exception
     */
    private static File createKeyStoreFile(final X509Certificate rootX509Certificate) throws Exception {
        final File keyStoreFile = File.createTempFile(KEY_STORE_FILE_PREFIX, KEY_STORE_FILE_SUFFIX);
        try (FileOutputStream fos = new FileOutputStream(keyStoreFile.getPath())) {
            KeyStore ks = KeyStore.getInstance(KEY_STORE_TYPE, KEY_STORE_PROVIDER);
            ks.load(null);
            ks.setCertificateEntry("rootCaCertificate", rootX509Certificate);
            ks.store(fos, DEFAULT_KEY_STORE_PASSWORD.toCharArray());
        }
        return keyStoreFile;
    }

    private static String getHostName() {
        if (EnvConstants.PROD.equals(RUN_ENV)) {
            return "bookstoredb2.c3xzdcecjoac.us-east-2.rds.amazonaws.com";
        } else {
            return "127.0.0.1";
        }
    }

    private static String getJDBCURL() {
        return "jdbc:mysql://" + INSTANCE_HOSTNAME + ":" + INSTANCE_PORT + "/bookstoreDB";
    }
}
