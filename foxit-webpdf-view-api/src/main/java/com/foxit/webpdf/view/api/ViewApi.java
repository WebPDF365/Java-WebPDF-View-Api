package com.foxit.webpdf.view.api;

import java.io.File;
import java.util.Map;

import org.apache.log4j.Logger;

import retrofit.RestAdapter;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedFile;

import com.foxit.webpdf.view.api.bean.BaseBean;
import com.foxit.webpdf.view.api.bean.DocumentBean;
import com.foxit.webpdf.view.api.bean.SessionBean;
import com.foxit.webpdf.view.api.dto.DocumentDTO;
import com.foxit.webpdf.view.api.dto.SessionDTO;
import com.foxit.webpdf.view.api.exception.ParameterTypeException;
import com.foxit.webpdf.view.api.exception.UploadDocumentException;

/**
 * Class ViewAPI
 * 
 * WebPDF Cloud API implementation.
 * Allows you to easily work with the WebPDF Cloud API,
 * uploading, deleting, and viewing documents.
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class ViewApi {
	private String apiServiceRootUrl = "http://api.webpdf365.com/api/v1.0";
	private ApiService apiService;
	private String apiKey;
	protected static final Logger log = Logger.getLogger(ViewApi.class);
	
	/**
	 * Initializes the ViewApi object.
	 * Ensure the access to cURL,
	 * that the api_key is set,
	 * and sets various URLs needed for interacting with the API.
	 * 
	 * @param String apiKey
	 * 	API Key for your WebPDF View Application.
	 */
	public ViewApi(String apiKey) {
		this.apiKey = apiKey;
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(
				apiServiceRootUrl).build();
		apiService = restAdapter.create(ApiService.class);
	}
	
	/**
	 * Initializes the ViewApi object.
	 * Ensure access to cURL,
	 * that the api_key is set,
	 * and sets various URLs needed for interacting with the API.
	 * 
	 * @param String apiKey
	 * @param String apiServiceRootUrl
	 */
	public ViewApi(String apiKey, String apiServiceRootUrl) {
		this.apiKey = apiKey;
		this.apiServiceRootUrl = apiServiceRootUrl;
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(
				apiServiceRootUrl).build();
		apiService = restAdapter.create(ApiService.class);
	}
	
	/**
	 * Upload a new file  the View API for conversion.
	 * Files can be uploaded either through a publicly accessible URL or
	 * through a multipart POST.
	 * 
	 * @param ViewDocument doc
	 *  
	 * @return DocumentBean
	 * 	The response is an object converted from JSON
	 * @throws UploadDocumentException
	 */
	public DocumentBean upload(ViewDocument doc) throws UploadDocumentException {
		DocumentBean docBean = null;
		String url = doc.getFileUrl();
		String path = doc.getFilePath();
		byte[] data = doc.getFileData();
		if (url != null && !url.isEmpty()) {
			DocumentDTO docDto = new DocumentDTO();
			docDto.setFileName(doc.getFileName());
			docDto.setUrl(doc.getFileUrl());
			docBean = apiService.uploadDocument(apiKey, "", docDto);
		} else if (path != null && !path.isEmpty()) {
			File file = null;
			try {
				file = new File(doc.getFilePath());
			} catch (Exception e) {
				String msg = String.format("get file(%s) failed.", doc.getFilePath());
				log.warn(msg);
				throw new UploadDocumentException(msg);
			}

			TypedFile typedFile = new TypedFile("multipart/form-data", file);
			docBean = apiService.uploadDocumentByMultipart(apiKey, "", typedFile);
		} else if (data != null) {
			TypedByteArrayApi typedByteArray = new TypedByteArrayApi("multipart/form-data", data, doc.getFileName());
			MultipartTypedOutput mtOutput = new MultipartTypedOutput();
			mtOutput.addPart("file", typedByteArray);
			docBean = apiService.uploadDocumentByMultipartOutput(apiKey, "", mtOutput);
		} else {
			String msg = "Missing file information. url or file path, or file data must be set.";
			log.warn(msg);
			throw new UploadDocumentException(msg);
		}
		return docBean;
	}
	
	/**
	 * Removes a document completely from the View API servers.
	 * 
	 * @param String docId
	 * 	The docId of the file to delete
	 * 
	 * @return BaseBean 
	 * 	The response is an object converted from JSON
	 */
	public BaseBean delete(String docId) {
		BaseBean baseBean = apiService.deleteDocument(apiKey, "", docId);
		return baseBean;
	}
	
	/**
	 * Creates a session for a single document.
	 * Sessions can only be created for documents that have a status of done
	 * 
	 * @param String docId
	 * 	The docId of the file to view
	 * 
	 * @param Map<String, Object> params
	 * 	A key-value pair of POST params
	 * 		Integer expiry -- Expiry time of the session starting from current time, in minutes, default is 60, can not be negative number or 0.
	 * 		Boolean infinite -- Whether SessionId is always valid, default is false.
	 * 
	 * @return SessionBean
	 * 	The response is an object converted from JSON
	 * @throws ParameterTypeException 
	 */
	public SessionBean view(String docId, Map<String, Object> params) throws ParameterTypeException {
		SessionBean sessionBean = null;
		SessionDTO sessionDTO = new SessionDTO();
		sessionDTO.setDocId(docId);
		if (params != null && params.containsKey("expiry")) {
			Object expiry = params.get("expiry");
			if (!expiry.getClass().equals(Integer.class)) {
				String msg = "Parameter expiry type not Insteger.";
				log.warn(msg);
				throw new ParameterTypeException(msg);
			}
			sessionDTO.setExpiry((Integer) expiry);
		}
		
		if (params != null && params.containsKey("infinite")) {
			Object infinite = params.get("infinite");
			if (!infinite.getClass().equals(Boolean.class)) {
				String msg = "Parameter infinite type not Boolean.";
				log.warn(msg);
				throw new ParameterTypeException(msg);
			}
			sessionDTO.setInfinite((Boolean) infinite);
		}
		sessionBean = apiService.createSession(apiKey, "", sessionDTO);
		return sessionBean;
	}
}
