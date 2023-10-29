package com.example.savis_intern_project.service.serviceimpl;

<<<<<<< HEAD
import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillDetail;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.repository.BillDetailRepository;
=======
import com.example.savis_intern_project.entity.*;
>>>>>>> master
import com.example.savis_intern_project.repository.BillRepository;
import com.example.savis_intern_project.repository.BillStatusRepository;
import com.example.savis_intern_project.repository.ProductResponsitory;
import com.example.savis_intern_project.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;
    @Autowired
    BillDetailRepository billDetailRepository;

    @Autowired
    BillStatusRepository billStatusRepository;

    @Override
    public Bill create_new_bill(Bill bill) {
       return billRepository.save(bill);
    }

    @Override
    public Bill update_bill(Bill bill) {
        Bill bill1 = billRepository.findById(bill.getId()).get();
            bill1.setReceiverName(bill.getReceiverName());
            bill1.setTotalMoney(bill.getTotalMoney());
            bill1.setCustomerPhone(bill.getCustomerPhone());
            bill1.setAddressDelivery(bill.getAddressDelivery());
            return billRepository.save(bill1);
    }

    @Override
    public List<Bill> get_all_bill() {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> get_all_byCusId(UUID cusId) {
        return billRepository.getAllByCustomerId(cusId);
    }

    @Override
    public List<Bill> get_all_by_Date(Date startDate, Date endDate) {
        return billRepository.getAllBillsInDateRange(startDate,endDate);
    }


    @Override
    public Bill get_one_bill(UUID billId) {
        return billRepository.findById(billId).get();
    }

    @Override
    public void change_bill_status(UUID billId) {
        Optional<Bill> optionalBill = billRepository.findById(billId);

//        if (optionalBill.isPresent()) {
//            Bill bill = optionalBill.get();
//            System.out.println(bill.getBillStatus().getName());
//            if (bill.getBillStatus().getId() ==  UUID.fromString("159b8bc3-5489-47c0-a115-b94a0cf6286f")) {
//                Optional<BillStatus> optionalBill2 = billStatusRepository.findById(UUID.fromString("159b8bc3-5489-47c0-a115-b94a0cf6286f"));
//                System.out.println(optionalBill2);
//                bill.setBillStatus(optionalBill2.get());
//            } else if (bill.getBillStatus().getId() == UUID.fromString("159b8bc3-5489-47c0-a115-b94a0cf6286f")) {
//                bill.setBillStatus(billStatusRepository.findById(UUID.fromString("159b8bc3-5489-47c0-a115-b94a0cf6286f")).get());
//            }
//            billRepository.save(bill);
//        } else {
//            // Xử lý trường hợp không tìm thấy hóa đơn
//            System.out.println("Hóa đơn không tồn tại với ID: " + billId);
//            // Hoặc bạn có thể ném ra một ngoại lệ hoặc thực hiện xử lý khác tùy ý.
//        }

    }

    @Override
    public void delete_bill(UUID billId) {
        billRepository.delete(billRepository.findById(billId).get());
    }
}
