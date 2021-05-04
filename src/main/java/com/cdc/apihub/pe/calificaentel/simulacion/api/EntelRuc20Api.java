package com.cdc.apihub.pe.calificaentel.simulacion.api;

import com.cdc.apihub.pe.calificaentel.simulacion.client.ApiClient;
import com.cdc.apihub.pe.calificaentel.simulacion.client.ApiException;
import com.cdc.apihub.pe.calificaentel.simulacion.client.ApiResponse;
import com.cdc.apihub.pe.calificaentel.simulacion.client.Configuration;
import com.cdc.apihub.pe.calificaentel.simulacion.client.Pair;
import com.cdc.apihub.pe.calificaentel.simulacion.client.ProgressRequestBody;
import com.cdc.apihub.pe.calificaentel.simulacion.client.ProgressResponseBody;
import com.cdc.apihub.pe.calificaentel.simulacion.model.Peticion;
import com.cdc.apihub.pe.calificaentel.simulacion.model.Respuesta;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntelRuc20Api {
    private ApiClient apiClient;
    public EntelRuc20Api() {
        this(Configuration.getDefaultApiClient());
    }
    public EntelRuc20Api(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call entelRuc20Call(String xApiKey,  Peticion request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        String localVarPath = "";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    private okhttp3.Call entelRuc20ValidateBeforeCall(String xApiKey,  Peticion request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling entelRuc20(Async)");
        }
        
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling entelRuc20(Async)");
        }
        
        okhttp3.Call call = entelRuc20Call(xApiKey,  request, progressListener, progressRequestListener);
        return call;
    }
    
    public Respuesta entelRuc20(String xApiKey, Peticion request) throws ApiException {
        ApiResponse<Respuesta> resp = entelRuc20WithHttpInfo(xApiKey,  request);
        return resp.getData();
    }
    
    public ApiResponse<Respuesta> entelRuc20WithHttpInfo(String xApiKey,  Peticion request) throws ApiException {
        okhttp3.Call call = entelRuc20ValidateBeforeCall(xApiKey, request, null, null);
        Type localVarReturnType = new TypeToken<Respuesta>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    
}
