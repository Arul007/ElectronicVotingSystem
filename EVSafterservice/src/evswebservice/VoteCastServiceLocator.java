/**
 * VoteCastServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package evswebservice;

public class VoteCastServiceLocator extends org.apache.axis.client.Service implements evswebservice.VoteCastService {

    public VoteCastServiceLocator() {
    }


    public VoteCastServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VoteCastServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for VoteCast
    private java.lang.String VoteCast_address = "http://localhost:5555/evswebservice/services/VoteCast";

    public java.lang.String getVoteCastAddress() {
        return VoteCast_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String VoteCastWSDDServiceName = "VoteCast";

    public java.lang.String getVoteCastWSDDServiceName() {
        return VoteCastWSDDServiceName;
    }

    public void setVoteCastWSDDServiceName(java.lang.String name) {
        VoteCastWSDDServiceName = name;
    }

    public evswebservice.VoteCast getVoteCast() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(VoteCast_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getVoteCast(endpoint);
    }

    public evswebservice.VoteCast getVoteCast(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            evswebservice.VoteCastSoapBindingStub _stub = new evswebservice.VoteCastSoapBindingStub(portAddress, this);
            _stub.setPortName(getVoteCastWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setVoteCastEndpointAddress(java.lang.String address) {
        VoteCast_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (evswebservice.VoteCast.class.isAssignableFrom(serviceEndpointInterface)) {
                evswebservice.VoteCastSoapBindingStub _stub = new evswebservice.VoteCastSoapBindingStub(new java.net.URL(VoteCast_address), this);
                _stub.setPortName(getVoteCastWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("VoteCast".equals(inputPortName)) {
            return getVoteCast();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://evswebservice", "VoteCastService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://evswebservice", "VoteCast"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("VoteCast".equals(portName)) {
            setVoteCastEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
