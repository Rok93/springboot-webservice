package com.rok93.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 클래스명: PostsRepository
 * Posts 클래스로 Database를 접근하게 해줄 인터페이스
 * 단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인
 * CRUD 메소드가 자동으로 생성된다.
 * (주의: Entity 클래스와 기본 Entity Repository는 함께 위치해야한다.
 * Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없다.)
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // SpringDataJpa에서 제공하는 기본 메소드만으로 해결할 수 있다. 하지만 @Query가 훨씬 가독성이 좋으니 선택해서 사용하라
    @Query("SELECT p from Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
