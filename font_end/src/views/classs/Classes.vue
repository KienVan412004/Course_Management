<template>
  <Menu>
    <div class="account">
      <div class="container" style="padding-top: 40px">
        <div
          style="height: 700px; background-color: white; border-radius: 20px"
        >
          <p style="font-size: 25px; font-weight: bold; padding: 15px">
            <img src="/img/pen2.png" alt="" width="50px" /> Quản lý lớp học
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
                  data-bs-target="#staticBackdrop"
                  style="
                    width: 140px;
                    height: 45px;
                    border-radius: 20px;
                    background-color: #ffa726;
                    border: none;
                    font-weight: 700;
                  "
                >
                  Thêm mới
                </button>
              </div>
            </div>
            <div>
              <table class="table" style="margin-top: 50px">
                <thead style="background-color: gray">
                  <tr>
                    <th scope="col">Stt</th>
                    <th scope="col">Mã Lớp học</th>
                    <th scope="col">Tên Lớp học</th>
                    <th scope="col">Khóa học</th>
                    <th scope="col">Tên giảng viên</th>
                    <th scope="col">Ngày bắt đầu</th>
                    <th scope="col">Hành động</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="(item, index) in getAllClass" :key="item.id">
                    <th>{{ index + 1 }}</th>
                    <th>
                      {{ item.classCode }}
                    </th>
                    <th>
                      {{ item.className }}
                    </th>
                    <th>
                      {{ item.course.name }}
                    </th>
                    <th>
                      {{ item.teacher.fullName }}
                    </th>
                    <th>
                      {{ formatDate(item.startDate) }}
                    </th>

                    <th>
                      <router-link :to="`/detail-classes/${item.id}`">
                        <button
                          type="button"
                          class="btn btn-info"
                          style="background-color: #189a2e; border-radius: 15px"
                        >
                          <img src="/img/icons8-eye-24.png" alt="" />
                        </button>
                      </router-link>
                    </th>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>

      <!-- Modal add-->
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
                <img src="/img/pen2.png" alt="" width="30px" /> Thêm mới lớp học
              </p>
            </div>
            <div class="modal-body">
              <div class="row">
                <div class="col-6">
                  <p style="font-weight: bold; margin-top: 20px">
                    Tên lớp học <span style="color: red">*</span>
                  </p>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleFormControlInput1"
                    placeholder="Tên lớp học"
                    v-model="addClassToCourse.className"
                  />
                </div>
                <div class="col-6">
                  <p style="font-weight: bold; margin-top: 20px">
                    Ngày bắt đầu <span style="color: red">*</span>
                  </p>
                  <input
                    type="date"
                    class="form-control"
                    id="exampleFormControlInput1"
                    v-model="addClassToCourse.startDate"
                  />
                </div>
                <p style="font-weight: bold; margin-top: 20px">
                  Các khóa học <span style="color: red">*</span>
                </p>

                <select
                  class="form-select"
                  aria-label="Default select example"
                  v-model="addClassToCourse.courseId"
                >
                  <option
                    v-for="item in getAllCourse"
                    :key="item.id"
                    :value="item.id"
                  >
                    {{ item.name }}
                  </option>
                </select>
                <p style="font-weight: bold; margin-top: 20px">
                  Giảng viên <span style="color: red">*</span>
                </p>

                <select
                  class="form-select"
                  aria-label="Default select example"
                  v-model="addClassToCourse.teacherId"
                >
                  <option
                    v-for="item in getAllTeacher"
                    :key="item.id"
                    :value="item.id"
                  >
                    {{ item.fullName }}
                  </option>
                </select>
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
                data-bs-dismiss="modal"
                @click="handleAddClassToCourse"
              >
                Xác nhận
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </Menu>
</template>
<script setup lang="ts">
import ClassesApi from "@/api/ClassesApi";
import Course from "../../types/Course";
import { ref, watchEffect } from "vue";
import type Teacher from "@/types/Teacher";
import type AddClassToCourse from "@/types/AddClassToCourse";
import dayjs from "dayjs";
import type Classes from "@/types/Classes";
import Menu from "../../layout/Menu.vue";
import { toast } from "vue3-toastify";
import Confirm from "@/components/Confirm";

const getAllCourse = ref<Course[]>([]);
const getAllTeacher = ref<Teacher[]>([]);
const getAllClass = ref<Classes[]>([]);

const showModal = ref(true);

const addClassToCourse = ref<AddClassToCourse>({
  className: "",
  courseId: "",
  teacherId: "",
  startDate: new Date(),
});

const formatDate = (date: Date) => {
  return dayjs(date).format("DD/MM/YYYY");
};

const handleAddClassToCourse = () => {
  const title = "Bạn có muốn thêm lớp không ?";
  const text = "";
  Confirm(title, text).then((result) => {
    if (result.isConfirmed) {
      addClassToCourse.value.startDate = dayjs(
        addClassToCourse.value.startDate
      ).format("YYYY-MM-DDTHH:mm:ss");
      ClassesApi.addClassToCourse(addClassToCourse.value).then((response) => {
        handleGetAllClass();
        toast.success("Success", {
          position: toast.POSITION.TOP_RIGHT,
        });
      });
    }
  });
};

const handleGetAllCourse = () => {
  ClassesApi.getAllCourse().then((response) => {
    getAllCourse.value = response.data;
    console.log(response.data);
  });
};

const handleGetAllClass = () => {
  ClassesApi.getAll().then((response) => {
    getAllClass.value = response.data;
    console.log(response.data, "all class");
  });
};

const handleGetAllTeacher = () => {
  ClassesApi.getAllTeacher().then((response) => {
    getAllTeacher.value = response.data;
    console.log(response.data);
  });
};

watchEffect(() => {
  handleGetAllCourse();
  handleGetAllTeacher();
  handleGetAllClass();
});
</script>
