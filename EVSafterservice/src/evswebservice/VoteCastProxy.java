package evswebservice;

public class VoteCastProxy implements evswebservice.VoteCast {
  private String _endpoint = null;
  private evswebservice.VoteCast voteCast = null;
  
  public VoteCastProxy() {
    _initVoteCastProxy();
  }
  
  public VoteCastProxy(String endpoint) {
    _endpoint = endpoint;
    _initVoteCastProxy();
  }
  
  private void _initVoteCastProxy() {
    try {
      voteCast = (new evswebservice.VoteCastServiceLocator()).getVoteCast();
      if (voteCast != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)voteCast)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)voteCast)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (voteCast != null)
      ((javax.xml.rpc.Stub)voteCast)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public evswebservice.VoteCast getVoteCast() {
    if (voteCast == null)
      _initVoteCastProxy();
    return voteCast;
  }
  
  public java.lang.String vote(java.lang.String userId, java.lang.String electionId, java.lang.String candidateId) throws java.rmi.RemoteException{
    if (voteCast == null)
      _initVoteCastProxy();
    return voteCast.vote(userId, electionId, candidateId);
  }
  
  
}