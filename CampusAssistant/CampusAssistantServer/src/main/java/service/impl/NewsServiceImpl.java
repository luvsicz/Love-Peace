package service.impl;

import entity.News;
import service.NewsService;

import java.util.List;


public class NewsServiceImpl implements NewsService {

	/**
	 * 录入新闻
	 *
	 * @param news
	 * @return
	 */
	@Override
	public int saveNews(News news) {
		return 0;
	}

	/**
	 * 获取所有新闻
	 *
	 * @return
	 */
	@Override
	public List<News> queryAllNews() {
		return null;
	}

	/**
	 * @param pagenum 查询页序号
	 * @param num     每页条数
	 * @return
	 * @paranm ewstype 新闻类型
	 */
	@Override
	public List<News> queryByPage(int pagenum, int num, int newstype) {
		return null;
	}

	/**
	 * 下一页
	 *
	 * @param newsid
	 * @param newstype
	 * @return
	 */
	@Override
	public List<News> queryNextNews(int newsid, int newstype) {
		return null;
	}

	@Override
	public List<News> queryNewsByType(String newstype) {
		return null;
	}

	@Override
	public News getNewsById(int newsid) {
		return null;
	}
}
