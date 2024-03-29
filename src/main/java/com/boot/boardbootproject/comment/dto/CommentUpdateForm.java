package com.boot.boardbootproject.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUpdateForm {
    private Long id;
    private Long userId;
    private Long boardId;
    private String text;
}
