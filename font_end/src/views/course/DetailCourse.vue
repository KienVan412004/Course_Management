<template>
  <Menu>
    <div class="container">
      <p style="font-size: 25px; font-weight: bold; padding: 15px">
        <img src="/img/pen2.png" alt="" width="50px" /> Chi tiết khóa học
      </p>
      <div class="content-detail-course">
        <div class="row container">
          <div class="col-6">
            <p style="font-weight: bold; margin-top: 20px">
              Tên khóa học <span style="color: red">*</span>
            </p>
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput1"
              placeholder="Họ và tên"
              v-model="getOneCourse.name"
            />
            <div class="row">
              <div class="col-6">
                <!-- <p style="font-weight: bold; margin-top: 20px">
                Ngày bắt đầu <span style="color: red">*</span>
              </p>
              <input
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                v-model="getOneCourse.startDate"
              /> -->
                <p style="font-weight: bold; margin-top: 20px">
                  Giá khóa học <span style="color: red">*</span>
                </p>
                <input
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  v-model="getOneCourse.price"
                />
              </div>
              <div class="col-6">
                <!-- <p style="font-weight: bold; margin-top: 20px">
                Ngày kết thúc <span style="color: red">*</span>
              </p>
              <input
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                v-model="getOneCourse.endDate"
              /> -->
                <p style="font-weight: bold; margin-top: 20px">
                  Thời gian dự kiến <span style="color: red">*</span>
                </p>
                <input
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  v-model="getOneCourse.estimatedStartTime"
                />
              </div>
            </div>
            <p style="font-weight: bold; margin-top: 20px">
              Mô tả <span style="color: red">*</span>
            </p>
            <textarea
              class="form-control"
              id="exampleFormControlTextarea1"
              rows="3"
              v-model="getOneCourse.description"
            ></textarea>
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
                margin-top: 60px;
              "
            >
              Cập nhật
            </button>
          </div>

          <div class="col-6">
            <p
              style="
                font-size: 25px;
                font-weight: bold;
                padding: 15px;
                position: static;
                top: 0;
              "
            >
              <img src="/img/danh_sach.png" alt="" width="50px" /> Danh sách môn
              học
              <img
                src="/img/plus.png"
                data-bs-toggle="modal"
                data-bs-target="#exampleModal"
                alt=""
                width="30px"
                style="float: right"
              />
            </p>
            <div style="overflow-y: scroll; max-height: 440px">
              <div class="container">
                <div class="row">
                  <div
                    class="col-6"
                    v-for="item in getSubjectByCourseId"
                    :key="item.id"
                  >
                    <router-link
                      class="link-detail"
                      :to="`/detail-subject/${item.id}`"
                    >
                      <div class="student-course">
                        <div class="avata-student">
                          <img src="/img/subject.png" alt="" />
                        </div>
                        <span style="font-weight: 600; padding: 5px">
                          Môn học: {{ item.subjectName }} <br />
                          Mã môn: {{ item.subjectCode }}</span
                        >
                      </div>
                    </router-link>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Modal add class-->
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
                <img src="/img/pen2.png" alt="" width="30px" /> Thêm mới môn học
              </p>
            </div>
            <div class="modal-body">
              <div class="row">
                <div class="col-6">
                  <p style="font-weight: bold; margin-top: 20px">
                    Tên môn học <span style="color: red">*</span>
                  </p>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleFormControlInput1"
                    placeholder="Tên môn học"
                    v-model="addSubjectByCourse.subjectName"
                  />
                </div>
                <div class="col-6">
                  <p style="font-weight: bold; margin-top: 20px">
                    Kết quả sau khóa học <span style="color: red">*</span>
                  </p>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleFormControlInput1"
                    placeholder="Kết quả"
                    v-model="addSubjectByCourse.result"
                  />
                </div>
              </div>
              <div class="row">
                <div class="col-6">
                  <p style="font-weight: bold; margin-top: 20px">
                    Ngày bắt đầu <span style="color: red">*</span>
                  </p>
                  <input
                    type="date"
                    class="form-control"
                    id="exampleFormControlInput1"
                    v-model="addSubjectByCourse.startDate"
                  />
                </div>
                <div class="col-6">
                  <p style="font-weight: bold; margin-top: 20px">
                    Ngày kết thúc <span style="color: red">*</span>
                  </p>
                  <input
                    type="date"
                    class="form-control"
                    id="exampleFormControlInput1"
                    v-model="addSubjectByCourse.endDate"
                  />
                </div>
              </div>

              <p style="font-weight: bold; margin-top: 20px">
                Lộ trình <span style="color: red">*</span>
              </p>
              <!-- <textarea
                class="form-control"
                id="exampleFormControlTextarea1"
                rows="3"
                v-model="addSubjectByCourse.description"
                style="height: 270px"
              ></textarea> -->
              <!-- <QuillEditor
                theme="snow"
                v-model="addSubjectByCourse.description"
                style="height: 270px"
              /> -->
              <Editor
                v-model="addSubjectByCourse.description"
                editorStyle="height: 320px"
              />
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
                @click="handleAddSubjectByCourse"
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
import CourseApi from "@/api/CourseApi";
import type Stduent from "@/types/Student";
import dayjs from "dayjs";
import Vue, { ref, watchEffect } from "vue";
import Course from "../../types/Course";
import { useRouter, useRoute } from "vue-router";
import { log } from "console";
import type Subject from "@/types/Subject";
import type AddSubjectByCourse from "@/types/AddSubjectByCourse";
import SubjectApi from "@/api/SubjectApi";
import { QuillEditor } from "@vueup/vue-quill";
import Menu from "../../layout/Menu.vue";
import Editor from "primevue/editor";

