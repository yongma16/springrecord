package dao;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    public JdbcTemplate jdbctemplate;

    @Override
    public void add(Book book) {
        String sql="insert into bookuser values(?,?,?)";//原生语句 添加数据 ?为参数的传输
        Object[] args={book.getUsername(),book.getUserpassword(),book.getId()};
        int update=jdbctemplate.update(sql,args);//成功返回1
        System.out.println(update);
    }

    @Override
    public void updatebook(Book book) {
        String sql="update bookuser set username=? where id=?";//原生语句 修改数据
        Object[] args={book.getUsername(),book.getId()};//只修改用户名
        int update=jdbctemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void deletebook(Book book) {
        String sql="delete from bookuser where id=?";//原生语句 更新数据
        Object[] args={book.getId()};
        int update=jdbctemplate.update(sql,args);
        System.out.println(update);
    }
}
