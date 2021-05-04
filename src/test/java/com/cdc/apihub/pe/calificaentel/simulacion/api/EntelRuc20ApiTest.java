package com.cdc.apihub.pe.calificaentel.simulacion.api;

import org.junit.Test;

import com.cdc.apihub.pe.calificaentel.simulacion.api.EntelRuc20Api;
import com.cdc.apihub.pe.calificaentel.simulacion.client.ApiException;
import com.cdc.apihub.pe.calificaentel.simulacion.model.Peticion;
import com.cdc.apihub.pe.calificaentel.simulacion.model.Respuesta;
import com.cdc.apihub.pe.calificaentel.simulacion.client.ApiClient;

import org.junit.Assert;
import org.junit.Before;


public class EntelRuc20ApiTest {
	
    private final EntelRuc20Api api = new EntelRuc20Api();
    
    
    @Before()
    public void setUp() {
    	ApiClient apiClient = api.getApiClient();
		apiClient.setBasePath("the_url");   	
    }
    
    @Test
    public void entelRuc20Test() throws ApiException {
    	
        String xApiKey = "your_api_key";
        
        
        Peticion request = new Peticion();
        request.setFolio("");
        request.setTipoDocumento("10");
        request.setNumeroDocumento("20100072590");
        request.setIdUsuario("946513634");
        request.setIdTipoOperacion("PPR");
        System.out.println(request+"");
        
        try {
        	
        	Respuesta response = api.entelRuc20(xApiKey, request);
        	System.out.println(response);
    		Assert.assertNotNull(response);
    	} catch (ApiException e) {
    		System.out.println(e);
    	}
    }
    
}
