package com.rok93.book.springboot.service.posts;

import com.rok93.book.springboot.domain.posts.Posts;
import com.rok93.book.springboot.domain.posts.PostsRepository;
import com.rok93.book.springboot.web.dto.PostsListResponseDto;
import com.rok93.book.springboot.web.dto.PostsResponseDto;
import com.rok93.book.springboot.web.dto.PostsSaveRequestDto;
import com.rok93.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id= " + id));

        //이 부분이 어디서 오류가 나는가...!?
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선됌 (CUD 기능이 전혀 없는 서비스 메소드에서 사용하는 것을 추천)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findeAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));

        postsRepository.delete(posts); // JpaRepository에서 이미 delete 메소드를 지원하고 있으니 이를 활용한다.
        // 엔티티를 파라미터로 삭제할 수도 있고, deleteById 메소드를 이용하면 id로 삭제할 수도 있다.
        // 존재하는 Posts인지 확인을 위해 엔티티 조회 후 그대로 삭제한다.
    }
}
