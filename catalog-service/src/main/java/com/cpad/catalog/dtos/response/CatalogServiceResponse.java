package com.cpad.catalog.dtos.response;

import com.cpad.catalog.utils.ResponseConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public record CatalogServiceResponse<T>(T data, String message) {

    /**
     * @param data: contains the data
     * @param message: response message
     * @return <T> ResponseEntity<RecruitmentToolResponse<T>>
     */
    private static <T> CatalogServiceResponse<T> generateResponseBuilder(T data, String message) {
        return new CatalogServiceResponse<>(data, message);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> continueResponse() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.CONTINUE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CONTINUE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> continueResponse(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CONTINUE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> continueResponse(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.CONTINUE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CONTINUE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> continueResponse(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CONTINUE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    continueResponse(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.CONTINUE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> switchingProtocols() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.SWITCHING_PROTOCOLS_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SWITCHING_PROTOCOLS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> switchingProtocols(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SWITCHING_PROTOCOLS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> switchingProtocols(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.SWITCHING_PROTOCOLS_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SWITCHING_PROTOCOLS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> switchingProtocols(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SWITCHING_PROTOCOLS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    switchingProtocols(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.SWITCHING_PROTOCOLS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> processing() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.PROCESSING_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PROCESSING);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> processing(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PROCESSING);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> processing(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.PROCESSING_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PROCESSING);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> processing(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PROCESSING);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> processing(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.PROCESSING);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> checkpoint() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.CHECKPOINT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CHECKPOINT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> checkpoint(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CHECKPOINT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> checkpoint(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.CHECKPOINT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CHECKPOINT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> checkpoint(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CHECKPOINT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> checkpoint(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.CHECKPOINT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> ok() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.OK_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.OK);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> ok(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.OK);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> ok(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.OK_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.OK);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> ok(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.OK);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> ok(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.OK);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> created() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.CREATED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> created(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> created(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.CREATED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> created(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> created(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> accepted() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.ACCEPTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.ACCEPTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> accepted(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.ACCEPTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> accepted(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.ACCEPTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.ACCEPTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> accepted(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.ACCEPTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> accepted(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.ACCEPTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> nonAuthoritativeInformation() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.NON_AUTHORITATIVE_INFORMATION_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> nonAuthoritativeInformation(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> nonAuthoritativeInformation(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.NON_AUTHORITATIVE_INFORMATION_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> nonAuthoritativeInformation(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    nonAuthoritativeInformation(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> noContent() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.NO_CONTENT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> noContent(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> noContent(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.NO_CONTENT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> noContent(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> noContent(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> resetContent() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.RESET_CONTENT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.RESET_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> resetContent(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.RESET_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> resetContent(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.RESET_CONTENT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.RESET_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> resetContent(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.RESET_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> resetContent(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.RESET_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> partialContent() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.PARTIAL_CONTENT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PARTIAL_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> partialContent(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PARTIAL_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> partialContent(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.PARTIAL_CONTENT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PARTIAL_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> partialContent(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PARTIAL_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> partialContent(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.PARTIAL_CONTENT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> multiStatus() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.MULTI_STATUS_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MULTI_STATUS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> multiStatus(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MULTI_STATUS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> multiStatus(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.MULTI_STATUS_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MULTI_STATUS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> multiStatus(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MULTI_STATUS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> multiStatus(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.MULTI_STATUS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> alreadyReported() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.ALREADY_REPORTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.ALREADY_REPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> alreadyReported(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.ALREADY_REPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> alreadyReported(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.ALREADY_REPORTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.ALREADY_REPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> alreadyReported(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.ALREADY_REPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    alreadyReported(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.ALREADY_REPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> imUsed() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.IM_USED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.IM_USED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> imUsed(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.IM_USED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> imUsed(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.IM_USED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.IM_USED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> imUsed(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.IM_USED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> imUsed(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.IM_USED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> multipleChoices() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.MULTIPLE_CHOICES_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MULTIPLE_CHOICES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> multipleChoices(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MULTIPLE_CHOICES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> multipleChoices(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.MULTIPLE_CHOICES_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MULTIPLE_CHOICES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> multipleChoices(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MULTIPLE_CHOICES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    multipleChoices(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.MULTIPLE_CHOICES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> movedPermanently() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.MOVED_PERMANENTLY_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MOVED_PERMANENTLY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> movedPermanently(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MOVED_PERMANENTLY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> movedPermanently(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.MOVED_PERMANENTLY_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MOVED_PERMANENTLY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> movedPermanently(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.MOVED_PERMANENTLY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    movedPermanently(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.MOVED_PERMANENTLY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> found() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.FOUND_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> found(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> found(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.FOUND_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> found(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> found(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> seeOther() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.SEE_OTHER_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SEE_OTHER);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> seeOther(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SEE_OTHER);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> seeOther(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.SEE_OTHER_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SEE_OTHER);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> seeOther(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SEE_OTHER);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> seeOther(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.SEE_OTHER);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notModified() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.NOT_MODIFIED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_MODIFIED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notModified(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_MODIFIED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notModified(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.NOT_MODIFIED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_MODIFIED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notModified(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_MODIFIED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notModified(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.NOT_MODIFIED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> temporaryRedirect() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.TEMPORARY_REDIRECT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.TEMPORARY_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> temporaryRedirect(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.TEMPORARY_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> temporaryRedirect(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.TEMPORARY_REDIRECT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.TEMPORARY_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> temporaryRedirect(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.TEMPORARY_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    temporaryRedirect(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.TEMPORARY_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> permanentRedirect() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.PERMANENT_REDIRECT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PERMANENT_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> permanentRedirect(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PERMANENT_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> permanentRedirect(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.PERMANENT_REDIRECT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PERMANENT_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> permanentRedirect(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PERMANENT_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    permanentRedirect(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.PERMANENT_REDIRECT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badRequest() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.BAD_REQUEST_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badRequest(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badRequest(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.BAD_REQUEST_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badRequest(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badRequest(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unauthorized() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.UNAUTHORIZED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unauthorized(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unauthorized(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.UNAUTHORIZED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unauthorized(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unauthorized(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> paymentRequired() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.PAYMENT_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PAYMENT_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> paymentRequired(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PAYMENT_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> paymentRequired(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.PAYMENT_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PAYMENT_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> paymentRequired(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PAYMENT_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    paymentRequired(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.PAYMENT_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> forbidden() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.FORBIDDEN_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FORBIDDEN);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> forbidden(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FORBIDDEN);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> forbidden(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.FORBIDDEN_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FORBIDDEN);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> forbidden(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FORBIDDEN);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> forbidden(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.FORBIDDEN);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notFound() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.NOT_FOUND_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notFound(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notFound(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.NOT_FOUND_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notFound(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notFound(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> methodNotAllowed() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.METHOD_NOT_ALLOWED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> methodNotAllowed(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> methodNotAllowed(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.METHOD_NOT_ALLOWED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> methodNotAllowed(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    methodNotAllowed(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notAcceptable() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.NOT_ACCEPTABLE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notAcceptable(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notAcceptable(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.NOT_ACCEPTABLE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notAcceptable(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notAcceptable(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.NOT_ACCEPTABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> proxyAuthenticationRequired() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.PROXY_AUTHENTICATION_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> proxyAuthenticationRequired(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> proxyAuthenticationRequired(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.PROXY_AUTHENTICATION_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> proxyAuthenticationRequired(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    proxyAuthenticationRequired(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestTimeout() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.REQUEST_TIMEOUT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUEST_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestTimeout(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUEST_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestTimeout(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.REQUEST_TIMEOUT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUEST_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestTimeout(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUEST_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestTimeout(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.REQUEST_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> conflict() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.CONFLICT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CONFLICT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> conflict(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CONFLICT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> conflict(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.CONFLICT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CONFLICT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> conflict(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.CONFLICT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> conflict(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.CONFLICT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gone() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.GONE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.GONE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gone(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.GONE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gone(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.GONE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.GONE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gone(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.GONE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gone(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.GONE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> lengthRequired() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.LENGTH_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LENGTH_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> lengthRequired(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LENGTH_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> lengthRequired(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.LENGTH_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LENGTH_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> lengthRequired(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LENGTH_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> lengthRequired(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.LENGTH_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> preconditionFailed() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.PRECONDITION_FAILED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PRECONDITION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> preconditionFailed(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PRECONDITION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> preconditionFailed(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.PRECONDITION_FAILED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PRECONDITION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> preconditionFailed(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PRECONDITION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    preconditionFailed(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.PRECONDITION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> payloadTooLarge() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.PAYLOAD_TOO_LARGE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> payloadTooLarge(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> payloadTooLarge(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.PAYLOAD_TOO_LARGE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> payloadTooLarge(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    payloadTooLarge(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> uriTooLong() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.URI_TOO_LONG_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.URI_TOO_LONG);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> uriTooLong(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.URI_TOO_LONG);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> uriTooLong(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.URI_TOO_LONG_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.URI_TOO_LONG);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> uriTooLong(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.URI_TOO_LONG);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> uriTooLong(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.URI_TOO_LONG);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unsupportedMediaType() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.UNSUPPORTED_MEDIA_TYPE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unsupportedMediaType(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unsupportedMediaType(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.UNSUPPORTED_MEDIA_TYPE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unsupportedMediaType(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    unsupportedMediaType(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestedRangeNotSatisfiable() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.REQUESTED_RANGE_NOT_SATISFIABLE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestedRangeNotSatisfiable(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestedRangeNotSatisfiable(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.REQUESTED_RANGE_NOT_SATISFIABLE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestedRangeNotSatisfiable(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    requestedRangeNotSatisfiable(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> expectationFailed() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.EXPECTATION_FAILED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.EXPECTATION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> expectationFailed(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.EXPECTATION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> expectationFailed(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.EXPECTATION_FAILED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.EXPECTATION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> expectationFailed(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.EXPECTATION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    expectationFailed(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.EXPECTATION_FAILED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> iAmATeapot() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.I_AM_A_TEAPOT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.I_AM_A_TEAPOT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> iAmATeapot(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.I_AM_A_TEAPOT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> iAmATeapot(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.I_AM_A_TEAPOT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.I_AM_A_TEAPOT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> iAmATeapot(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.I_AM_A_TEAPOT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> iAmATeapot(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.I_AM_A_TEAPOT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unprocessableEntity() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.UNPROCESSABLE_ENTITY_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unprocessableEntity(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unprocessableEntity(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.UNPROCESSABLE_ENTITY_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unprocessableEntity(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    unprocessableEntity(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> locked() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.LOCKED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LOCKED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> locked(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LOCKED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> locked(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.LOCKED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LOCKED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> locked(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LOCKED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> locked(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.LOCKED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> failedDependency() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.FAILED_DEPENDENCY_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FAILED_DEPENDENCY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> failedDependency(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FAILED_DEPENDENCY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> failedDependency(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.FAILED_DEPENDENCY_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FAILED_DEPENDENCY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> failedDependency(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.FAILED_DEPENDENCY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    failedDependency(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.FAILED_DEPENDENCY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> upgradeRequired() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.UPGRADE_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UPGRADE_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> upgradeRequired(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UPGRADE_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> upgradeRequired(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.UPGRADE_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UPGRADE_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> upgradeRequired(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UPGRADE_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    upgradeRequired(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.UPGRADE_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> preconditionRequired() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.PRECONDITION_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PRECONDITION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> preconditionRequired(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PRECONDITION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> preconditionRequired(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.PRECONDITION_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PRECONDITION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> preconditionRequired(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.PRECONDITION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    preconditionRequired(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.PRECONDITION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> tooManyRequests() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.TOO_MANY_REQUESTS_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.TOO_MANY_REQUESTS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> tooManyRequests(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.TOO_MANY_REQUESTS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> tooManyRequests(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.TOO_MANY_REQUESTS_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.TOO_MANY_REQUESTS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> tooManyRequests(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.TOO_MANY_REQUESTS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    tooManyRequests(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.TOO_MANY_REQUESTS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestHeaderFieldsTooLarge() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.REQUEST_HEADER_FIELDS_TOO_LARGE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestHeaderFieldsTooLarge(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestHeaderFieldsTooLarge(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.REQUEST_HEADER_FIELDS_TOO_LARGE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> requestHeaderFieldsTooLarge(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    requestHeaderFieldsTooLarge(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unavailableForLegalReasons() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.UNAVAILABLE_FOR_LEGAL_REASONS_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unavailableForLegalReasons(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unavailableForLegalReasons(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.UNAVAILABLE_FOR_LEGAL_REASONS_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> unavailableForLegalReasons(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    unavailableForLegalReasons(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> internalServerError() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.INTERNAL_SERVER_ERROR_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> internalServerError(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> internalServerError(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.INTERNAL_SERVER_ERROR_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> internalServerError(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    internalServerError(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notImplemented() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.NOT_IMPLEMENTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_IMPLEMENTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notImplemented(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_IMPLEMENTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notImplemented(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.NOT_IMPLEMENTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_IMPLEMENTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notImplemented(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_IMPLEMENTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notImplemented(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.NOT_IMPLEMENTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badGateway() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.BAD_GATEWAY_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BAD_GATEWAY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badGateway(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BAD_GATEWAY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badGateway(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.BAD_GATEWAY_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BAD_GATEWAY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badGateway(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BAD_GATEWAY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> badGateway(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.BAD_GATEWAY);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> serviceUnavailable() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.SERVICE_UNAVAILABLE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> serviceUnavailable(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> serviceUnavailable(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.SERVICE_UNAVAILABLE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> serviceUnavailable(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    serviceUnavailable(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.SERVICE_UNAVAILABLE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gatewayTimeout() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.GATEWAY_TIMEOUT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.GATEWAY_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gatewayTimeout(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.GATEWAY_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gatewayTimeout(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.GATEWAY_TIMEOUT_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.GATEWAY_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gatewayTimeout(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.GATEWAY_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> gatewayTimeout(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.GATEWAY_TIMEOUT);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> httpVersionNotSupported() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.HTTP_VERSION_NOT_SUPPORTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> httpVersionNotSupported(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> httpVersionNotSupported(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.HTTP_VERSION_NOT_SUPPORTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> httpVersionNotSupported(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    httpVersionNotSupported(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> variantAlsoNegotiates() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.VARIANT_ALSO_NEGOTIATES_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.VARIANT_ALSO_NEGOTIATES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> variantAlsoNegotiates(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.VARIANT_ALSO_NEGOTIATES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> variantAlsoNegotiates(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.VARIANT_ALSO_NEGOTIATES_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.VARIANT_ALSO_NEGOTIATES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> variantAlsoNegotiates(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.VARIANT_ALSO_NEGOTIATES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    variantAlsoNegotiates(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.VARIANT_ALSO_NEGOTIATES);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> insufficientStorage() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.INSUFFICIENT_STORAGE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.INSUFFICIENT_STORAGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> insufficientStorage(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.INSUFFICIENT_STORAGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> insufficientStorage(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.INSUFFICIENT_STORAGE_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.INSUFFICIENT_STORAGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> insufficientStorage(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.INSUFFICIENT_STORAGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    insufficientStorage(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.INSUFFICIENT_STORAGE);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> loopDetected() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.LOOP_DETECTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LOOP_DETECTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> loopDetected(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LOOP_DETECTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> loopDetected(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.LOOP_DETECTED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LOOP_DETECTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> loopDetected(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.LOOP_DETECTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> loopDetected(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.LOOP_DETECTED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> bandwidthLimitExceeded() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.BANDWIDTH_LIMIT_EXCEEDED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> bandwidthLimitExceeded(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> bandwidthLimitExceeded(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.BANDWIDTH_LIMIT_EXCEEDED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> bandwidthLimitExceeded(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    bandwidthLimitExceeded(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notExtended() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.NOT_EXTENDED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_EXTENDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notExtended(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_EXTENDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notExtended(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.NOT_EXTENDED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_EXTENDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notExtended(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NOT_EXTENDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> notExtended(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.NOT_EXTENDED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> networkAuthenticationRequired() {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, ResponseConstants.ResponseMessages.NETWORK_AUTHENTICATION_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> networkAuthenticationRequired(String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(null, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> networkAuthenticationRequired(T data) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, ResponseConstants.ResponseMessages.NETWORK_AUTHENTICATION_REQUIRED_MESSAGE);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>> networkAuthenticationRequired(T data, String message) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<CatalogServiceResponse<T>>
    networkAuthenticationRequired(T data, String message, HttpHeaders headers) {
        CatalogServiceResponse<T> UCAuthBackendResponse =
                generateResponseBuilder(data, message);
        return new ResponseEntity<>(UCAuthBackendResponse, headers, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }
}
