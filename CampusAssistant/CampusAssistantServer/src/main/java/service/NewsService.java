package service;

import entity.News;

import java.util.List;

public interface NewsService {

    public int saveNews(final News news);

    public List<News> queryAllNews();

    public List<News> queryByPage(int pagenum, int num, int newstype);

    public List<News> queryNextNews(int newsid, int newstype);

    public List<News> queryNewsByType(String newstype);

    public News getNewsById(int newsid);
}