const router = useRoute();

const getAllStudent = ref<Stduent[]>([]);

const getOneCourse = ref<Course>();

const getStudentByCourseId = ref<Stduent[]>([]);

const getSubjectByCourseId = ref<Subject[]>([]);

const addSubjectByCourse = ref<AddSubjectByCourse>({
  subjectName: "",
  description: "",
  result: "",
  startDate: new Date(),
  endDate: new Date(),
  courseId: router.params.id,
});
console.log(addSubjectByCourse.value.subjectName);

console.log(router.params);

const formatPrice = (price: any) => {
  let formattedPrice = (price / 1)
    .toFixed(0)
    .replace(/\B(?=(\d{3})+(?!\d))/g, ".");
  return `${formattedPrice} VND`;
};

const detailCourse = (courseId: String) => {
  CourseApi.getOne(courseId).then((response) => {
    getOneCourse.value = response.data;
  });
};

const handleGetSubjectByCourseId = (courseId: String) => {
  CourseApi.getSubjectByCourseId(courseId).then((response) => {
    getSubjectByCourseId.value = response.data;
  });
};

const fetchData = () => {
  CourseApi.getAllStudent().then((response) => {
    getAllStudent.value = response.data;
  });
};

const handleAddSubjectByCourse = () => {
  addSubjectByCourse.value.startDate = dayjs(
    addSubjectByCourse.value.startDate
  ).format("YYYY-MM-DDTHH:mm:ss");
  addSubjectByCourse.value.endDate = dayjs(
    addSubjectByCourse.value.endDate
  ).format("YYYY-MM-DDTHH:mm:ss");

  SubjectApi.addSubjectByCourse(addSubjectByCourse.value).then((response) => {
    handleGetSubjectByCourseId(router.params.id);
    console.log(response.data, "add");
  });
};

const fomartDate = (date: Date) => {
  return dayjs(date).format("DD/MM/YYYY");
};

watchEffect(() => {
  fetchData();
  detailCourse(router.params.id);
  handleGetSubjectByCourseId(router.params.id);
});
</script>
<style scoped>
.link-detail {
  text-decoration: none;
  color: black;
}
.classmates {
  background-color: white;
  padding: 5px;
  border-radius: 30px;
  margin-top: 60px;
}
.content-detail-course {
  background-color: white;
  padding: 5px;
  border-radius: 30px;
  height: 545px;
}
.student-course {
  height: 85px;
  margin-bottom: 30px;
  border: 1px solid #ffa726;
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.student-course-classmates {
  height: 50px;
  margin-bottom: 30px;
  border: 1px solid #0288d1;
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.avata-student {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #ffa726;
  display: flex;
  align-items: center;
  justify-content: center;
}
.avata-student-classmates {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #0288d1;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
