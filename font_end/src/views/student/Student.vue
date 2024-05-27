<template>
  <Menu>
    <div class="account">
      <div class="container" style="padding-top: 40px">
        <div
          style="height: 200px; background-color: white; border-radius: 20px"
        >
          <p style="font-size: 25px; font-weight: bold; padding: 15px">
            <img src="/img/pen2.png" alt="" width="50px" /> Quản lý sinh viên
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
                  style="
                    width: 70%;

                    border-radius: 20px;
                    height: 40px;
                  "
                  placeholder="Tìm kiếm ..."
                  v-model="searchStudent"
                />
                <button
                  type="button"
                  class="btn btn-primary"
                  style="
                    width: 100px;
                    height: 45px;
                    border-radius: 10px;
                    background-color: #ffa726;
                    border: none;
                    font-weight: 700;
                    margin-left: 20px;
                  "
                  @click="searchByCode()"
                >
                  Tìm kiếm
                </button>
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
                    width: 50px;
                    height: 45px;
                    border-radius: 10px;
                    background-color: #ffa726;
                    border: none;
                    font-weight: 700;
                    margin-right: 20px;
                  "
                >
                  <img src="/img/plus_icon.png" alt="" />
                </button>
                <button
                  type="button"
                  class="btn btn-primary"
                  style="
                    width: 50px;
                    height: 45px;
                    border-radius: 10px;
                    background-color: #ffa726;
                    border: none;
                    font-weight: 700;
                  "
                >
                  <img src="/img/import.png" alt="" />
                </button>
              </div>
            </div>
          </div>
        </div>
        <div class="list-student">
          <div class="container">
            <div class="row">
              <div class="col-3" v-for="item in getStudent" :key="item.id">
                <div
                  class="student-course"
                  data-bs-toggle="modal"
                  data-bs-target="#staticBackdrop"
                  @click="handleGetOneStudent(item.id)"
                >
                  <div class="avata-student">
                    <img src="/img/icons8-user-24.png" alt="" />
                  </div>
                  <span style="font-weight: 600; padding: 5px">
                    {{ item.fullName }} - {{ item.code }}</span
                  >
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
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-header">
                <p style="font-size: 25px; font-weight: bold; padding: 15px">
                  <img src="/img/pen2.png" alt="" width="40px" /> Thêm mới sinh
                  viên
                </p>
              </div>
              <div class="modal-body">
                <div class="container">
                  <div class="row">
                    <div class="col-6">
                      <p style="font-weight: bold; margin-top: 20px">
                        Họ và tên <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="addStudent.fullName"
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
                        v-model="addStudent.phoneNumber"
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
                        v-model="addStudent.email"
                      />
                      <!-- ------------------------------------- -->
                    </div>

                    <div class="col-6">
                      <p style="font-weight: bold; margin-top: 20px">
                        Địa chỉ <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="addStudent.address"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Ngày sinh <span style="color: red">*</span>
                      </p>
                      <input
                        type="date"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="addStudent.dateOfBirth"
                      />
                      <p style="font-weight: bold; margin-top: 20px">
                        Khóa học <span style="color: red">*</span>
                      </p>
                      <select
                        class="form-select"
                        aria-label="Default select example"
                        v-model="selectedCourseId"
                        @change="handleSelectedCourse"
                      >
                        <option
                          selected
                          v-for="item in getAllCourse"
                          :key="item.id"
                          :value="item.id"
                        >
                          {{ item.name }}
                        </option>
                      </select>
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
                  @click="handleAddStudent"
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
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-header">
                <p style="font-size: 25px; font-weight: bold; padding: 15px">
                  <img src="/img/pen2.png" alt="" width="40px" /> Thông tin sinh
                  viên
                </p>
              </div>
              <div class="modal-body">
                <div class="container">
                  <div class="row">
                    <div class="col-6">
                      <p style="font-weight: bold; margin-top: 20px">
                        Họ và tên <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="updateStudents.fullName"
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
                        v-model="updateStudents.phoneNumber"
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
                        v-model="updateStudents.email"
                      />
                      <!-- ------------------------------------- -->
                    </div>

                    <div class="col-6">
                      <p style="font-weight: bold; margin-top: 20px">
                        Địa chỉ <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="updateStudents.address"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Ngày sinh <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Họ và tên"
                        v-model="updateStudents.dateOfBirth"
                      />
                      <p style="font-weight: bold; margin-top: 20px">
                        Khóa học <span style="color: red">*</span>
                      </p>
                      <select
                        class="form-select"
                        aria-label="Default select example"
                        v-model="selectedCourseId"
                        @change="handleSelectedCourseUpdate"
                      >
                        <option
                          selected
                          v-for="item in getAllCourse"
                          :key="item.id"
                          :value="item.id"
                        >
                          {{ item.name }}
                        </option>
                      </select>
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
                  @click="handleUpdateStudent(getOneStudent.id)"
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
import StudentApi from "@/api/StudentApi";
import type Course from "@/types/Course";
import type Student from "@/types/Student";
import dayjs from "dayjs";
import Vue, { ref, watchEffect } from "vue";
import Menu from "../../layout/Menu.vue";
const getAllStudent = ref<Student[]>([]);
const getStudent = ref<Student[]>([]);
const getAllCourse = ref<Course[]>([]);
const searchStudent = ref("");
const selectedCourseId = ref<String>("");
const getOneStudent = ref<Student>();
const updateStudents = ref<Student>({
  id: "",
  fullName: "",
  dateOfBirth: new Date(),
  phoneNumber: "",
  address: "",
  email: "",
  code: "",
  courseId: "",
});
const addStudent = ref<Student>({
  id: "",
  fullName: "",
  dateOfBirth: new Date(),
  phoneNumber: "",
  address: "",
  email: "",
  code: "",
  courseId: "",
});

const handleGetStudent = (name: string) => {
  StudentApi.getStudent(name).then((response) => {
    getStudent.value = response.data;
  });
};

const searchByCode = () => {
  if (searchStudent.value.trim() != "") {
    handleGetStudent(searchStudent.value);
  } else {
  }
};

const handleUpdateStudent = (id: string) => {
  StudentApi.updateStudent(updateStudents.value, id).then((response) => {
    handleGetAllStudent();
  });
};

const handleGetOneStudent = (id: String) => {
  StudentApi.getOneStudent(id).then((response) => {
    getOneStudent.value = response.data;
    updateStudents.value = { ...response.data };
    console.log(response.data);
  });
};

const handleAddStudent = () => {
  addStudent.value.dateOfBirth = dayjs(addStudent.value.dateOfBirth).format(
    "YYYY-MM-DDTHH:mm:ss"
  );
  StudentApi.addStudent(addStudent.value).then((response) => {
    handleGetAllStudent();
  });
};

const handleSelectedCourse = () => {
  addStudent.value.courseId = selectedCourseId.value;
};
const handleSelectedCourseUpdate = () => {
  updateStudents.value.courseId = selectedCourseId.value;
};

const handleGetAllStudent = () => {
  StudentApi.getAll().then((response) => {
    getAllStudent.value = response.data;
  });
};

const handleGetAllCourse = () => {
  StudentApi.getAllCourse().then((response) => {
    getAllCourse.value = response.data;
  });
};

watchEffect(() => {
  handleGetAllStudent();
  handleGetAllCourse();
  handleGetOneStudent(getOneStudent.id);
  handleGetStudent(searchStudent.value);
});
</script>
<style scoped>
.avata-student {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #ffa726;
  display: flex;
  align-items: center;
  justify-content: center;
}
.student-course {
  height: 50px;
  margin-bottom: 30px;
  border: 1px solid #ffa726;
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
