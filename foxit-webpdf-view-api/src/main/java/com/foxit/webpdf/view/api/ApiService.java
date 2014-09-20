package com.foxit.webpdf.view.api;

import com.foxit.webpdf.view.api.bean.BaseBean;
import com.foxit.webpdf.view.api.bean.DocumentBean;
import com.foxit.webpdf.view.api.bean.SessionBean;
import com.foxit.webpdf.view.api.bean.SessionInfoBean;
import com.foxit.webpdf.view.api.bean.SessionInfoListBean;
import com.foxit.webpdf.view.api.dto.DocumentDTO;
import com.foxit.webpdf.view.api.dto.SessionDTO;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedFile;

/**
 * Interface ApiService
 * 
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public interface ApiService {
	@Headers("content-type: application/json")
	@POST("/documents")
	DocumentBean uploadDocument(@Query("api_key") String apiKey, @Body DocumentDTO documentDTO);

	@Multipart
	@POST("/documents")
	DocumentBean uploadDocumentByMultipart(@Query("api_key") String apiKey, @Part("file") TypedFile file);
	
	@POST("/documents")
	DocumentBean uploadDocumentByMultipartOutput(@Query("api_key") String apiKey, @Body MultipartTypedOutput file);
	
	@Headers("content-type: application/json")
	@DELETE("/documents/{docId}")
	BaseBean deleteDocument(@Query("api_key") String apiKey, @Path("docId") String docId);
	
	@Headers("content-type: application/json")
	@POST("/sessions")
	SessionBean createSession(@Query("api_key") String apiKey, @Body SessionDTO sessionDTO);
	
	@GET("/sessions/{sessionId}")
	SessionInfoBean getSessionInfo(@Query("api_key") String apiKey, @Path("sessionId") String sessionId);
	
	@Headers("content-type: application/json")
	@DELETE("/sessions/{sessionId}")
	BaseBean deleteSession(@Query("api_key") String apiKey, @Path("sessionId") String sessionId);
	
	@GET("/{docId}/sessions")
	SessionInfoListBean getSessionInfoByDocId(@Query("api_key") String apiKey, @Path("docId") String docId);
	
	@Headers("content-type: application/json")
	@DELETE("/{docId}/sessions")
	BaseBean deleteSessionByDocId(@Query("api_key") String apiKey, @Path("docId") String docId);
}
