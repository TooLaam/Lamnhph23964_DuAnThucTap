package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillStatus;
import com.example.savis_intern_project.repository.BillRepository;
import com.example.savis_intern_project.repository.BillStatusRepository;
import com.example.savis_intern_project.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    BillStatusRepository billStatusRepository;

    @Override
    public void create_new_bill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public List<Bill> get_all_bill() {
        return billRepository.findAll();
    }

    @Override
    public Bill get_one_bill(UUID billId) {
        return billRepository.findById(billId).get();
    }

    @Override
    public void change_bill_status(UUID billId) {
        Optional<Bill> optionalBill = billRepository.findById(billId);

        if (optionalBill.isPresent()) {
            Bill bill = optionalBill.get();
            System.out.println(bill.getBillStatus().getName());
            if (bill.getBillStatus().getId() == 1) {
                Optional<BillStatus> optionalBill2 = billStatusRepository.findById(2);
                System.out.println(optionalBill2);
                bill.setBillStatus(optionalBill2.get());
            } else if (bill.getBillStatus().getId() == 2) {
                bill.setBillStatus(billStatusRepository.findById(3).get());
            }
            billRepository.save(bill);
        } else {
            // Xử lý trường hợp không tìm thấy hóa đơn
            System.out.println("Hóa đơn không tồn tại với ID: " + billId);
            // Hoặc bạn có thể ném ra một ngoại lệ hoặc thực hiện xử lý khác tùy ý.
        }

    }

    @Override
    public void delete_bill(UUID billId) {
        billRepository.delete(billRepository.findById(billId).get());
    }
}
