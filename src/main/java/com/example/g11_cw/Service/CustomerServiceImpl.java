package com.example.g11_cw.Service;

import com.example.g11_cw.Entity.Customer;
import com.example.g11_cw.Mapper.CustomerMapper;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Service.Interface.CustomerService;
import com.example.g11_cw.Utils.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired(required = false)
    private CustomerMapper customerMapper;

    @Override
    public Customer getCustomerByEmail(String cuemail) {
        return customerMapper.getCustomerByEmail(cuemail);
    }

    @Override
    public int addCustomer(Customer customer) {
        Customer cu = customerMapper.getCustomerByEmail(customer.getCuemail());
        if (cu == null) {
            int flag = customerMapper.addCustomer(customer);
            return flag;
        }
        else {
            return 0;
        }

    }

    @Override
    public List<Customer> getAllCustomer(QueryInfo queryInfo) {
        List<Customer> allUser = customerMapper.getAllCustomer();
        List<Customer> res = (List<Customer>) PagingUtil.pagingData(allUser, queryInfo.getPageSize(), queryInfo.getPageNum());
        return res;
    }

    @Override
    public String customerLogin(Customer customer) {
        Customer userByEmail = customerMapper.getCustomerByEmail(customer.getCuemail());
        if (userByEmail!=null) {
            if (customer.getCupassword().equals(userByEmail.getCupassword())){
                //正确
                return "200";
            } else {
                return "201";
            }
        }else {
            return "202";//没有此账号
        }
    }

    @Override
    public int updateCustomerInfo(Customer customer) {
        return customerMapper.updateCustomerInfo(customer);
    }

    @Override
    public int setCustomerDescription(int cuid, String cudescription) {
        return customerMapper.setCustomerDescription(cuid,cudescription);
    }
}
