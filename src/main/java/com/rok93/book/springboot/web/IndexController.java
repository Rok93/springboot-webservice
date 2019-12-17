package com.rok93.book.springboot.web;

import com.rok93.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController 클래스
 * index 머스테치에 URL 매핑을 하기 위한 Controller
 *
 * 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때, 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
 */

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) { // Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        // 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달한다.
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; //index.mustache를 호출
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save"; //posts-save.mustache를 호출
    }
}
