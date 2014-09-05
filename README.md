Documentation
-------------
For general API documentation, please refer to the [WebPDF View API Documentation](http://api.webpdf365.com/ApiList).


Installation:
First, get the library. You can download the JAR here: http://api.webpdf365.com/download/foxit-webpdf-view-api.jar
Add foxit-webpdf-view-api.jar to your classpath.

Initializing the API class:
```java
String api_key = "YOUR_API_KEY";
ViewApi viewApi = new ViewApi(api_key);
```

Creating a document to upload:
```java
ViewDocument viewDocument = new ViewDocument("test document.pdf", "URL_TO_FILE");
```

Uploading a document to the API:
```java
DocumentBean documentBean = viewApi.upload(viewDocument);
if (documentBean.getError() == 0) {
	log.info(("Uploaded successfully, docId:%s\n", documentBean.getDocId());
} else {
	log.warn(("Uploaded failed, error:%s, msg:%s\n", documentBean.getError(), documentBean.getMsg());
}
```

You can also upload local files through the API:
```java
ViewDocument viewDocument = new ViewDocument("/filepath/filename.pdf");
DocumentBean documentBean = viewApi.upload(viewDocument);
if (documentBean.getError() == 0) {
	log.info(("Uploaded successfully, docId:%s\n", documentBean.getDocId());
} else {
	log.warn(("Uploaded failed, error:%s, msg:%s\n", documentBean.getError(), documentBean.getMsg());
}
```

You can also upload memory files through the API:
```java
ViewDocument viewDocumentByData = new ViewDocument("test document", BYTEDATA_TO_FILE);
DocumentBean documentBean = viewApi.upload(viewDocument);
if (documentBean.getError() == 0) {
	log.info(("Uploaded successfully, docId:%s\n", documentBean.getDocId());
} else {
	log.warn(("Uploaded failed, error:%s, msg:%s\n", documentBean.getError(), documentBean.getMsg());
}
```

After some time, the document will be processed and can be viewed:
```java
SessionBean sessionBean = viewApi.view(documentBean.getDocId(), null);
if (sessionBean.getError() == 0) {
	log.info("View successfully, docId:%s, sessionId:%s\n", documentBean.getDocId(), sessionBean.getSessionId());
} else {
	log.warn("View failed, error:%s, msg:%s\n", sessionBean.getError(), sessionBean.getMsg());
}
```

Embed the document in an iframe.
```java
String html = "<iframe src=\"" + sessionBean.getUrls().getView() + "\"></iframe>";
```

Deleting the document:
```java
BaseBean deleteBean = viewApi.delete(documentBean.getDocId());
if (deleteBean.getError() == 0) {
	log.info("Deleted successfully, docId:%s\n", documentBean.getDocId());
} else {
	log.warn("Deleted failed, error:%s, msg:%s\n", deleteBean.getError(), deleteBean.getMsg());
}
```

####Handling Exceptions
API calls will throw an instance of `UploadDocumentException` or `ParameterTypeException` when an error is encountered.  
You should wrap your API calls with a `try/catch`.
```php
try
{
	DocumentBean documentBean = viewApi.upload(viewDocument);
}
catch(UploadDocumentException e)
{
	log.warn(e->getMessage());
}
```
