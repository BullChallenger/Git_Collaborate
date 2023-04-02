package com.github.collab.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Account author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @Lob
    @Column(nullable = false, name = "comment_content")
    private String content;

    @Builder
    public Comment(String content) {
        this.content = content;
    }

    public void inscribeAuthor(Account author) {
        this.author = author;
        author.addComment(this);
    }

    public void inscribeArticle(Article article) {
        this.article = article;
        article.addComment(this);
    }
}
