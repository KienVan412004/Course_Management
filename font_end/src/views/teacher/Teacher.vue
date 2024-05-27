<template>
  <Menu>
    <div class="account">
      <div class="container" style="padding-top: 40px">
        <div
          style="height: 200px; background-color: white; border-radius: 20px"
        >
          <p style="font-size: 25px; font-weight: bold; padding: 15px">
            <img src="/img/pen2.png" alt="" width="50px" /> Quản lý giảng viên
          </p>
          <hr />
          <div class="container">
            <div class="row">
              <div class="col-6">
                <input
                  type="text"
                  id="inputPassword5"
                  class="form-control"
                  aria-describedby="passwordHelpBlock"
                  style="width: 70%; border-radius: 20px; height: 40px"
                  placeholder="Tìm kiếm ..."
                />
              </div>
              <div class="col-2">
                <input
                  type="date"
                  id="inputPassword5"
                  class="form-control"
                  aria-describedby="passwordHelpBlock"
                  style="width: 100%; border-radius: 20px; height: 40px"
                  placeholder="Tìm kiếm ..."
                />
              </div>
              <div class="col-2">
                <input
                  type="date"
                  id="inputPassword5"
                  class="form-control"
                  aria-describedby="passwordHelpBlock"
                  style="width: 100%; border-radius: 20px; height: 40px"
                  placeholder="Tìm kiếm ..."
                />
              </div>
              <div class="col-2">
                <button
                  type="button"
                  class="btn btn-primary"
                  data-bs-toggle="modal"
                  data-bs-target="#exampleModal"
                  style="
                    width: 140px;
                    height: 45px;
                    border-radius: 10px;
                    background-color: #ffa726;
                    border: none;
                    font-weight: 700;
                    margin-right: 20px;
                  "
                >
                  Thêm mới
                </button>
              </div>
            </div>
          </div>
        </div>
        <div class="list-student">
          <div class="container">
            <div class="row">
              <div class="col-3" v-for="item in getAllTeacher" :key="item.id">
                <div
                  class="student-course"
                  data-bs-toggle="modal"
                  data-bs-target="#staticBackdrop"
                  @click="handleDetailTeacher(item.id)"
                >
                  <div class="avata-student">
                    <img src="/img/teacher.png" alt="" />
                  </div>

                  <span style="font-weight: 600; padding: 5px">
                    {{ item.fullName }}
                  </span>
                  <router-link :to="`/detail-class-teacher/${item.id}`">
                    <div class="detail-teacher" @click.stop>
                      <img src="/img/icons8-setting-24.png" alt="" />
                    </div>
                  </router-link>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!-- Modal add-->
        <div
          class="modal fade"
          id="exampleModal"
          tabindex="-1"
          aria-labelledby="exampleModalLabel"
          aria-hidden="true"
        >
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <p style="font-size: 25px; font-weight: bold; padding: 15px">
                  <img src="/img/pen2.png" alt="" width="40px" /> Thêm mới giảng
                  viên
                </p>
              </div>
              <div class="modal-body">
                <div class="container">
                  <div class="row">
                    <div class="col-12">
                      <p style="font-weight: bold; margin-top: 20px">
                        Họ và tên <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="addTeachers.fullName"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Số điện thoại <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="addTeachers.phoneNumber"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Email <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="addTeachers.email"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Giới tính <span style="color: red">*</span>
                      </p>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          name="inlineRadioOptions"
                          id="inlineRadio1"
                          value="1"
                          v-model="addTeachers.gender"
                        />
                        <label class="form-check-label" for="inlineRadio1"
                          >Nam</label
                        >
                      </div>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          name="inlineRadioOptions"
                          id="inlineRadio2"
                          value="0"
                          v-model="addTeachers.gender"
                        />
                        <label class="form-check-label" for="inlineRadio2"
                          >Nữ</label
                        >
                      </div>
                      <!-- ------------------------------------- -->
                    </div>
                  </div>
                </div>
              </div>
              <div class="modal-footer">
                <button
                  type="button"
                  class="btn btn-secondary"
                  data-bs-dismiss="modal"
                  style="
                    width: 130px;
                    border-radius: 10px;
                    background-color: #f3f6f9;
                    border: none;
                    color: black;
                  "
                >
                  Hủy
                </button>
                <button
                  type="button"
                  class="btn btn-primary"
                  style="
                    width: 130px;
                    border-radius: 10px;
                    background-color: #ffa726;
                    border: none;
                    color: black;
                  "
                  @click="handleAddTeacher"
                >
                  Xác nhận
                </button>
              </div>
            </div>
          </div>
        </div>

        <!-- Modal update-->
        <div
          class="modal fade"
          id="staticBackdrop"
          data-bs-backdrop="static"
          data-bs-keyboard="false"
          tabindex="-1"
          aria-labelledby="staticBackdropLabel"
          aria-hidden="true"
        >
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <p style="font-size: 25px; font-weight: bold; padding: 15px">
                  <img src="/img/pen2.png" alt="" width="40px" /> Thông tin
                  giảng viên
                </p>
              </div>
              <div class="modal-body">
                <div class="container">
                  <div class="row">
                    <div class="col-12">
                      <p style="font-weight: bold; margin-top: 20px">
                        Họ và tên <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="updateTeachers.fullName"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Số điện thoại <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="updateTeachers.phoneNumber"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Email <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="updateTeachers.email"
                      />
                      <!-- ------------------------------------- -->
                      <div class="row">
                        <div class="col-6">
                          <p style="font-weight: bold; margin-top: 20px">
                            Giới tính <span style="color: red">*</span>
                          </p>
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="radio"
                              name="inlineRadioOptions"
                              id="inlineRadio1"
                              value="1"
                              v-model="updateTeachers.gender"
                            />
                            <label class="form-check-label" for="inlineRadio1"
                              >Nam</label
                            >
                          </div>
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="radio"
                              name="inlineRadioOptions"
                              id="inlineRadio2"
                              value="0"
                              v-model="updateTeachers.gender"
                            />
                            <label class="form-check-label" for="inlineRadio2"
                              >Nữ</label
                            >
                          </div>
                        </div>
                        <div class="col-6">
                          <p style="font-weight: bold; margin-top: 20px">
                            Số lớp đang dạy <span style="color: red">*</span>
                          </p>
                          <input
                            type="text"
                            class="form-control"
                            id="exampleFormControlInput1"
                            value="0"
                            v-model="updateTeachers.soLop"
                          />
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="modal-footer">
                <button
                  type="button"
                  class="btn btn-secondary"
                  data-bs-dismiss="modal"
                  style="
                    width: 130px;
                    border-radius: 10px;
                    background-color: #f3f6f9;
                    border: none;
                    color: black;
                    font-weight: 600;
                  "
                >
                  Hủy
                </button>
                <button
                  type="button"
                  class="btn btn-primary"
                  style="
                    width: 130px;
                    border-radius: 10px;
                    background-color: #ffa726;
                    border: none;
                    color: white;
                    font-weight: 600;
                  "
                  @click="handleUpdateTeacher(detailTeachers.id)"
                >
                  Cập nhật
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </Menu>
</template>
<script setup lang="ts">
import TeacherApi from "@/api/TeacherApi";
import type Teacher from "@/types/Teacher";
import Vue, { ref, watchEffect } from "vue";
const getAllTeacher = ref<Teacher[]>([]);
const detailTeachers = ref<Teacher>();
import Menu from "../../layout/Menu.vue";

