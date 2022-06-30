package yfj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import yfj.model.Book;
import yfj.util.StringUtil;

public class BookDao {
	
	
	/**
	 * 判断图书类别下面是否有图书
	 * @param con
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	public boolean existBookByBookType(Connection con,String typeId) throws Exception{
		String sql = "select * from t_book where bookTypeId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,typeId );
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
	
	/**
	 * 图书信息添加Dao
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception 
	 */
	public int add(Connection con,Book book) throws Exception{
		String sql = "insert into t_book values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setInt(7, book.getBookCount());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 遍历图书遍历
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception 
	 */
	public ResultSet list(Connection con,Book book) throws Exception{
		//select * from t_book b,t_booktype bt where b.bookTypeId = bt.id;
		StringBuffer sb = new StringBuffer(" select * from t_book b,t_booktype bt where b.bookTypeId=bt.id ");
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" and b.bookName like '%"+ book.getBookName() +"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and b.author like '%"+ book.getAuthor() +"%'");
		}
		if(book.getBookTypeId() != null ){
			sb.append(" and b.bookTypeId = " + book.getBookTypeId());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		System.out.println("sql"+sb.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id) throws Exception{
		String sql = " delete from t_book where id=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	
	/**
	 * 图书信息修改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book) throws Exception{
		String sql = "update t_book set bookName=?,author=?,sex=?,price=?,bookTypeId=?,bookDesc=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}

	/**
	 * 借阅数量修改
	 * @param con
	 * @param id
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public int updateCount(Connection con,Integer id,Integer count) throws Exception{
		String sql = "update t_book set bookCount = bookCount - ? where id = ?";
		System.out.println(sql);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setInt(2, id);
		return pstmt.executeUpdate();
	}


	/**
	 * 借阅数量修改
	 * @param con
	 * @param id
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public int deleteCount(Connection con,Integer id,Integer count) throws Exception{
		String sql = "update t_book set bookCount = bookCount + ? where id = ?";
		System.out.println(sql);
		System.out.println(count);
		System.out.println(id);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setInt(2, id);
		return pstmt.executeUpdate();
	}
}
