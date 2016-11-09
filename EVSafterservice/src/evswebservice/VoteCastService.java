/**
 * VoteCastService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package evswebservice;

public interface VoteCastService extends javax.xml.rpc.Service {
    public java.lang.String getVoteCastAddress();

    public evswebservice.VoteCast getVoteCast() throws javax.xml.rpc.ServiceException;

    public evswebservice.VoteCast getVoteCast(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
