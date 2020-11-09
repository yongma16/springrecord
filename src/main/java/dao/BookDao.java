package dao;

import entity.Book;

public interface BookDao {
    public  void add(Book book);//添加book表数据
    public void updatebook(Book book);//修改表数据
    public void deletebook(Book book);//删除数据
}
