/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.soap;

/**
 * <code>SOAPElementFactory</code> is a factory for XML fragments that
 * will eventually end up in the SOAP part. These fragments
 * can be inserted as children of the <code>SOAPHeader</code> or
 * <code>SOAPBody</code> or <code>SOAPEnvelope</code>.
 *
 * <p>Elements created using this factory do not have the properties
 * of an element that lives inside a SOAP header document. These
 * elements are copied into the XML document tree when they are
 * inserted.
 *
 * @see javax.xml.soap.SOAPFactory
 * @deprecated - Use <code>javax.xml.soap.SOAPFactory</code> for creating SOAPElements.
 */
public class SOAPElementFactory {

  private SOAPFactory soapFactory;

  private SOAPElementFactory(SOAPFactory soapFactory) {
    this.soapFactory = soapFactory;
  }

  /**
   * Create a <code>SOAPElement</code> object initialized with the
   * given <code>Name</code> object.
   *
   * @param name a <code>Name</code> object with the XML name for the new element
   * @return the new <code>SOAPElement</code> object that was created
   * @throws SOAPException if there is an error in creating the <code>SOAPElement</code> object
   * @see javax.xml.soap.SOAPFactory#createElement(javax.xml.soap.Name)
   * @see javax.xml.soap.SOAPFactory#createElement(javax.xml.namespace.QName)
   * @deprecated Use javax.xml.soap.SOAPFactory.createElement(javax.xml.soap.Name) instead
   */
  public SOAPElement create(Name name) throws SOAPException {
    return soapFactory.createElement(name);
  }

  /**
   * Create a <code>SOAPElement</code> object initialized with the
   * given local name.
   *
   * @param localName a <code>String</code> giving the local name for the new element
   * @return the new <code>SOAPElement</code> object that was created
   * @throws SOAPException if there is an error in creating the <code>SOAPElement</code> object
   * @see javax.xml.soap.SOAPFactory#createElement(java.lang.String)
   * @deprecated Use javax.xml.soap.SOAPFactory.createElement(String localName) instead
   */
  public SOAPElement create(String localName) throws SOAPException {
    return soapFactory.createElement(localName);
  }

  /**
   * Create a new <code>SOAPElement</code> object with the given
   * local name, prefix and uri.
   *
   * @param localName a <code>String</code> giving the local name for the new element
   * @param prefix the prefix for this <code>SOAPElement</code>
   * @param uri a <code>String</code> giving the URI of the namespace to which the new element
   * belongs
   * @throws SOAPException if there is an error in creating the <code>SOAPElement</code> object
   * @see javax.xml.soap.SOAPFactory#createElement(java.lang.String, java.lang.String,
   * java.lang.String)
   * @deprecated Use javax.xml.soap.SOAPFactory.createElement(String localName, String prefix,
   * String uri) instead
   */
  public SOAPElement create(String localName, String prefix, String uri)
      throws SOAPException {
    return soapFactory.createElement(localName, prefix, uri);
  }

  /**
   * Creates a new instance of <code>SOAPElementFactory</code>.
   *
   * @return a new instance of a <code>SOAPElementFactory</code>
   * @throws SOAPException if there was an error creating the default
   * <code>SOAPElementFactory</code>
   */
  public static SOAPElementFactory newInstance() throws SOAPException {
    try {
      return new SOAPElementFactory(SOAPFactory.newInstance());
    } catch (Exception ex) {
      throw new SOAPException(
          "Unable to create SOAP Element Factory: " + ex.getMessage());
    }
  }
}
