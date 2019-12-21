package com.rok93.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 클래스명: Application
 * 설명: 앞으로 만들 프로젝트의 메인 클래스가 된다.
 * @SpringBootApplication으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기, 생성 모두 자동으로
 * 설정 된다. 특히나 @SpinrgBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는
 * 항상 프로젝트의 최상단에 위치해야만 한다.
 */
@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        /**
         * SpringApplication.run으로 인해 내장 WAS를 실행한다.
         * 이렇게 되면 별도로 외부에 WAS를 두지 않고 애프리케이션을 실행할 때
         * 내부에서 WAS를 실행하게 되므로, 항상 서버에 톰캣을 설치할 필요가 없게 되고,
         * 스프링 부트로 만들어진 Jar파일(실행 가능한 Java패키징 파일)로 실행하면 된다.
         * 스프링 부트에서는 내장 WAS를 사용하는 것을 권장하고 있다.
         * --> '언제 어디서나 같은 환경에서 스프링 부트를 배포'할 수 있기 때문이다.
         */
        SpringApplication.run(Application.class, args);
    }
}
