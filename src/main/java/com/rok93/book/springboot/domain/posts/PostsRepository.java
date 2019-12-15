package com.rok93.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 클래스명: PostsRepository
 * Posts 클래스로 Database를 접근하게 해줄 인터페이스
 * 단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인
 * CRUD 메소드가 자동으로 생성된다.
 * (주의: Entity 클래스와 기본 Entity Repository는 함께 위치해야한다.
 * Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없다.)
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
