package org.csci4050.bookstore.Bookstore.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.rds.auth.GetIamAuthTokenRequest;
import com.amazonaws.services.rds.auth.RdsIamAuthTokenGenerator;

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
import java.util.Properties;

/**
 * More information on authenticating with RDS can be found in this tutorial:
 * https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/UsingWithRDS.IAMDBAuth.Connecting.Java.html
 * Most of the configuration code in this class is taken or modified from the tutorial. IAM authentication, however,
 * is not used here.
 */
@Configuration
public class JDBCConfig {

    private static final String RDS_INSTANCE_HOSTNAME = "bookstoredb2.c3xzdcecjoac.us-east-2.rds.amazonaws.com";
    private static final int RDS_INSTANCE_PORT = 3306;
    private static final String REGION_NAME = "us-east-2";
    private static final String DB_USER = "group6";
    private static final String DB_PASSWORD = "groupNumber6";
    private static final String JDBC_URL = "jdbc:mysql://" + RDS_INSTANCE_HOSTNAME + ":" + RDS_INSTANCE_PORT + "/bookstoreDB";

    private static final String SSL_CERTIFICATE = "rds-ca-2015-us-east-2.pem";

    private static final String KEY_STORE_TYPE = "JKS";
    private static final String KEY_STORE_PROVIDER = "SUN";
    private static final String KEY_STORE_FILE_PREFIX = "sys-connect-via-ssl-test-cacerts";
    private static final String KEY_STORE_FILE_SUFFIX = ".jks";
    private static final String DEFAULT_KEY_STORE_PASSWORD = "changeit";

    @Autowired
    private DataSource dataSource;

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
     * This method returns a connection to the db instance authenticated using IAM Database Authentication
     * @return
     * @throws Exception
     */
    private static DataSource getDataSource() throws Exception {
        setSslProperties();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("bookstoreDB");
        dataSource.setUser(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setURL(JDBC_URL);
        dataSource.setVerifyServerCertificate(true);
        dataSource.setUseSSL(true);
        return dataSource;
    }



    /**
     * This method sets the mysql connection properties with the DB username and password.
     * It also specifies that SSL verification is required.
     * @return mysql connection properties
     */
    private static Properties setMySqlConnectionProperties() {
        final Properties mysqlConnectionProperties = new Properties();
        mysqlConnectionProperties.setProperty("verifyServerCertificate", "true");
        mysqlConnectionProperties.setProperty("useSSL", "true");
        mysqlConnectionProperties.setProperty("user", DB_USER);
        mysqlConnectionProperties.setProperty("password", DB_PASSWORD);
        return mysqlConnectionProperties;
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

    // As of now, this method is unneeded. It was previously used to generate the connection password.
    private static String generateAuthToken() {
        final AWSCredentials credentials = new BasicAWSCredentials("AKIAJ4L7X6MSJGJV5Q6Q", "OVNokyLLdrQQroEqeoj00ijPO2hv2n9CEabfVUy+");
        final RdsIamAuthTokenGenerator generator = RdsIamAuthTokenGenerator.builder()
                .credentials(new AWSStaticCredentialsProvider(credentials))
                .region(REGION_NAME)
                .build();

        final String authToken = generator.getAuthToken(
                GetIamAuthTokenRequest.builder()
                        .hostname(RDS_INSTANCE_HOSTNAME)
                        .port(RDS_INSTANCE_PORT)
                        .userName(DB_USER)
                        .build());

        return authToken;
    }
}
