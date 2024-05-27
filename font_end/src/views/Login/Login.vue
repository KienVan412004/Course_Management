<template>
  <div class="container-fluid">
    <div class="row no-gutter">
      <div class="col-md-6 d-none d-md-flex bg-image"></div>

      <div class="col-md-6 bg-light">
        <div class="login d-flex align-items-center py-5">
          <div class="container">
            <div class="row">
              <div class="col-lg-10 col-xl-7 mx-auto">
                <p
                  class="text-muted mb-4"
                  style="font-size: 30px; color: green; font-weight: bold"
                >
                  Newwave Solution
                </p>
                <form @submit.prevent="handleLogin">
                  <div class="mb-3">
                    <input
                      id="inputEmail"
                      type="email"
                      placeholder="Email address"
                      class="form-control rounded-pill border-0 shadow-sm px-4"
                      v-model="userName"
                    />
                  </div>
                  <div class="mb-3">
                    <input
                      id="inputPassword"
                      type="password"
                      placeholder="Password"
                      class="form-control rounded-pill border-0 shadow-sm px-4 text-primary"
                      v-model="password"
                    />
                  </div>
                  <div class="form-check">
                    <input
                      id="customCheck1"
                      type="checkbox"
                      checked
                      class="form-check-input"
                    />
                    <label for="customCheck1" class="form-check-label"
                      >Remember password</label
                    >
                  </div>
                  <div class="d-grid gap-2 mt-2">
                    <button
                      type="submit"
                      class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm"
                    >
                      Sign in
                    </button>
                  </div>
                </form>
                <div class="text-center d-flex justify-content-between mt-4">
                  <p>
                    Code by
                    <a
                      href="https://therichpost.com/"
                      class="font-italic text-muted"
                    >
                      <u>Jassa</u></a
                    >
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import LoginApi from "@/api/Login";
import Vue, { ref } from "vue";
import { useRouter } from "vue-router";
import { log } from "util";
const userName = ref("");
const password = ref("");
const roles = ref("");
const router = useRouter();

const handleLogin = () => {
  const userNameValue = userName.value;
  const passwordValue = password.value;

  // Xóa các thông tin cũ trong localStorage
  localStorage.removeItem("userName");
  localStorage.removeItem("password");
  localStorage.removeItem("role");

  // Gọi API để đăng nhập
  LoginApi.login(userNameValue, passwordValue)
    .then((response) => {
      // Xác định vai trò từ phản hồi
      const userRole = response.data.role;

      // Lưu thông tin đăng nhập vào localStorage
      if (response.status == 200) {
        localStorage.setItem("role", userRole);
        localStorage.setItem("userName", userNameValue);
        localStorage.setItem("password", passwordValue);

        // Chuyển hướng người dùng đến trang khóa học
        router.push("/");
      }
    })
    .catch((error) => {
      // Xử lý lỗi nếu có
      console.error("Login failed:", error);
    });
};
</script>

<style scoped>
.login,
.image {
  min-height: 100vh;
}
.bg-image {
  background-image: url("https://therichpost.com/wp-content/uploads/2021/02/login-split.jpg");
  background-size: cover;
  background-position: center center;
}
</style>
y
