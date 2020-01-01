package com.rok93.book.springboot.web;

import com.rok93.book.springboot.config.auth.LoginUser;
import com.rok93.book.springboot.config.auth.dto.SessionUser;
import com.rok93.book.springboot.service.posts.PostsService;
import com.rok93.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

/**
 * IndexController 클래스
 * index 머스테치에 URL 매핑을 하기 위한 Controller
 * <p>
 * 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때, 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
 */

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) { // Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        // 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달한다.
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) { // 세션에 저장된 값이 있을 때만 model에 userName으로 등록한다.
            model.addAttribute("userName", user.getName());
        }
        return "index"; //index.mustache를 호출
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save"; //posts-save.mustache를 호출
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
