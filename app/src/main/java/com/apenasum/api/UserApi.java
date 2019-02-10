package com.apenasum.api;

import com.apenasum.utils.Constants;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface UserApi {


    /**
     * @param l login
     * @param p password
     * @return
     */
    @FormUrlEncoded
    @POST(Constants.URL_LOGIN)
    Call<LoginResponse> login(@Field("email") String l,
                              @Field("password") String p);


    class LoginResponse {
        private boolean success;
        private String id;
        private String name;
        private String lastName;
        private String cpf;
        private String email;
        private String password;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


}
