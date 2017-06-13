/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


package javax.security.cert;

import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.InvalidKeyException;
import java.security.SignatureException;

/**
 * <p>Abstract class for managing a variety of identity certificates.
 * An identity certificate is a guarantee by a principal that
 * a public key is that of another principal.  (A principal represents
 * an entity such as an individual user, a group, or a corporation.)
 * <p>
 * This class is an abstraction for certificates that have different
 * formats but important common uses.  For example, different types of
 * certificates, such as X.509 and PGP, share general certificate
 * functionality (like encoding and verifying) and
 * some types of information (like a public key).
 * <p>
 * X.509, PGP, and SDSI certificates can all be implemented by
 * subclassing the Certificate class, even though they contain different
 * sets of information, and they store and retrieve the information in
 * different ways.
 *
 * <p><em>Note: The classes in the package {@code javax.security.cert}
 * exist for compatibility with earlier versions of the
 * Java Secure Sockets Extension (JSSE). New applications should instead
 * use the standard Java SE certificate classes located in
 * {@code java.security.cert}.</em></p>
 *
 * @author Hemma Prafullchandra
 * @see X509Certificate
 * @since 1.4
 */
public abstract class Certificate {

  /**
   * Compares this certificate for equality with the specified
   * object. If the {@code other} object is an
   * {@code instanceof} {@code Certificate}, then
   * its encoded form is retrieved and compared with the
   * encoded form of this certificate.
   *
   * @param other the object to test for equality with this certificate.
   * @return true if the encoded forms of the two certificates match, false otherwise.
   */
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Certificate)) {
      return false;
    }
    try {
      byte[] thisCert = this.getEncoded();
      byte[] otherCert = ((Certificate) other).getEncoded();

      if (thisCert.length != otherCert.length) {
        return false;
      }
      for (int i = 0; i < thisCert.length; i++) {
        if (thisCert[i] != otherCert[i]) {
          return false;
        }
      }
      return true;
    } catch (CertificateException e) {
      return false;
    }
  }

  /**
   * Returns a hashcode value for this certificate from its
   * encoded form.
   *
   * @return the hashcode value.
   */
  public int hashCode() {
    int retval = 0;
    try {
      byte[] certData = this.getEncoded();
      for (int i = 1; i < certData.length; i++) {
        retval += certData[i] * i;
      }
      return (retval);
    } catch (CertificateException e) {
      return (retval);
    }
  }

  /**
   * Returns the encoded form of this certificate. It is
   * assumed that each certificate type would have only a single
   * form of encoding; for example, X.509 certificates would
   * be encoded as ASN.1 DER.
   *
   * @return encoded form of this certificate
   * @throws CertificateEncodingException on internal certificate encoding failure
   */
  public abstract byte[] getEncoded() throws CertificateEncodingException;

  /**
   * Verifies that this certificate was signed using the
   * private key that corresponds to the specified public key.
   *
   * @param key the PublicKey used to carry out the verification.
   * @throws NoSuchAlgorithmException on unsupported signature algorithms.
   * @throws InvalidKeyException on incorrect key.
   * @throws NoSuchProviderException if there's no default provider.
   * @throws SignatureException on signature errors.
   * @throws CertificateException on encoding errors.
   */
  public abstract void verify(PublicKey key)
      throws CertificateException, NoSuchAlgorithmException,
      InvalidKeyException, NoSuchProviderException,
      SignatureException;

  /**
   * Verifies that this certificate was signed using the
   * private key that corresponds to the specified public key.
   * This method uses the signature verification engine
   * supplied by the specified provider.
   *
   * @param key the PublicKey used to carry out the verification.
   * @param sigProvider the name of the signature provider.
   * @throws NoSuchAlgorithmException on unsupported signature algorithms.
   * @throws InvalidKeyException on incorrect key.
   * @throws NoSuchProviderException on incorrect provider.
   * @throws SignatureException on signature errors.
   * @throws CertificateException on encoding errors.
   */
  public abstract void verify(PublicKey key, String sigProvider)
      throws CertificateException, NoSuchAlgorithmException,
      InvalidKeyException, NoSuchProviderException,
      SignatureException;

  /**
   * Returns a string representation of this certificate.
   *
   * @return a string representation of this certificate.
   */
  public abstract String toString();

  /**
   * Gets the public key from this certificate.
   *
   * @return the public key.
   */
  public abstract PublicKey getPublicKey();
}
