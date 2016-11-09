/**
 * VoteCast.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package evswebservice;

public interface VoteCast extends java.rmi.Remote {
    public java.lang.String vote(java.lang.String userId, java.lang.String electionId, java.lang.String candidateId) throws java.rmi.RemoteException;
}
