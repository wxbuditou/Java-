package cn.it.cast.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.it.cast.Dao.AdminDao;
import cn.it.cast.Dao.StudentDao;
import cn.it.cast.Dao.TeacherDao;
import cn.it.cast.domain.Admin;
import cn.it.cast.function.Comment;
import cn.it.cast.function.Document;
import cn.it.cast.function.Message;
import cn.it.cast.function.News;
import cn.it.cast.function.Video;
import cn.it.cast.utils.PageModel;

public class AdminService {

	public PageModel findNewsWithPage(int num) throws SQLException {
		int currentPagenum = num;
		int pageSize = 5;
		AdminDao adminDao = new AdminDao();
		int totalRecord = adminDao.getNewsNumber();
		List<News> list = adminDao.getNewsObject(5*(num-1),5);
		System.out.println("list length is" + list.size());
		PageModel pModel = new PageModel(currentPagenum, pageSize, totalRecord);
		pModel.setList(list);
		//前台通过url构造对象
		pModel.setUrl("Admin/AdminServlet?method=scan_news");//设置url，通过pagemodel的属性构造url
		return pModel;
	}

	public PageModel findVideoWithPage(int num) throws SQLException {
		int currentPagenum = num;
		int pageSize = 5;
		AdminDao adminDao = new AdminDao();
		int totalRecord = adminDao.getVideoNumber();
		List<Video> list = adminDao.getVideoObject(5*(num-1),5);
		PageModel pModel = new PageModel(currentPagenum, pageSize, totalRecord);
		pModel.setList(list);
		pModel.setUrl("/Admin/AdminServlet?method=scan_video");
		return pModel;
	}

	public PageModel findDocumentWithPage(int num) throws SQLException {
		int currentPagenum = num;
		int pageSize = 5;
		AdminDao adminDao = new AdminDao();
		int totalRecord = adminDao.getDocumentNumber();
		List<Document> list = adminDao.getDocumentObject(5*(num-1),5);
		PageModel pModel = new PageModel(currentPagenum, pageSize, totalRecord);
		pModel.setList(list);
		pModel.setUrl("/Admin/AdminServlet?method=scan_document");
		return pModel;
	}

	public News show_news(String news_id) throws SQLException {
		AdminDao adminDao = new AdminDao();
		return adminDao.show_news(news_id);
	}
	
	public void delete_news(String news_id) throws SQLException {
		AdminDao adminDao = new AdminDao();
		adminDao.delete_news(news_id);
	}

	public void publish_news(String number, String topic, String content, int character,String name) throws SQLException {
		AdminDao adminDao = new AdminDao();
		adminDao.publish_news(number, topic, content, character,name);
	}

	public void publish_video(Map<String, String> map) throws SQLException {
		AdminDao adminDao = new AdminDao();
		adminDao.publish_video(map);;
	}

	public Video show_video(String video_id) throws SQLException {
		AdminDao adminDao = new AdminDao();
		return adminDao.show_video(video_id);
	}

	public void publish_document(Map<String, String> map) throws SQLException {
		AdminDao adminDao = new AdminDao();
		adminDao.publish_document(map);
		
	}

	public Document download_document(String document_id) throws SQLException {
		AdminDao adminDao = new AdminDao();
		return adminDao.download_document(document_id);
	}

	public void delete_video(String video_id) throws SQLException {
		AdminDao adminDao = new AdminDao();
		adminDao.delete_video(video_id);
		
	}

	public void delete_document(String document_id) throws SQLException {
		AdminDao adminDao  = new AdminDao();
		adminDao.delete_document(document_id);
		
	}

	public PageModel findMessageWithPage(int num) throws SQLException {
		int currentPagenum = num;
		int pageSize = 5;
		AdminDao adminDao = new AdminDao();
		int totalRecord = adminDao.getMessageNumber();
		List<Message> list = adminDao.getMessageObject(5*(num-1),5);
		PageModel pModel = new PageModel(currentPagenum, pageSize, totalRecord);
		pModel.setList(list);
		pModel.setUrl("/Admin/AdminServlet?method=scan_Message");
		return pModel;
	}

	public Message show_message(String message_id) throws SQLException {
		AdminDao adminDao = new AdminDao();
		return adminDao.show_message(message_id);
	}

	public List<Comment> getCommentByid(String message_id) throws SQLException {
		AdminDao adminDao = new AdminDao();
		return adminDao.getCommentByid(message_id);
	}

	public void publish_comment(String comment_username, String comment_usernumber, String comment_content,
			String comment_messageid, int comment_character) throws SQLException {
		AdminDao adminDao = new AdminDao();
		adminDao.publish_comment(comment_username, comment_usernumber, comment_content, comment_messageid, comment_character);
	}

	public void delete_message(String message_id) throws SQLException {
		AdminDao adminDao = new AdminDao();
		adminDao.delete_message(message_id);
	}

}
