package com.rok93.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 6 클래스 내 모든 필드의 Getter 메소드를 자동생성 (lombok)
@NoArgsConstructor // 5 기본생성자들 자동으로 생성 (lombok)
@Entity // 1
public class Posts {

    @Id // 2
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3 PK의 생성 규칙을 나타냄, 웬만하면 Long 타입의 Auto_increment를 추천
    private Long id;

    @Column(length = 500, nullable = false) // 4
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 7 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

