package com.cm.dao;

import com.cm.model.Address;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/19 23:01
 */
public interface AddressDao {

    List<Address> listAddress(Integer id);

    int insertAddress(Address address);

    int deleteAddress(Integer id);

    int updateStatus(Integer id);

    int selectStatus(Integer id);

    Integer select(Integer id);

}
