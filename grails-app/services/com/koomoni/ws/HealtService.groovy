package com.koomoni.ws

import org.apache.commons.logging.LogFactory;

import wslite.soap.SOAPClient;

class HealtService {
	private static final log = LogFactory.getLog(this);

	
	public String checkHealt(SOAPClient client){
		def respuesta
		
		
		try {
			
			
			def response = client.send(SOAPAction:'getResponse') {
				body{
					'ser:getResponse'('xmlns:ser':'http://services.ws.champion.com/'){
						arg0({
							
						})
					}
				}
			}
			
			respuesta = response.envelope.Body.getResponseResponse.return
			
		} catch (Exception e) {
			respuesta = e.getMessage()
			e.printStackTrace()
		}
		
		
		
		
		return respuesta	
	}
	
	
	
}
