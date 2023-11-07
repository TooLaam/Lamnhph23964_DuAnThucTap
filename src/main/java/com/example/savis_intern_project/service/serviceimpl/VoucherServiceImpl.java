package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.CategoryDetail;
import com.example.savis_intern_project.entity.Voucher;
import com.example.savis_intern_project.repository.VoucherRepository;
import com.example.savis_intern_project.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    VoucherRepository voucherRepository;

    @Override
    public void add(Voucher voucher) {
        voucherRepository.save(voucher);
    }

    @Override
    public void delete(UUID id) {
        voucherRepository.deleteById(id);
    }

    @Override
    public void update(UUID id, Voucher voucher) {
        Voucher voucherUpdate = getOne(id);
        voucherUpdate.setCode(voucher.getCode());
        voucherUpdate.setValue(voucher.getValue());
        voucherUpdate.setTimeStart(voucher.getTimeStart());
        voucherUpdate.setTimeEnd(voucher.getTimeEnd());
        voucherUpdate.setStatus(voucher.getStatus());
        voucherRepository.saveAndFlush(voucherUpdate);
    }

    @Override
    public List<Voucher> getAll() {
        return voucherRepository.findAll();
    }

    @Override
    public Voucher getByCode(String code) {
        return voucherRepository.findByVoucherCode(code);
    }

    @Override
    public Voucher getOne(UUID id) {
        return voucherRepository.findById(id).get();
    }
}
