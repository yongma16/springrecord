package service;

import dao.BookDao;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//自动注解把类名的首字母小写
public class BookService {
    @Autowired
    private BookDao bookdao;
    public void addBook(Book book)
    {
        bookdao.add(book);//添加
    }
    public void updateBook(Book book)
    {
        bookdao.updatebook(book);//更新
    }
    public void deleteBook(Book book)
    {
        bookdao.deletebook(book);//删除
    }

}
