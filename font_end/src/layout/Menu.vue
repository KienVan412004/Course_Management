<template>
  <div>
    <div>
      <div class="row">
        <div class="col-1" style="padding: 0">
          <div style="min-height: 720px; background-color: #ffffff">
            <div
              style="
                justify-content: center;
                display: flex;
                margin-bottom: 30px;
              "
            >
              <img src="/img/logo.jpg" alt="logo" width="80%" />
            </div>
            <div v-if="check == `STUDENT`">
              <a href="/point-student">
                <div style="justify-content: center; display: flex">
                  <div class="icon-menu">
                    <img src="/img/doashboard.png" alt="" width="50" />
                  </div>
                </div>
              </a>
              <p class="title-menu">Score</p>
            </div>
            <div v-if="check == `TEACHER`">
              <a href="/point">
                <div style="justify-content: center; display: flex">
                  <div class="icon-menu">
                    <img src="/img/doashboard.png" alt="" width="50" />
                  </div>
                </div>
              </a>
              <p class="title-menu">Score</p>
            </div>
            <div v-if="check == `ADMIN`">
              <div style="justify-content: center; display: flex">
                <a href="/account">
                  <div class="icon-menu">
                    <img
                      src="/img/lock-removebg-preview.png"
                      alt=""
                      width="80"
                    />
                  </div>
                </a>
              </div>
              <p class="title-menu">Account</p>
            </div>
            <div v-if="check == `ADMIN`">
              <div style="justify-content: center; display: flex">
                <a href="/course">
                  <div class="icon-menu">
                    <img
                      src="/img/course-removebg-preview.png"
                      alt=""
                      width="50"
                    />
                  </div>
                </a>
              </div>
              <p class="title-menu">Course</p>
            </div>
            <div v-if="check == `ADMIN`">
              <div style="justify-content: center; display: flex">
                <a href="/classes">
                  <div class="icon-menu">
                    <img src="/img/class.png" alt="" width="50" />
                  </div>
                </a>
              </div>
              <p class="title-menu">Classes</p>
            </div>
            <div v-if="check == `ADMIN`">
              <div style="justify-content: center; display: flex">
                <a href="/student">
                  <div class="icon-menu">
                    <img
                      src="/img/student-removebg-preview.png"
                      alt=""
                      width="50"
                    />
                  </div>
                </a>
              </div>
              <p class="title-menu">Student</p>
            </div>
            <div v-if="check == `ADMIN`">
              <div style="justify-content: center; display: flex">
                <a href="/teacher">
                  <div class="icon-menu">
                    <img
                      src="/img/teacher-removebg-preview.png"
                      alt=""
                      width="50"
                    />
                  </div>
                </a>
              </div>
              <p class="title-menu">Teacher</p>
            </div>
            <div v-if="check == `ADMIN`">
              <div style="justify-content: center; display: flex">
                <a href="/send-mail">
                  <div class="icon-menu">
                    <img
                      src="/img/teacher-removebg-preview.png"
                      alt=""
                      width="50"
                    />
                  </div>
                </a>
              </div>
              <p class="title-menu">Mail</p>
            </div>
            <div v-if="check == `ADMIN`">
              <div style="justify-content: center; display: flex">
                <a href="/account-mail">
                  <div class="icon-menu">
                    <img
                      src="/img/teacher-removebg-preview.png"
                      alt=""
                      width="50"
                    />
                  </div>
                </a>
              </div>
              <p class="title-menu">AccountMail</p>
            </div>

            <!-- <div class="title-menu">
              <div style="margin-bottom: 20px">
                <img src="/img/icons8-lock-24.png" alt="account" />
                <span class="title-name">Account</span>
              </div>
            </div>
            <div class="title-menu">
              <div style="margin-bottom: 20px">
                <img src="/img/icons8-course-24.png" alt="account" />
                <span class="title-name">Course</span>
              </div>
            </div>
            <div class="title-menu">
              <div style="margin-bottom: 20px">
                <img src="/img/icons8-student-30.png" alt="account" />
                <span class="title-name">Student</span>
              </div>
            </div>
            <div class="title-menu">
              <div style="margin-bottom: 20px">
                <img src="/img/icons8-teacher-24.png" alt="account" />
                <span class="title-name">Teacher</span>
              </div>
            </div> -->
          </div>
        </div>
        <div class="col-11" style="padding: 0">
          <!-- <nav class="navbar" style="background-color: white"></nav> -->
          <div
            class="container-fluid"
            style="background-color: white; height: 80px"
          >
            <div class="row">
              <div class="col-4">
                <input
                  type="text"
                  id="inputPassword5"
                  class="form-control"
                  aria-describedby="passwordHelpBlock"
                  style="
                    width: 100%;
                    background-color: #f3fbff;
                    border-radius: 20px;
                    height: 40px;
                    margin-top: 20px;
                  "
                  placeholder="Tìm kiếm ..."
                />
              </div>
              <div class="col-4"></div>
              <div
                class="col-4"
                style="
                  display: flex;
                  justify-content: flex-end;
                  margin-top: 20px;
                "
              >
                <img
                  src="/img/icons8-bell-50.png"
                  alt="notififcation"
                  style="width: 40px; height: 40px; margin-left: 10px"
                />
                <img
                  src="/img/icons8-user-50 (1).png"
                  alt="user"
                  style="width: 40px; height: 40px; margin-left: 10px"
                />
                <img
                  @click="logOut"
                  src="/img/icons8-log-out-64 (1).png"
                  alt="logout"
                  style="
                    width: 40px;
                    height: 40px;
                    margin-right: 70px;
                    margin-left: 10px;
                  "
                />
              </div>
            </div>
          </div>

          <div style="background-color: #f7f7f9; min-height: 640px">
            <slot />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { watchEffect, ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";

const router = useRouter();
const checkRole = ref("");
const check = localStorage.getItem("role");
console.log(checkRole);

const logOut = () => {
  localStorage.removeItem("userName");
  localStorage.removeItem("password");
  localStorage.removeItem("role");
  router.push("/login");
};
</script>
<style scoped>
/* .title-menu {
  padding-left: 40px;
  padding-right: 40px;
  margin-top: 40px;
  display: flex;
  justify-content: center;
  border-bottom: 1px solid black;
}
.title-name {
  font-size: 20px;
  font-weight: 600;
  margin-left: 30px;
} */
.icon-menu {
  width: 60px;
  height: 60px;
  border-radius: 15px;
  background-color: #f5f8fa;
  justify-content: center;
  display: flex;
  align-items: center;
}
.title-menu {
  text-align: center;
  font-size: 15px;
  font-weight: 700;
}
</style>
