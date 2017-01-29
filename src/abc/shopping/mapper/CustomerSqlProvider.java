package abc.shopping.mapper;

import org.apache.ibatis.jdbc.SQL;

import abc.shopping.dto.Customer;

public class CustomerSqlProvider {
	public String find(final Customer customer){
		return new SQL(){
			{
				SELECT(" * ");
				FROM("customer");
				
				if(customer.getName() != null && customer.getName() !=""){
					WHERE("name like #{name}");
				}
				if(customer.getAddress() != null && customer.getAddress() !=""){
					WHERE("address like #{address}");
				}
				if(customer.getEmail() != null && customer.getEmail() !=""){
					WHERE("email like #{email}");
				}
			}
		}.toString();
	}
}
