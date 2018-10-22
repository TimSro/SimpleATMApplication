package de.tz.helloweb;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {
	
    @NotNull
    @NotEmpty
    private String firstName;
     
    @NotNull
    @NotEmpty
    private String lastName;
     
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
     
    @NotNull
    @NotEmpty
    private String email;

	public String getPassword() {
		return password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}
     
}