const addTeachers = ref<Teacher>({
  id: "",
  fullName: "",
  email: "",
  gender: 0,
  phoneNumber: "",
});

const updateTeachers = ref<Teacher>({
  id: "",
  fullName: "",
  email: "",
  gender: 0,
  phoneNumber: "",
});

const handleUpdateTeacher = (id: string) => {
  TeacherApi.updateTeacher(updateTeachers.value, id).then(() => {
    fetchData();
  });
};

const handleDetailTeacher = (id: string) => {
  TeacherApi.getOne(id).then((response) => {
    detailTeachers.value = response.data;
    updateTeachers.value = { ...response.data };
  });
};

const handleAddTeacher = () => {
  TeacherApi.addTeacher(addTeachers.value).then((response) => {
    fetchData();
  });
};

const fetchData = () => {
  TeacherApi.getAll().then((response) => {
    getAllTeacher.value = response.data;
  });
};

watchEffect(() => {
  fetchData();
  handleDetailTeacher(detailTeachers.value);
});
</script>
<style scoped>
.detail-teacher {
  float: right;
  margin-right: -50px;
  margin-left: 30px;
  margin-bottom: 30px;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: rgb(109, 109, 255);
  display: flex;
  align-items: center;
  justify-content: center;
}
.avata-student {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #ffd75e;
  display: flex;
  align-items: center;
  justify-content: center;
}
.student-course {
  height: 50px;
  margin-bottom: 30px;
  border: 1px solid #ffd75e;
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 30px;
}
.list-student {
  background-color: white;
  min-height: 390px;
  margin-top: 10px;
  border-radius: 25px;
  overflow-y: scroll;
  max-height: 300px;
}
</style>
