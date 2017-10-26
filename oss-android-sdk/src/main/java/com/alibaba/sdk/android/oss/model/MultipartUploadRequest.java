package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSConstants;

import java.io.File;
import java.util.Map;

public class MultipartUploadRequest extends OSSRequest {
    private String bucketName;
    private String objectKey;

    private Boolean deleteUploadOnCancelling = true;

    private String uploadFilePath;
    private long partSize = 256 * 1024;

    private ObjectMetadata metadata;

    private Map<String, String> callbackParam;
    private Map<String, String> callbackVars;

    private OSSProgressCallback<MultipartUploadRequest> progressCallback;

    /**
     * Constructor
     * @param bucketName The target object's bucket name
     * @param objectKey The target object's key
     * @param uploadFilePath The local path of the file to upload
     */
    public MultipartUploadRequest(String bucketName, String objectKey, String uploadFilePath) {
        this(bucketName,objectKey,uploadFilePath,null);
    }

    /**
     * Constructor
     * @param bucketName The target object's bucket name
     * @param objectKey The target object's key
     * @param uploadFilePath The local path of the file to upload
     * @param metadata The metadata of the target object
     */
    public MultipartUploadRequest(String bucketName, String objectKey, String uploadFilePath, ObjectMetadata metadata) {
        setBucketName(bucketName);
        setObjectKey(objectKey);
        setUploadFilePath(uploadFilePath);
        setMetadata(metadata);
    }

    public String getBucketName() {
        return bucketName;
    }

    /**
     * Sets the OSS bucket name
     * @param bucketName
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getObjectKey() {
        return objectKey;
    }

    /**
     * Sets the OSS object key
     * @param objectKey
     */
    public void setObjectKey(String objectKey) {
        this.objectKey = objectKey;
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    /**
     * Sets the local path of the file to upload
     * @param uploadFilePath the local path of the file to upload
     */
    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }

    public ObjectMetadata getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata of the target object
     * @param metadata The metadata
     */
    public void setMetadata(ObjectMetadata metadata) {
        this.metadata = metadata;
    }

    public OSSProgressCallback<MultipartUploadRequest> getProgressCallback() {
        return progressCallback;
    }

    /**
     * Sets the upload progress callback
     */
    public void setProgressCallback(OSSProgressCallback<MultipartUploadRequest> progressCallback) {
        this.progressCallback = progressCallback;
    }

    public long getPartSize() {
        return partSize;
    }

    /**
     * Sets the part size, by default it's 256KB and the minimal value is 100KB
     * @param partSize size in byte
     */
    public void setPartSize(long partSize) throws IllegalArgumentException{
        if (partSize < OSSConstants.MIN_PART_SIZE_LIMIT) {
            throw new IllegalArgumentException("Part size must be greater than or equal to 100KB!");
        }
        this.partSize = partSize;
    }

    public Map<String, String> getCallbackParam() {
        return callbackParam;
    }

    /**
     * Sets the server callback parameters
     */
    public void setCallbackParam(Map<String, String> callbackParam) {
        this.callbackParam = callbackParam;
    }

    public Map<String, String> getCallbackVars() {
        return callbackVars;
    }

    /**
     * Sets the server callback variables
     */
    public void setCallbackVars(Map<String, String> callbackVars) {
        this.callbackVars = callbackVars;
    }
}