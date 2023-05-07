package com.practicas.pmdm.listviewandroid.dao;

import java.util.List;

public interface PojoDao {

    public long add(Object obj);

    public int update(Object obj);

    public void delete(Object obj);

    public Object search(Object obj);

    public List getAll();

}
