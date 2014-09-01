package com.foxit.webpdf.view.api;

import com.foxit.webpdf.view.api.bean.DocumentBean;
import com.foxit.webpdf.view.api.bean.SessionBean;
import com.foxit.webpdf.view.api.dto.DocumentDTO;
import com.foxit.webpdf.view.api.dto.SessionDTO;

import retrofit.http.Body;
import retrofit.http.DELETE;
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
	DocumentBean uploadDocument(@Query("api_key") String apiKey, @Query("userId") String userId, @Body DocumentDTO documentDTO);

	@Multipart
	@POST("/documents")
	DocumentBean uploadDocumentByMultipart(@Query("api_key") String apiKey, @Query("userId") String userId, @Part("file") TypedFile file);
	
	@POST("/documents")
	DocumentBean uploadDocumentByMultipartOutput(@Query("api_key") String apiKey, @Query("userId") String userId, @Body MultipartTypedOutput file);
	
	@Headers("content-type: application/json")
	@DELETE("/documents/{docId}")
	DocumentBean deleteDocument(@Query("api_key") String apiKey, @Query("userId") String userId, @Path("docId") String docId);
	
	@Headers("content-type: application/json")
	@POST("/sessions")
	SessionBean createSession(@Query("api_key") String apiKey, @Query("userId") String userId, @Body SessionDTO sessionDTO);
}
