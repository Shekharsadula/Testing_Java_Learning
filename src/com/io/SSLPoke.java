package com.io;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/** Establish a SSL connection to a host and port, writes a byte and
 * prints the response. See
 * http://confluence.atlassian.com/display/JIRA/Connecting+to+SSL+services
 */
public class SSLPoke {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        if (args.length != 2) {
            System.out.println("Usage: "+SSLPoke.class.getName()+" <host> <port>");
            System.exit(1);
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            SSLSocketFactory sslSocketFactory;
            if (true) {
                // https://www.baeldung.com/java-7-tls-v12
                SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
                sslContext.init(null, null, new SecureRandom());

                sslSocketFactory = sslContext.getSocketFactory();
            } else {
                sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                // This will cause an exception on connecting to a TLSv1.2-only server,
                // Exception in thread "main" javax.net.ssl.SSLHandshakeException: Remote host closed connection during handshake
                //         at sun.security.ssl.SSLSocketImpl.readRecord(SSLSocketImpl.java:953)
                //         at sun.security.ssl.SSLSocketImpl.performInitialHandshake(SSLSocketImpl.java:1332)
                //         at sun.security.ssl.SSLSocketImpl.writeRecord(SSLSocketImpl.java:709)
                //         at sun.security.ssl.AppOutputStream.write(AppOutputStream.java:122)
                //         at sun.security.ssl.AppOutputStream.write(AppOutputStream.java:136)
                //         at SSLPoke.main(SSLPoke.java:66)
                // Caused by: java.io.EOFException: SSL peer shut down incorrectly
                //         at sun.security.ssl.InputRecord.read(InputRecord.java:482)
                //         at sun.security.ssl.SSLSocketImpl.readRecord(SSLSocketImpl.java:934)
                //         ... 5 more
            }
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(args[0], Integer.parseInt(args[1]));

            // https://gist.github.com/lanimall/cb808a11a058f7fb620a#file-gistfile1-java
            String[] protocols = sslSocket.getSupportedProtocols();

            System.out.println("Supported Protocols: " + protocols.length);
            for(int i = 0; i < protocols.length; i++)
            {
                System.out.println(" " + protocols[i]);
            }

            protocols = sslSocket.getEnabledProtocols();

            System.out.println("Enabled Protocols: " + protocols.length);
            for(int i = 0; i < protocols.length; i++)
            {
                System.out.println(" " + protocols[i]);
            }

            String[] ciphers = sslSocket.getSupportedCipherSuites();
            System.out.println("Enabled Ciphers: " + ciphers.length);
            for(int i = 0; i < ciphers.length; i++)
            {
                System.out.println(" " + ciphers[i]);
            }

            in = sslSocket.getInputStream();
            out = sslSocket.getOutputStream();

            // Write a test byte to get a reaction :)
            out.write(1);

            while (in.available() > 0) {
                System.out.print(in.read());
            }
            System.out.println("Successfully connected");

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}