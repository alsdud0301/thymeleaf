package com.icia.board.dao;

import com.icia.board.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BoardDaoTest {
    @Autowired //junit테스트시 필드주입만 된다
    private BoardDao boardDao;

    @Test
    public void initTest() {
        assertNotNull(boardDao);
    }


    @Test
    void insertDummyDataTest(){
        BoardDto boardDto = new BoardDto();
        for(int i=1; i<=35;i++){
            boardDto.setB_title("제목"+i).setB_contents("무궁화꽃이 피었습니다")
                    .setB_writer("icia");
            boardDao.insertDummyData(boardDto);
        }
    }
    @Test
    public void findBoardList(){
        assertEquals(35,boardDao.getBoardList().size());
        boardDao.getBoardList().forEach(boardDto->{
            System.out.println(boardDto);
        });
    }
}
