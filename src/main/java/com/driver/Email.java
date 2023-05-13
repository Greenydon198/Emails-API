package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(password.equals(oldPassword)){
            int flag[] = new int[5];
            flag[0] = newPassword.length()>=8 ? 1 : 0;
            for(int i=0;i<newPassword.length();i++){
                char t = newPassword.charAt(i);
                if(t>='A'&&t<='Z')flag[1]++;
                else if(t>='a' && t<='z')flag[2]++;
                else if(t>='0' && t<='9')flag[3]++;
                else flag[4]++;
            }
            for(int i=0;i<5;i++){
                if(flag[i]==0)return;
            }
            password = newPassword;
        }
    }
}
