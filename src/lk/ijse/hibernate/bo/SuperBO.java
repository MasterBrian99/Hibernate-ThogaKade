package lk.ijse.hibernate.bo;

import lk.ijse.hibernate.dto.CustomerDTO;

import java.util.List;

public interface SuperBO<T,t>{
    public T find(String s) throws Exception;
    public long getCount() throws Exception;
    public List<T> findAll() throws Exception;
}
