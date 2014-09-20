package com.foxit.webpdf.view.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foxit.webpdf.view.api.bean.BaseBean;
import com.foxit.webpdf.view.api.bean.DocumentBean;
import com.foxit.webpdf.view.api.bean.SessionBean;
import com.foxit.webpdf.view.api.bean.SessionInfo;
import com.foxit.webpdf.view.api.bean.SessionInfoBean;
import com.foxit.webpdf.view.api.bean.SessionInfoListBean;
import com.foxit.webpdf.view.api.exception.ParameterTypeException;
import com.foxit.webpdf.view.api.exception.UploadDocumentException;

public class Example {
	
	public static void main(String args[]) {
		/**
		 * Manipulate documents using the API.
		 */
		String api_key = "YOUR_API_KEY";
		ViewApi viewApi = new ViewApi(api_key);
		
		/**
		 *  Create new document we want to upload.
		 *  Use URL.
		 */
		ViewDocument viewDocumentByURL = new ViewDocument("test document", "URL_TO_FILE");
		DocumentBean documentBeanByURL = null;
		try {
			documentBeanByURL = viewApi.upload(viewDocumentByURL);
			if (documentBeanByURL.getError() == 0) {
				System.out.printf("Uploaded successfully, docId:%s\n", documentBeanByURL.getDocId());
			} else {
				System.out.printf("Uploaded failed, error:%d, msg:%s\n", documentBeanByURL.getError(), documentBeanByURL.getMsg());
				return;
			}
		} catch (UploadDocumentException e) {
			System.out.println(e.getMessage());
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return;
		}
		
		/**
		 *  Create new document we want to upload.
		 *  Use Path.
		 */
		ViewDocument viewDocumentByPath = new ViewDocument("PATH_TO_FILE");
		DocumentBean documentBeanByPath = null;
		try {
			documentBeanByPath = viewApi.upload(viewDocumentByPath);
			if (documentBeanByPath.getError() == 0) {
				System.out.printf("Uploaded successfully, docId:%s\n", documentBeanByPath.getDocId());
			} else {
				System.out.printf("Uploaded failed, error:%d, msg:%s\n", documentBeanByPath.getError(), documentBeanByPath.getMsg());
				return;
			}
		} catch (UploadDocumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		/**
		 *  Create new document we want to upload.
		 *  Use document data.
		 */
		byte[] BYTEDATA_TO_FILE = {10,10,10,10,10};
		ViewDocument viewDocumentByData = new ViewDocument("test document2", BYTEDATA_TO_FILE);
		DocumentBean documentBeanByData = null;
		try {
			documentBeanByData = viewApi.upload(viewDocumentByData);
			if (documentBeanByData.getError() == 0) {
				System.out.printf("Uploaded successfully, docId:%s\n", documentBeanByData.getDocId());
			} else {
				System.out.printf("Uploaded failed, error:%d, msg:%s\n", documentBeanByData.getError(), documentBeanByData.getMsg());
				return;
			}
		} catch (UploadDocumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		/**
		 * Delete the document.
		 */
		try {
			BaseBean deleteBean = viewApi.delete(documentBeanByData.getDocId());
			if (deleteBean.getError() == 0) {
				System.out.printf("Deleted successfully, docId:%s\n", documentBeanByData.getDocId());
			} else {
				System.out.printf("Deleted failed, error:%d, msg:%s\n", deleteBean.getError(), deleteBean.getMsg());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		/**
		 * View Documents using the API.
		 */
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("expiry", 120);
		SessionBean sessionBean = null;
		try {
			sessionBean = viewApi.view(documentBeanByURL.getDocId(), params);
			if (sessionBean.getError() == 0) {
				System.out.printf("View successfully, docId:%s, sessionId:%s\n", documentBeanByURL.getDocId(), sessionBean.getSessionId());
			} else {
				System.out.printf("View failed, error:%d, msg:%s\n", sessionBean.getError(), sessionBean.getMsg());
			}
		} catch (ParameterTypeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		String html = "<iframe src=\"" + sessionBean.getUrls().getView() + "\"></iframe>\n";
		System.out.println(html);
		
		/**
		 * Get session information based on session ID
		 */
		SessionInfoBean sessionInfoBean = viewApi.getSessionInfo(sessionBean.getSessionId());
		if (sessionInfoBean.getError() == 0) {
			System.out.printf("Get session information based on session ID successfully, sessionId:%s, createDate:%s\n", sessionInfoBean.getSessionId(), sessionInfoBean.getCreateDate());
		} else {
			System.out.printf("Get session information based on session ID failed, error:%d\n", sessionInfoBean.getError());
			return;
		}
		
		/**
		 * Search session information based on document ID
		 */
		SessionInfoListBean sessionInfoListBean = viewApi.getSessionInfoByDocId(documentBeanByURL.getDocId());
		if (sessionInfoListBean.getError() == 0) {
			System.out.printf("Search session information based on document ID successfully:\n");
			List<SessionInfo> sessionInfoList = sessionInfoListBean.getSessionList();
			for (SessionInfo sessionInfo : sessionInfoList) {
				System.out.printf("		sessionId:%s, createDate:%s\n", sessionInfo.getSessionId(), sessionInfo.getCreateDate());
			}
		} else {
			System.out.printf("Search session information based on document ID failed, error:%d\n", sessionInfoListBean.getError());
			return;
		}
		
		/**
		 * Delete session information based on session ID
		 */
		BaseBean deleteSessionBean = viewApi.deleteSession(sessionBean.getSessionId());
		if (deleteSessionBean.getError() == 0) {
			System.out.printf("Delete session information based on session ID successfully, sessionId:%s\n", sessionBean.getSessionId());
		} else {
			System.out.printf("Delete session information based on session ID failed, error:%d\n", deleteSessionBean.getError());
		}
		
		/**
		 * Delete session information based on document ID
		 */
		deleteSessionBean = viewApi.deleteSessionByDocId(documentBeanByURL.getDocId());
		if (deleteSessionBean.getError() == 0) {
			System.out.printf("Delete session information based on session ID successfully, docId:%s\n", documentBeanByURL.getDocId());
		} else {
			System.out.printf("Delete session information based on session ID failed, error:%d\n", deleteSessionBean.getError());
		}
	}
	
}
