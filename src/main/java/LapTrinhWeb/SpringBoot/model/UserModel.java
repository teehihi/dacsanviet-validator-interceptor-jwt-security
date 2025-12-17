package LapTrinhWeb.SpringBoot.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	@NotEmpty(message = "Username không được để trống")
	private String username;
	
	@NotEmpty(message = "Password không được để trống")
	@Size(min = 6, message = "Password phải có ít nhất 6 ký tự")
	private String password;
	
	private String phone;
	
	@NotEmpty(message = "Họ và tên không được để trống")
	private String fullname;
	
	@Email(message = "Email không hợp lệ")
	@NotEmpty(message = "Email không được để trống")
	private String email;
	
	private Boolean admin = false;
	private Boolean active = true;
	private String images;
	private Boolean isEdit = false;
}
