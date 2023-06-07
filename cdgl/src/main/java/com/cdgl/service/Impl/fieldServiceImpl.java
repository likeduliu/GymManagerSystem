package com.cdgl.service.Impl;

import com.cdgl.mapper.fieldMapper;
import com.cdgl.mapper.fieldNoticeMapper;
import com.cdgl.pojo.field;
import com.cdgl.pojo.fieldnotice;
import com.cdgl.pojo.reservations;
import com.cdgl.service.fieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class fieldServiceImpl implements fieldService {
    @Autowired
    private fieldMapper fieldmapper;
    @Autowired
    private fieldNoticeMapper fieldNoticemapper;

    @Override
    public List<field> findAll() {
        return fieldmapper.findAll();
    }

    @Override
    public List<reservations> unbook1() {
        return fieldmapper.unbook1();
    }

    @Override
    public List<field> booked() {
        return fieldmapper.booked();
    }

    @Override
    public List<reservations> unbook2(Integer fieldid) {
        return fieldmapper.unbook2(fieldid);
    }

    @Override
    public void DelField(Integer fieldid) {
        fieldmapper.DelField(fieldid);
    }

    @Override
    public void UpdateFieldId(Integer fieldid) {
        fieldmapper.UpdateFieldId(fieldid);
    }

    @Override
    public void AddField(field field) {
        fieldmapper.AddField(field);
    }

    @Override
    public void BookField(reservations reservation) {
        fieldmapper.BookField(reservation);
    }

    @Override
    public void BookField1(reservations reservation) {
        fieldmapper.BookField1(reservation);
    }

    @Override
    public List<reservations> FieldBookCheck(reservations reservations) {
        return fieldmapper.FieldBookCheck(reservations);
    }

    @Override
    public List<reservations> FieldBookCheckTime(reservations reservations) {
        return fieldmapper.FieldBookCheckTime(reservations);
    }

    @Override
    public List<reservations> FieldBookCheckDate(reservations reservations) {
        return fieldmapper.FieldBookCheckDate(reservations);
    }

    @Override
    public void CancleBook(Integer reservation_id) {
        fieldmapper.CancleBook(reservation_id);
    }

    @Override
    public List<fieldnotice> findAllNotice() {
        return fieldNoticemapper.findAllNotice();
    }

    @Override
    public fieldnotice fefieldnotice(Integer fieldnoticeid) {
        return fieldNoticemapper.fefieldnotice(fieldnoticeid);
    }

    @Override
    public void updateFieldNotice(fieldnotice fieldnotice) {
        fieldNoticemapper.updateFieldNotice(fieldnotice);
    }

    @Override
    public void deleteFieldNotice(Integer fieldnoticeid) {
        fieldNoticemapper.deleteFieldNotice(fieldnoticeid);
    }

    @Override
    public void addFieldNotice(fieldnotice fieldnotice) {
        fieldNoticemapper.addFieldNotice(fieldnotice);
    }
    @Override
    public void canlbookbydel(Integer fieldid){
        fieldmapper.canlbookbydel(fieldid);
    }

//

}
