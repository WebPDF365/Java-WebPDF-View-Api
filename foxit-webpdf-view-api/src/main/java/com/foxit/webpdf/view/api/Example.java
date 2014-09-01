package com.foxit.webpdf.view.api;

import java.util.HashMap;
import java.util.Map;

import com.foxit.webpdf.view.api.bean.BaseBean;
import com.foxit.webpdf.view.api.bean.DocumentBean;
import com.foxit.webpdf.view.api.bean.SessionBean;
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
		 *  用URL的方式
		 */
		ViewDocument viewDocumentByURL = new ViewDocument("test document", "URL_TO_FILE");
		DocumentBean documentBeanByURL = null;
		try {
			documentBeanByURL = viewApi.upload(viewDocumentByURL);
			if (documentBeanByURL.getError() == 0) {
				System.out.printf("Uploaded successfully, docId:%s\n", documentBeanByURL.getDocId());
			} else {
				System.out.printf("Uploaded failed, error:%s, msg:%s\n", documentBeanByURL.getError(), documentBeanByURL.getMsg());
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
		 *  用Path的方式
		 */
		ViewDocument viewDocumentByPath = new ViewDocument("PATH_TO_FILE");
		DocumentBean documentBeanByPath = null;
		try {
			documentBeanByPath = viewApi.upload(viewDocumentByPath);
			if (documentBeanByPath.getError() == 0) {
				System.out.printf("Uploaded successfully, docId:%s\n", documentBeanByPath.getDocId());
			} else {
				System.out.printf("Uploaded failed, error:%s, msg:%s\n", documentBeanByPath.getError(), documentBeanByPath.getMsg());
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
		 *  用文件数据的方式
		 */
		byte[] BYTEDATA_TO_FILE = {10,10,10,10,10};
		ViewDocument viewDocumentByData = new ViewDocument("test document", BYTEDATA_TO_FILE);
		DocumentBean documentBeanByData = null;
		try {
			documentBeanByData = viewApi.upload(viewDocumentByData);
			if (documentBeanByData.getError() == 0) {
				System.out.printf("Uploaded successfully, docId:%s\n", documentBeanByData.getDocId());
			} else {
				System.out.printf("Uploaded failed, error:%s, msg:%s\n", documentBeanByData.getError(), documentBeanByData.getMsg());
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
				System.out.printf("Deleted failed, error:%s, msg:%s\n", deleteBean.getError(), deleteBean.getMsg());
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
				System.out.printf("View failed, error:%s, msg:%s\n", sessionBean.getError(), sessionBean.getMsg());
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
	}
	
}
