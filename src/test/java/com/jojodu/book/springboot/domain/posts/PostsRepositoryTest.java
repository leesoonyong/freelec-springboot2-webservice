package com.jojodu.book.springboot.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

//    @After
//    public void cleanup(){
//        postsRepository.deleteAll();
//    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트게시글";
        String content = "테스트본문";
        postsRepository.save(Posts.builder()
                            .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build()) ;
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2022,6,3,0,0,0);
        postsRepository.save(
                Posts.builder()
                        .title("제목")
                        .content("내용")
                        .author("글쓴이")
                        .build()
        );
        //when
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreateDate() + ", modifiedDate=" + posts.getModifiedDate());

        Assertions.assertThat(posts.getCreateDate()).isAfter(now);
        Assertions.assertThat(posts.getModifiedDate()).isAfter(now);
    }





}
