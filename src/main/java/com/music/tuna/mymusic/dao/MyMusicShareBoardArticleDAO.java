package com.music.tuna.mymusic.dao;

import com.music.tuna.mymusic.vo.MyMusicShareBoardArticle;
import com.music.tuna.mymusic.vo.MyMusicShareBoardArticleListPage;
import com.music.tuna.util.SqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyMusicShareBoardArticleDAO {
    SqlSession sqlSession;
    public MyMusicShareBoardArticleDAO(){
        sqlSession =SqlSessionFactoryBean.getSqlSessionInstance();
    }
    public int insertArticle(MyMusicShareBoardArticle vo){
        return sqlSession.insert("MyMusicShareBoardArticleDAO.insertArticle", vo);
    }
    public int selectLastInsertedArticleNo(MyMusicShareBoardArticle vo){
        return sqlSession.selectOne("MyMusicShareBoardArticleDAO.selectLastInsertedArticleNo", vo);
    }
    public MyMusicShareBoardArticle selectArticleByArticleNo(MyMusicShareBoardArticle vo){
        return sqlSession.selectOne("MyMusicShareBoardArticleDAO.selectArticleByArticleNo", vo);
    }
    public List<MyMusicShareBoardArticle> selectList(MyMusicShareBoardArticleListPage vo){
        return sqlSession.selectList("MyMusicShareBoardArticleDAO.selectList", vo);
    }
    public int selectNext(MyMusicShareBoardArticle vo){
       return sqlSession.selectOne("MyMusicShareBoardArticleDAO.selectNext", vo);
    }
    public int selectPrev(MyMusicShareBoardArticle vo){
        return sqlSession.selectOne("MyMusicShareBoardArticleDAO.selectPrev", vo);
    }
    public int getCount(){
        return sqlSession.selectOne("MyMusicShareBoardArticleDAO.getCount");
    }
    public int getReadCount(MyMusicShareBoardArticle vo){ return sqlSession.selectOne("MyMusicShareBoardArticleDAO.getReadCount", vo); }
    public void getUpdateCount (MyMusicShareBoardArticle vo){ sqlSession.update("MyMusicShareBoardArticleDAO.updateReadCount", vo); }
    public void commit(){
        sqlSession.commit();
    }
}