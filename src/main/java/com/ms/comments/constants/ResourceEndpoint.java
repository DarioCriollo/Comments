package com.ms.comments.constants;

public class ResourceEndpoint {
    private ResourceEndpoint(){
        super();
    }

    public static final String API_VERSION = "/api/v1";
    public static final String ENTERPRISE = API_VERSION + "/enterprise/admin";
    public static final String FIND_ALL_COMMENTS = "/find-all-comments";
    public static final String SAVE_COMMENT = "/save-comment";
    public static final String FIND_COMMENT_BY_ID = "/find-comment/{id}";
    public static final String DELETE_COMMENT = "/delete-comment/{id}";
    public static final String FIND_COMMENT_TASK = "/find-comment-task";
}
