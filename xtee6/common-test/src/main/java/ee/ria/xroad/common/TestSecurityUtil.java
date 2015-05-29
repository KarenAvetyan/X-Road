package ee.ria.xroad.common;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * Initializes test security environment.
 */
public final class TestSecurityUtil {

    private TestSecurityUtil() {
    }

    /**
     * Initializes BouncyCastle security library.
     * Disables specified algorithms when building certpath.
     */
    public static void initSecurity() {
        // This property disables specified algorithms when building certpath
        // Ultimately, we should load custom security properties file
        // for example, on the command line via -Djava.security.properties.
        Security.setProperty("jdk.certpath.disabledAlgorithms", "MD5");

        Security.addProvider(new BouncyCastleProvider());

        org.apache.xml.security.Init.init();
    }

}